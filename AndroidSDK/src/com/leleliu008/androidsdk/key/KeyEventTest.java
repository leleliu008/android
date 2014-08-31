package com.leleliu008.androidsdk.key;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;

public class KeyEventTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		return super.dispatchKeyEvent(event);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		boolean result = super.onKeyUp(keyCode, event);
		new Throwable().printStackTrace();
		return result;
	}
}
