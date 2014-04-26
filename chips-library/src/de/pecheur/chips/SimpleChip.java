/*
 * Copyright (C) 2013 The Android Open Source Project
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


public class SimpleChip implements BaseChip {
	private final CharSequence mText;
	private boolean mEditable;

	public SimpleChip(final CharSequence text, boolean editable) {
		mText = text;
		mEditable = editable;
	}

	@Override
	public CharSequence getText() {
		return mText;
	}

	@Override
	public String toString() {
		return mText.toString();
	}

	@Override
	public boolean isEditable() {
		return mEditable;
	}
	
	@Override
	public boolean isSelectable() {
		return true;
	}
}