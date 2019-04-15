//
// Created by Administrator on 2018/5/23.
//

#ifndef CTRLSDK_LOG_H
#define CTRLSDK_LOG_H

#include <android/log.h>
#include <string>

#define TAG    "CtrlSDK"
#define LOGW(...)  __android_log_print(ANDROID_LOG_WARN,TAG,__VA_ARGS__)
#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,TAG ,__VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,TAG ,__VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,TAG ,__VA_ARGS__)
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,TAG ,__VA_ARGS__)

#endif //CTRLSDK_LOG_H
