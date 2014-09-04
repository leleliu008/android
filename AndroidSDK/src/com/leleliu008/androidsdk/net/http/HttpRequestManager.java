package com.leleliu008.androidsdk.net.http;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.apache.http.client.methods.HttpUriRequest;

/* 此子系统中只有此类是公开的 */
public final class HttpRequestManager implements IHttpUrlConnectionRequest, IHttpClientRequest {
	
	public byte[] request(RequestMethod requestMethod, String urlStr) throws IOException {
		IHttpRequest httpRequest = null;
		if ((requestMethod == RequestMethod.HttpUrlConnection)
				|| (requestMethod == null)) {
			httpRequest = new HttpUrlConnectionRequest();
		} else {
			httpRequest = new HttpClientRequest();
		}
		return httpRequest.request(urlStr);
	}
	
	@Override
	public byte[] request(HttpURLConnection httpURLConnection) throws IOException {
		return new HttpUrlConnectionRequest().request(httpURLConnection);
	}
	
	@Override
	public byte[] request(HttpUriRequest request) throws IOException {
		return new HttpClientRequest().request(request);
	}
}
