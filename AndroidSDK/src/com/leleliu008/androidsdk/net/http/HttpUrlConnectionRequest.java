package com.leleliu008.androidsdk.net.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.leleliu008.util.IOUtil;

/* 使用HttpUrlConnection请求网络连接 */
final class HttpUrlConnectionRequest implements IHttpRequest, 
                                                IHttpUrlConnectionRequest {
	
	@Override
	public byte[] request(HttpURLConnection httpURLConnection) 
			                              throws IOException {
		return httpURLConnection == null ? null : 
			IOUtil.inputStream2bytes(httpURLConnection.getInputStream());
	}
	
	@Override
	public byte[] request(String urlStr) throws IOException {
		return IOUtil.inputStream2bytes(getInputStream(urlStr));
	}

	@Override
	public InputStream getInputStream(String urlStr) throws IOException {
		if (urlStr == null || "".equals(urlStr)) {
			return null;
		}
		
		URL url = new URL(urlStr);
		HttpURLConnection connection = 
				(HttpURLConnection) url.openConnection();
		//设置请求方式为GET方式，可以不设置，默认就是GET方式的
		connection.setRequestMethod("GET");
		//设置请求超时5秒
		connection.setConnectTimeout(5 * 1000);
		
		if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
			//得到输入流，就会返回的数据
			return connection.getInputStream();
		}
		return null;
	}
}
