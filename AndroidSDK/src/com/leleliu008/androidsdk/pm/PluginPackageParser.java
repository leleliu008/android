package com.leleliu008.androidsdk.pm;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import android.util.Log;

public final class PluginPackageParser {
	
	private static final String TAG = "PluginPackageParser";
	
	private PluginPackageParser() { }

	/**
	 * 异步获取插件包信息
	 * @param context     上下文
	 * @param apkFilePath apk包完整路径
	 * @param listener    解析完成的回调
	 */
	public static void getAPKInfoAsynchronous(final Context context, final String apkFilePath, final ParserFinishedListener listener) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				PluginPackageInfo pluginPackageInfo = getAPKInfoSynchronous(context, apkFilePath);
				if (listener != null) {
					listener.onFinished(pluginPackageInfo);
				}
			}
		}).start();
	}
	
	/**
	 * 同步获取插件包信息
	 * @param context     上下文
	 * @param apkFilePath apk包完整路径
	 * @return
	 */
	public static PluginPackageInfo getAPKInfoSynchronous(Context context, String apkFilePath) {
		if (context == null || TextUtils.isEmpty(apkFilePath)) {
			return null;
		}
		PackageManager pm = context.getPackageManager();
		
		PackageInfo packageInfo = pm.getPackageArchiveInfo(apkFilePath, PackageManager.GET_ACTIVITIES
				                                                      | PackageManager.GET_SERVICES
				                                                      | PackageManager.GET_RECEIVERS
				                                                      | PackageManager.GET_PROVIDERS
				                                                      | PackageManager.GET_PERMISSIONS);
		if (packageInfo == null) {
			return null;
		}
		
		Log.d(TAG, "插件包的版本号：" + packageInfo.versionCode);
		Log.d(TAG, "插件包的版本名：" + packageInfo.versionName);
		Log.d(TAG, "插件包的包名：" + packageInfo.packageName);
		Log.d(TAG, "插件包与哪个包运行在同一个进程中：" + packageInfo.sharedUserId);
		
		ApplicationInfo applicationInfo = packageInfo.applicationInfo;
		if (applicationInfo == null) {
			return null;
		}
		
		Log.d(TAG, "插件包的应用程序类名：" + applicationInfo.className);
		
		PluginPackageInfo pluginPackageInfo = new PluginPackageInfo();
		
		//获取所有的注册的Activity，需要设置PackageManager.GET_ACTIVITIES
		ActivityInfo[] activityInfos = packageInfo.activities;
		if (activityInfos != null) {
			for (ActivityInfo activityInfo : activityInfos) {
				if (activityInfo == null) {
					continue;
				}
				
				Log.d(TAG, "插件包的Activity的类名：" + activityInfo.name);
			}
		}
		
		//获取所有的注册的Service
		ServiceInfo[] serviceInfos = packageInfo.services;
		if (serviceInfos != null) {
			for (ServiceInfo serviceInfo : serviceInfos) {
				if (serviceInfo == null) {
					continue;
				}
				
				Log.d(TAG, "插件包的Service的类名：" + serviceInfo.name);
			}
		}
		
		//获取所有的注册的BroadcastReceiver
		ActivityInfo[] receiverInfos = packageInfo.receivers;
		if (receiverInfos != null) {
			for (ActivityInfo receiverInfo : receiverInfos) {
				if (receiverInfo == null) {
					continue;
				}
				
				Log.d(TAG, "插件包的BroadcastReceiver的类名：" + receiverInfo.name);
			}
		}
		
		//获取所有的注册的ContentProvider
		ProviderInfo[] providerInfos = packageInfo.providers;
		if (providerInfos != null) {
			for (ProviderInfo providerInfo : providerInfos) {
				if (providerInfo == null) {
					continue;
				}
				
				Log.d(TAG, "插件包的ContentProvider的类名：" + providerInfo.name);
			}
		}
		
		//获取所有的注册的权限
		PermissionInfo[] permissionInfos = packageInfo.permissions;
		if (permissionInfos != null) {
			for (PermissionInfo permissionInfo : permissionInfos) {
				if (permissionInfo == null) {
					continue;
				}
				
				Log.d(TAG, "插件包的需要的权限：" + permissionInfo.name);
			}
		}
		
		
		String[] usePermissions = packageInfo.requestedPermissions;
		if (usePermissions != null) {
			for (String usePermission : usePermissions) {
				Log.d(TAG, "插件包的需要的权限：" + usePermission);
			}
		}
		
		
		return pluginPackageInfo;
	}
	
	public static interface ParserFinishedListener {
		void onFinished(PluginPackageInfo pluginPackageInfo);
	}
	
}
