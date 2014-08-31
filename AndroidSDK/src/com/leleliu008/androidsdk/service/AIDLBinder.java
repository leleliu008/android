package com.leleliu008.androidsdk.service;

import android.os.RemoteException;
import android.util.Log;

public class AIDLBinder extends AIDL.Stub {

	private static final String TAG = "AIDLBinder";
	
	@Override
	public void a() throws RemoteException {
		Log.d(TAG, "a invoke");
	}

	@Override
	public void b() throws RemoteException {
		Log.d(TAG, "b invoke");
	}

	@Override
	public void c() throws RemoteException {
		Log.d(TAG, "c invoke");
	}

	@Override
	public void d() throws RemoteException {
		Log.d(TAG, "d invoke");
	}

}
