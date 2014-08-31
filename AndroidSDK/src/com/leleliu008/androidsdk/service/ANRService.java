package com.leleliu008.androidsdk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class ANRService extends Service {

	private static final String TAG = "ANRService";
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		 Log.d(TAG, "onCreate");  
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		//经测试，Service里面是不能进行耗时的操作的，必须要手动开启一个工作线程来处理耗时操作  
        Log.d(TAG, "onStart");  
        try {
            Thread.sleep(100000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        Log.d(TAG, "睡眠结束");  
		return super.onStartCommand(intent, flags, startId);
	}
}