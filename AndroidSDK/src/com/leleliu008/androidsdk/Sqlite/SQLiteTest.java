package com.leleliu008.androidsdk.Sqlite;

import java.io.File;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
/**
 * 测试不使用SQLiteOpenHelper进行数据库操作
 * @author leleliu008
 *
 */
public class SQLiteTest {

	private static final String TAG = "SQLiteTest";
	private static final String DB_NAME = "test.db";
	private static final String SQL = "CREATE TABLE [person] ("
			                        + "[id] INTEGER PRIMARY KEY AUTOINCREMENT,"
			                        + "[name] TEXT,"
			                        + "[age] INTEGER);";
	
	public static void xx(Context context) {
		SQLiteDatabase db = context.openOrCreateDatabase(DB_NAME, Context.MODE_PRIVATE, null);
		db.execSQL(SQL);
		db.execSQL("INSERT INTO person VALUES(1, '张三', 18)");
		db.execSQL("INSERT INTO person VALUES(2, '李四', 19)");
		db.execSQL("INSERT INTO person VALUES(3, '王五', 20)");
		db.close();
		
		File file = context.getDatabasePath(DB_NAME);
		Log.i(TAG, file.getPath());
	}
}
