package com.leleliu008.androidsdk.ActivityThread;

import java.lang.reflect.Field;

import com.leleliu008.androidsdk.R;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

public class ActivityThreadTest extends Activity {

	private static final String TAG = "xx";
		
	@SuppressWarnings("rawtypes")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		try {
			Class thisClass = getClass();
			Field mMainThreadField = thisClass.getSuperclass().getDeclaredField("mMainThread");
			mMainThreadField.setAccessible(true);
			Object mMainThread = mMainThreadField.get(this);
			Log.d(TAG, "" + mMainThread.toString());
			
			Class activityThreadClass = mMainThread.getClass();
			Field activityClientRecordListField = activityThreadClass.getDeclaredField("mActivities");
			activityClientRecordListField.setAccessible(true);
			Object activityClientRecordList = activityClientRecordListField.get(mMainThread);
			Log.d(TAG, "" + activityClientRecordList.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		setContentView(R.layout.activity_main);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		setContentView(new LinearLayout(this));
	}
}
