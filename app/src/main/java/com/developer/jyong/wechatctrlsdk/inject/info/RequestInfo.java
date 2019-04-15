package com.developer.jyong.wechatctrlsdk.inject.info;


import android.database.Cursor;

public class RequestInfo {

    public static String WX_FMESSAGE_CONVERSATION_FMSGCONTENT = "fmsgContent";

    private String fmsgContent;

    public RequestInfo() {
        this.fmsgContent = "";
    }

    public String getFmsgContent() {
        return fmsgContent;
    }

    public void setFmsgContent(String fmsgContent) {
        this.fmsgContent = fmsgContent;
    }

    @Override
    public String toString() {
        return "\n RequestInfo { " +
                "\n\t fmsgContent=" + fmsgContent +
                "\n\t }";
    }

    public static RequestInfo convert(Cursor cursor) {
        RequestInfo request = null;
        if (cursor != null && cursor.getCount() > 0) {

            request = new RequestInfo();

            while (cursor.moveToNext()) {
                request.setFmsgContent(cursor.getColumnIndex(WX_FMESSAGE_CONVERSATION_FMSGCONTENT) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_FMESSAGE_CONVERSATION_FMSGCONTENT)));
            }
            cursor.close();
        }
        return request;
    }
}
