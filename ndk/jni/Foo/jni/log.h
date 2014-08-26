#ifndef _JNI_H_
#define _JNI_H_

#include<android/log.h>

#define LOGI(TAG, ...) __android_log_print(ANDROID_LOG_INFO, TAG, ##__VA_ARGS__)

#endif
