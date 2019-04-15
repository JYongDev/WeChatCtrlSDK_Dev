package com.developer.jyong.wechatctrlsdk.inject.core.message;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.core.main.Configurator;
import com.developer.jyong.wechatctrlsdk.inject.info.LinkInfo;
import com.developer.jyong.wechatctrlsdk.inject.info.MsgInfo;
import com.developer.jyong.wechatctrlsdk.inject.info.RemittanceInfo;
import com.developer.jyong.wechatctrlsdk.inject.tool.DBTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.HookProxy;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;

import java.io.File;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;


public class Emitter {

    public static void sendText(String talker, String content, ClassLoader classLoader) {

        if (TextUtils.isEmpty(talker) || TextUtils.isEmpty(content) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {
            Object obj = configTextMsg(talker, content, configurator, classLoader);
            if (obj != null) {
                Class bootClz = HookProxy.findClass(configurator.getTextMsgBootClz(), classLoader);
                Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getTextMsgBootFunc());
                HookProxy.callMethod(bootObj, configurator.getTextMsgSendFunc(), obj, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object configTextMsg(String talker, String content, Configurator configurator, ClassLoader classLoader) throws Exception {
        Object obj = null;

        Class entityClz = HookProxy.findClass(configurator.getTextMsgEntityClz(), classLoader);
        Constructor entityConstructor = entityClz.getDeclaredConstructor(String.class, String.class, int.class);
        obj = entityConstructor.newInstance(talker, content, 1);
        return obj;
    }

    public static void sendImage(String myWXID, String talker, String imgLocalPath, ClassLoader classLoader) {
        if (TextUtils.isEmpty(myWXID) || TextUtils.isEmpty(talker) || TextUtils.isEmpty(imgLocalPath) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {
            Object obj = configImgMsg(myWXID, talker, imgLocalPath, configurator, classLoader);
            Class bootClz = HookProxy.findClass(configurator.getImgMsgBootClz(), classLoader);
            Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getImgMsgBootFunc());
            HookProxy.callMethod(bootObj, configurator.getImgMsgSendFunc(), obj, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object configImgMsg(String myWXID, String talker, String imgLocalPath, Configurator configurator, ClassLoader classLoader) throws Exception {

        Class imgEntityClz = HookProxy.findClass(configurator.getImgMsgEntityClz(), classLoader);
        Class imgEntityParamClz = HookProxy.findClass(configurator.getImgMsgEntityParamClz(), classLoader);
        Object object = null;

        Constructor imgMsgConstructor = imgEntityClz.getDeclaredConstructor(
                int.class, String.class, String.class, String.class,
                int.class, imgEntityParamClz, int.class, String.class,
                String.class, boolean.class, int.class);
        object = imgMsgConstructor.newInstance(2, myWXID, talker, imgLocalPath,
                0, null, 0, "",
                "", true, 2130837923);

        return object;
    }

    public static void sendVideo(String talker, String filePath, Context context, ClassLoader classLoader) {

        if (TextUtils.isEmpty(talker) || TextUtils.isEmpty(filePath) || context == null || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {
            Object obj = configVideoMsg(talker, filePath, configurator, classLoader, context);

            if (obj != null) {
                Class bootClz = HookProxy.findClass(configurator.getVideoMsgBootClz(), classLoader);
                HookProxy.callStaticMethod(bootClz, configurator.getVideoMsgBootFunc(), obj, "ChattingUI_importMultiVideo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object configVideoMsg(String talker, String filePath, Configurator configurator, ClassLoader classLoader, Context context) throws Exception {

        if (TextUtils.isEmpty(talker) || TextUtils.isEmpty(filePath) || context == null || configurator == null || classLoader == null) {
            return null;
        }

        Object obj = null;
        Class entityClz = HookProxy.findClass(configurator.getVideoMsgEntityClz(), classLoader);
        Class entityParamClz = HookProxy.findClass(configurator.getVideoMsgEntityParamClz(), classLoader);

        Constructor constructor = entityClz.getDeclaredConstructor(Context.class, List.class, Intent.class,
                String.class, int.class, entityParamClz);

        List<String> list = new ArrayList<>();
        list.add(filePath);
        obj = constructor.newInstance(context, list, null, talker, 2, null);
        return obj;
    }

    /**
     * run on ui Thread
     *
     * @param talker        chatting obj
     * @param localFilePath local voice file path
     */
    public static void sendVoice(final String talker, final String localFilePath, final ClassLoader classLoader) {

        if (TextUtils.isEmpty(talker) || TextUtils.isEmpty(localFilePath) || classLoader == null) {
            return;
        }

        final Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {
            Object obj = configVoiceMsg(talker, localFilePath, configurator, classLoader);

            if (obj != null) {
                Class bootClz = HookProxy.findClass(configurator.getVoiceMsgBootClz(), classLoader);
                Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getVoiceMsgBootFunc());
                HookProxy.callMethod(bootObj, configurator.getVoiceMsgSendFunc(), obj, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object configVoiceMsg(String talker, String localFilePath, Configurator configurator, ClassLoader classLoader) throws Exception {

        if (TextUtils.isEmpty(talker) || TextUtils.isEmpty(localFilePath)) {
            return null;
        }

        Object entityObj = null;

        Class dbClz = HookProxy.findClass(configurator.getVoiceMsgDBEntityClz(), classLoader);
        String fileName = (String) HookProxy.callStaticMethod(dbClz, configurator.getVoiceMsgDBEntityFunc(), talker);

        Class pathClz = HookProxy.findClass(configurator.getVoiceMsgPathClz(), classLoader);
        String targetFilePath = (String) HookProxy.callStaticMethod(pathClz, configurator.getVoiceMsgPathFunc(), fileName, true);

        File target = MediaTool.modifyVoiceFile(localFilePath, targetFilePath);

        if (target == null)
            return null;

        HookProxy.callStaticMethod(pathClz, configurator.getVoiceMsgNotifyFunc(), fileName, (int) target.length(), 0);

        Class entityClz = HookProxy.findClass(configurator.getVoiceMsgEntityClz(), classLoader);
        Constructor entityConstructor = entityClz.getDeclaredConstructor(String.class);

        entityObj = entityConstructor.newInstance(fileName);

        return entityObj;
    }

    private static LinkInfo configLinkMsg(String msgId, Configurator configurator, ClassLoader classLoader) throws Exception {

        Object dbObject = FieldTool.instance().getDbObject();

        if (dbObject == null) {
            return null;
        }

        String sql = "select imgPath,msgSvrId,content from message where msgId = ? ";
        MsgInfo msg = MsgInfo.toEntity(DBTool.rawQuery(dbObject, sql, new String[]{msgId}));

        if (msg == null)
            return null;

        Object obj = null;
        if (!TextUtils.isEmpty((String) msg.getContent())) {
            Class biClz = HookProxy.findClass(configurator.getLinkMsgParam1WrapClz(), classLoader);
            String str = (String) HookProxy.callStaticMethod(biClz, configurator.getLinkMsgParam1WrapFunc(), msg.getContent());
            if (!TextUtils.isEmpty(str)) {
                Class gClz = HookProxy.findClass(configurator.getLinkMsgParam1InvokeClz(), classLoader);
                Object fvObj = HookProxy.callStaticMethod(gClz, configurator.getLinkMsgParam1InvokeFunc(), str);
                Class gClzz = HookProxy.findClass(configurator.getLinkMsgParam1ConvertClz(), classLoader);
                obj = HookProxy.callStaticMethod(gClzz, configurator.getLinkMsgParam1ConvertFunc(), fvObj);
            }
        }
        byte[] data = null;
        if (!TextUtils.isEmpty(msg.getImgPath())) {
            Class oClz = HookProxy.findClass(configurator.getLinkMsgParam2WrapClz(), classLoader);
            Object gObj = HookProxy.callStaticMethod(oClz, configurator.getLinkMsgParam2WrapFunc());
            String result = (String) HookProxy.callMethod(gObj, configurator.getLinkMsgParam2InvokeFunc(), msg.getImgPath(), true);
            if (!TextUtils.isEmpty(result)) {
                Class fileOpClz = HookProxy.findClass(configurator.getLinkMsgParam2ConvertClz(), classLoader);

                if (configurator.getVersion() < Configurator.CODE_CHANGED_VERSION_672) {
                    data = (byte[]) HookProxy.callStaticMethod(fileOpClz, configurator.getLinkMsgParam2ConvertFunc(), result, 0, -1);
                } else {
                    data = (byte[]) HookProxy.callStaticMethod(fileOpClz, configurator.getLinkMsgParam2ConvertFunc(), result);
                }
            }
        }

        String session = "SessionId@" + msg.getMsgSvrId() + "#" + System.nanoTime();
        LinkInfo link = new LinkInfo();
        link.setObj(obj);
        link.setData(data);
        link.setSession(session);
        return link;
    }

    public static void transmitLink(String msgId, String talker, ClassLoader classLoader) {

        if (TextUtils.isEmpty(msgId) || TextUtils.isEmpty(talker) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {
            LinkInfo link = configLinkMsg(msgId, configurator, classLoader);

            if (link != null) {
                Class lClz = HookProxy.findClass(configurator.getLinkMsgSendClz(), classLoader);
                HookProxy.callStaticMethod(lClz, configurator.getLinkMsgSendFunc(), link.getObj(), "", null, talker, "", link.getData(), link.getSession(), "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendCard(String talker, String cardOwner, ClassLoader classLoader) {
        if (TextUtils.isEmpty(talker) || TextUtils.isEmpty(cardOwner) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {
            Object obj = configCard(talker, cardOwner, configurator, classLoader);

            if (obj != null) {

                Class bootClz = HookProxy.findClass(configurator.getCardMsgBootClz(), classLoader);
                Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getCardMsgBootFunc());
                HookProxy.callMethod(bootObj, configurator.getCardMsgSendFunc(), obj, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object configCard(String talker, String cardOWner, Configurator configurator, ClassLoader classLoader) throws Exception {
        Object entity = null;

        Class packagerClz = HookProxy.findClass(configurator.getCardMsgPackagerClz(), classLoader);
        String packageStr = (String) HookProxy.callStaticMethod(packagerClz, configurator.getCardMsgPackageFunc(), cardOWner);

        Class entityClz = HookProxy.findClass(configurator.getCardMsgEntityClz(), classLoader);
        Constructor constructor = entityClz.getDeclaredConstructor(String.class, String.class, int.class);
        entity = constructor.newInstance(talker, packageStr, 42);
        return entity;
    }

    /**
     * 发送公众号名片
     *
     * @param talker           聊天对象
     * @param subscriptionWXID 公众号wxid
     * @param classLoader      classloader
     */
    public static void sendSubscriptionCard(String talker, String subscriptionWXID, ClassLoader classLoader) {
        if (TextUtils.isEmpty(talker) || TextUtils.isEmpty(subscriptionWXID) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {
            Class bootClz = HookProxy.findClass(configurator.getSubscriptionBootClz(), classLoader);
            Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getSubscriptionBootFunc());
            HookProxy.callMethod(bootObj, configurator.getSubscriptionSendFunc(), subscriptionWXID, talker, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 接受转账
     *
     * @param msgId       消息id
     * @param classLoader classloader
     */
    public static void acceptRemittance(String msgId, ClassLoader classLoader) {

        if (TextUtils.isEmpty(msgId) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());
        Object dbObject = FieldTool.instance().getDbObject();

        if (dbObject == null || configurator == null) {
            return;
        }

        try {

            Object entity = configRemittance(msgId, configurator, dbObject, classLoader);

            if (entity == null) {
                return;
            }

            Class bootClz = HookProxy.findClass(configurator.getRemittanceBootClz(), classLoader);
            Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getRemittanceBootFunc());
            Object obj = HookProxy.getObjectField(bootObj, configurator.getRemittanceAcceptInstance());
            HookProxy.callMethod(obj, configurator.getRemittanceAcceptFunc(), entity, 0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object configRemittance(String msgId, Configurator configurator, Object dbObj, ClassLoader classLoader) {
        Object entity = null;
        try {
            RemittanceInfo remittanceInfo = getRemittanceInfo(msgId, dbObj);

            if (remittanceInfo == null) {
                return null;
            }

            Class entityClz = HookProxy.findClass(configurator.getRemittanceEntityClz(), classLoader);
            Constructor constructor = HookProxy.findConstructor(entityClz, String.class, String.class, int.class, String.class, String.class, int.class);

            entity = constructor.newInstance(
                    remittanceInfo.getTranscationID(),
                    remittanceInfo.getTransferID(),
                    0,
                    "confirm",
                    remittanceInfo.getTalker(),
                    Integer.parseInt(remittanceInfo.getInvalidTime()));
            HookProxy.setObjectField(entity, configurator.getRemittanceEntityParams(), "RemittanceProcess");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    private static RemittanceInfo getRemittanceInfo(String msgId, Object dbObj) {

        String messageSQL = "select talker,content from message where msgId = ? ";
        MsgInfo msgInfo = MsgInfo.toEntity(DBTool.rawQuery(dbObj, messageSQL, new String[]{String.valueOf(msgId)}));

        if (msgInfo == null) {
            return null;
        }

        return RemittanceInfo.toEntity(msgInfo.getTalker(), (String) msgInfo.getContent());
    }
}
