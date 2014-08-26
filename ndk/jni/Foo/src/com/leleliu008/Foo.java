package com.leleliu008;

import android.util.Log;

public class Foo {
	
	public native static void func1();

	public native void func2();

	public native boolean func3(boolean pram);

	public native byte func4(byte pram);
	
	public native char func5(char pram);

	public native short func6(short pram);

	public native int func7(int pram);

	public native long func8(long pram);

	public native float func9(float pram);

	public native double func10(double pram);
	
	public native String func11(String pram);

	public native Foo func12(Foo pram);

	static {
		System.loadLibrary("foo");
	}
	
	public static void main(String[] args) {
		Foo.func1();
		
		Foo foo = new Foo();
		
		foo.func2();
		
		boolean value3 = foo.func3(true);
		Log.i("com_leleliu008", "" + value3);
		
		byte value4 = foo.func4("a".getBytes()[0]);
		Log.i("com_leleliu008", "" + Byte.valueOf(value4));
		
		char value5 = foo.func5('A');
		Log.i("com_leleliu008", "" + value5);
		
		short value6 = foo.func6((short)5);
		Log.i("com_leleliu008", "" + value6);
		
		int value7 = foo.func7(5);
		Log.i("com_leleliu008", "" + value7);
		
		long value8 = foo.func8(5L);
		Log.i("com_leleliu008", "" + value8);
		
		float value9 = foo.func9(5.0f);
		Log.i("com_leleliu008", "" + value9);
		
		double value10 = foo.func10(10.0);
		Log.i("com_leleliu008", "" + value10);
		
		String value11 = foo.func11("Hello World!");
		Log.i("com_leleliu008", value11);
		
		foo.func12(new Foo());
	}
}
