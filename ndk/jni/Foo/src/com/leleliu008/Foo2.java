package com.leleliu008;

import android.util.Log;

public class Foo2 {

	public native boolean[] func1(boolean[] pram);

	public native byte[] func2(byte[] pram);
	
	public native char[] func3(char[] pram);

	public native short[] func4(short[] pram);

	public native int[] func5(int[] pram);

	public native long[] func6(long[] pram);

	public native float[] func7(float[] pram);

	public native double[] func8(double[] pram);
	
	public native String[] func9(String[] pram);

	public native Foo2[] func10(Foo2[] pram);

	static {
		System.loadLibrary("foo2");
	}
	
	public static void main(String[] args) {
		Foo2 foo2 = new Foo2();
		
		boolean[] value = foo2.func1(new boolean[] {true, false, true, false});
		Log.i("com_leleliu008", "--------------");
		for (int i = 0; i < value.length; i++) {
			Log.i("com_leleliu008", "" + value[i]);
		}
	}
}
