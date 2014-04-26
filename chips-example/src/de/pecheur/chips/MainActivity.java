package de.pecheur.chips;

import java.util.Locale;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView.Validator;
import android.widget.Button;
import android.widget.Toast;
import de.pecheur.chips.R;
import de.pecheur.chips.ChipEditTextView.ChipCreator;



public class MainActivity extends Activity implements OnClickListener {
	private ChipEditTextView mChipEditTextView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// create adapter with chips.
		String[] chips = this.getResources().getStringArray(R.array.chips);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
				R.layout.chips_dropdown_item_1, chips);
		adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	
		/*
		 * Sample 1:
		 * simple non-editable chips by using predefined SimpleChipCreator.
		 */
		ChipEditTextView chipEditTextView = (ChipEditTextView) findViewById(R.id.chipView1);
		chipEditTextView.setAdapter( adapter);
		chipEditTextView.setCreator(new SimpleChipCreator(false));
		chipEditTextView.setThreshold(1);    // pop-up the list after a single char is typed
		/*
		 * Sample 2:
		 * simple editable chips by using predefined SimpleChipCreator.
		 */
		chipEditTextView = (ChipEditTextView) findViewById(R.id.chipView2);
		chipEditTextView.setAdapter( adapter);
		chipEditTextView.setCreator(new SimpleChipCreator(true));
		
		/*
		 * Sample 3:
		 * All chips, except the predefined chips, are editable by using
		 * CustomChipCreator.
		 */
		chipEditTextView = (ChipEditTextView) findViewById(R.id.chipView3);
		chipEditTextView.setAdapter( adapter);
		chipEditTextView.setCreator(new DefinedChipCreator(chips));

		/*
		 * Sample 4:
		 * Using of UpperCaseValidator.
		 */
		chipEditTextView = (ChipEditTextView) findViewById(R.id.chipView4);
		chipEditTextView.setAdapter(adapter);
		chipEditTextView.setCreator(new SimpleChipCreator(true));
		chipEditTextView.setValidator(new UpperCaseValidator());
		
		/*
		 * Sample 5:
		 * Custom chips with reversed, non-selectable chip.
		 */
		chipEditTextView = (ChipEditTextView) findViewById(R.id.chipView5);
		chipEditTextView.setAdapter(adapter);
		chipEditTextView.setCreator(ReversedChip.CREATOR);
		
		/*
		 * Sample 6:
		 * Append chipsn without shrinking on focus changes. 
		 * 
		 * Caution: Do no use setText! Only append single chips, never
		 * multiple chips.
		 */
		mChipEditTextView = (ChipEditTextView) findViewById(R.id.chipView6);
		mChipEditTextView.setAdapter(adapter);
		mChipEditTextView.setCreator(new SimpleChipCreator(false));
		mChipEditTextView.setOnFocusShrinkChips(false);

		/* we don't want to append the chips again, after activity 
		 * is recreated. ChipEditTextView does not implement all 
		 * the logic like a general EditTextView, so it is our task
		 * to take care.
		 */
		
		if (savedInstanceState == null) {
			for (String chip : chips) {
				/*
				 * if you append chips, pay attention to trim each 
				 * single chip before. It is not necessary to append 
				 * a seperator, it is handled by the ChipEditTextView.
				 */
				mChipEditTextView.append(chip);
			}
		}
		
		// button for showing toast.
        Button publish = (Button) findViewById(R.id.publish);
        publish.setOnClickListener(this);
	}
	
	

	private static class DefinedChipCreator implements ChipCreator {
		String[] mChips;
		
		public DefinedChipCreator(String[] chips) {
			mChips = chips;
		}
		
		@Override
		public BaseChip createChip(CharSequence text) {
			for(String chip : mChips) {
				if(chip.equalsIgnoreCase(text.toString())){
					return new SimpleChip(text, false);
				}
			}
			return new SimpleChip(text, true);
		}
	}
	
	
	private static class UpperCaseValidator implements Validator {
		@Override
		public boolean isValid(CharSequence text) {
			// is upper case
			for(int i = 0; i < text.length(); i++) {
				char c = text.charAt(i);
				if(Character.isLetter(c) && Character.isLowerCase(c)) {
					return false;
				}
			}
			return true;
		}

		@Override
		public CharSequence fixText(CharSequence invalidText) {
			return invalidText.toString().toUpperCase(Locale.US);
		}
    };


	@Override
	public void onClick(View arg0) {
		String chips = mChipEditTextView.getText().toString();	
		Toast.makeText(this, chips, Toast.LENGTH_LONG).show();
	}

	
}
