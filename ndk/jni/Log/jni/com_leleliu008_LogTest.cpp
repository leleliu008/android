#include<android/log.h>
#include"com_leleliu008_LogTest.h"

#define TAG "com_leleliu008_LOGTest.cpp"

#define LOGV(...) __android_log_print(ANDROID_LOG_VERBOSE, TAG, __VA_ARGS__);
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG, TAG, __VA_ARGS__);
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, TAG, __VA_ARGS__);
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN, TAG, __VA_ARGS__);
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR, TAG, __VA_ARGS__);
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL, TAG, __VA_ARGS__);


JNIEXPORT void JNICALL Java_com_leleliu008_LogTest_printLog
										(JNIEnv *, jclass) {
	LOGV("log verbose");
	LOGD("log debug");
	LOGI("log info");
	LOGW("log warn");
	LOGE("log error");
	LOGF("log fatal");
}
