package com.leleliu008;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		TextView textView = new TextView(this);
		textView.setText("xx");
		setContentView(textView);
		
		Foo.main(null);
		Foo2.main(null);
	}
}
