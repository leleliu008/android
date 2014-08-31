package com.leleliu008.androidsdk.view;

import com.leleliu008.androidsdk.R;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.LinearLayout;

/**
 * 测试Canvas
 * @author leleliu008
 * @date 2013.01.17
 */

public class CanvasTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		LinearLayout linearLayout = new LinearLayout(this);
		
		setContentView(linearLayout);
		
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		Canvas canvas = new Canvas(bitmap);
		canvas.drawARGB(255, 255, 0, 0);
		
		
		linearLayout.setBackgroundDrawable(new BitmapDrawable(bitmap));
	}
}
