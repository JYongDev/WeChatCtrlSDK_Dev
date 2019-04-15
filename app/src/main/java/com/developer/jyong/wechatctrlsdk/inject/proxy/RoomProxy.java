package com.developer.jyong.wechatctrlsdk.inject.proxy;

import com.developer.jyong.wechatctrlsdk.inject.core.room.Room;

import org.json.JSONArray;

import java.util.List;


public class RoomProxy {

    public static void createRoom(final List<String> memberList, final String roomName, final ClassLoader classLoader) {
        Room.createRoom(memberList, roomName, classLoader);
    }

    public static void addMember(List<String> memberList, String roomId, ClassLoader classLoader) {
        Room.addMember(memberList, roomId, classLoader);
    }

    public static void removeMember(List<String> memberList, String roomId, ClassLoader classLoader) {
        Room.removeMember(memberList, roomId, classLoader);
    }

    public static void notifyAllMember(String roomId, String content, ClassLoader classLoader) {
        Room.atAll(roomId, content, classLoader);
    }

    public static JSONArray roomList() {
        return Room.roomList();
    }

    public static void amendRoomName(String roomId, String newName, ClassLoader classLoader) {
        Room.amendRoomName(roomId, newName, classLoader);
    }

    public static void exitRoom(String roomId, ClassLoader classLoader) {
        Room.exitRoom(roomId, classLoader);
    }

    public static void atSomebody(String roomId, List<String> at, String content, ClassLoader classLoader){
        Room.atSomebody(roomId,at,content,classLoader);
    }

}
