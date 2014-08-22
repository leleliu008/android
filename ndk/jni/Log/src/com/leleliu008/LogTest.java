package com.leleliu008;

public class LogTest {

	public native static void printLog();
	
	static {
		System.loadLibrary("logtest");
	}
}
