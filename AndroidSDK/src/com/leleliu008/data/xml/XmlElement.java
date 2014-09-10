package com.leleliu008.data.xml;

import java.util.Map;

/**
 * XML元素
 * @author leleliu008
 *
 */
final class XmlElement {
	
	private String tag;
	private String text;
	private Map<String, String> attributes;
	
	public String getTag() {
		return tag;
	}
	
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Map<String, String> getAttributes() {
		return attributes;
	}
	
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
}
