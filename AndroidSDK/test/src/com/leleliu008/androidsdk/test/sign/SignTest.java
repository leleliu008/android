package com.leleliu008.androidsdk.test.sign;

import java.security.MessageDigest;

import android.content.Context;
import android.test.AndroidTestCase;

import com.leleliu008.androidsdk.sign.SignVerify;

public class SignTest extends AndroidTestCase {
	
	private Context context;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		context = getContext();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		context = null;
	}

	public void testSignVerify() throws Exception {
		String publicKey = SignVerify.getInstalledAppPublicKeys(context)[0].toString();
		int x = publicKey.indexOf("modulus");
		int y = publicKey.indexOf("public");
		publicKey = publicKey.substring(x + 8, y - 1);
		
		try {
			byte[] md5 = MessageDigest.getInstance("MD5").digest(publicKey.getBytes());
			String xxString = new String(md5, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
