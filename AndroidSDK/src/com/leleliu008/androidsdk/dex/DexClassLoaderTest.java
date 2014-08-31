package com.leleliu008.androidsdk.dex;

import java.io.File;

import com.leleliu008.androidsdk.R;
import com.leleliu008.plugin.IPlugin;
import com.leleliu008.plugin.PluginInfo;
import com.leleliu008.plugin.ProxyActivity;

import dalvik.system.DexClassLoader;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

public class DexClassLoaderTest extends Activity {

	@SuppressWarnings("rawtypes")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_bind_service);

		try {
			String apkPath = Environment.getExternalStorageDirectory()
					.getAbsolutePath() + "/plugin.dex";

			File dexOutputDir = getDir("dex", Context.MODE_PRIVATE);

			DexClassLoader classLoader = new DexClassLoader(apkPath,
					dexOutputDir.getAbsolutePath(), null, getClassLoader());

			Class clazz = classLoader
					.loadClass("com.leleliu008.plugin.XXPluginInfo");
			Log.d("xx", "classLoader1 = " + clazz.getClassLoader());
			Log.d("xx", "classLoader2 = " + PluginInfo.class.getClassLoader());
			PluginInfo pluginInfo = (PluginInfo) clazz.newInstance();

			Class pluginClazz = pluginInfo.getPluginClass();
			IPlugin plugin = (IPlugin) pluginClazz.newInstance();
			int result = plugin.add(2, 3);
			Log.d("xx", "result = " + result);
			
			Intent intent = new Intent(this, ProxyActivity.class);
			intent.putExtra(ProxyActivity.EXTRA_DEX_PATH, apkPath);
			intent.putExtra(ProxyActivity.EXTRA_ACTIVITY_NAME, "com.leleliu008.plugin.XXActivity");
			startActivity(intent);
		} catch (Exception e) {
			Log.e("xx", "", e);
		}

	}
}
