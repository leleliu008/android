package com.leleliu008.androidsdk;

import com.leleliu008.androidsdk.localsocket.Client;
import com.leleliu008.androidsdk.localsocket.Server;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Intent serverIntent = new Intent(this, Server.class);
		startService(serverIntent);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Intent clientIntent = new Intent(this, Client.class);
		startService(clientIntent);
	}
}

