#include "HttpUtil.h"
#include "Log.h"

size_t req_reply(void *ptr, size_t size, size_t nmemb, void *stream) {
    string *str = (string *) stream;
    (*str).append((char *) ptr, size * nmemb);
    return size * nmemb;
}

CURLcode curl_post_req(const string &url, const string &postParams, string &response) {
    // init curl
    CURL *curl = curl_easy_init();
    // res code
    CURLcode res;
    if (curl) {
        // set params
        curl_easy_setopt(curl, CURLOPT_POST, 1); // post req
        curl_easy_setopt(curl, CURLOPT_URL, url.c_str()); // url
        curl_easy_setopt(curl, CURLOPT_POSTFIELDS, postParams.c_str()); // params
        curl_easy_setopt(curl, CURLOPT_SSL_VERIFYPEER, true); // if want to use https
        curl_easy_setopt(curl, CURLOPT_SSL_VERIFYHOST, false); // set peer and host verify false
        curl_easy_setopt(curl, CURLOPT_VERBOSE, 1);
        curl_easy_setopt(curl, CURLOPT_READFUNCTION, NULL);
        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, req_reply);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, (void *) &response);
        curl_easy_setopt(curl, CURLOPT_NOSIGNAL, 1);
        curl_easy_setopt(curl, CURLOPT_HEADER, 1);
        curl_easy_setopt(curl, CURLOPT_CONNECTTIMEOUT, 3);
        curl_easy_setopt(curl, CURLOPT_TIMEOUT, 3);
        // start req
        res = curl_easy_perform(curl);
    }
    // release curl
    curl_easy_cleanup(curl);
    return res;
}

CURLcode curl_get_req(const std::string &url, std::string &response) {
    // init curl
    CURL *curl = curl_easy_init();
    // res code
    CURLcode res;
    if (curl) {
        // set params
        curl_easy_setopt(curl, CURLOPT_URL, url.c_str()); // url
        curl_easy_setopt(curl, CURLOPT_SSL_VERIFYPEER, true); // if want to use https
        curl_easy_setopt(curl, CURLOPT_SSL_VERIFYHOST, false); // set peer and host verify false
        curl_easy_setopt(curl, CURLOPT_VERBOSE, 1);
        curl_easy_setopt(curl, CURLOPT_READFUNCTION, NULL);
        curl_easy_setopt(curl, CURLOPT_WRITEFUNCTION, req_reply);
        curl_easy_setopt(curl, CURLOPT_WRITEDATA, (void *) &response);
        curl_easy_setopt(curl, CURLOPT_NOSIGNAL, 1);
        curl_easy_setopt(curl, CURLOPT_HEADER, 1);
        curl_easy_setopt(curl, CURLOPT_CONNECTTIMEOUT, 3); // set transport and time out time
        curl_easy_setopt(curl, CURLOPT_TIMEOUT, 3);
        // start req
        res = curl_easy_perform(curl);
    }
    // release curl
    curl_easy_cleanup(curl);

    return res;
}

string HttpUtil::doGet(const string url, const string result) {

    curl_global_init(CURL_GLOBAL_ALL);

    string getUrlStr = url;

    string getResponseStr = result;

    string resStr;
    auto res = curl_get_req(getUrlStr, getResponseStr);
    if (res != CURLE_OK) {
        resStr = string(curl_easy_strerror(res));
    } else {
        resStr = getResponseStr;
    }

    curl_global_cleanup();

    return resStr;
}

string HttpUtil::doPost(const string url, const string result) {

    curl_global_init(CURL_GLOBAL_ALL);

    string postUrlStr = url;
    string postParams = "";
    string postResponseStr;
    string resStr;
    auto res = curl_post_req(postUrlStr, postParams, postResponseStr);
    if (res != CURLE_OK) {
        resStr = string(curl_easy_strerror(res));
    } else {
        resStr = postResponseStr;
    }
    curl_global_cleanup();

    return resStr;
}


