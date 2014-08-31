package com.leleliu008.androidsdk.service;

import com.leleliu008.androidsdk.R;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

public class BindServiceTest extends Activity implements OnClickListener {

	private static final String TAG = "BindService";
	
	private Intent intent;
	private ServiceConnection serviceConnection;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bind_service);
		findViewById(R.id.bind_btn).setOnClickListener(this);
		findViewById(R.id.unbind_btn).setOnClickListener(this);
		
		intent = new Intent(this, BindService.class);
		
		serviceConnection = new ServiceConnection() {
			
			@Override
			public void onServiceDisconnected(ComponentName name) {
			}
			
			@Override
			public void onServiceConnected(ComponentName name, IBinder service) {
				Log.d(TAG, "onServiceConnected");
			}
		};
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bind_btn:
			for (int i = 0; i < 10; i++) {
				bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
			}
			
			break;
		case R.id.unbind_btn:
			unbindService(serviceConnection);
			break;
		default:
			break;
		}
	}
}
