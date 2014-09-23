package com.leleliu008.data.xml;

import java.io.InputStream;
import java.io.Reader;

/**
 * xml解析接口
 * 
 * @author 792793182@qq.com
 *
 */
public interface IXMLParser<Result> {
	
	Result parse(String in);

	Result parse(Reader in);
	
	Result parse(InputStream in);
}
