package com.leleliu008.clipboard;

import android.content.Context;
import android.os.Build;

/**
 * 剪贴板功能代理类
 * 
 * @author 792793182@qq.com
 */
public final class ClipboardManager implements IClipboardManager {

	private static volatile ClipboardManager mInstance;
	
	private IClipboardManager mClipboardManager;
	
	private ClipboardManager(Context context) {
		//Android3.0（内部版本号为11）前后剪贴板大不同,根据版本区分应该使用哪个
		if (Build.VERSION.SDK_INT < 11) {
			mClipboardManager = new ClipboardSDK0_11(context);
		} else {
			mClipboardManager = new ClipboardSDK11_(context);
		}
	}
	
	public static ClipboardManager getInstance(Context context) {
		if (mInstance == null) {
			synchronized (ClipboardManager.class) {
				if (mInstance == null) {
					mInstance = new ClipboardManager(context);
				}
			}
		}
		return mInstance;
	}
	
	@Override
	public void copy(CharSequence text) {
		mClipboardManager.copy(text);
	}

	@Override
	public CharSequence paste() {
		return mClipboardManager.paste();
	}
}