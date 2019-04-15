package com.developer.jyong.wechatctrlsdk.inject.proxy;


import com.developer.jyong.wechatctrlsdk.inject.core.main.Booter;

import java.util.concurrent.BlockingQueue;


public class ListenerProxy {

    public static void listen(BlockingQueue queue){
        Booter.setQueue(queue);
    }

}
