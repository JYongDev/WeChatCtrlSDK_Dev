package com.developer.jyong.wechatctrlsdk.inject.core.main;

import android.content.ContentValues;

import com.developer.jyong.wechatctrlsdk.inject.core.contact.ContactListener;
import com.developer.jyong.wechatctrlsdk.inject.core.message.Listener;
import com.developer.jyong.wechatctrlsdk.inject.tool.TLog;
import com.developer.jyong.wechatctrlsdk.inject.tool.XposedInjectMethodProxy;

public class InsertInvader extends XposedInjectMethodProxy {

    private ClassLoader classLoader = null;

    public InsertInvader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void before(MethodHookParam param) {
    }

    @Override
    public void after(MethodHookParam param) {
        TLog.log("dbInsert: table => " + param.args[0].toString());
        TLog.log("dbInsert: value => " + param.args[2].toString());
        TLog.log("----------------------------------------------");

        Listener.listen((String) param.args[0], param.args[2], Listener.NORMAL, classLoader);
        ContactListener.listen((String) param.args[0], (ContentValues) param.args[2], ContactListener.INSERT);

    }
}
