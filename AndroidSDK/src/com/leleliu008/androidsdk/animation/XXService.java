package com.leleliu008.androidsdk.animation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class XXService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		 Log.d("xx", "onCreate");  
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
		super.onStart(intent, startId);
		//经测试，Service里面是不能进行耗时的操作的，必须要手动开启一个工作线程来处理耗时操作  
        Log.d("xx", "onStart");  
        try {
            Thread.sleep(100000);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
        Log.d("xx", "睡眠结束");  
	}
}
