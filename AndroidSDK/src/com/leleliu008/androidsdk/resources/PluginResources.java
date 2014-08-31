package com.leleliu008.androidsdk.resources;

import java.lang.reflect.Method;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * 通过android.content.res.AssetManager.addAssetPath(String path)方法
 * 
 * @author 792793182@qq.com 2014-1-14
 *
 */
public final class PluginResources extends Resources {
	
	private PluginResources(AssetManager assets, DisplayMetrics metrics, Configuration config) {
		super(assets, metrics, config);
	}

	public static PluginResources obtain(Context context, String apkFilePath) {
		try {
			//创建一个AssetManager实例，并调用addAssetPath方法将apk包进入路径中
			Class<AssetManager> assetManagerClass = AssetManager.class;
			AssetManager assetManager = assetManagerClass.newInstance();
			Method addAssetPathMethod = assetManagerClass.getDeclaredMethod("addAssetPath", String.class);
			addAssetPathMethod.invoke(assetManager, apkFilePath);
			
			//宿主的资源包
			Resources resources = context.getResources();
			
			return new PluginResources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
