#include<stdio.h>
#include<android/log.h>
#include"com_leleliu008_Foo.h"

#define TAG "com_leleliu008_Foo.cpp"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, TAG, ##__VA_ARGS__)


JNIEXPORT void JNICALL Java_com_leleliu008_Foo_func1
					(JNIEnv *env, jclass clazz) {
	jclass superClazz = env->GetSuperclass(clazz);
}

JNIEXPORT void JNICALL Java_com_leleliu008_Foo_func2
					(JNIEnv *env, jobject thiz) {
  	jclass clazz = env->GetObjectClass(thiz);
}

JNIEXPORT jboolean JNICALL Java_com_leleliu008_Foo_func3
					(JNIEnv *env, jobject, jboolean isxx) {
	return isxx;
}

JNIEXPORT jbyte JNICALL Java_com_leleliu008_Foo_func4
					(JNIEnv * env, jobject thiz, jbyte pram) {
	return pram;
}

JNIEXPORT jchar JNICALL Java_com_leleliu008_Foo_func5
					(JNIEnv *env, jobject thiz, jchar pram) {
	return pram;
}

JNIEXPORT jshort JNICALL Java_com_leleliu008_Foo_func6
					(JNIEnv *env, jobject thiz, jshort pram) {
	return pram;
}

JNIEXPORT jint JNICALL Java_com_leleliu008_Foo_func7
					(JNIEnv *env, jobject thiz, jint pram) {
	return pram;
}

JNIEXPORT jlong JNICALL Java_com_leleliu008_Foo_func8
					(JNIEnv *env, jobject thiz, jlong pram) {
	return pram;
}

JNIEXPORT jfloat JNICALL Java_com_leleliu008_Foo_func9
					(JNIEnv *env, jobject thiz, jfloat pram) {
	return pram;
}

JNIEXPORT jdouble JNICALL Java_com_leleliu008_Foo_func10
					(JNIEnv *env, jobject thiz, jdouble pram) {
	return pram;
}

JNIEXPORT jstring JNICALL Java_com_leleliu008_Foo_func11
					(JNIEnv *env, jobject thiz, jstring str) {
	return str;
}

JNIEXPORT jobject JNICALL Java_com_leleliu008_Foo_func12
					(JNIEnv *env, jobject thiz, jobject obj) {
	return obj;
}

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
	LOGI("jni version = %d", JNI_VERSION_1_4);
	return JNI_VERSION_1_4;
}
