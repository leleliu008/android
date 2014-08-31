package com.leleliu008.androidsdk.device;

import android.app.admin.DeviceAdminReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class DeviceReceiver extends DeviceAdminReceiver {

	private static final String TAG = "DeviceReceiver";

	@Override
	public void onEnabled(Context context, Intent intent) {
		super.onEnabled(context, intent);
		Log.d(TAG, "onEnabled()");
	}

	@Override
	public void onDisabled(Context context, Intent intent) {
		super.onDisabled(context, intent);
		Log.d(TAG, "onDisabled()");
	}

	@Override
	public void onPasswordSucceeded(Context context, Intent intent) {
		super.onPasswordSucceeded(context, intent);
		Log.d(TAG, "onPasswordSucceeded()");
	}

	@Override
	public void onPasswordFailed(Context context, Intent intent) {
		super.onPasswordFailed(context, intent);
		Log.d(TAG, "onPasswordFailed()");
	}

	@Override
	public void onPasswordExpiring(Context context, Intent intent) {
		super.onPasswordExpiring(context, intent);
		Log.d(TAG, "onPasswordExpiring()");
	}

	@Override
	public void onPasswordChanged(Context context, Intent intent) {
		super.onPasswordChanged(context, intent);
		Log.d(TAG, "onPasswordChanged()");
	}

	@Override
	public CharSequence onDisableRequested(Context context, Intent intent) {
		Log.d(TAG, "onDisableRequested()");
		return super.onDisableRequested(context, intent);
	}
}
