package com.leleliu008.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;

/**
 * 启动界面的工具类
 * 
 * @author leleliu008
 * 
 */
public final class LauncherManager {

	private static final String TAG = LauncherManager.class.getSimpleName();

	private LauncherManager() {
	}

	/**
	 * 打开网络设置
	 * 
	 * @param context
	 *            上下文
	 */
	public static void startNetSetting(Context context) {
		if (context == null) {
			return;
		}

		Intent intent = null;
		if (Build.VERSION.SDK_INT < 14) {
			intent = new Intent(Settings.ACTION_WIRELESS_SETTINGS);
		} else {
			intent = new Intent(Settings.ACTION_SETTINGS);
		}
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);

		try {
			context.startActivity(intent);
		} catch (Exception e) {
			Log.e(TAG, "startNetSetting()", e);
		}
	}

	/**
	 * 打开位置设置
	 * 
	 * @param context
	 *            上下文
	 */
	public static void startLocationSetting(Context context) {
		if (context == null) {
			return;
		}

		Intent intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
				| Intent.FLAG_ACTIVITY_SINGLE_TOP
				| Intent.FLAG_ACTIVITY_CLEAR_TOP);
		try {
			context.startActivity(intent);
		} catch (Exception e) {
			Log.e(TAG, "startLocationSetting()", e);
		}
	}

	/**
	 * 打开系统联系人应用
	 * 
	 * @param context
	 *            上下文
	 */
	public static void startContactsApp(Context context) {
		try {
			Intent intent = new Intent();
			intent.setAction(Intent.ACTION_VIEW);
			intent.setData(Uri.parse("content://contacts/people/"));
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK
					| Intent.FLAG_ACTIVITY_SINGLE_TOP
					| Intent.FLAG_ACTIVITY_CLEAR_TOP);
			context.startActivity(intent);
		} catch (Exception e) {
			Log.e(TAG, "startContactsApp()", e);
		}
	}
}
