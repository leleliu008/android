package com.leleliu008.androidsdk.test.security;

import com.leleliu008.security.AES;

import android.test.AndroidTestCase;

public class AESTest extends AndroidTestCase {

	public void testAES() throws Exception {
		//AES加密的key必须是16个字节
		String key = "ABCDEFGHIJKLMNOP";
		String source = "I Love you";
		
		//加密
		byte[] encrpt = AES.encrypt(source.getBytes(), key.getBytes());
		assertEquals(true, encrpt != null);
		//解密
		byte[] decrpt = AES.decrypt(encrpt, key.getBytes());
		assertEquals(true, decrpt != null);
		assertEquals(source, new String(decrpt));
	}
}
