package com.leleliu008.data.xml;

import java.io.InputStream;
import java.io.Reader;

/**
 * xml解析接口
 * 
 * @author leleliu008
 *
 * @param <Result>
 */
public interface IXMLParser<Result> {
	
	Result parse(String in);

	Result parse(Reader in);
	
	Result parse(InputStream in);
}
