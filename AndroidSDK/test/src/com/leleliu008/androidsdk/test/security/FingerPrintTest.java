package com.leleliu008.androidsdk.test.security;

import com.leleliu008.security.FingerPrint;
import com.leleliu008.security.FingerPrint.Algorithm;

import android.test.AndroidTestCase;

public class FingerPrintTest extends AndroidTestCase {

	public void testMD5() throws Exception {
		String result = FingerPrint.encode(Algorithm.MD5, "hh");
		assertEquals(true, result != null);
		assertEquals(32, result.length());
	}
	
	public void testSHA1() throws Exception {
		String result = FingerPrint.encode(Algorithm.SHA_1, "hh");
		assertEquals(true, result != null);
		assertEquals(40, result.length());
	}
	
	public void testSHA256() throws Exception {
		String result = FingerPrint.encode(Algorithm.SHA_256, "hh");
		assertEquals(true, result != null);
		assertEquals(64, result.length());
	}
}
