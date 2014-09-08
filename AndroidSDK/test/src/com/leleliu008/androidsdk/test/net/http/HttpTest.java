package com.leleliu008.androidsdk.test.net.http;

import com.leleliu008.androidsdk.MainActivity;
import com.leleliu008.androidsdk.R;
import com.leleliu008.androidsdk.net.http.HttpRequestManager;
import com.leleliu008.androidsdk.net.http.RequestMethod;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageView;

public class HttpTest extends ActivityInstrumentationTestCase2<MainActivity>{

	private MainActivity activity;
	
	public HttpTest() {
		super(MainActivity.class);
	}
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		activity = null;
	}
	
	public void testHttpRequestManager1() {
		final ImageView imageView = (ImageView) getActivity().findViewById(R.id.imageview);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				HttpRequestManager httpRequestManager = new HttpRequestManager();
				String urlStr = "http://www.baidu.com/img/bdlogo.png";
				try {
					byte[] data = httpRequestManager.request(RequestMethod.HttpUrlConnection, urlStr);
					Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
					final BitmapDrawable bitmapDrawable = new BitmapDrawable(activity.getResources(), bitmap);
					imageView.post(new Runnable() {
						
						@Override
						public void run() {
							if (imageView != null) {
								imageView.setBackgroundDrawable(bitmapDrawable);
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		SystemClock.sleep(10000);
	}
	
	public void testHttpRequestManager2() {
		final ImageView imageView = (ImageView) getActivity().findViewById(R.id.imageview);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				HttpRequestManager httpRequestManager = new HttpRequestManager();
				String urlStr = "http://f.hiphotos.baidu.com/image/pic/item/3b87e950352ac65c5d7a42fcf9f2b21192138ac5.jpg";
				try {
					byte[] data = httpRequestManager.request(RequestMethod.HttpClient, urlStr);
					Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
					final BitmapDrawable bitmapDrawable = new BitmapDrawable(activity.getResources(), bitmap);
					imageView.post(new Runnable() {
						
						@Override
						public void run() {
							if (imageView != null) {
								imageView.setBackgroundDrawable(bitmapDrawable);
							}
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		SystemClock.sleep(10000);
	}
}
