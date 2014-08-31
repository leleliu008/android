package com.leleliu008.androidsdk.exec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;

import com.leleliu008.androidsdk.sign.SignVerify;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;

public class ExecTest extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setTitle("执行可执行文件测试");

		TextView textView = new TextView(this);
		textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		textView.setTextColor(Color.RED);

		setContentView(textView);

		textView.setText(exec("/data/app/MainActivity"));
		
		String publicKey = SignVerify.getInstalledAppPublicKeys(this)[0].toString();
		int x = publicKey.indexOf("modulus");
		int y = publicKey.indexOf("public");
		publicKey = publicKey.substring(x + 8, y - 1);
		
		try {
			byte[] md5 = MessageDigest.getInstance("MD5").digest(publicKey.getBytes());
			String xxString = new String(md5, "utf-8");
			textView.setText(xxString);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static String exec(String command) {
		BufferedReader bufferedReader = null;
		try {
			Process process = Runtime.getRuntime().exec(command);
			process.waitFor();
			InputStream is = process.getInputStream();
			bufferedReader = new BufferedReader(new InputStreamReader(is));
			StringBuilder result = new StringBuilder();
			String lineStr = null;
			while ((lineStr = bufferedReader.readLine()) != null) {
				result.append(lineStr + "\n");
			}
			return result.toString();
		} catch (Exception e) {
			Log.e("xx", "onCreate()", e);
			return "error!";
		} finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
