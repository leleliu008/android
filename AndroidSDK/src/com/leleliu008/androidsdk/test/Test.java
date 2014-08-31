package com.leleliu008.androidsdk.test;


import android.app.Activity;
import android.os.Bundle;

public class Test extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		try {
//			Class teleClass = Class.forName("android.telephony.TelephonyManager");
//			Method getFirstMethod = teleClass.getDeclaredMethod("getFirst");
//			TelephonyManager telephonyManager1 = (TelephonyManager) getFirstMethod.invoke(null);
//			
//			Method getSecondaryMethod = teleClass.getDeclaredMethod("getSecondary");
//			TelephonyManager telephonyManager2 = (TelephonyManager) getSecondaryMethod.invoke(null);
//		
//			Field phoneIndexField = teleClass.getDeclaredField("mPhoneIndex");
//			phoneIndexField.setAccessible(true);
//			int card1 = (Integer) phoneIndexField.get(telephonyManager1);
//			int card2 = (Integer) phoneIndexField.get(telephonyManager2);
//			Log.d("xx", "card1 = " + card1 + " , card2 = " + card2);
//			
//			Method getSimStateMethod = teleClass.getDeclaredMethod("getSimState");
//			int card1State = (Integer) getSimStateMethod.invoke(telephonyManager1);
//			int card2State = (Integer) getSimStateMethod.invoke(telephonyManager2);
//			Log.d("xx", "card1State = " + card1State + " , card2State = " + card2State);
//		
////			Method getLine1NumberMethod = teleClass.getDeclaredMethod("getLine1Number");
////			String card1Number = (String) getLine1NumberMethod.invoke(telephonyManager1);
////			String card2Number = (String) getLine1NumberMethod.invoke(telephonyManager2);
////			Log.d("xx", "card1Number = " + card1Number + " , card2Number = " + card2Number);
//			
//			
//			SmsManager smsManager = SmsManager.getDefault();
//			Class<SmsManager> smsClass = (Class<SmsManager>) Class.forName("android.telephony.SmsManager");
//			
//			//Method sendTextMessageMethod = smsClass.getDeclaredMethod("sendTextMessage", String.class, String.class, String.class, PendingIntent.class, PendingIntent.class);
////			sendTextMessageMethod.invoke(smsManager, "15656059397", null, "xxxxx", null, null);
//			Method sendTextMessageMethod = smsClass.getDeclaredMethod("sendTextMessage", String.class, String.class, String.class, PendingIntent.class, PendingIntent.class, boolean.class, int.class, int.class, int.class);
//			sendTextMessageMethod.invoke(smsManager, "15656059397", null, "xxxxx", null, null, true,0,0,0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		new Throwable().printStackTrace();
	}
}
