package com.leleliu008.androidsdk.test.security;

import com.leleliu008.security.DES;

import android.test.AndroidTestCase;

public class DESTest extends AndroidTestCase {

	public void testDES() throws Exception {
		//DES加密的key必须是8个字节
		String key = "ABCDEFGH";
		String source = "I Love you";
		
		//加密
		byte[] encrpt = DES.encrypt(source.getBytes(), key.getBytes());
		assertEquals(true, encrpt != null);
		//解密
		byte[] decrpt = DES.decrypt(encrpt, key.getBytes());
		assertEquals(true, decrpt != null);
		assertEquals(source, new String(decrpt));
	}
}
