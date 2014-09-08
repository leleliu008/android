package com.leleliu008.androidsdk.Sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * 测试使用SQLiteOpenHelper进行数据库操作
 * 
 * @author leleliu008
 *
 */
public class DBHelper extends SQLiteOpenHelper {
	private static final String TAG = "DBHelper";
	private static final String DB_NAME = "test.db";
	private static final int DB_VERSION = 2;
	private static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS [person] ("
						        + "[id] INTEGER PRIMARY KEY AUTOINCREMENT,"
						        + "[name] TEXT,"
						        + "[age] INTEGER);";
	
	public DBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}
	
	//创建
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE);
		Log.i(TAG, "step 1 :onCreate()");
	}
	
	//升级
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.beginTransaction();
		try {
			db.execSQL("ALTER TABLE [person] RENAME TO [_person]");
			db.execSQL("CREATE TABLE IF NOT EXSITS [person] ("
							        + "[id] INTEGER PRIMARY KEY AUTOINCREMENT,"
							        + "[name] TEXT,"
							        + "[age] INTEGER,"
							        + "[sex] INTEGER);");
			db.execSQL("INSERT INTO [person] ([id],[name],[age]) SELECT * FROM [_person]");
			db.execSQL("DROP TABLE IF EXISTS [_person]");
			db.setTransactionSuccessful();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.endTransaction();
		}
		
		
		//db.execSQL("ALTER TABLE [_person] ADD COLUMN [sex2] INTEGER");
		Log.i(TAG, "step 1 :onUpgrade() oldVersion = " + oldVersion + 
				                       ", newVersion = " + newVersion);
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
		Log.i(TAG, "step 2 :onOpen()");
	}
}
