package com.leleliu008.androidsdk.bluetooth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class Client extends Activity {

	private static final String TAG = Client.class.getName();
	
	private static final int REQUEST_ENABLE_BLUETOOTH = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		if (bluetoothAdapter == null) {
			// 表明此手机不支持蓝牙
			return;
		}

		if (bluetoothAdapter.isEnabled()) {
			discoveryRemoteDevice();
		} else {  // 蓝牙未开启，则开启蓝牙
			Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(intent, REQUEST_ENABLE_BLUETOOTH);
		}
		
		Set<BluetoothDevice> remoteDevices = bluetoothAdapter.getBondedDevices();
		if (remoteDevices != null && remoteDevices.size() > 0) {
			for (BluetoothDevice device : remoteDevices) {
				Log.i(TAG, device.getName() + " " + device.getAddress());
			}
		} else {
			Log.i(TAG, "没有配对的设备");
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_ENABLE_BLUETOOTH) {
			if (resultCode == RESULT_OK) {
				discoveryRemoteDevice();
			}
		}
	}
	
	private void discoveryRemoteDevice() {
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
		registerReceiver(mReceiver, filter);
		BluetoothAdapter.getDefaultAdapter().startDiscovery();
	}

	private BroadcastReceiver mReceiver = new BroadcastReceiver() {

		// 当搜索结束后调用onReceive
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (BluetoothDevice.ACTION_FOUND.equals(action)) {
				BluetoothDevice remoteDevice = intent
						.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
				// 已经配对的则跳过
				if (remoteDevice.getBondState() != BluetoothDevice.BOND_BONDED) {
					//启动服务端监听
					new ClientThread(remoteDevice).start();
				}
				Log.d(TAG, "ACTION_FOUND");
			} 
			// 搜索结束
			else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {
				Log.d(TAG, "ACTION_DISCOVERY_FINISHED");
			}
		}
	};
	
	// UUID可以看做一个端口号
	private static final UUID MY_UUID = UUID
			.fromString("fa87c0d0-afac-11de-8a39-0800200c9a66");

	// 另一个设备去连接本机,相当于客户端
	private class ClientThread extends Thread {
		
		private BluetoothDevice remoteDevice;
		
		public ClientThread(BluetoothDevice remoteDevice) {
			this.remoteDevice = remoteDevice;
		}
		
		public void run() {
			// 取消设备查找
			BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
			
			BluetoothSocket clientSocket = null;
			InputStream is = null;
			OutputStream os = null;
			try {
				clientSocket = remoteDevice.createRfcommSocketToServiceRecord(MY_UUID);
				clientSocket.connect();
			
				is = clientSocket.getInputStream();
				os = clientSocket.getOutputStream();
				
				os.write("你好！".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
				if (os != null) {
					try {
						os.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
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
