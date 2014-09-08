package com.leleliu008.androidsdk.test.data.xml;

import java.util.Map;

import com.leleliu008.androidsdk.data.xml.XMLPullParser;

import android.util.Log;

public class ConcreateXmlParser<Result> extends XMLPullParser<Result> {

	private static final String TAG = "XMLPullParser";
	
	@Override
	public void onDocumentStart() {
		Log.i(TAG, "onDocumentStart()");
	}

	@Override
	public void onTagStart(String tagName, int depth, Map<String, String> attributes) {
		Log.i(TAG, "onTagStart() depth = " + depth + ", tagName = " + tagName);
	}

	@Override
	public void onText(String tagName, int depth, String text) {
		Log.i(TAG, "onText()     depth = " + depth + ", tagName = " + tagName + ", text = " + text);
	}

	@Override
	public void onTagEnd(String tagName, int depth, Map<String, String> attributes, String text) {
		Log.i(TAG, "onTagEnd()   depth = " + depth + ", tagName = " + tagName + ", text = " + text);
	}

	@Override
	public Result onDocumentEnd() {
		Log.i(TAG, "onDocumentEnd()");
		return null;
	}
	
}
