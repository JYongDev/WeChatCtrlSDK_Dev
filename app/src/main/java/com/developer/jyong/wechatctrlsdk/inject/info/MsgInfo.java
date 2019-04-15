package com.developer.jyong.wechatctrlsdk.inject.info;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.core.contact.ContactTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;

import org.json.JSONObject;


public class MsgInfo extends Info {

    //  微信消息类型
    public final static int WX_MESSAGE_TYPE_TEXT = 1;                           //  文字
    public final static int WX_MESSAGE_TYPE_CARD = 42;                          //  名片
    public final static int WX_MESSAGE_TYPE_VOICE = 34;                         //  语音
    public final static int WX_MESSAGE_TYPE_IMAGE = 3;                          //  图片
    public final static int WX_MESSAGE_TYPE_VIDEO = 43;                         //  视频
    public final static int WX_MESSAGE_TYPE_REMITTANCE = 419430449;             //  转账
    public final static int WX_MESSAGE_TYPE_LINK = 49;                          //  链接
    public final static int WX_MESSAGE_TYPE_REDPACKAGE = 436207665;             //  红包
    public final static int WX_MESSAGE_TYPE_SYSTEM = 10000;                     //  系统消息
    public final static int WX_MESSAGE_TYPE_SYSTEM2 = 10002;                    //  系统消息
    public final static int WX_MESSAGE_TYPE_ROOM_SYSTEM = 570425393;        //  群系统消息(修改群名,加入群聊)

    // 微信 message 表字段名
    private final static String WX_MESSAGE_COLUMNNAME_TYPE = "type";
    private final static String WX_MESSAGE_COLUMNNAME_ISSEND = "isSend";
    private final static String WX_MESSAGE_COLUMNNAME_CONTENT = "content";
    private final static String WX_MESSAGE_COLUMNNAME_MSGSVRID = "msgSvrId";
    public final static String WX_MESSAGE_COLUMNNAME_MSGID = "msgId";
    private final static String WX_MESSAGE_COLUMNNAME_IMGPATH = "imgPath";
    private final static String WX_MESSAGE_COLUMNNAME_TALKER = "talker";
    private final static String WX_MESSAGE_COLUMNNAME_CREATETIME = "createTime";

    //  本 SDK 自定义字段名
    private final static String WX_OWNER = "owner";
    private final static String WX_VOICEPATH = "voicePath";
    private final static String WX_THUMBIMGPATH = "thumbImgPath";
    private final static String WX_VIDEOPATH = "videoPath";
    private final static String WX_MONEY = "money";
    private final static String WX_ISREMITTER = "isRemitter";
    private final static String WX_ROOMTALKER = "roomTalker";
    private final static String WX_ISROOM = "isRoom";
    private final static String WX_ISDEL = "isDel";
    private final static String WX_ISREVOKE = "isRevoke";

    //  微信 imgInfo2 表字段名
    private final static String WX_IMGINFO2_COLUMNNAME_BIGIMGPATH = "bigImgPath";

    private int type = 0;
    /**
     * 1=自己，0=其他人
     */
    private int isSend = 2;
    private Object content = null;
    private String msgSvrId = "";
    private String msgId = "";
    private String imgPath = "";
    private String talker = "";
    private String createTime = "";
    private String owner = "";
    private String voicePath = "";
    private String thumbImgPath = "";
    private String bigImgPath = "";
    private String videoPath = "";
    private String money = "";
    /**
     * 1=是转账的人，0=不是转账的人
     */
    private int isRemitter = 0;
    private String roomTalker = "";
    /**
     * 1 = 是群聊 ， 0 = 不是群聊
     */
    private int isRoom = 0;
    /**
     * 1 = 删除，0 = 不是删除
     */
    private int isDel = 0;
    /**
     * 1 = 撤回，0=不是撤回
     */
    private int isRevoke = 0;

    public int isDel() {
        return isDel;
    }

    public void setDel(int del) {
        isDel = del;
    }

    public int isRevoke() {
        return isRevoke;
    }

    public void setRevoke(int revoke) {
        isRevoke = revoke;
    }

    public int getIsRoom() {
        return isRoom;
    }

    public void setIsRoom(int isRoom) {
        this.isRoom = isRoom;
    }

    public String getRoomTalker() {
        return roomTalker;
    }

    public void setRoomTalker(String roomTalker) {
        this.roomTalker = roomTalker;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getIsRemitter() {
        return isRemitter;
    }

    public void setIsRemitter(int isRemitter) {
        this.isRemitter = isRemitter;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }

    public String getThumbImgPath() {
        return thumbImgPath;
    }

    public void setThumbImgPath(String thumbImgPath) {
        this.thumbImgPath = thumbImgPath;
    }

    public String getBigImgPath() {
        return bigImgPath;
    }

    public void setBigImgPath(String bigImgPath) {
        this.bigImgPath = bigImgPath;
    }

    public String getVoicePath() {
        return voicePath;
    }

    public void setVoicePath(String voicePath) {
        this.voicePath = voicePath;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsSend() {
        return isSend;
    }

    public void setIsSend(int isSend) {
        this.isSend = isSend;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public String getMsgSvrId() {
        return msgSvrId;
    }

    public void setMsgSvrId(String msgSvrId) {
        this.msgSvrId = msgSvrId;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTalker() {
        return talker;
    }

    public void setTalker(String talker) {
        this.talker = talker;
    }

    private static MsgInfo convert(ContentValues val) {
        if (val == null) {
            return null;
        }
        MsgInfo msg = new MsgInfo();

        msg.setType(val.containsKey(WX_MESSAGE_COLUMNNAME_TYPE) ? val.getAsInteger(WX_MESSAGE_COLUMNNAME_TYPE) : 0);
        msg.setIsSend(val.containsKey(WX_MESSAGE_COLUMNNAME_ISSEND) ? val.getAsInteger(WX_MESSAGE_COLUMNNAME_ISSEND) : 2);
        msg.setMsgSvrId(val.containsKey(WX_MESSAGE_COLUMNNAME_MSGSVRID) ? val.getAsString(WX_MESSAGE_COLUMNNAME_MSGSVRID) : "");
        msg.setMsgId(val.containsKey(WX_MESSAGE_COLUMNNAME_MSGID) ? val.getAsString(WX_MESSAGE_COLUMNNAME_MSGID) : "");
        msg.setContent(val.containsKey(WX_MESSAGE_COLUMNNAME_CONTENT) ? val.getAsString(WX_MESSAGE_COLUMNNAME_CONTENT) : "");
        msg.setCreateTime(val.containsKey(WX_MESSAGE_COLUMNNAME_CREATETIME) ? val.getAsString(WX_MESSAGE_COLUMNNAME_CREATETIME) : "");
        msg.setImgPath(val.containsKey(WX_MESSAGE_COLUMNNAME_IMGPATH) ? val.getAsString(WX_MESSAGE_COLUMNNAME_IMGPATH) : "");
        msg.setTalker(val.containsKey(WX_MESSAGE_COLUMNNAME_TALKER) ? val.getAsString(WX_MESSAGE_COLUMNNAME_TALKER) : "");
        msg.setBigImgPath("");

        return msg;
    }

    private static MsgInfo convert(Cursor cursor) {
        if (cursor == null) {
            return null;
        }

        MsgInfo msg = new MsgInfo();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                msg.setType(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_TYPE) == -1 ? 0 : cursor.getInt(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_TYPE)));
                msg.setIsSend(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_ISSEND) == -1 ? 2 : cursor.getInt(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_ISSEND)));
                msg.setMsgSvrId(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_MSGSVRID) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_MSGSVRID)));
                msg.setMsgId(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_MSGID) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_MSGID)));
                msg.setContent(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_CONTENT) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_CONTENT)));
                msg.setCreateTime(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_CREATETIME) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_CREATETIME)));
                msg.setImgPath(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_IMGPATH) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_IMGPATH)));
                msg.setTalker(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_TALKER) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_MESSAGE_COLUMNNAME_TALKER)));

                if (cursor.getColumnIndex(WX_IMGINFO2_COLUMNNAME_BIGIMGPATH) == -1) {
                    msg.setBigImgPath("");
                } else {
                    String bigImgHeader = "SERVERID://";
                    if (cursor.getString(cursor.getColumnIndex(WX_IMGINFO2_COLUMNNAME_BIGIMGPATH)).contains(bigImgHeader)) {
                        msg.setBigImgPath("");
                    } else {
                        msg.setBigImgPath(cursor.getString(cursor.getColumnIndex(WX_IMGINFO2_COLUMNNAME_BIGIMGPATH)));
                    }
                }
            }
        }
        return msg;
    }

    public static MsgInfo toEntity(Object obj) {

        if (obj == null) {
            return null;
        }

        MsgInfo msg = null;

        if (obj instanceof Cursor) {
            msg = convert((Cursor) obj);
        } else if (obj instanceof ContentValues) {
            msg = convert((ContentValues) obj);
        }

        if (msg != null) {
            String owner = WeChatTool.currentWX(WeChatTool.getWXContext());
            msg.setOwner(TextUtils.isEmpty(owner) ? "" : owner);
            msg.setVoicePath("");
            msg.setThumbImgPath("");
            msg.setVideoPath("");
            msg.setMoney("");
            msg.setIsRemitter(2);
            msg.setDel(0);
            msg.setRevoke(0);

            if (ContactTool.isRoom(msg.getTalker()) && msg.getIsSend() != -1) {
                msg.setIsRoom(1);
                if (msg.getIsSend() == 1) {
                    msg.setRoomTalker(owner);
                } else if (msg.getIsSend() == 0) {
                    if (msg.getType() == WX_MESSAGE_TYPE_SYSTEM2) {
                        msg.setRoomTalker(owner);
                    } else if (msg.getType() == WX_MESSAGE_TYPE_SYSTEM) {
                        // system message don't get roon talker
                    } else {    // normal message ,which send by other
                        String msgContent = (String) msg.getContent();
                        if (msgContent.contains(":")) {
                            String arr[] = ((String) msg.getContent()).split(":", 2);
                            if (arr != null && arr.length > 0) {
                                msg.setRoomTalker(arr[0]);
                                if (arr[1] != null) {
                                    String content = arr[1];
                                    content = content.replace("<?xml version=\"1.0\"?>", "");
                                    msg.setContent(content);
                                    msg.setContent(content.replaceFirst("\n", ""));
                                }
                            }
                        }
                    }
                }
            }
        }
        return msg;
    }

    public static JSONObject toJSON(MsgInfo msg) {

        if (msg == null)
            return null;

        JSONObject obj = new JSONObject();
        try {
            obj.put(WX_OWNER, msg.getOwner() == null ? "" : msg.getOwner());
            obj.put(WX_MESSAGE_COLUMNNAME_CONTENT, msg.getContent() == null ? "" : msg.getContent());
            obj.put(WX_MESSAGE_COLUMNNAME_TALKER, msg.getTalker() == null ? "" : msg.getTalker());
            obj.put(WX_MESSAGE_COLUMNNAME_CREATETIME, msg.getCreateTime() == null ? "" : msg.getCreateTime());
            obj.put(WX_MESSAGE_COLUMNNAME_IMGPATH, msg.getImgPath() == null ? "" : msg.getImgPath());
            obj.put(WX_MESSAGE_COLUMNNAME_MSGSVRID, msg.getMsgSvrId() == null ? "" : msg.getMsgSvrId());
            obj.put(WX_MESSAGE_COLUMNNAME_MSGID, msg.getMsgId() == null ? "" : msg.getMsgId());
            obj.put(WX_VOICEPATH, msg.getVoicePath() == null ? "" : msg.getVoicePath());
            obj.put(WX_IMGINFO2_COLUMNNAME_BIGIMGPATH, msg.getBigImgPath() == null ? "" : msg.getBigImgPath());
            obj.put(WX_THUMBIMGPATH, msg.getThumbImgPath() == null ? "" : msg.getThumbImgPath());
            obj.put(WX_VIDEOPATH, msg.getVideoPath() == null ? "" : msg.getVideoPath());
            obj.put(WX_MONEY, msg.getMoney() == null ? "" : msg.getMoney());
            obj.put(WX_ROOMTALKER, msg.getRoomTalker() == null ? "" : msg.getRoomTalker());
            obj.put(WX_MESSAGE_COLUMNNAME_ISSEND, msg.getIsSend());
            obj.put(WX_MESSAGE_COLUMNNAME_TYPE, msg.getType());
            obj.put(WX_ISREMITTER, msg.getIsRemitter());
            obj.put(WX_ISROOM, msg.getIsRoom());
            obj.put(WX_ISDEL, msg.isDel());
            obj.put(WX_ISREVOKE, msg.isRevoke());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;

    }

}
