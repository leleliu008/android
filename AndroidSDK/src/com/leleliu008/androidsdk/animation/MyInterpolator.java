package com.leleliu008.androidsdk.animation;


import android.view.animation.Interpolator;

public class MyInterpolator implements Interpolator {

	@Override
	public float getInterpolation(float input) {
		return (float) Math.sin(100 * input);
	}

}
