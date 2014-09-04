package com.leleliu008.androidsdk.net.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* IO工具类 */
public final class IOUtil {
	
	private IOUtil() { }

	/* 将输入流转换成字节数组 */
	public static byte[] inputStream2bytes(InputStream is) throws IOException {
		if (is == null) {
			return null;
		}
		
		byte[] result = null;
		
		ByteArrayOutputStream baos = null;
		try {
			baos = new ByteArrayOutputStream();
			
			byte[] buff = new byte[1024];
			int len = 0;
			while (-1 != (len = is.read(buff))) {
				baos.write(buff, 0, len);
			}
			baos.flush();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		if (baos != null) {
			result = baos.toByteArray();
		}
		
		return result;
	}
}
