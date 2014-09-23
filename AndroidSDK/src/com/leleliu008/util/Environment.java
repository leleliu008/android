package com.leleliu008.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.WindowManager;

/**
 * 应用程序的环境
 * 
 * @author 792793182@qq.com
 * 
 */
public final class Environment {
	private static final String TAG = Environment.class.getSimpleName();
   
	private static int mScreenWidth;
	private static int mScreenHeight;
	
	private static class InstanceHolder {
		private static Environment instance = new Environment();
	}

	private Environment() { }
	
    public static Environment getInstance() {
        return InstanceHolder.instance;
    }
    
	/**
	 * 获取系统版本号
	 */
	public static int getOSVersionCode() {
		return Build.VERSION.SDK_INT;
	}
   
	/**
	 * 获取系统代号
	 */
    public static String getOSVersionName() {
		return Build.VERSION.RELEASE;
	}
    
    /**
     * 获取系统唯一标志
     */
    public static String getPhoneModel() {
		return Build.MODEL;
	}
    
    /**
     * 获取屏幕宽度
     * @param context 上下文
     * @return        屏幕宽度（单位：px）
     */
    public static int getScreenWidth(Context context) {
    	if (0 == mScreenWidth) {
    		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        	mScreenWidth = windowManager.getDefaultDisplay().getWidth();
		}
    	return mScreenWidth;
	}
	
    /**
     * 获取屏幕高度
     * @param context 上下文
     * @return        屏幕高度（单位：px）
     */
    public static int getScreenHeight(Context context) {
    	if (0 == mScreenHeight) {
    		WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        	mScreenHeight = windowManager.getDefaultDisplay().getHeight();
		}
    	return mScreenHeight;
	}
    
    /**
     * 获取灵犀的版本号
     * @param context 上下文
     * @return
     */
    public static int getMyVersionCode(Context context) {
        try {
        	PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (Exception e) {
        	Log.e(TAG, "getMyVersionCode()", e);
        }
        return 0;
    }
    
    /**
     * 获取灵犀的版本代号
     * @param context 上下文
     * @return
     */
    public static String getMyVersionName(Context context) {
        try {
            PackageManager pm = context.getPackageManager();
            PackageInfo packageInfo = pm.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
            Log.e(TAG, "getMyVersionName()", e);
        }
        return null;
    }
    
    /**
	 * 判断外部存储器是否可用
	 * @return
	 */
    public static boolean isExternalStorageAvailable() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }
    
    /**
	 * 手机可用存储空间，不是存储卡空间，返回值以M单位
	 * @return long
	 */
    public static long getRomAvailableSize() {
    	String path = android.os.Environment.getDataDirectory().getAbsolutePath();  
        StatFs fileStats = new StatFs(path);   
        fileStats.restat(path);
        return (long)fileStats.getAvailableBlocks() * (long)fileStats.getBlockSize() / 1024 / 1024; 
    }
    
    public static boolean isWifi(Context context) {
		// 获取系统的连接服务
		ConnectivityManager connectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		// 获取网络的连接情况
		NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
		return activeNetInfo != null && activeNetInfo.getType() == ConnectivityManager.TYPE_WIFI;
	}
	
	/**
     * 转换网络类型到字符串
     */
    public static String getNetworkTypeName(Context context) {
    	if (context == null) {
			return "";
		}
    	
    	String res = "";
    	int type = 0;
    	
        TelephonyManager telephonyManager = (TelephonyManager)context.getApplicationContext()
                .getSystemService(Context.TELEPHONY_SERVICE);        
        
        if (null != telephonyManager) {
            type = telephonyManager.getNetworkType();
        }
        
        switch (type) {
        case TelephonyManager.NETWORK_TYPE_GPRS:
            res = "GPRS";
            break;
        case TelephonyManager.NETWORK_TYPE_EDGE:
            res = "EDGE";
            break;
        case TelephonyManager.NETWORK_TYPE_UMTS:
            res = "UMTS";
            break;
        case TelephonyManager.NETWORK_TYPE_HSDPA:
            res = "HSDPA";
            break;
        case TelephonyManager.NETWORK_TYPE_HSUPA:
            res =  "HSUPA";
            break;
        case TelephonyManager.NETWORK_TYPE_HSPA:
            res =  "HSPA";
            break;
        case TelephonyManager.NETWORK_TYPE_CDMA:
            res =  "CDMA";
            break;
        case TelephonyManager.NETWORK_TYPE_EVDO_0:
            res =  "EVDO_0";
            break;
        case TelephonyManager.NETWORK_TYPE_EVDO_A:
            res =  "EVDO_A";
            break;
        case TelephonyManager.NETWORK_TYPE_EVDO_B:
            res =  "EVDO_B";
            break;
        case TelephonyManager.NETWORK_TYPE_1xRTT:
            res =  "1xRTT";
            break;
        case TelephonyManager.NETWORK_TYPE_LTE:
            res =  "LTE";
            break;
        case TelephonyManager.NETWORK_TYPE_EHRPD:
            res =  "EHRPD";
            break;
        case TelephonyManager.NETWORK_TYPE_IDEN:
            res =  "IDEN";
            break;
        case TelephonyManager.NETWORK_TYPE_HSPAP:
            res =  "HSPAP";
            break;
        default:
            res = "UNKNOWN";
            break;
        }
        return res + ";" + type;
    }
    
    /**
     * 判断是否是小米的ROM
     */
    public static boolean isMIUIRom(){
		try {
			Class.forName("miui.os.Build");
			return true;
		} catch (Exception e) {
			Log.d(TAG, "isMIUIRom | catch exception");
			return false;
		}
    }
    
}
