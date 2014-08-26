LOCAL_PATH       := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE     := foo
LOCAL_SRC_FILES  := com_leleliu008_Foo.cpp
LOCAL_LDLIBS     += -llog
include $(BUILD_SHARED_LIBRARY)

include $(CLEAR_VARS)
LOCAL_MODULE     := foo2
LOCAL_SRC_FILES  := com_leleliu008_Foo2.cpp
LOCAL_LDLIBS     += -llog
include $(BUILD_SHARED_LIBRARY)
