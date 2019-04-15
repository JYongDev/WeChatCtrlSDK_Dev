package com.developer.jyong.wechatctrlsdk.inject.info;

import org.json.JSONObject;


public class Info {

    public final static String TYPE = "type";
    public final static String DATA = "data";

    public final static int TYPE_MESSAGE = 1;
    public final static int TYPE_REVOKE_MESSAGE = 2;
    public final static int TYPE_DELETE_MESSAGE = 3;
    public final static int TYPE_NEW_CONTACT_NOTIFY = 4;
    public final static int TYPE_IN_BLACKLIST = 5 ;
    public final static int TYPE_REMOVE_BLACKLIST = 6;
    public final static int TYPE_NEW_CONTACT = 7;
    public final static int TYPE_REMOVE_CONTACT = 8;
    public final static int TYPE_MODIFY_NICKNAME = 9;
    public final static int TYPE_MODIFY_REMARK = 10 ;


    public static JSONObject convert(Object obj, int type) {

        if (obj == null) {
            return null;
        }

        JSONObject parentObj = new JSONObject();

        try {
            if (obj instanceof MsgInfo) {
                JSONObject data = MsgInfo.toJSON((MsgInfo) obj);
                parentObj.put(TYPE, type);
                parentObj.put(DATA, data == null ? "" : data);
            } else if (obj instanceof ContactInfo) {
                JSONObject data = ContactInfo.convert2JsonObj((ContactInfo) obj);
                parentObj.put(TYPE, type);
                parentObj.put(DATA, data == null ? "" : data);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return parentObj;
    }

}
