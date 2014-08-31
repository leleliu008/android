package com.leleliu008.androidsdk.fragment;

import java.util.ArrayList;

import com.leleliu008.androidsdk.R;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

public class FragmentTest extends FragmentActivity {

	private static final String TAG = "FragmentTest";
	
	private HelpFragment helpFragment;
	
	private AboutFragment aboutFragment;
	
	private OtherFragment otherFragment;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		Log.d(TAG, "onCreate");
		
		setContentView(R.layout.activity_fragment);
		
		FragmentManager fragmentManager = getSupportFragmentManager();
		
		//xml布局实现
		helpFragment = (HelpFragment) fragmentManager.findFragmentById(R.id.help_fragment);
		
		//硬编码实现
		aboutFragment = new AboutFragment();
		otherFragment = new OtherFragment();
		
		FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
		fragmentTransaction.hide(helpFragment);
		fragmentTransaction.hide(aboutFragment);
		fragmentTransaction.add(R.id.root, otherFragment);
//		fragmentTransaction.replace(R.id.root, otherFragment);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
		fragmentTransaction.commit();
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(TAG, "onResume");
		
		
	}
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d(TAG, "onRestart");
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		Log.d(TAG, "onStart");
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		Log.d(TAG, "onPause");
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(TAG, "onStop");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(TAG, "onDestroy");
		
//		Process.killProcess(Process.myPid());
	}
	
	public static void xx() {
		ArrayList<String> arrayList = new ArrayList<String>();
		
		for (int i = 0; i < 10000; i++) {
			arrayList.add("value is : " + i);
		}
	}
}
