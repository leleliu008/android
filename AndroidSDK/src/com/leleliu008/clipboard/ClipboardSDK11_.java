package com.leleliu008.clipboard;

import android.content.Context;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * Android3.0以上（包括Android3.0）的剪贴板
 * 通篇采用反射，请看CLipData、ClipDescription、ClipboardManager的源码和方法调用
 * 
 * @author 792793182@qq.com
 */
@SuppressWarnings("rawtypes")
class ClipboardSDK11_ implements IClipboardManager {
	private static final String TAG = "ClipboardSDK11_";

	//实际上是ClipboardManager对象
	private Object mClipService;
	
	ClipboardSDK11_(Context context) {
		mClipService = context.getSystemService(Context.CLIPBOARD_SERVICE);
	}
	
	
	@SuppressWarnings("unchecked")
	@Override
	public void copy(CharSequence text) {
		try {
			Class clipDataClass = Class.forName("android.content.ClipData");
			Method method1 = clipDataClass.getMethod("newPlainText", CharSequence.class, CharSequence.class);
			Object clipDataObject = method1.invoke(null, "text", text);
			
			Method method2 = mClipService.getClass().getMethod("setPrimaryClip", clipDataClass);
			method2.invoke(mClipService, clipDataObject);
		} catch (Exception e) {
			Log.e(TAG, "copy()", e);
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public CharSequence paste() {
		CharSequence result = null;
		
		try {
			//获取剪贴板中的数据
			Method method1 = mClipService.getClass().getMethod("getPrimaryClip");
			Object clipDataObject = method1.invoke(mClipService);
			
			//获取数据类型描述
			Class clipDataClass = Class.forName("android.content.ClipData");
			Method method2 = clipDataClass.getMethod("getDescription", new Class[]{});
			Object clipDescriptionObject = method2.invoke(clipDataObject, new Object[]{});
			
			//判断是否是文本
			Class clipDescriptionClass = Class.forName("android.content.ClipDescription");
			Method method3 = clipDescriptionClass.getMethod("hasMimeType", new Class[]{String.class});
			boolean hasText = (Boolean) method3.invoke(clipDescriptionObject, "text/plain");
			if (hasText) {
				//获取第一个数据
				Method method4 = clipDataClass.getMethod("getItemAt", new Class[]{int.class});
				Object itemObject = method4.invoke(clipDataObject, 0);
				
				//获取文本
				Class itemClass = Class.forName("android.content.ClipData$Item");
				Method method5 = itemClass.getMethod("getText", new Class[]{});
				result = (CharSequence) method5.invoke(itemObject, new Object[]{});
			}
		} catch (Exception e) {
			Log.e(TAG, "paste()", e);
		} 
		return result;
	}
	
}