package com.leleliu008.androidsdk;

import com.leleliu008.androidsdk.Sqlite.DBHelper;
import com.leleliu008.androidsdk.Sqlite.SQLiteTest;
import com.leleliu008.androidsdk.localsocket.Client;
import com.leleliu008.androidsdk.localsocket.Server;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/*Intent serverIntent = new Intent(this, Server.class);
		startService(serverIntent);
		
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Intent clientIntent = new Intent(this, Client.class);
		startService(clientIntent);*/
		
		/*SQLiteTest.xx(this);*/
		
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
	}
}

