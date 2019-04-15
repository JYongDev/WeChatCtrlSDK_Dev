package com.developer.jyong.wechatctrlsdk.inject.core.message;

/**
 * Created by JYONG on 2018/6/12.
 * when message insert to database and
 * the server return the message server id  ,
 * invoke this callback
 */

public interface MsgCallback {


    /**
     * wechat message callback listener
     *
     * @param type   msg type
     * @param result result
     */
    void onChanged(int type, boolean result);


}
