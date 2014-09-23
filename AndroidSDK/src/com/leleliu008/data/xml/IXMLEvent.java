package com.leleliu008.data.xml;

import java.util.Map;

/**
 * XML事件
 * 
 * @author 792793182@qq.com
 *
 */
interface IXMLEvent<Result> {

	void onDocumentStart();
	
	void onTagStart(String tagName, int depth, Map<String, String> attributes);
	
	void onText(String tagName, int depth, String text);
	
	void onTagEnd(String tagName, int depth, Map<String, String> attributes, String text);
	
	Result onDocumentEnd();
}
