package com.leleliu008.androidsdk.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class ConcurrentService extends IntentService {

	private static final String TAG = "ConcurrentService";
	
	public ConcurrentService() {
		super("ConcurrentService");
	}
	
	public ConcurrentService(String name) {
		super(name);
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d(TAG, "onCreate");  
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		Log.d(TAG, "onStart");  
	}
	
	@Override
	protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent");  
        try {
            Thread.sleep(100000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        Log.d(TAG, "睡眠结束");  
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");  
	}
}
