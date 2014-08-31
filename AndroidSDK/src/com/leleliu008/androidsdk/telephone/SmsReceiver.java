package com.leleliu008.androidsdk.telephone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * 监听短信接收广播
 * @author leleliu008
 * @date 2013-7-3
 */
public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if ("android.provider.Telephony.SMS_RECEIVED".equals(intent.getAction())) {
			
		}
		Bundle bundle = intent.getExtras();
		Object messages[] = (Object[]) bundle.get("pdus");
		SmsMessage[] smsMessage = new SmsMessage[messages.length];
		for (int n = 0; n < messages.length; n++) {
			smsMessage[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
			Log.d("xx", smsMessage[n].getOriginatingAddress());
			Log.d("xx", smsMessage[n].getMessageBody());
			Log.d("xx", "" + smsMessage[n].getIndexOnIcc());
		}
		//拦截后其他软件就接收不到了
		//abortBroadcast();
	}

}
