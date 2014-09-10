package com.leleliu008.androidsdk.test.security;

import com.leleliu008.security.DES3;

import android.test.AndroidTestCase;

public class DES3Test extends AndroidTestCase {

	public void testDES3() throws Exception {
		//DES3加密的key必须是8x3=24个字节
		String key = "ABCDEFGHABCDEFGHABCDEFGH";
		String source = "I Love you";
		
		//加密
		byte[] encrpt = DES3.encrypt(source.getBytes(), key.getBytes());
		assertEquals(true, encrpt != null);
		//解密
		byte[] decrpt = DES3.decrypt(encrpt, key.getBytes());
		assertEquals(true, decrpt != null);
		assertEquals(source, new String(decrpt));
	}
}
