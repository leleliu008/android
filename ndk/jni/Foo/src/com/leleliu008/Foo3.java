package com.leleliu008;

public class Foo3 {

	public native boolean[][] func1(boolean[][] pram);

	public native byte[][] func2(byte[][] pram);
	
	public native char[][] func3(char[][] pram);

	public native short[][] func4(short[][] pram);

	public native int[][] func5(int[][] pram);

	public native long[][] func6(long[][] pram);

	public native float[][] func7(float[][] pram);

	public native double[][] func8(double[][] pram);
	
	public native String[][] func9(String[][] pram);

	public native Foo3[][] func10(Foo3[][] pram);

	static {
		System.loadLibrary("foo3");
	}
}
