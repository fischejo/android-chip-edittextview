/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.pecheur.chips;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ImageSpan;

/**
 * VisibleRecipientChip defines an ImageSpan that contains information relevant
 * to a particular recipient and renders a background asset to go with it.
 */
public final class DrawableChip extends ImageSpan {
	private final BaseChip mDelegate;
	private boolean mSelected = false;
	private CharSequence mOriginalText;

	public DrawableChip(final Drawable drawable, BaseChip chip) {
		super(drawable, DynamicDrawableSpan.ALIGN_BOTTOM);
		mDelegate = chip;
	}

	/**
     * Set the selected state of the chip.
     */
	public void setSelected(final boolean selected) {
		mSelected = selected;
	}

	/**
     * Return true if the chip is selected.
     */
	public boolean isSelected() {
		return mSelected;
	}
	
	public boolean isSelectable() {
		return mDelegate.isSelectable();
	}


	public CharSequence getText() {
		return mDelegate.getText();
	}


	public Rect getBounds() {
		return getDrawable().getBounds();
	}


	public void draw(final Canvas canvas) {
		getDrawable().draw(canvas);
	}

	public String toString() {
		return mDelegate.toString();
	}


	public boolean isEditable() {
		return mDelegate.isEditable();
	}

	public BaseChip getDelegate() {
		return mDelegate;
	}
	
	public void setOriginalText(final CharSequence text) {
		mOriginalText = text;
	}

	public CharSequence getOriginalText() {
		return mOriginalText;
	}
}
