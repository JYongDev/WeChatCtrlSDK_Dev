package com.developer.jyong.wechatctrlsdk.inject.core.moment;

import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.core.main.Configurator;
import com.developer.jyong.wechatctrlsdk.inject.tool.MD5Utils;
import com.developer.jyong.wechatctrlsdk.inject.core.message.MediaTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.HookProxy;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class Moment {

    public static void sendText(String content, ClassLoader classLoader) {
        if (TextUtils.isEmpty(content) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        configText(content, configurator, classLoader);

        Class refreshClz = HookProxy.findClass(configurator.getSnsToolsOfGetRefreshClz(), classLoader);
        Object refreshInstance = HookProxy.callStaticMethod(refreshClz, configurator.getSnsToolsOfGetRefreshFunc());
        HookProxy.callMethod(refreshInstance, configurator.getSnsRefreshFunc());

    }

    private static void configText(String content, Configurator configurator, ClassLoader classLoader) {

        if (TextUtils.isEmpty(content)) {
            return;
        }

        try {
            Class entityClz = HookProxy.findClass(configurator.getSnsEntityClz(), classLoader);
            Constructor entityConstructor = entityClz.getDeclaredConstructor(int.class);
            Object entity = entityConstructor.newInstance(configurator.getSnsTextEntityInstanceParam());

            HookProxy.callMethod(entity, configurator.getSnsEntityDescConfigFunc(), content);
            HookProxy.callMethod(entity, configurator.getSnsEntityVal0ConfigFunc1(), 0);
            HookProxy.callMethod(entity, configurator.getSnsEntityVal0ConfigFunc2(), 0);
            HookProxy.callMethod(entity, configurator.getSnsEntityVal0ConfigFunc3(), 0);
            HookProxy.callMethod(entity, configurator.getSnsEntityVal0ConfigFunc4(), 0);

            int result = (int) HookProxy.callMethod(entity, configurator.getSnsEntityCommitFunc());

            Class wrapClz = HookProxy.findClass(configurator.getSnsEntityCarrierClz(), classLoader);
            Constructor wrapConstructor = wrapClz.getDeclaredConstructor(int.class, int.class);
            Object wrapObj = wrapConstructor.newInstance(701, 1);
            HookProxy.callMethod(wrapObj, configurator.getSnsEntityCarryFunc(), result);
            Class emitClz = HookProxy.findClass(configurator.getSnsMsgHandleQueueClz(), classLoader);
            Object emitObj = HookProxy.getStaticObjectField(emitClz, configurator.getSnsMsgHandleQueueVar());
            HookProxy.callMethod(emitObj, configurator.getSnsMsgHandlePutFunc(), wrapObj);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void sendImage(String content, List<String> imgList, ClassLoader classLoader) {
        if (imgList == null || classLoader == null || imgList.size() <= 0) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        configImage(content, imgList, configurator, classLoader);

        Class refreshClz = HookProxy.findClass(configurator.getSnsToolsOfGetRefreshClz(), classLoader);
        Object refreshInstance = HookProxy.callStaticMethod(refreshClz, configurator.getSnsToolsOfGetRefreshFunc());
        HookProxy.callMethod(refreshInstance, configurator.getSnsRefreshFunc());
    }

    private static void configImage(String content, List<String> imgList, Configurator configurator, ClassLoader classLoader) {

        try {

            Class entityClz = HookProxy.findClass(configurator.getSnsEntityClz(), classLoader);
            Constructor entityConstructor = entityClz.getDeclaredConstructor(int.class);
            Object entityObj = entityConstructor.newInstance(configurator.getSnsImgEntityInstanceParam());
            HookProxy.callMethod(entityObj, configurator.getSnsEntityDescConfigFunc(), content);
            HookProxy.callMethod(entityObj, configurator.getSnsEntityVal0ConfigFunc1(), 0);
            HookProxy.callMethod(entityObj, configurator.getSnsEntityVal0ConfigFunc2(), 0);
            HookProxy.callMethod(entityObj, configurator.getSnsEntityVal0ConfigFunc3(), 0);
            HookProxy.callMethod(entityObj, configurator.getSnsEntityVal0ConfigFunc4(), 0);

            List<Object> list = new ArrayList<>();

            for (int i = 0; i < imgList.size(); i++) {
                Class imgInfoClz = HookProxy.findClass(configurator.getSnsImgInfoClz(), classLoader);
                Constructor imgInfoConstructor = imgInfoClz.getDeclaredConstructor(String.class, int.class);
                Object imgInfoObj = imgInfoConstructor.newInstance(imgList.get(i), 2);
                HookProxy.setObjectField(imgInfoObj, configurator.getSnsImgInfoVarType(), 2);
                HookProxy.setObjectField(imgInfoObj, configurator.getSnsImgInfoVal0Var1(), 0);
                HookProxy.setObjectField(imgInfoObj, configurator.getSnsImgInfoVal0Var2(), 0);
                HookProxy.setObjectField(imgInfoObj, configurator.getSnsImgInfoVal0Var3(), 0);
                HookProxy.setObjectField(imgInfoObj, configurator.getSnsImgInfoVal0Var4(), 0);
                HookProxy.setObjectField(imgInfoObj, configurator.getSnsImgInfoValFalseVar5(), false);
                HookProxy.setObjectField(imgInfoObj, configurator.getSnsImgInfoVarDesc(), content);
                list.add(imgInfoObj);
            }

            Object snsEntityVar = HookProxy.getObjectField(entityObj, configurator.getSnsEntityOneOfVar());
            Object imgOptListObj = HookProxy.getObjectField(snsEntityVar, configurator.getSnsImgOptListVar());

            for (int i = 0; i < list.size(); i++) {
                Class imgOptClz = HookProxy.findClass(configurator.getSnsImgOptClz(), classLoader);
                Constructor imgOptConstructor = imgOptClz.getDeclaredConstructor();
                Object imgOptObj = imgOptConstructor.newInstance();
                HookProxy.setObjectField(imgOptObj, configurator.getSnsImgOptVal00fVar(), 0.0f);
                HookProxy.setObjectField(imgOptObj, configurator.getSnsImgOptVal0Var(), 0);
                HookProxy.setObjectField(imgOptObj, configurator.getSnsImgOptVal1000fVar1(), -1000.0f);
                HookProxy.setObjectField(imgOptObj, configurator.getSnsImgOptVal1000fVar2(), -1000.0f);
                HookProxy.setObjectField(imgOptObj, configurator.getSnsImgOptVal1000fVar3(), -1000.0f);
                HookProxy.setObjectField(imgOptObj, configurator.getSnsImgOptVal1000fVar4(), -1000.0f);
                HookProxy.setObjectField(imgOptObj, configurator.getSnsImgOptVal2Var(), 2);
                HookProxy.setObjectField(imgOptObj, configurator.getSnsImgOptTimestamp1(), System.currentTimeMillis() / 1000);
                HookProxy.setObjectField(imgOptObj, configurator.getSnsImgOptTimestamp2(), System.currentTimeMillis() / 1000);

                HookProxy.callMethod(imgOptListObj, configurator.getSnsImgOptAddFunc(), imgOptObj);
            }

            HookProxy.callMethod(entityObj, configurator.getSnsEntityImgConfigFunc(), list);

            int result = (int) HookProxy.callMethod(entityObj, configurator.getSnsEntityCommitFunc());

            Class carrierClz = HookProxy.findClass(configurator.getSnsEntityCarrierClz(), classLoader);
            Constructor carrierConstructor = carrierClz.getDeclaredConstructor(int.class, int.class);
            Object carrierObj = carrierConstructor.newInstance(701, 1);
            HookProxy.callMethod(carrierObj, configurator.getSnsEntityCarryFunc(), result);

            Class queueClz = HookProxy.findClass(configurator.getSnsMsgHandleQueueClz(), classLoader);
            Object queueObj = HookProxy.getStaticObjectField(queueClz, configurator.getSnsMsgHandleQueueVar());
            HookProxy.callMethod(queueObj, configurator.getSnsMsgHandlePutFunc(), carrierObj);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void configVideo(String content, String videoLocalPath, Configurator configurator, ClassLoader classLoader) {
        try {

            Class entityClz = HookProxy.findClass(configurator.getSnsEntityClz(), classLoader);
            Constructor entityConstructor = entityClz.getDeclaredConstructor(int.class);
            Object entityObj = entityConstructor.newInstance(configurator.getSnsVideoEntityInstanceParam());
            HookProxy.callMethod(entityObj, configurator.getSnsEntityDescConfigFunc(), content);
            HookProxy.callMethod(entityObj, configurator.getSnsEntityVal0ConfigFunc1(), 0);
            HookProxy.callMethod(entityObj, configurator.getSnsEntityVal0ConfigFunc2(), 0);
            HookProxy.callMethod(entityObj, configurator.getSnsEntityVal0ConfigFunc3(), 0);
            HookProxy.callMethod(entityObj, configurator.getSnsEntityVal0ConfigFunc4(), 0);

            String videoPath = videoLocalPath;
            String coverPath = MediaTool.getVideoThumbImgPath(videoPath);
            File videoFile = new File(videoPath);
            String videoFileMd5 = MD5Utils.getFileMD5(videoFile);

            Class getTmpPathClz = HookProxy.findClass(configurator.getGetSnsVideoTmpPathClz(), classLoader);
            String tmpPath = (String) HookProxy.callStaticMethod(getTmpPathClz, configurator.getGetSnsVideoTmpPathFunc());

            String videoPathMD5Str = MD5Utils.get32MD5Value(videoPath);
            String coverImgMD5Str = MD5Utils.get32MD5Value(coverPath);
            String videoResult = tmpPath + videoPathMD5Str;
            String coverResult = tmpPath + coverImgMD5Str;
            HookProxy.callMethod(entityObj, configurator.getSnsEntityVideoConfigFunc(), videoResult);
            Class fileOpClz = HookProxy.findClass(configurator.getSnsVideoFileOperationClz(), classLoader);
            HookProxy.callStaticMethod(fileOpClz, configurator.getSnsVideoCopyFileFunc(), videoPath, videoResult);
            HookProxy.callStaticMethod(fileOpClz, configurator.getSnsVideoCopyFileFunc(), coverPath, coverResult);

            Object videoExtraVar1 = null;

            if (configurator.getVersion() < Configurator.CODE_CHANGED_VERSION_667) {
                videoExtraVar1 = HookProxy.callMethod(entityObj, configurator.getSnsVideoGetOneOfVarFunc(), "", 6, videoResult, coverResult, videoFileMd5, "", "");

            } else {
                videoExtraVar1 = HookProxy.callMethod(entityObj, configurator.getSnsVideoGetOneOfVarFunc(), "", videoResult, coverResult, videoFileMd5, "", "");
            }

            HookProxy.setObjectField(videoExtraVar1, configurator.getSnsVideoExtraVar1Param1(), content);
            Object oneOfVideoEntityVar = HookProxy.getObjectField(entityObj, configurator.getSnsVideoEntityOneOfVar1());
            Object varInnerVar1 = HookProxy.getObjectField(oneOfVideoEntityVar, configurator.getSnsVideoEntityVarInnerVar1());
            Object var1InnerVar2 = HookProxy.getObjectField(varInnerVar1, configurator.getSnsVideoEntityVar1InnerVar1());
            HookProxy.callMethod(var1InnerVar2, configurator.getSnsVideoExtraVar1AddFunc(), videoExtraVar1);

            Class videoExtraVar2Clz = HookProxy.findClass(configurator.getSnsVideoExtraVar2Clz(), classLoader);
            Constructor videoExtraVar2Constructor = videoExtraVar2Clz.getDeclaredConstructor();
            Object videoExtraVar2 = videoExtraVar2Constructor.newInstance();
            Object videoExtraVar2Param1 = HookProxy.getObjectField(videoExtraVar1, configurator.getSnsVideoExtraVar1Param2());
            HookProxy.setObjectField(videoExtraVar2, configurator.getSnsVideoExtraVar2Param1(), videoExtraVar2Param1);
            Object videoEntityOneOfVar2 = HookProxy.getObjectField(entityObj, configurator.getSnsVideoEntityOneOfVar2());
            Object videoEntityVar2InnerVar = HookProxy.getObjectField(videoEntityOneOfVar2, configurator.getSnsVideoEntityVar2InnerVar());
            HookProxy.callMethod(videoEntityVar2InnerVar, configurator.getSnsVideoExtraVar2AddFunc(), videoExtraVar2);

            int result = (int) HookProxy.callMethod(entityObj, configurator.getSnsEntityCommitFunc());
            Class carrierClz = HookProxy.findClass(configurator.getSnsEntityCarrierClz(), classLoader);
            Constructor carrierConstructor = carrierClz.getDeclaredConstructor(int.class, int.class);
            Object carrierObj = carrierConstructor.newInstance(701, 1);
            HookProxy.callMethod(carrierObj, configurator.getSnsEntityCarryFunc(), result);
            Class queueClz = HookProxy.findClass(configurator.getSnsMsgHandleQueueClz(), classLoader);
            Object queueObj = HookProxy.getStaticObjectField(queueClz, configurator.getSnsMsgHandleQueueVar());
            HookProxy.callMethod(queueObj, configurator.getSnsMsgHandlePutFunc(), carrierObj);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void sendVideo(String content, String videoPath, ClassLoader classLoader) {
        if (TextUtils.isEmpty(videoPath) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        configVideo(content, videoPath, configurator, classLoader);

        Class refreshClz = HookProxy.findClass(configurator.getSnsToolsOfGetRefreshClz(), classLoader);
        Object refreshInstance = HookProxy.callStaticMethod(refreshClz, configurator.getSnsToolsOfGetRefreshFunc());
        HookProxy.callMethod(refreshInstance, configurator.getSnsRefreshFunc());

    }
}
