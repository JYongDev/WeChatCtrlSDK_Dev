package com.developer.jyong.wechatctrlsdk.inject.proxy;

import com.developer.jyong.wechatctrlsdk.inject.core.moment.Moment;

import java.util.List;


public class MomentProxy {

    public static void sendText(String content, ClassLoader classLoader) {
        Moment.sendText(content, classLoader);
    }

    public static void sendImage(String content, List<String> imgPath, ClassLoader classLoader) {
        Moment.sendImage(content, imgPath, classLoader);
    }

    public static void sendVideo(String content, String videoPath, ClassLoader classLoader) {
        Moment.sendVideo(content, videoPath, classLoader);
    }

}
