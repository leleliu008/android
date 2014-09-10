package com.leleliu008.androidsdk.test.security;

import com.leleliu008.security.Base64;

import android.test.AndroidTestCase;
import android.util.Log;

public class Base64Test extends AndroidTestCase {
	
	private static final String TAG = "Base64Test";

	public void testBase64() throws Exception {
		String string = "I Love you";
		
		//先编码
		String result = Base64.encode(string.getBytes());
		Log.i(TAG, "result = " + result);
		assertEquals(true, result != null);
		
		//再解码
		byte[] result2 = Base64.decode(result.getBytes());
		assertEquals(string, new String(result2));
	}
}
