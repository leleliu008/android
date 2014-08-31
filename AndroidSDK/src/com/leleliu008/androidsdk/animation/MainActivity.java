package com.leleliu008.androidsdk.animation;

import com.leleliu008.androidsdk.R;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		ImageView imageView = (ImageView) findViewById(R.id.imageview);
//		imageView.setBackgroundResource(R.drawable.animation);
//		AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getBackground();
//		animationDrawable.start();
		
//		RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//		rotateAnimation.setDuration(1000);
//		rotateAnimation.setInterpolator(new LinearInterpolator());
//		rotateAnimation.setRepeatCount(RotateAnimation.INFINITE);
//		ImageView imageView = (ImageView) findViewById(R.id.imageview);
//		imageView.setBackgroundResource(R.drawable.spinner_114_0);
//		imageView.startAnimation(rotateAnimation);
		
		
		Intent intent = new Intent(this, XXService.class);
		startService(intent);
		
		
//		RotateView rotateView = (RotateView) findViewById(R.id.rotateview);
//		rotateView.start();
//		new Son1().xx();
//		
//		
//		String log_str = "type:oplog;opcode: 01001; starttime:2012-12-05 19:01:01;";	
//    	try {
//    		boolean isCpaOperation = false ;
//            String opCode = "";
//            //判断 LOG的OpCode
//            String[] strings = log_str.split(";");
//            if (null != strings && strings.length > 0) {
//            	for (String string : strings) {
//            		String[] strs = string.split(":");
//                	if (null != strs && strs.length == 2) {
//                		if ("opcode".equals(strs[0].trim())) {
//    						opCode = strs[1].trim();
//    						break;
//    					}
//                	}
//    			}
//    		}
//            Log.d("xx", "opCode = " + opCode);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//    	try {
//    		TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);
//        	//读取系统设置
//        	Class telephonymanager = Class.forName("android.telephony.TelephonyManager");
//            Method getMmsDefaultSim = telephonymanager.getDeclaredMethod("getSmsDefaultSim");
//            getMmsDefaultSim.setAccessible(true);
//            int phoneid = (Integer) getMmsDefaultSim.invoke(telephonyManager);
//            Log.d("xx", "phoneid = " +phoneid);
//    	} catch (Exception e) {
//    		e.printStackTrace();
//    		Log.d("xx", e.getMessage());
//    	}
	}

	
//	@Override
//	public void onWindowFocusChanged(boolean hasFocus) {
//		super.onWindowFocusChanged(hasFocus);
//		if (hasFocus) {
//			AnimationDrawable animationDrawable = new AnimationDrawable();
//			animationDrawable.setOneShot(false);
//			for (int i = 0; i < 12; i++) {
//				String name = "spinner_114_" + i;
//				int id = getResources().getIdentifier(name, "drawable", getPackageName());
//				Drawable drawable = getResources().getDrawable(id);
//				animationDrawable.addFrame(drawable, 150);
//			}
//			ImageView imageView = (ImageView) findViewById(R.id.imageview);
//			imageView.setBackgroundDrawable(animationDrawable);
//			animationDrawable.start();
//		}
//	}
	
}
