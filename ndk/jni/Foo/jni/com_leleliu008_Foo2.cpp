#include<jni.h>
#include<stddef.h>
#include"log.h"
#include"com_leleliu008_Foo2.h"
#define TAG "com_leleliu008_Foo2"

JNIEXPORT jbooleanArray JNICALL Java_com_leleliu008_Foo2_func1
  			(JNIEnv *env, jobject thiz, jbooleanArray array) {
	jsize length = env->GetArrayLength(array);
	LOGI(TAG, "length = %d", length);

	jboolean *buff = env->GetBooleanArrayElements(array, NULL);
	if(NULL != buff) {
		int i;
		for(i = 0; i < length; i++) {
			LOGI(TAG, "%d", buff[i]);
		}
		env->ReleaseBooleanArrayElements(array, buff, 0);
	}
	
	jbooleanArray value = env->NewBooleanArray(10);
	jboolean *buff2 = env->GetBooleanArrayElements(value, NULL);
	if(NULL != buff2) {
		int i;
		for(i = 0; i < 10; i++) {
			if(i % 2 == 0) {
				buff2[i] = JNI_TRUE;
			} else {
				buff2[i] = JNI_FALSE;
			}
		}
		env->ReleaseBooleanArrayElements(value, buff2, 0);
	}
	
	return value;
}

JNIEXPORT jobjectArray JNICALL Java_com_leleliu008_Foo2_func9
  			(JNIEnv *env, jobject thiz, jobjectArray array) {
	jsize length = env->GetArrayLength(array);
	int i;
	for(i = 0; i < length; i++) {
		jobject element = env->GetObjectArrayElement(array, i);
	}
	return array;
}
			
JNIEXPORT jobjectArray JNICALL Java_com_leleliu008_Foo2_func10
  			(JNIEnv *env, jobject thiz, jobjectArray array) {
	jsize length = env->GetArrayLength(array);
	int i;
	for(i = 0; i < length; i++) {
		jobject element = env->GetObjectArrayElement(array, i);
	}
	return array;
}
