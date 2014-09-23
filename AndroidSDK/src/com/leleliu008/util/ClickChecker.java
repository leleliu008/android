package com.leleliu008.util;

/**
 * 检测是否是快速点击的帮助类
 * 
 * @author 792793182@qq.com
 *
 */
public final class ClickChecker {

	private static final long CLICK_WAIT_TIME = 1000;
	private long waitTime = CLICK_WAIT_TIME;
	private long last_click_time = 0;
	
	public ClickChecker() { }
	
	public ClickChecker(long waitTime) { 
		this.waitTime = waitTime;
	}
	
	public boolean isClickTooMuch() {
		long now = java.lang.System.currentTimeMillis();
		//这种情况是修改了系统时间，将系统时间改成现在时间的前面
		if (now - last_click_time < 0) {
			last_click_time = 0;
		} else if (now - last_click_time < waitTime) {
			return true;
		}
		last_click_time = System.currentTimeMillis();
		return false;
	}
}
