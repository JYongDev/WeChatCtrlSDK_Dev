package com.developer.jyong.wechatctrlsdk.inject.core.main;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import android.view.Menu;

import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.FileTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.HookProxy;

import org.json.JSONObject;

import java.util.concurrent.BlockingQueue;


public class Booter {

    private static BlockingQueue<Object> queue = null;

    public Booter() {
    }

    public void init(ClassLoader classLoader) {
        String version = WeChatTool.getVersion();

        if (!TextUtils.isEmpty(version)) {
            WeChatTool.disableTinker();
            Configurator configurator = Configurator.instance(version);
            hook(classLoader, configurator);
        }
    }

    public static void setQueue(BlockingQueue<Object> queue) {
        if (queue == null) {
            return;
        }
        Booter.queue = queue;

        try {
            JSONObject obj = new JSONObject();
            obj.put("type", 0);
            obj.put("WeChatCtrlSDK_Version", Confige.VERSION);
            Booter.queue.offer(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static BlockingQueue<Object> getQueue() {
        if (Booter.queue == null) {
            return null;
        } else {
            return Booter.queue;
        }
    }

    public static boolean put(Object obj) {
        boolean flag = false;
        try {
            BlockingQueue<Object> queue = getQueue();
            if (queue == null) {
                flag = false;
            } else {
                flag = queue.offer(obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    private void hook(final ClassLoader classLoader, final Configurator configurator) {
        try {
            dbObject(classLoader, configurator, new Callback() {
                @Override
                public void callHook(Object dbObject) {

                    try {
                        Class adClz = HookProxy.findClass(configurator.getContextClz(), classLoader);
                        Context mContext = (Context) HookProxy.callStaticMethod(adClz, configurator.getContextFunc());
                        FieldTool.instance().setContext(mContext);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    try {
                        launcher(classLoader, configurator);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    try {
                        dbInsert(classLoader, configurator);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    try {
                        dbUpdate(classLoader, configurator);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    try {
                        dbDelete(classLoader, configurator);
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dbObject(ClassLoader classLoader, Configurator configurator, Callback callback) {

        Class cipherSpec = HookProxy.findClass(configurator.getDbCipherClz(), classLoader);
        Class cursorFactory = HookProxy.findClass(configurator.getDbCursorFactoryClz(), classLoader);
        Class dbErrorHandler = HookProxy.findClass(configurator.getDbErrorHandlerClz(), classLoader);

        HookProxy.hookMethod(configurator.getDbClz(),
                classLoader,
                configurator.getDbOpenFunc(),
                String.class,
                byte[].class,
                cipherSpec,
                cursorFactory,
                int.class,
                dbErrorHandler,
                int.class,
                new DBInvader(callback));
    }

    private void launcher(final ClassLoader classLoader, Configurator configurator) {
        HookProxy.hookMethod(configurator.getLauncherClz(),
                classLoader,
                configurator.getLauncherFunc(),
                Menu.class,
                new LauncherInvader(classLoader));
    }

    private void dbInsert(final ClassLoader classLoader, Configurator configurator) {
        HookProxy.hookMethod(configurator.getDbClz(),
                classLoader,
                configurator.getDbInsertFunc(),
                String.class,
                String.class,
                ContentValues.class,
                int.class,
                new InsertInvader(classLoader));
    }

    private void dbUpdate(final ClassLoader classLoader, Configurator configurator) {
        HookProxy.hookMethod(configurator.getDbClz(),
                classLoader,
                configurator.getDbUpdateFunc(),
                String.class,
                ContentValues.class,
                String.class,
                String[].class,
                int.class,
                new UpdateInvader(classLoader));
    }

    private void dbDelete(final ClassLoader classLoader, Configurator configurator) {
        HookProxy.hookMethod(configurator.getDbClz(),
                classLoader,
                configurator.getDbDeleteFunc(),
                String.class,
                String.class,
                String[].class,
                new DeleteInvader(classLoader));
    }


}
