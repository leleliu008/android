LOCAL_PATH         := $(call my-dir)

include $(CLEAR_VARS)
LOCAL_MODULE       := client
LOCAL_SRC_FILES    := client.c
include $(BUILD_EXECUTABLE)


include $(CLEAR_VARS)
LOCAL_MODULE       := server
LOCAL_SRC_FILES    := server.c
include $(BUILD_EXECUTABLE)
