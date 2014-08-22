LOCAL_PATH       := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE     := logtest
LOCAL_SRC_FILES  := com_leleliu008_LogTest.cpp
LOCAL_LDLIBS     += -llog

include $(BUILD_SHARED_LIBRARY)
