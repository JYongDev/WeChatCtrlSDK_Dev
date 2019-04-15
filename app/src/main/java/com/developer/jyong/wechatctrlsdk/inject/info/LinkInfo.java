package com.developer.jyong.wechatctrlsdk.inject.info;

import org.json.JSONObject;

/**
 * use in transmit link msg
 */
public class LinkInfo {

    private final static String LINK_TITLE = "title";
    private final static String LINK_URL = "url";

    private Object obj = null;
    private String session = "";
    private byte[] data = null;
    private String title = "";
    private String url = "";

    public LinkInfo() {
        this.obj = new Object();
        this.session = "";
        this.data = new byte[0];
        this.title = "";
        this.url = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public static JSONObject convert2Json(LinkInfo link) {
        if (link == null)
            return null;
        JSONObject obj = new JSONObject();
        try {
            obj.put(LINK_TITLE, link.getTitle());
            obj.put(LINK_URL, link.getUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
