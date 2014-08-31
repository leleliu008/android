package com.leleliu008.androidsdk.localsocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import android.app.IntentService;
import android.content.Intent;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.util.Log;

public final class Client extends IntentService {

	private static final String TAG = Client.class.getName();
	
	public Client() {
		super(TAG);
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		LocalSocket clientSocket = null;
		try {
			//创建客户端socket
			clientSocket = new LocalSocket();
			//服务器地址
			LocalSocketAddress serverAddress = new LocalSocketAddress(getPackageName());
			//连接服务器
			clientSocket.connect(serverAddress);
			
			//向服务器写数据
			OutputStream os = clientSocket.getOutputStream();
			String sendmsg = "I love you!";
			os.write(sendmsg.getBytes());
			os.flush();
			Log.i(TAG, "send message to server : " + sendmsg);
			
			//读取从服务器返回的数据
			InputStream is = clientSocket.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is), 2048);
			StringBuilder recevmsg = new StringBuilder();
			String lineStr = null;
			while ((lineStr = br.readLine()) != null) {
				recevmsg.append(lineStr);
			}
			Log.i(TAG, "receive message from server : " + recevmsg.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (clientSocket != null) {
				try {
					clientSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
