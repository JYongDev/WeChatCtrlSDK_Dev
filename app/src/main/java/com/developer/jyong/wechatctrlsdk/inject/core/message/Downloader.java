package com.developer.jyong.wechatctrlsdk.inject.core.message;


import android.database.Cursor;
import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.core.main.Configurator;
import com.developer.jyong.wechatctrlsdk.inject.info.MediaInfo;
import com.developer.jyong.wechatctrlsdk.inject.tool.DBTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.HookProxy;

import java.lang.reflect.Constructor;


public class Downloader {

    public static final int HD_IMAGE = 1;
    public static final int MID_IMAGE = 2;

    /**
     * download chatting image
     *
     * @param msgId local msgId
     * @param type  HD or Mid
     */
    public static void downloadImg(long msgId, int type, ClassLoader classLoader) {

        if (TextUtils.isEmpty(String.valueOf(msgId)) || classLoader == null)
            return;

        Object dbObject = FieldTool.instance().getDbObject();

        if (dbObject == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {

            Object obj = null;

            if (type == HD_IMAGE) {
                obj = configImage(msgId, 1, 0, dbObject, configurator, classLoader);
            } else if (type == MID_IMAGE) {
                obj = configImage(msgId, 0, -1, dbObject, configurator, classLoader);
            }

            if (obj == null)
                return;

            Class bootClz = HookProxy.findClass(configurator.getImgDownloadBootClz(), classLoader);
            Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getImgDownloadBootFunc());
            HookProxy.callMethod(bootObj, configurator.getDownloadFunc(), obj, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object configImage(long msgId, int param3, int param5, Object dbObject, Configurator configurator, ClassLoader classLoader) throws Exception {

        long imgId = getLastImgId(msgId, dbObject);

        if (imgId == 0)
            return null;

        Object keyObject = null;

        Class loadClz = HookProxy.findClass(configurator.getLoadClz(), classLoader);
        Object obj = HookProxy.callStaticMethod(loadClz, configurator.getLoadFunc());

        Class jClz = HookProxy.findClass(configurator.getDownImgEntityClz(), classLoader);
        Class kClz = HookProxy.findClass(configurator.getDownImgEntityParamClz(), classLoader);

        Constructor jConstructor = jClz.getDeclaredConstructor(long.class, long.class, int.class, kClz, int.class);
        keyObject = jConstructor.newInstance(imgId, msgId, param3, obj, param5);

        return keyObject;
    }

    private static long getLastImgId(long msgId, Object dbObject) {

        if (TextUtils.isEmpty(String.valueOf(msgId)))
            return 0;

        String imgSql = "select id from ImgInfo2 where thumbImgPath = ( select imgPath from message where msgId = ? ) order by id desc limit 0,1 ";
        Cursor cursor = DBTool.rawQuery(dbObject, imgSql, new String[]{String.valueOf(msgId)});

        MediaInfo media = MediaInfo.convertByCursor(cursor);

        if (media == null)
            return 0;

        return media.getId();
    }

    /**
     * download chatting video
     *
     * @param imgPath message imgPath column
     */
    public static void downloadVideo(String imgPath, ClassLoader classLoader) {

        if (TextUtils.isEmpty(imgPath) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        Class clz = HookProxy.findClass(configurator.getVideoDownloadBootClz(), classLoader);
        HookProxy.callStaticMethod(clz, configurator.getVideoDownloadFunc(), imgPath);
    }

}
