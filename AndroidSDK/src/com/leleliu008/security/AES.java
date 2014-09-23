package com.leleliu008.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES对称加密和解密，传入的key必须是128bit=16byte
 * 
 * @author 792793182@qq.com
 *
 */
public final class AES {
	
	private static final String Algorithm = "AES/ECB/PKCS7Padding";

	private static Cipher cipher = null;
	static {
		try {
			cipher = Cipher.getInstance(Algorithm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private AES() { }

	public static byte[] encrypt(final byte[] bySrc, byte[] key) {
		return crypt(Cipher.ENCRYPT_MODE, bySrc, key);
	}

	public static byte[] decrypt(final byte[] bySrc, byte[] key) {
		return crypt(Cipher.DECRYPT_MODE, bySrc, key);
	}

	private static byte[] crypt(int opmode, final byte[] bySrc, byte[] key) {
		if (key == null || key.length == 0) {
			return null;
		}

		SecretKey deskey = new SecretKeySpec(key, Algorithm);

		try {
			cipher.init(opmode, deskey);
			return cipher.doFinal(bySrc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
