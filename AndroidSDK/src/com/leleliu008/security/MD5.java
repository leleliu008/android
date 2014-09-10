package com.leleliu008.security;

import java.io.File;
import java.io.RandomAccessFile;
import java.security.MessageDigest;

public final class MD5 {
	private static final int BUFF_SIZE = 4096;
	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7',
			                            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

	private MD5() { }
	
	/* 用于文件校验 */
	public static String encode(File file) {
		try {
			byte[] buffer = new byte[BUFF_SIZE];
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			RandomAccessFile fread = new RandomAccessFile(file, "r");

			if (fread.length() <= 0) {
				fread.close();
				return null;
			}

			int read_len = 0;
			fread.seek(0);
			for (;;) {
				read_len = fread.read(buffer);
				if (read_len > 0) {
					mdTemp.update(buffer, 0, read_len);
				} else {
					break;
				}
			}

			fread.close();
			byte[] mdByte = mdTemp.digest();
			int mdByte_len = mdByte.length;
			char ret_str[] = new char[mdByte_len * 2];
			int k = 0;
			for (int i = 0; i < mdByte_len; i++) {
				byte byte0 = mdByte[i];
				ret_str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				ret_str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(ret_str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static String encode(String string) {
		try {
			byte[] strTemp = string.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
}
