package com.leleliu008.test.ui;

import com.leleliu008.androidsdk.MainActivity;
import com.leleliu008.ui.CustomToast;

import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;

public class CustomToastTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mainActivity;
	
	public CustomToastTest() {
		super(MainActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mainActivity = getActivity();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		mainActivity = null;
	}
	
	public void testCustomToat() throws Exception {
		CustomToast.makeText(mainActivity, "我是自定义Toast", 50000).show();
		SystemClock.sleep(50000);
	}
}
