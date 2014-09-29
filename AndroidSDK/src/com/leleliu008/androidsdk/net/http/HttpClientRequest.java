package com.leleliu008.androidsdk.net.http;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import com.leleliu008.util.IOUtil;

/* 使用HttpClient请求网络连接 */
final class HttpClientRequest implements IHttpRequest, IHttpClientRequest {
	
	@Override
	public byte[] request(HttpUriRequest request) throws IOException {
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = httpClient.execute(request);
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return IOUtil.inputStream2bytes(httpResponse.getEntity().getContent());
		}
		return null;
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
		
		HttpGet httpGet = new HttpGet(urlStr);
		HttpClient httpClient = new DefaultHttpClient();
		HttpResponse httpResponse = httpClient.execute(httpGet);
		if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
			return httpResponse.getEntity().getContent();
		}
		return null;
	}
}
