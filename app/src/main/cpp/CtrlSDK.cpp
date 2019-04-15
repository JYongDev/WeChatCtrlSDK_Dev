#include <jni.h>
#include <string>
#include "MD5.h"
#include "Log.h"
#include "FileUtil.h"
#include "EncryptUtil.h"
#include "Download.h"
#include "web_task.h"
#include "HttpUtil.h"

using namespace std;

#define AES_KEY "devJYongCtrlSDK0"


extern "C" {

jclass classLoaderClz;
jclass dexClassLoaderClz;
jclass bootClz;
jobject dexClassloaderObject;

string getSDKDir() {
    return "/sdcard/wechatctrlsdk/";
}

jclass getClassLoaderClz(JNIEnv *env) {
    jclass classLoaderClzTmp = env->FindClass("java/lang/ClassLoader");
    classLoaderClz = (jclass) env->NewGlobalRef(classLoaderClzTmp);
    return classLoaderClz;
}

jobject getClassLoaderObj(JNIEnv *env, jclass classLoaderClz) {

    jmethodID getSystemClassLoaderMID = env->GetStaticMethodID(classLoaderClz,
                                                               "getSystemClassLoader",
                                                               "()Ljava/lang/ClassLoader;");
    jobject loader = env->CallStaticObjectMethod(classLoaderClz, getSystemClassLoaderMID);
    return loader;
}

jobject getDexClassLoaderObj(JNIEnv *env, string corePath, string cachePath, jobject loader) {
    jclass dexClassLoaderClzTmp = env->FindClass("dalvik/system/DexClassLoader");
    dexClassLoaderClz = (jclass) env->NewGlobalRef(dexClassLoaderClzTmp);

    jmethodID dexClassLoaderInitMID = env->GetMethodID(dexClassLoaderClz,
                                                       "<init>",
                                                       "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V");

    jobject dexClassLoaderObj = env->NewObject(dexClassLoaderClz,
                                               dexClassLoaderInitMID,
                                               env->NewStringUTF(corePath.c_str()),
                                               env->NewStringUTF(cachePath.c_str()),
                                               NULL,
                                               loader);
    return dexClassLoaderObj;
}

jclass getBooterClz(JNIEnv *env, jclass classLoaderClz, jobject dexClassLoaderObj) {

    jmethodID loadClzMID = env->GetMethodID(classLoaderClz, "loadClass",
                                            "(Ljava/lang/String;)Ljava/lang/Class;");
    jclass bootClz = (jclass) env->CallObjectMethod(dexClassLoaderObj,
                                                    loadClzMID,
                                                    env->NewStringUTF(
                                                            "com.developer.jyong.wechatctrlsdk.inject.core.main.Booter"));
    bootClz = (jclass) env->NewGlobalRef(bootClz);
    return bootClz;
}

string getWechatFilesDir() {
    return "/data/data/com.tencent.mm/files/";
}

string getWechatCacheDir() {
    return "/data/data/com.tencent.mm/cache/";
}

string getDexName() {
    // 4d92e3dc096f6421.dex
    string fileNameMD5 = MD5("ironman").hexdigest();
    string fileName = fileNameMD5.substr(3, 16);
    fileName = fileName + ".dex";
    return fileName;
}

bool decrypt(string origin, string dest) {

    return 1 != Encrypt::decryptFile(origin, dest, AES_KEY);
}

bool downloadFile(string urlStr, string path, string filename) {
    Download download;
    const char *url = urlStr.c_str();
    int nRet = download.DownLoad(url, path.c_str(), filename.c_str());
    return nRet == 0;
}

bool download() {
    string dexDir = getSDKDir();
    string dexName = getDexName();

    // todo set download url
    return downloadFile("", dexDir, dexName);
}

JNIEXPORT void JNICALL
Java_com_developer_jyong_wechatctrlsdk_CtrlSDK_encrypt(JNIEnv *env, jclass jclz) {
    string encryptPath = getSDKDir() + getDexName();
    Encrypt::encryptFile("/sdcard/key1.dex", encryptPath, AES_KEY);

}

JNIEXPORT jobject JNICALL
Java_com_developer_jyong_wechatctrlsdk_CtrlSDK_init(JNIEnv *env, jclass jclz, jobject classLoader) {

    string dexName = getDexName();
    string appFilesDir = getWechatFilesDir();
    string appCacheDir = getWechatCacheDir();
    string dexDir = getSDKDir();

    string unzipPath = appFilesDir + dexName;
    string loadPath = appCacheDir + dexName;
    string encryptDexPath = dexDir + dexName;

    // todo 授权

    if (!FileUtil::isExist(encryptDexPath)) {
        download();
    }

    if (FileUtil::isExist(encryptDexPath)) {

        if (decrypt(encryptDexPath, unzipPath)) {

            classLoaderClz = getClassLoaderClz(env);
            jobject classloaderObject = getClassLoaderObj(env, classLoaderClz);

            dexClassloaderObject = getDexClassLoaderObj(env, unzipPath, appCacheDir,
                                                        classloaderObject);

            bootClz = getBooterClz(env, classLoaderClz, dexClassloaderObject);

            if (bootClz != NULL) {

                jmethodID createMID = env->GetMethodID(bootClz, "<init>", "()V");
                jobject booterObj = env->NewObject(bootClz, createMID);

                jmethodID initMID = env->GetMethodID(bootClz, "init",
                                                     "(Ljava/lang/ClassLoader;)V");

                env->CallObjectMethod(booterObj, initMID, classLoader);

            }

            env->DeleteGlobalRef(dexClassLoaderClz);
            env->DeleteGlobalRef(classLoaderClz);
            env->DeleteGlobalRef(bootClz);
        }
    }

    std::remove(unzipPath.c_str());
    std::remove(loadPath.c_str());

    return dexClassloaderObject;
}

}