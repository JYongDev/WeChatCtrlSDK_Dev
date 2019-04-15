//
// Created by Administrator on 2018/7/7.
//

#ifndef CTRLSDK_DOWNLOAD_H
#define CTRLSDK_DOWNLOAD_H

#include <string>
#include "include/curl/curl.h"
#include <sys/stat.h>
#include <unistd.h>

using namespace std;

class Download {
public:
    Download();

    virtual ~Download();

    static void Init();

    static void Cleanup();

public:
    static size_t DownLoadPackage(void *ptr, size_t size, size_t nmemb,
                                  void *userdata);

private:
    long GetLocalFileLenth(const string &strFileName);

public:
    /*
     * param1 string 下载文件的url地址。
     * param2 string 下载到的路径  注意要以/结尾
     * param3 string 下载后的文件名
     * return 0 下载成功/-1代表初始化失败/其他为curl返回错误码
     * */
    int DownLoad(std::string strUrl, std::string strStoragePath,
                 std::string strFileName);

private:
    CURL *m_pCurl;
};

#endif //CTRLSDK_DOWNLOAD_H
