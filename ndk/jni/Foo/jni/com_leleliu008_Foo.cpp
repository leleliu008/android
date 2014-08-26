#include<stdio.h>
#include"log.h"
#include"com_leleliu008_Foo.h"

#define TAG "com_leleliu008_Foo.cpp"

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
	LOGI(TAG, "isxx = %d", isxx);
	jboolean value = JNI_TRUE;
	return value;
}

JNIEXPORT jbyte JNICALL Java_com_leleliu008_Foo_func4
					(JNIEnv * env, jobject thiz, jbyte pram) {
	LOGI(TAG, "pram = %d", pram);
	jbyte value = -'A';
	return value;
}

JNIEXPORT jchar JNICALL Java_com_leleliu008_Foo_func5
					(JNIEnv *env, jobject thiz, jchar pram) {
	LOGI(TAG, "func5() pram = %c", pram);
	jchar value = 'B';
	return value;
}

JNIEXPORT jshort JNICALL Java_com_leleliu008_Foo_func6
					(JNIEnv *env, jobject thiz, jshort pram) {
	LOGI(TAG, "func6() pram = %d", pram);
	jshort value = -150;
	return value;
}

JNIEXPORT jint JNICALL Java_com_leleliu008_Foo_func7
					(JNIEnv *env, jobject thiz, jint pram) {
	LOGI(TAG, "func7() pram = %d", pram);
	jint value = -250;
	return value;
}

JNIEXPORT jlong JNICALL Java_com_leleliu008_Foo_func8
					(JNIEnv *env, jobject thiz, jlong pram) {
	LOGI(TAG, "func8() pram = %lld\n", pram);
	jlong value = 1000LL;
	return value;
}

JNIEXPORT jfloat JNICALL Java_com_leleliu008_Foo_func9
					(JNIEnv *env, jobject thiz, jfloat pram) {
	LOGI(TAG, "func9() pram = %f", pram);
	jfloat value = 5.0f;
	return value;
}

JNIEXPORT jdouble JNICALL Java_com_leleliu008_Foo_func10
					(JNIEnv *env, jobject thiz, jdouble pram) {
	LOGI(TAG, "func10() pram = %f", pram);
	jdouble value = 2.0;
	return value;
}

JNIEXPORT jstring JNICALL Java_com_leleliu008_Foo_func11
					(JNIEnv *env, jobject thiz, jstring str) {
	const jchar *javachar = env->GetStringChars(str, NULL);
	if(NULL != javachar) {
		env->ReleaseStringChars(str, javachar);
	}

	const char *ch = env->GetStringUTFChars(str, NULL);
	if(NULL != ch) {
		LOGI(TAG, "str = %s", ch);
		env->ReleaseStringUTFChars(str, ch);
	}

	jsize length1 = env->GetStringLength(str);
	jsize length2 = env->GetStringUTFLength(str);
	LOGI(TAG, "length1 = %d", length1);
	LOGI(TAG, "length2 = %d", length2);

	jchar buff1[20];
	char buff2[20];
	env->GetStringRegion(str, 0, length1, buff1);
	env->GetStringUTFRegion(str, 0, length2, buff2);

	return env->NewStringUTF("from C++ code");
}

JNIEXPORT jobject JNICALL Java_com_leleliu008_Foo_func12
					(JNIEnv *env, jobject thiz, jobject obj) {
	jclass clazz = env->GetObjectClass(obj);
	
	jmethodID methodId = env->GetMethodID(clazz, "toString", "()Ljava/lang/String;");
	jstring jstr = (jstring)env->CallObjectMethod(obj, methodId);
	const char *str = env->GetStringUTFChars(jstr, NULL);
	LOGI(TAG, "%s", str);
	env->ReleaseStringUTFChars(jstr, str);

	return obj;
}

JNIEXPORT jint JNI_OnLoad(JavaVM* vm, void* reserved) {
	LOGI(TAG, "jni version = %d", JNI_VERSION_1_4);
	return JNI_VERSION_1_4;
}
