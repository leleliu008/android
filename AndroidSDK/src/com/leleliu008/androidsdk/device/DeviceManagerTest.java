package com.leleliu008.androidsdk.device;

import com.leleliu008.androidsdk.R;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class DeviceManagerTest extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.lock_screen);
		
		findViewById(R.id.open).setOnClickListener(this);
		findViewById(R.id.close).setOnClickListener(this);
		findViewById(R.id.system_lock).setOnClickListener(this);
		findViewById(R.id.custom_lock).setOnClickListener(this);
	}
	
	@Override
	public void onClick(View v) {
		DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
		ComponentName componentName = new ComponentName(this, DeviceReceiver.class);
		switch (v.getId()) {
		case R.id.open:
			Intent intent = new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
			intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN, componentName);
			intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION, "fsdfdf");
			startActivity(intent);
			break;
		case R.id.close:
			if (devicePolicyManager.isAdminActive(componentName)) {
				devicePolicyManager.removeActiveAdmin(componentName);
			}
			break;
		case R.id.system_lock:
			if (devicePolicyManager.isAdminActive(componentName)) {
				devicePolicyManager.lockNow();
			}
			break;
		case R.id.custom_lock:
			break;
		default:
			break;
		}
	}
}
