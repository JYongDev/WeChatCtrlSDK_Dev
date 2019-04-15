//
// Created by Administrator on 2018/7/7.
//

#ifndef CTRLSDK_HTTPUTIL_H
#define CTRLSDK_HTTPUTIL_H

#include "include/curl/curl.h"
#include <string.h>
#include <string>
#include <sys/stat.h>
#include <unistd.h>


using namespace std;

class HttpUtil {
public :

    static string doGet(const string url, const string result);

    static string doPost(const string url, const string result);

};


#endif //CTRLSDK_HTTPUTIL_H
