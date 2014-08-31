package com.leleliu008.androidsdk.telephone;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 监听广播
 * @author leleliu008
 * @date 2013-7-3
 */
public class MonitorReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		//开机启动监听服务
		Intent service = new Intent(context, MonitorService.class);
		context.startService(service);
	}

}
