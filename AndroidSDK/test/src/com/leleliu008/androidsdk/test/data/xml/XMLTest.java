package com.leleliu008.androidsdk.test.data.xml;

import android.test.AndroidTestCase;

public class XMLTest extends AndroidTestCase {

	public void testXMLParser() {
		String xmlString = 
			"<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
			"<root>"
				+ "<second>"
					+ "<xx k='ss'/>"
					+ "<yy k2='vv'/>"
					+ "<zz>ggggg</zz>"
					+ "<jj>hhhhh</jj>"
				+ "</second>"
			+ "</root>";
		
		ConcreateXmlParser<String> xml = new ConcreateXmlParser<String>();
		xml.parse(xmlString);
	}
}
