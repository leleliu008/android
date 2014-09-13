package com.leleliu008.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 解析ini格式的内容
 * 
 * @author leleliu008
 * 
 */
public final class IniParser {

	private static final int DEFAULT_BUFFER_SIZE = 1024 * 2;

	/**
	 * 注释标记
	 */
	private static final String COMMENT_TAG = "#";

	/**
	 * 属性开始标记
	 */
	private static final String PROPERTY_START_TAG = "[";

	/**
	 * 属性结束标记
	 */
	private static final String PROPERTY_END_TAG = "]";

	/**
	 * 分隔标记
	 */
	private static final char SEPARATE_TAG = '=';

	private IniParser() { }

	public static Map<String, Properties> parse(String iniFilePath) {
		try {
			InputStream is = new FileInputStream(iniFilePath);
			return parse(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<String, Properties> parse(File iniFile) {
		try {
			InputStream is = new FileInputStream(iniFile);
			return parse(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Map<String, Properties> parse(InputStream is) {
		if (is == null) {
			return null;
		}
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(is, "utf-8"), DEFAULT_BUFFER_SIZE);
			
			Map<String, Properties> propertiesMap = new HashMap<String, Properties>();
			Properties properties = null;
			
			String key = null;
			String value = null;
			
			String str = null;
			while ((str = br.readLine()) != null) {
				str = str.trim();
				if (str.startsWith(COMMENT_TAG)) {
					/* 如果是注释行，则读下一行 */
					continue;
				} else if (str.startsWith(PROPERTY_START_TAG)
						&& str.endsWith(PROPERTY_END_TAG)) {
					/* 如果是新的属性，则创建对象并加入列表 */
					key = str.substring(1, str.length() - 1);
					if (key.length() > 0) {
						properties = new Properties();
						propertiesMap.put(key, properties);
					}
				} else {
					/* 读取每个键值对 */
					int index = str.indexOf(SEPARATE_TAG);
					if (index > 0) {
						key = str.substring(0, index).trim();
						value = str.substring(index + 1).trim();
						if (key.length() > 0 && properties != null) {
							properties.put(key, value);
						}
					}
				}
			}
			
			return propertiesMap;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return null;
	}

}
