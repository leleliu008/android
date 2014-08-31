package com.leleliu008.androidsdk.service;

import com.leleliu008.androidsdk.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ServiceTest1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("服务中做耗时操作出现ANR测试");
		
//		Intent intent = new Intent(this, ANRService.class);
//		startService(intent);
		
		for (int i = 0; i < 10; i++) {
			Intent intent = new Intent(this, ConcurrentService.class);
			startService(intent);
		}
		
		findViewById(R.id.xx_btn).setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ServiceTest1.this, ConcurrentService.class);
				stopService(intent);
			}
		});
	}
}
