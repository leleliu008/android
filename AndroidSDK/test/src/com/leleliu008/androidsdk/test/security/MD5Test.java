package com.leleliu008.androidsdk.test.security;

import com.leleliu008.security.MD5;

import android.test.AndroidTestCase;

public class MD5Test extends AndroidTestCase {

	public void testMD5() throws Exception {
		String result = MD5.encode("hh");
		assertEquals(true, result != null);
		assertEquals(32, result.length());
	}
}
