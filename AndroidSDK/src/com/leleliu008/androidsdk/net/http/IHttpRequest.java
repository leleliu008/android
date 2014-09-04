package com.leleliu008.androidsdk.net.http;

import java.io.IOException;
import java.io.InputStream;

/* 此接口是包访问权限，在本子系统中使用 */
interface IHttpRequest {

	InputStream getInputStream(String urlStr) throws IOException;
	
	public byte[] request(String urlStr) throws IOException;
}
