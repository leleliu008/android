package com.leleliu008.androidsdk.animation;
import java.lang.reflect.ParameterizedType;

import android.util.Log;



public class Parent<T> {

	T t;
	
	@SuppressWarnings("rawtypes")
	public void xx() {
		ParameterizedType superClass = (ParameterizedType)getClass().getGenericSuperclass();
		Class actualType = (Class) superClass.getActualTypeArguments()[0];
		String className = actualType.getName();
		Log.d("xx", className);
	}
}
