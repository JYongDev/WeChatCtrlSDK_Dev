package com.developer.jyong.wechatctrlsdk.inject.core.main;

import android.content.ContentValues;

import com.developer.jyong.wechatctrlsdk.inject.core.message.Listener;
import com.developer.jyong.wechatctrlsdk.inject.info.MsgInfo;
import com.developer.jyong.wechatctrlsdk.inject.tool.XposedInjectMethodProxy;

public class DeleteInvader extends XposedInjectMethodProxy {

    private ClassLoader classLoader = null;

    public DeleteInvader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void before(MethodHookParam param) {
        if (param.args[0].equals(Listener.TABLE_MESSAGE)) {
            String arr[] = (String[]) param.args[2];
            if (arr != null && arr.length == 1) {
                ContentValues values = new ContentValues();
                values.put(MsgInfo.WX_MESSAGE_COLUMNNAME_MSGID, arr[0]);
                Listener.listen((String) param.args[0], values, Listener.DELETE, classLoader);
            }
        }
    }

    @Override
    public void after(MethodHookParam param) {
    }
}
