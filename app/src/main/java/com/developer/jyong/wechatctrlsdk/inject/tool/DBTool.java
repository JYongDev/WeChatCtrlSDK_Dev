package com.developer.jyong.wechatctrlsdk.inject.tool;

import android.database.Cursor;
import android.text.TextUtils;

import static de.robv.android.xposed.XposedHelpers.callMethod;


public class DBTool {

    private final static String WECHAT_DATABASE_CLASSNAME = "com.tencent.wcdb.database.SQLiteDatabase";
    private final static String QUERY = "rawQuery";
    private final static String IS_OPEN = "isOpen";


    public static Cursor rawQuery(Object obj, String sql, String[] args) {

        if (obj == null || TextUtils.isEmpty(sql)) {
            return null;
        }

        Cursor cursor;
        if (args == null) {
            cursor = (Cursor) HookProxy.callMethod(obj, QUERY, sql, null);
        } else {
            cursor = (Cursor) HookProxy.callMethod(obj, QUERY, sql, args);
        }
        return cursor;
    }

    public static boolean isDBOpen(Object object) {
        boolean isOpen = false;
        if (null != object && object.getClass().getName().equals(WECHAT_DATABASE_CLASSNAME)) {
            isOpen = (boolean) callMethod(object, IS_OPEN);
        }
        return isOpen;
    }


}
