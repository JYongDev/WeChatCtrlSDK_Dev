package com.developer.jyong.wechatctrlsdk;

import java.lang.reflect.Method;


public class ReflexUtil {

    public static Class findClass(ClassLoader classLoader, String className) {
        if (classLoader == null)
            return null;
        Class clz = null;
        try {
            clz = classLoader.loadClass(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clz;
    }

    public static Method getMethod(Class clz, String name, Class... param) {
        if (clz == null)
            return null;

        if (name == null || name.length() <= 0)
            return null;

        Method method = null;
        try {
            method = clz.getDeclaredMethod(name, param);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return method;
    }

    public static Object invoke(Method method, Object obj, Object... args) {
        if (method == null)
            return null;
        Object result = null;
        try {
            result = method.invoke(obj, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
