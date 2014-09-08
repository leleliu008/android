package com.leleliu008.androidsdk.test.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

import com.leleliu008.androidsdk.Sqlite.DBHelper;

public class SqliteTest extends AndroidTestCase {
	private Context context;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		context = getContext();
	}
	
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		context = null;
	}

	public void testSqlite() throws Exception {
		DBHelper dbHelper = new DBHelper(context);
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
