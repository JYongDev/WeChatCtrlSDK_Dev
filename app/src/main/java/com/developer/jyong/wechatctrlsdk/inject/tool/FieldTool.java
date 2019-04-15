package com.developer.jyong.wechatctrlsdk.inject.tool;

import android.app.Activity;
import android.content.Context;

public class FieldTool {

    private static FieldTool instance = new FieldTool();
    private static String TAG = "CtrlSDK";
    private Object dbObject = null;
    private Context context = null;
    private Activity activity = null;


    private FieldTool() {
    }

    public static FieldTool instance() {
        if (instance == null) {
            instance = new FieldTool();
        }
        return instance;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        if (activity == null)
            return;
        this.activity = activity;
    }

    public Object getDbObject() {
        return dbObject;
    }

    public void setDbObject(Object dbObject) {
        if (dbObject == null) {
            return;
        }
        this.dbObject = dbObject;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        if (context == null) {
            return;
        }
        this.context = context;
    }
}
