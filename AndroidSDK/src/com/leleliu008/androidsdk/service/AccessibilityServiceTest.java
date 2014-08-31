package com.leleliu008.androidsdk.service;

import android.accessibilityservice.AccessibilityService;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class AccessibilityServiceTest extends AccessibilityService {

	@Override
	protected void onServiceConnected() {
		super.onServiceConnected();
		
		Log.d("xx", "onServiceConnected()");
	}
	
	@Override
	public void onAccessibilityEvent(AccessibilityEvent event) {
		
	}

	@Override
	public void onInterrupt() {
		
	}

}
