package com.leleliu008.test.data.xml;

import java.util.Map;

import com.leleliu008.data.xml.XMLPullParser;

import android.util.Log;

public class ConcreateXmlParser extends XMLPullParser<Website> {

	private static final String TAG = "XMLPullParser";
	
	private Website website;
	
	@Override
	public void onDocumentStart() {
		Log.i(TAG, "onDocumentStart()");
		website = new Website();
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
		
		if ("status".equals(tagName)) {
			website.setStatus("success".equals(text));
		} else if ("rawtext".equals(tagName)) {
			website.setRawtext(text);
		} else if ("focus".equals(tagName)) {
			website.setFocus(text);
		} else if ("name".equals(tagName)) {
			website.setName(text);
		} else if ("code".equals(tagName)) {
			website.setCode(text);
		} else if ("type".equals(tagName)) {
			website.setType(text);
		}
	}

	@Override
	public Website onDocumentEnd() {
		Log.i(TAG, "onDocumentEnd()");
		return website;
	}
	
}
