package com.leleliu008.clipboard;

/**
 * 剪贴板操作接口
 * 
 * @author 792793182@qq.com
 */
interface IClipboardManager {

	/**
	 * 复制操作，即将文本临时保存在剪贴板中
	 * @param text 要复制的文本
	 */
	void copy(CharSequence text);
	
	/**
	 * 粘贴操作，即从剪贴板中获取文本
	 */
	CharSequence paste();
}
