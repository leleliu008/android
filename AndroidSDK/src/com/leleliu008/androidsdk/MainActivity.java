package com.leleliu008.androidsdk;

import com.leleliu008.androidsdk.Sqlite.DBHelper;
import com.leleliu008.androidsdk.Sqlite.SQLiteTest;
import com.leleliu008.androidsdk.localsocket.Client;
import com.leleliu008.androidsdk.localsocket.Server;
import com.leleliu008.androidsdk.net.http.HttpRequestManager;
import com.leleliu008.androidsdk.net.http.RequestMethod;

import android.os.Bundle;
import android.widget.ImageView;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;

public class MainActivity extends Activity {
	
	private ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imageView = (ImageView) findViewById(R.id.imageview);
		/*Intent serverIntent = new Intent(this, Server.class);
		startService(serverIntent);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Intent clientIntent = new Intent(this, Client.class);
		startService(clientIntent);*/
		
		DBHelper dbHelper = new DBHelper(this);
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		try {
			db.execSQL("INSERT INTO [person] VALUES(1, '张三', 18)");
			db.execSQL("INSERT INTO [person] VALUES(2, '李四', 19)");
			db.execSQL("INSERT INTO [person] VALUES(3, '王五', 20)");
		} catch (Exception e) {
			e.printStackTrace();
		}
		dbHelper.close();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				HttpRequestManager httpRequestManager = new HttpRequestManager();
				String urlStr = "http://www.baidu.com/img/bdlogo.png";
				try {
					byte[] data = httpRequestManager.request(RequestMethod.HttpUrlConnection, urlStr);
					Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
					final BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
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
	}
}

