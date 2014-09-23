package com.leleliu008.data.xml;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Stack;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/**
 * XML解析类
 * 
 * @author 792793182@qq.com
 *
 */
public abstract class XMLPullParser<Result> implements IXMLParser<Result>, IXMLEvent<Result> {

	private Stack<XmlElement> xmlElements;
	
	/* 子类可重写此方法，对XmlPullParserFactory的属性重新设置 */
	protected XmlPullParser newXmlPullParser() throws XmlPullParserException {
		XmlPullParserFactory xmlPullParserFactory = XmlPullParserFactory.newInstance();
		xmlPullParserFactory.setNamespaceAware(false);
		return xmlPullParserFactory.newPullParser();
	}
	
	@Override
	public final Result parse(String in) {
		return parse(new StringReader(in));
	}
	
	@Override
	public final Result parse(Reader in) {
		try {
			XmlPullParser xmlPullParser = newXmlPullParser();
			if (xmlPullParser != null) {
				xmlPullParser.setInput(in);
				return parser(xmlPullParser);
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public final Result parse(InputStream is) {
		try {
			XmlPullParser xmlPullParser = newXmlPullParser();
			if (xmlPullParser != null) {
				xmlPullParser.setInput(is, "utf-8");
				return parser(xmlPullParser);
			}
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private Result parser(XmlPullParser xmlPullParser) {
		while (true) {
			try {
				switch (xmlPullParser.getEventType()) {
				case XmlPullParser.START_DOCUMENT: //文档开始事件
					xmlElements = new Stack<XmlElement>();
					onDocumentStart();
					break;
				case XmlPullParser.START_TAG://标签开始事件
					String tagName = xmlPullParser.getName();
					
					int depth = xmlPullParser.getDepth();
					
					HashMap<String, String> attributes = null;
					int attributeCount = xmlPullParser.getAttributeCount();
					if (attributeCount > 0) {
						attributes = new HashMap<String, String>(attributeCount);
						for (int i = 0; i < attributeCount; i++) {
							String name = xmlPullParser.getAttributeName(i);
							String value = xmlPullParser.getAttributeValue(i);
							attributes.put(name, value);
						}
					}
					
					XmlElement xmlElement = new XmlElement();
					xmlElement.setTag(tagName);
					xmlElement.setAttributes(attributes);
					
					xmlElements.push(xmlElement);
					
					onTagStart(tagName, depth, attributes);
					break;
				case XmlPullParser.TEXT://标签之间的文本事件，如果有的话
					String text = xmlPullParser.getText();
					
					XmlElement element = xmlElements.peek();
					element.setText(text);
					
					onText(element.getTag(), xmlPullParser.getDepth(), text);
					break;
				case XmlPullParser.END_TAG://标签结束事件
					XmlElement currentElement = xmlElements.pop();
					onTagEnd(currentElement.getTag(), xmlPullParser.getDepth(), 
							 currentElement.getAttributes(), currentElement.getText());
					break;
				case XmlPullParser.END_DOCUMENT://文档结束事件
					return onDocumentEnd();
				default:
					break;
				}
				xmlPullParser.next();
			} catch (XmlPullParserException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
