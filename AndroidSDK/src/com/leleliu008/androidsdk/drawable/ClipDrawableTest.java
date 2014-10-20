package com.leleliu008.androidsdk.drawable;

import com.leleliu008.androidsdk.R;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;

public class ClipDrawableTest {

	public static ClipDrawable get(Context context) {
		Drawable drawable = context.getResources().getDrawable(R.drawable.clip);
		return new ClipDrawable(drawable, Gravity.CENTER, ClipDrawable.HORIZONTAL);
	}
}
