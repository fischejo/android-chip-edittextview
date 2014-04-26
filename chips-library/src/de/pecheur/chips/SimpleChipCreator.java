package de.pecheur.chips;

import de.pecheur.chips.ChipEditTextView.ChipCreator;

public class SimpleChipCreator implements ChipCreator {
	private boolean mEditable;
	
	public SimpleChipCreator(boolean editable) {
		mEditable = editable;
	}
	
	@Override
	public BaseChip createChip(CharSequence text) {
		return new SimpleChip(text, mEditable);
	}
	
}