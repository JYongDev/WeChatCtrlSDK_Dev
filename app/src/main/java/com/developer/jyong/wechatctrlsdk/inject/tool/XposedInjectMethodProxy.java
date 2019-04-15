package com.developer.jyong.wechatctrlsdk.inject.tool;


import de.robv.android.xposed.XC_MethodHook;

public abstract class XposedInjectMethodProxy extends XC_MethodHook {

    @Override
    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
        super.beforeHookedMethod(param);
        before(param);
    }

    @Override
    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
        super.afterHookedMethod(param);
        after(param);
    }

    public abstract void before(MethodHookParam param);

    public abstract void after(XC_MethodHook.MethodHookParam param);

}