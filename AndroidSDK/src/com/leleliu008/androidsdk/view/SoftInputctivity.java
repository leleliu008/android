package com.leleliu008.androidsdk.view;

import com.leleliu008.androidsdk.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class SoftInputctivity extends Activity {

	private Button bottomButton;
	private EditText editText;
	private boolean isSoftInputMethodShowing;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bottomButton = (Button) findViewById(R.id.bottom_btn);
		editText = (EditText) findViewById(R.id.edit);
		editText.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				editText.requestFocus();
				editText.requestFocusFromTouch();
				
				showSoftInput(SoftInputctivity.this, editText);
			}
		});
		final View buble = findViewById(R.id.buble);
		final View btnPanel = findViewById(R.id.btn_panel);
		
		final View scroView = findViewById(R.id.scrollview);
		final View rootView = findViewById(R.id.root);
		rootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
			
			@Override
			public void onGlobalLayout() {

				buble.getLocationOnScreen(bubleonscreen);
				rootView.getLocationOnScreen(rootonscreen);
				Log.d("xx", "rootview = " + rootView.getRootView());
				int softInputMethodHeight = rootView.getRootView().getHeight() - rootView.getHeight() - rootonscreen[1];
				Log.d("xx", "old = " + rootView.getRootView().getHeight() + " new = " + scroView.getHeight() + "softInputMethodHeight = " + softInputMethodHeight);
				if (softInputMethodHeight > 200) {
					btnPanel.setVisibility(View.VISIBLE);
					bottomButton.setVisibility(View.GONE);
					int xx = (rootonscreen[1] + scroView.getHeight()) - (bubleonscreen[1] + buble.getHeight());
					Log.d("xx", "xx = " + xx);
					if (true) {
						scroView.scrollBy(0, 252);
					}
					
				} else {
					btnPanel.setVisibility(View.GONE);
					bottomButton.setVisibility(View.VISIBLE);
				}
			}
		});
	}
	int[] rootonscreen = new int[2];
	int[] bubleonscreen = new int[2];
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void showSoftInput(Context context, EditText editText) {
		if (context == null || editText == null) {
			return;
		}
		
		final InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE); 
		if (imm != null) {
			isSoftInputMethodShowing = true;
			imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED); 
		}
	}
	
	private void hideSoftInput(Context context, EditText editText) {
		if (context == null || editText == null) {
			return;
		}
		
		InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (imm != null && imm.isActive(editText)) {
			isSoftInputMethodShowing = false;
			imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
		}
	}
	
	public boolean isSoftInputMethodShowing() {
		return isSoftInputMethodShowing;
	}
	
}
