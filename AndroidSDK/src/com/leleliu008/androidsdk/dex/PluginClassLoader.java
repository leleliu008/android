package com.leleliu008.androidsdk.dex;

import java.io.File;

import android.content.Context;
import dalvik.system.DexClassLoader;

/**
 * 插件的类加载器
 * 
 * @author 792793182@qq.com 2014-1-15
 *
 */
public final class PluginClassLoader extends DexClassLoader {

	private PluginClassLoader(String dexPath, String optimizedDirectory,
			String libraryPath, ClassLoader parent) {
		super(dexPath, optimizedDirectory, libraryPath, parent);
	}

	public static ClassLoader obtain(Context context, String apkFilePath) {
		File dexOutputDir = context.getDir("dex", Context.MODE_PRIVATE);

		return new PluginClassLoader(apkFilePath, dexOutputDir.getAbsolutePath(), null, context.getClassLoader());
	}
}
