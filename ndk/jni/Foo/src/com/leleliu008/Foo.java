package com.leleliu008;

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
}
