package com.developer.jyong.wechatctrlsdk.inject.info;

import android.database.Cursor;

public class MediaInfo {
    public final static int VIDEO_START_DOWLOAD = 111;
    public final static int VIDEO_DOWNLOAD_SUCCESS = 199;
    public final static String IMG_DOWNLOAD_SUCCESS_SUFFIX = ".jpg";
    public final static String IMG_NEED_DOWNLOAD_PREFIX = "SERVERID://";

    private final static String WX_VIDEOINFO2_COLUMNNAME_STATUS = "status";

    private final static String WX_IMGINFO2_COLUMNNAME_BIGIMGPATH = "bigImgPath";
    private final static String WX_IMGINFO2_COLUMNNAME_MSGLOCALID = "msglocalid";

    private final static String WX_ID = "id";

    private final static String WX_MESSAGE_COLUMNNAME_MSGSVRID = "msgSvrId";

    private long id = -1;
    private int status = -1;
    private String bigImgPath = "";
    private String msgSvrId = "";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMsgSvrId() {
        return msgSvrId;
    }

    public void setMsgSvrId(String msgSvrId) {
        this.msgSvrId = msgSvrId;
    }

    public String getBigImgPath() {
        return bigImgPath;
    }

    public void setBigImgPath(String bigImgPath) {
        this.bigImgPath = bigImgPath;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static MediaInfo convertByCursor(Cursor cursor) {
        if (cursor == null)
            return null;
        MediaInfo media = new MediaInfo();

        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                media.setStatus(cursor.getColumnIndex(WX_VIDEOINFO2_COLUMNNAME_STATUS) == -1 ? -1 : cursor.getInt(cursor.getColumnIndex(WX_VIDEOINFO2_COLUMNNAME_STATUS)));
                media.setBigImgPath(cursor.getColumnIndex(WX_IMGINFO2_COLUMNNAME_BIGIMGPATH) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_IMGINFO2_COLUMNNAME_BIGIMGPATH)));
                media.setMsgSvrId(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_MSGSVRID) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_MSGSVRID)));
                media.setId(cursor.getColumnIndex(WX_ID) == -1 ? -1 : cursor.getInt(cursor.getColumnIndex(WX_ID)));
            }
            cursor.close();
        }
        return media;
    }

    @Override
    public String toString() {
        return "MediaInfo{" +
                "status=" + status +
                ", bigImgPath='" + bigImgPath + '\'' +
                ", msgSvrId='" + msgSvrId + '\'' +
                '}';
    }
}
