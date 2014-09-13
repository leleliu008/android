package com.leleliu008.ui;

import android.view.MotionEvent;
import android.view.View;

/**
 * 与UI相关的工具类
 * 
 * @author leleliu008
 *
 */
public final class UIUtil {

	private static class InstanceHolder {
		private static int[] location = new int[2];
	}
	
	private UIUtil() { }
	
	/**
	 * 判断某个Touch点是否在某个View中
	 * @param event Touch事件
	 * @param view  目标View
	 * @return
	 */
	public static boolean isInView(View view, MotionEvent event) {
		if (view.getVisibility() == View.GONE) {
			return false;
		}

		//得到Touch事件在屏幕上的坐标
		int rawX = (int) event.getRawX();
		int rawY = (int) event.getRawY();
		
		//得到View在屏幕上的坐标
		view.getLocationOnScreen(InstanceHolder.location);

		// 判断event是否落在view内
		return rawX >= InstanceHolder.location[0]
			&& rawX <= InstanceHolder.location[0] + view.getWidth()
			&& rawY >= InstanceHolder.location[1]
			&& rawY <= InstanceHolder.location[1] + view.getHeight();
	}
}
