package com.developer.jyong.wechatctrlsdk.inject.core.main;

import com.developer.jyong.wechatctrlsdk.inject.tool.DBTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.XposedInjectMethodProxy;

import de.robv.android.xposed.XC_MethodHook;

public class DBInvader extends XposedInjectMethodProxy {

    private Callback callback = null;

    public DBInvader(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void before(XC_MethodHook.MethodHookParam param) {
    }

    @Override
    public void after(XC_MethodHook.MethodHookParam param) {
        String dbName = "EnMicroMsg.db";
        if (param.args[0].toString().contains(dbName)) {
            if (null == FieldTool.instance().getDbObject()) {

                Object dbObject = param.getResult();

                if (DBTool.isDBOpen(dbObject)) {
                    FieldTool.instance().setDbObject(dbObject);
                    callback.callHook(dbObject);
                }
            }

        }
    }
}
