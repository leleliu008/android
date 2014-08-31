package com.leleliu008.androidsdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class AIDLService extends Service {

	private static final String ACTION = "com.leleliu008.androidsdk.service.ACTION_AIDL";
	
	@Override
	public IBinder onBind(Intent intent) {
		if (intent != null && ACTION.equals(intent.getAction())) {
			return new AIDLBinder();
		}
		return null;
	}

}
