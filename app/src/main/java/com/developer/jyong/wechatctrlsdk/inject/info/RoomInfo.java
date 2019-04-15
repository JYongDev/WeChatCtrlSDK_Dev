package com.developer.jyong.wechatctrlsdk.inject.info;


import android.database.Cursor;
import android.text.TextUtils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RoomInfo {

    private final static String WX_CHATROOM_COLUMNNAME_MEMBERLIST = "memberlist";
    private final static String WX_CHATROOM_COLUMNNAME_ROOMOWNER = "roomowner";
    private final static String WX_CHATROOM_COLUMNNAME_CHATROOMNAME = "chatroomname";
    private final static String WX_CHATROOM_COLUMNNAME_DISPLAYNAME = "displayname";

    private final static String WX_RCONTACT_COLUMNNAME_NICKNAME = "nickname";
    private final static String WX_RCONTACT_COLUMNNAME_USERNAME = "username";

    private String memberList = "";
    private String roomOwner = "";
    private String chatroomName = "";
    private String displayName = "";

    public String getMemberList() {
        return memberList;
    }

    public void setMemberList(String memberList) {
        this.memberList = memberList;
    }

    public String getRoomOwner() {
        return roomOwner;
    }

    public void setRoomOwner(String roomOwner) {
        this.roomOwner = roomOwner;
    }

    public String getChatroomName() {
        return chatroomName;
    }

    public void setChatroomName(String chatroomName) {
        this.chatroomName = chatroomName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public static List<RoomInfo> convertAsEntity(Cursor cursor) {
        List<RoomInfo> list = null;
        if (cursor != null) {
            if (cursor.getColumnCount() > 0) {
                list = new ArrayList<>();
                while (cursor.moveToNext()) {
                    RoomInfo info = new RoomInfo();

                    info.setMemberList(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_MEMBERLIST) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_MEMBERLIST)));
                    info.setRoomOwner(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_ROOMOWNER) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_ROOMOWNER)));
                    info.setChatroomName(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_CHATROOMNAME) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_CHATROOMNAME)));
                    info.setDisplayName(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_DISPLAYNAME) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_DISPLAYNAME)));

                    if (cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_NICKNAME) != -1) {
                        String nickname = cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_NICKNAME));
                        if (!TextUtils.isEmpty(nickname)) {
                            info.setDisplayName(nickname);
                        }
                    }

                    list.add(info);
                }
            }
            cursor.close();
        }
        return list;
    }

    public static JSONArray convertAsJSON(Cursor cursor) {
        JSONArray arr = null;
        if (cursor != null) {
            if (cursor.getColumnCount() > 0) {
                arr = new JSONArray();
                while (cursor.moveToNext()) {
                    try {

                        JSONObject obj = new JSONObject();

                        obj.put(WX_CHATROOM_COLUMNNAME_MEMBERLIST, cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_MEMBERLIST) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_MEMBERLIST)));
                        obj.put(WX_CHATROOM_COLUMNNAME_ROOMOWNER, cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_ROOMOWNER) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_ROOMOWNER)));
                        obj.put(WX_CHATROOM_COLUMNNAME_CHATROOMNAME, cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_CHATROOMNAME) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_CHATROOMNAME)));
                        obj.put(WX_CHATROOM_COLUMNNAME_DISPLAYNAME, cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_DISPLAYNAME) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_CHATROOM_COLUMNNAME_DISPLAYNAME)));

                        if (cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_NICKNAME) != -1) {
                            String nickname = cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_NICKNAME));
                            if (!TextUtils.isEmpty(nickname)) {
                                obj.put(WX_RCONTACT_COLUMNNAME_NICKNAME, nickname);
                            }
                        }
                        arr.put(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            cursor.close();
        }
        return arr;
    }
}
