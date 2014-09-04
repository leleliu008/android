package com.leleliu008.androidsdk.net.http;

import java.io.IOException;

import org.apache.http.client.methods.HttpUriRequest;

/* 使用HttpClient协议请求网络连接 */
interface IHttpClientRequest {
	
	byte[] request(HttpUriRequest request) throws IOException;
}
