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
		
		Foo.func1();
		
		Foo foo = new Foo();
		
		foo.func2();
		foo.func3(true);
		foo.func4("a".getBytes()[0]);
		foo.func5('A');
		foo.func6((short)5);
		foo.func7(5);
		foo.func8(5L);
		foo.func9(5.0f);
		foo.func10(10.0);
		foo.func11("Hello World!");
		foo.func12(new Foo());
	}
}
