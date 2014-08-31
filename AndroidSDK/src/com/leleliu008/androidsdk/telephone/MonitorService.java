package com.leleliu008.androidsdk.telephone;

import java.io.File;

import android.app.Service;
import android.content.Intent;
import android.media.MediaRecorder;
import android.os.Environment;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/**
 * 监听电话状态变化的服务
 * @author leleliu008
 * @date 2013-7-3
 */
public class MonitorService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		
		TelephonyManager telephonyManager = (TelephonyManager) getSystemService(TELEPHONY_SERVICE);  
        //监听电话状态变化
		telephonyManager.listen(new PhoneStateListener() {
			
			private String incomeNumber; // 来电号码
			private MediaRecorder mediaRecorder;
			private File file;

			@Override
			public void onCallStateChanged(int state, String incomingNumber) {
				super.onCallStateChanged(state, incomingNumber);

				try {
					switch (state) {
					case TelephonyManager.CALL_STATE_RINGING: // 来电
						this.incomeNumber = incomingNumber;
						break;
					case TelephonyManager.CALL_STATE_OFFHOOK: // 接通电话
						file = new File(Environment.getExternalStorageDirectory(), this.incomeNumber + System.currentTimeMillis() + ".3gp");
						if (null == file) {
							file = new File(Environment.getDataDirectory(), this.incomeNumber + System.currentTimeMillis() + ".3gp"); 
						}
						mediaRecorder = new MediaRecorder();
						mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC); // 获得声音数据源
						mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP); // 按3gp格式输出
						mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
						mediaRecorder.setOutputFile(file.getAbsolutePath()); // 输出文件
						mediaRecorder.prepare(); // 准备
						mediaRecorder.start();
						break;
					case TelephonyManager.CALL_STATE_IDLE: // 挂掉电话
						if (mediaRecorder != null) {
							mediaRecorder.stop();
							mediaRecorder.release();
							mediaRecorder = null;
						}
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, PhoneStateListener.LISTEN_CALL_STATE);
	}
	
}
