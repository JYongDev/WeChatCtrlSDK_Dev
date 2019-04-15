package com.developer.jyong.wechatctrlsdk.inject.tool;

import java.lang.reflect.Constructor;

import de.robv.android.xposed.XposedHelpers;

public class HookProxy {

    public static Object callStaticMethod(Class clz, String methodName, Object... args) {
        return XposedHelpers.callStaticMethod(clz, methodName, args);
    }

    public static Object callMethod(Object obj, String methodName, Object... args) {
        return XposedHelpers.callMethod(obj, methodName, args);
    }

    public static Class findClass(String clzName, ClassLoader classLoader) {
        return XposedHelpers.findClass(clzName, classLoader);
    }

    public static Object getObjectField(Object obj, String fieldName) {
        return XposedHelpers.getObjectField(obj, fieldName);
    }

    public static void setObjectField(Object obj, String fieldName, Object value) {
        XposedHelpers.setObjectField(obj, fieldName, value);
    }

    public static Object getStaticObjectField(Class clz, String fieldName) {
        return XposedHelpers.getStaticObjectField(clz, fieldName);
    }

    public static void hookMethod(String clzName, ClassLoader classLoader, String methodName, Object... args) {
        XposedHelpers.findAndHookMethod(clzName, classLoader, methodName, args);
    }

    public static void hookConstructor(String clzName, ClassLoader classLoader, Object... args) {
        XposedHelpers.findAndHookConstructor(clzName, classLoader, args);
    }

    public static Constructor findConstructor(Class clzName, Class... args) {
        return XposedHelpers.findConstructorExact(clzName, args);
    }

}
