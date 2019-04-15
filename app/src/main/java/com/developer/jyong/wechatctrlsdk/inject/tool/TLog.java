package com.developer.jyong.wechatctrlsdk.inject.tool;

import android.util.Log;

public class TLog {

    private final static String TAG = "CtrlSDK";
    public static boolean DEBUG = true;

    public static void log(String msg) {
        if (DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void log(String tag, String msg) {
        if (DEBUG) {
            Log.w(tag, msg);
        }
    }

    public static void d(String TAG, String msg) {
        if (DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void w(String TAG, String msg) {
        if (DEBUG) {
            Log.w(TAG, msg);
        }
    }

    public static void e(String TAG, String msg) {
        if (DEBUG) {
            Log.e(TAG, msg);
        }
    }

    public static void i(String TAG, String msg) {
        if (DEBUG) {
            Log.i(TAG, msg);
        }
    }

    public static void v(String TAG, String msg) {
        if (DEBUG) {
            Log.v(TAG, msg);
        }
    }

}
