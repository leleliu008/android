package com.leleliu008.androidsdk.localsocket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.app.IntentService;
import android.content.Intent;
import android.net.LocalServerSocket;
import android.net.LocalSocket;
import android.util.Log;

public final class Server extends IntentService {

	private static final String TAG = Server.class.getName();
	
	private LocalServerSocket serverSocket;
	
	public Server() {
		super(TAG);
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		try {
			serverSocket = new LocalServerSocket(getPackageName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
		while (true) {
			try {
				if (serverSocket != null) {
					//这里起线程的目的是为了不阻塞下一个连接请求，增大吞吐量
					new WorkThread(serverSocket.accept()).start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		if (serverSocket != null) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static class WorkThread extends Thread {
		private LocalSocket clientSocket;
		
		WorkThread(LocalSocket clientSocket) {
			this.clientSocket = clientSocket;
		}
		
		@Override
		public void run() {
			super.run();
			
			try {
				InputStream is = clientSocket.getInputStream();
				byte[] buff = new byte[1024];
				int n = is.read(buff);
				String recevmsg = new String(buff, 0, n);
				Log.i(TAG, "receive message from client : " + recevmsg);
			
				OutputStream os = clientSocket.getOutputStream();
				String sendmsg = "I love you, too!";
				os.write(sendmsg.getBytes());
				Log.i(TAG, "back message to client : " + sendmsg);
			} catch (Exception e) {
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
}
