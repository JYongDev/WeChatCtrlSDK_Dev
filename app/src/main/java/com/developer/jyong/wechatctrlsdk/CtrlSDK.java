package com.developer.jyong.wechatctrlsdk;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.BlockingQueue;

import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;

public class CtrlSDK {

    private final static String WECHAT_PACKAGE_NAME = "com.tencent.mm";

    private static String getNativeLibPath(Context mContext, String pkgName) {
        String fullLibPath = "";
        try {
            Context appContext = mContext.createPackageContext(pkgName, Context.CONTEXT_IGNORE_SECURITY);

            String libPath = appContext.getApplicationInfo().nativeLibraryDir;

            if (!CtrlSDK.isEmpty(libPath)) {
                fullLibPath = libPath + File.separator + "libWeChatCtrlSDK.so";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fullLibPath;
    }

    public static ClassLoader init(String pkgName, XC_LoadPackage.LoadPackageParam param) {
        ClassLoader classLoader = null;
        if (!CtrlSDK.isEmpty(pkgName) && param.packageName.contains(WECHAT_PACKAGE_NAME)) {
            classLoader = initLoad(pkgName, param);
        }
        return classLoader;
    }

    private static ClassLoader initLoad(String pkgName, XC_LoadPackage.LoadPackageParam param) {
        Context mContext = getContext();
        ClassLoader classLoader = null;
        try {
            if (mContext != null) {

                String fullLibPath = getNativeLibPath(mContext, pkgName);

                if (!CtrlSDK.isEmpty(fullLibPath)) {
                    load(fullLibPath);
                    classLoader = init(param.classLoader);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return classLoader;
    }

    private static Context getContext() {
        return (Context) callMethod(callStaticMethod(XposedHelpers.findClass("android.app.ActivityThread", null), "currentActivityThread", new Object[0]), "getSystemContext", new Object[0]);
    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    private static void load(String path) {
        try {
            if (!CtrlSDK.isEmpty(path)) {
                System.load(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static native ClassLoader init(ClassLoader classLoader);

    public static native void encrypt();

    public static void sendText(String to, String message, ClassLoader ctrl, ClassLoader bootLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.EmiterProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "sendText";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, to, message, bootLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendImage(String talker, String imgLocalPath, ClassLoader ctrl, ClassLoader classLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.EmiterProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "sendImage";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, talker, imgLocalPath, classLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendVideo(String talker, String filePath, ClassLoader ctrl, ClassLoader classLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.EmiterProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "sendVideo";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, talker, filePath, classLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendCard(String talker, String cardOwner, ClassLoader ctrl, ClassLoader classLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.EmiterProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "sendCard";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, talker, cardOwner, classLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void transmitLink(String msgId, String talker, ClassLoader ctrl, ClassLoader classLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.EmiterProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "transmitLink";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, msgId, talker, classLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendVoice(String talker, String localFilePath, ClassLoader ctrl, ClassLoader classLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.EmiterProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "sendVoice";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, talker, localFilePath, classLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void listen(ClassLoader classloader, BlockingQueue queue) {
        String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.ListenerProxy";
        String methodName = "listen";
        Class clz = ReflexUtil.findClass(classloader, clzName);
        Method method = ReflexUtil.getMethod(clz, methodName, BlockingQueue.class);
        ReflexUtil.invoke(method, null, queue);
    }

    public static void momentText(String content, ClassLoader ctrl, ClassLoader bootLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.MomentProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "sendText";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, content, bootLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void momentImage(String content, List<String> list, ClassLoader ctrl, ClassLoader bootLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.MomentProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "sendImage";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, List.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, content, list, bootLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void momentVideo(String content, String videoPath, ClassLoader ctrl, ClassLoader bootLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.MomentProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "sendVideo";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, content, videoPath, bootLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void roomCreate(List<String> memberList, String roomName, ClassLoader ctrl, ClassLoader bootLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.RoomProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "createRoom";
            Method method = ReflexUtil.getMethod(clz, methodName, List.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, memberList, roomName, bootLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addMember(List<String> memberList, String roomId, ClassLoader ctrl, ClassLoader bootLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.RoomProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "addMember";
            Method method = ReflexUtil.getMethod(clz, methodName, List.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, memberList, roomId, bootLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void removeMember(List<String> memberList, String roomId, ClassLoader ctrl, ClassLoader bootLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.RoomProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "removeMember";
            Method method = ReflexUtil.getMethod(clz, methodName, List.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, memberList, roomId, bootLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void notifyAllMember(String roomId, String content, ClassLoader ctrl, ClassLoader bootLoader) {
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.RoomProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "notifyAllMember";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class, String.class, ClassLoader.class);
            ReflexUtil.invoke(method, null, roomId, content, bootLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONArray roomList(ClassLoader ctrl) {
        JSONArray obj = null;
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.RoomProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "roomList";
            Method method = ReflexUtil.getMethod(clz, methodName);
            obj = (JSONArray) ReflexUtil.invoke(method, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static JSONArray contactList(ClassLoader ctrl) {
        JSONArray obj = null;
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.ContactProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "contactList";
            Method method = ReflexUtil.getMethod(clz, methodName);
            obj = (JSONArray) ReflexUtil.invoke(method, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static JSONObject contact(String wxid, ClassLoader ctrl) {
        JSONObject obj = null;
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.ContactProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "contact";
            Method method = ReflexUtil.getMethod(clz, methodName, String.class);
            obj = (JSONObject) ReflexUtil.invoke(method, null, wxid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static JSONObject personalInfo(ClassLoader ctrl) {
        JSONObject obj = null;
        try {
            String clzName = "com.developer.jyong.wechatctrlsdk.inject.proxy.ContactProxy";
            Class clz = ReflexUtil.findClass(ctrl, clzName);
            String methodName = "personalInfo";
            Method method = ReflexUtil.getMethod(clz, methodName);
            obj = (JSONObject) ReflexUtil.invoke(method, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }


}
