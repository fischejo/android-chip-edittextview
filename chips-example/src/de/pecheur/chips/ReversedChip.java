package de.pecheur.chips;

import de.pecheur.chips.ChipEditTextView.ChipCreator;

public class ReversedChip implements BaseChip {
	private final CharSequence mText;
	
	
	private ReversedChip(CharSequence text) {
		// reverse text
		mText = new StringBuffer(text).reverse().toString();
	}
	
	@Override
	public CharSequence getText() {
		return mText;
	}

	@Override
	public boolean isEditable() {
		return false;
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	public static final ChipCreator CREATOR = new ChipCreator() {
		@Override
		public BaseChip createChip(CharSequence text) {
			return new ReversedChip(text);
		}
	};
}
