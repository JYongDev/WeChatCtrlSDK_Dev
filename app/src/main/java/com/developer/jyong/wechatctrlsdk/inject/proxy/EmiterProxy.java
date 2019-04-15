package com.developer.jyong.wechatctrlsdk.inject.proxy;

import android.app.Activity;
import android.content.Context;

import com.developer.jyong.wechatctrlsdk.inject.core.main.Configurator;
import com.developer.jyong.wechatctrlsdk.inject.core.message.Emitter;
import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.HookProxy;


public class EmiterProxy {

    public static void sendText(String to, String message, ClassLoader classLoader) {
        Emitter.sendText(to, message, classLoader);
    }

    public static void sendVideo(String talker, String filePath, ClassLoader classLoader) {
        Class adClz = HookProxy.findClass(Configurator.instance(WeChatTool.getVersion()).getContextClz(), classLoader);
        Context mContext = (Context) HookProxy.callStaticMethod(adClz, Configurator.instance(WeChatTool.getVersion()).getContextFunc());
        Emitter.sendVideo(talker, filePath, mContext, classLoader);
    }

    public static void sendImage(String talker, String imgLocalPath, ClassLoader classLoader) {
        String myWxid = WeChatTool.currentWX(WeChatTool.getWXContext());
        Emitter.sendImage(myWxid, talker, imgLocalPath, classLoader);
    }

    public static void sendVoice(final String talker, final String localFilePath, final ClassLoader classLoader) {
        Activity activity = FieldTool.instance().getActivity();
        if (activity != null) {
            (activity).runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Emitter.sendVoice(talker, localFilePath, classLoader);
                }
            });
        }
    }

    public static void transmitLink(String msgId, String talker, ClassLoader classLoader) {
        Emitter.transmitLink(msgId, talker, classLoader);
    }

    public static void sendCard(String talker, String cardOwner, ClassLoader classLoader) {
        Emitter.sendCard(talker, cardOwner, classLoader);
    }

    public static void sendSubscriptionCard(String talker, String subscriptionWXID, ClassLoader classLoader) {
        Emitter.sendSubscriptionCard(talker, subscriptionWXID, classLoader);
    }

    public static void acceptRemittance(String msgId, ClassLoader classLoader) {
        Emitter.acceptRemittance(msgId, classLoader);
    }

}
