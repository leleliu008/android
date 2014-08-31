package com.leleliu008.androidsdk.pm;

import com.leleliu008.androidsdk.dex.PluginClassLoader;
import com.leleliu008.androidsdk.pm.PluginPackageParser.ParserFinishedListener;
import com.leleliu008.androidsdk.resources.PluginResources;

import android.app.Activity;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

/**
 * 
 * @author fpliu@iflytek.com 2014-1-13
 *
 */
public class PackageManagerTest extends Activity {
	
	private static final String TAG = "PackageManagerTest";
	
	private Resources pluginResources;
	
	private ClassLoader pluginClassLoader;
	
	private PluginPackageInfo pluginPackageInfo;
	
	private String pluginFilePath;
	
	private ParserFinishedListener parserFinishedListener = new ParserFinishedListener() {
		
		@Override
		public void onFinished(PluginPackageInfo pluginPackageInfo) {
			Log.d(TAG, "解析完成");
			PackageManagerTest.this.pluginPackageInfo = pluginPackageInfo;
			parserFinishedListener = null;
		}
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		pluginFilePath = Environment.getExternalStorageDirectory() + "/ViaFly/lingxi_v2.0.release_1260.apk";
		PluginPackageParser.getAPKInfoAsynchronous(this, pluginFilePath, parserFinishedListener);
		pluginClassLoader = PluginClassLoader.obtain(this, pluginFilePath);
		pluginResources = PluginResources.obtain(this, pluginFilePath);
		
		int resID = pluginResources.getIdentifier("ls_arrow_down", "drawable", "com.iflytek.cmcc");
		Log.d(TAG, "resID = " + resID);
		Drawable drawable = pluginResources.getDrawable(resID);
		ImageView imageView = new ImageView(this);
		imageView.setImageDrawable(drawable);
		setContentView(imageView);
		
		int layoutID = pluginResources.getIdentifier("viafly_main_speech_speechevagame_layout", "layout", "com.iflytek.cmcc");
		XmlResourceParser xmlResourceParser = pluginResources.getLayout(layoutID);
		View view = getLayoutInflater().inflate(xmlResourceParser, null);
		Log.d(TAG, "view = " + view);
		setContentView(view);
	}
	
	@Override
	public ClassLoader getClassLoader() {
		return pluginClassLoader == null ? super.getClassLoader() : pluginClassLoader;
	}
	
	@Override
	public Resources getResources() {
		return pluginResources == null ? super.getResources() : pluginResources;
	}
	
	@Override
	public String getPackageName() {
		return "com.iflytek.cmcc";
	}
	
	/**
	 * 扩展服务
	 */
	@Override
	public Object getSystemService(String name) {
		return super.getSystemService(name);
	}
}
