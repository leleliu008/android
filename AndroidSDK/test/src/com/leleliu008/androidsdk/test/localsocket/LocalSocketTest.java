package com.leleliu008.androidsdk.test.localsocket;

import android.content.Context;
import android.content.Intent;
import android.test.AndroidTestCase;

import com.leleliu008.androidsdk.localsocket.Client;
import com.leleliu008.androidsdk.localsocket.Server;

public class LocalSocketTest extends AndroidTestCase {

	private Context context;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		context = getContext();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		context = null;
	}
	
	public void testLocalSocket() throws Exception {
		Intent serverIntent = new Intent(context, Server.class);
		context.startService(serverIntent);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Intent clientIntent = new Intent(context, Client.class);
		context.startService(clientIntent);
	}
}
