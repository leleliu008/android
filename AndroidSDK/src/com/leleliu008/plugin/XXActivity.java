package com.leleliu008.plugin;

import com.leleliu008.androidsdk.R;

import android.os.Bundle;

public class XXActivity extends PluginActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setTitle("我是插件的Activity");
		
		setContentView(R.layout.activity_main);
	}
}
