package com.leleliu008.androidsdk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.ViewGroup;

public class CustomView1 extends ViewGroup {

	private static final String TAG = "CustomView1";
	
	public CustomView1(Context context) {
		super(context);
		
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		Log.d(TAG, "onMeasure()");
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		Log.d(TAG, "onLayout()");
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		Log.d(TAG, "onSizeChanged()");
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		Log.d(TAG, "onDraw()");
		super.onDraw(canvas);
	}
}
