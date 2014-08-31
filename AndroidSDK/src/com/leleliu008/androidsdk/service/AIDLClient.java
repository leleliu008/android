package com.leleliu008.androidsdk.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

public class AIDLClient extends Activity {

	private static final String ACTION = "com.leleliu008.androidsdk.service.ACTION_AIDL";
	
	private ServiceConnection serviceConnection = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			aidl = AIDL.Stub.asInterface(service);
		}
	};
	
	private AIDL aidl;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent intent = new Intent(ACTION);
		bindService(intent, serviceConnection, BIND_AUTO_CREATE);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		unbindService(serviceConnection);
	}
}
