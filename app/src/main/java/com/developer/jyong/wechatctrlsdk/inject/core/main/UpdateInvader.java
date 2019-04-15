package com.developer.jyong.wechatctrlsdk.inject.core.main;

import android.content.ContentValues;

import com.developer.jyong.wechatctrlsdk.inject.core.contact.ContactListener;
import com.developer.jyong.wechatctrlsdk.inject.core.message.Listener;
import com.developer.jyong.wechatctrlsdk.inject.tool.TLog;
import com.developer.jyong.wechatctrlsdk.inject.tool.XposedInjectMethodProxy;

import de.robv.android.xposed.XC_MethodHook;


public class UpdateInvader extends XposedInjectMethodProxy {

    private ClassLoader classLoader = null;

    public UpdateInvader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public void before(XC_MethodHook.MethodHookParam param) {
        TLog.log("dbUpdate: table => " + param.args[0].toString());
        TLog.log("dbUpdate: value => " + param.args[1].toString());
        TLog.log("++++++++++++++++++++++++++++++++++++++++++++++");

        Listener.listen((String) param.args[0], param.args[1], Listener.REVOKE, classLoader);
        ContactListener.listen((String) param.args[0], (ContentValues) param.args[1], ContactListener.UPDATE);
    }

    public void after(XC_MethodHook.MethodHookParam param) {
    }

}
