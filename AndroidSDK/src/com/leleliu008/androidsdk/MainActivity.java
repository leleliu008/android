package com.leleliu008.androidsdk;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
//		TextView textView = (TextView) findViewById(R.id.textview);
//		textView.setBackgroundDrawable(ShapeTest.getRoundRectShape());
		
		Drawable drawable = getResources().getDrawable(R.drawable.clip);
		final ClipDrawable clipDrawable = new ClipDrawable(drawable, Gravity.CENTER, ClipDrawable.HORIZONTAL);
		findViewById(R.id.rootview).setBackgroundDrawable(clipDrawable);
		
		final Handler handler = new Handler() {
			
			@Override
			public void handleMessage(Message msg) {
				clipDrawable.setLevel(clipDrawable.getLevel() + 1);
			}
		};
		
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if (clipDrawable.getLevel() == 10000) {
					timer.cancel();
				} else {
					Message.obtain(handler).sendToTarget();
				}
			}
		}, 1000, 1);
	}
}

