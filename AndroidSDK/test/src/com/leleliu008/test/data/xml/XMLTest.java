package com.leleliu008.test.data.xml;

import android.test.AndroidTestCase;

public class XMLTest extends AndroidTestCase {

	public void testXMLParser() {
		String xmlString = 
				"<?xml version=\"1.0\" encoding=\"utf-8\" ?>"
			  + "<biz_result>"
			      + "<status><![CDATA[success]]></status>"
				  + "<rawtext><![CDATA[打开新浪网]]></rawtext>"
				  + "<result>"
				      + "<focus><![CDATA[website]]></focus>"
					  + "<object>"
					      + "<name><![CDATA[新浪网]]></name>"
						  + "<code><![CDATA[http://www.sina.com.cn]]></code>"
						  + "<type><![CDATA[known]]></type>"
					  + "</object>"
				  + "</result>"
			  + "</biz_result>";
		
		ConcreateXmlParser xmlParser = new ConcreateXmlParser();
		Website website = xmlParser.parse(xmlString);
		
		assertEquals(true, website != null);
		assertEquals(true, website.status());
		assertEquals("打开新浪网", website.getRawtext());
		assertEquals("website", website.getFocus());
		assertEquals("新浪网", website.getName());
		assertEquals("http://www.sina.com.cn", website.getCode());
		assertEquals("known", website.getType());
	}
}
