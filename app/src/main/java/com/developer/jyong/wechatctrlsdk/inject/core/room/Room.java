package com.developer.jyong.wechatctrlsdk.inject.core.room;


import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.core.main.Configurator;
import com.developer.jyong.wechatctrlsdk.inject.info.ContactInfo;
import com.developer.jyong.wechatctrlsdk.inject.info.RoomInfo;
import com.developer.jyong.wechatctrlsdk.inject.tool.DBTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.EventTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.HookProxy;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;

import org.json.JSONArray;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.List;

import de.robv.android.xposed.XposedHelpers;

public class Room {

    /**
     * create chatroom
     *
     * @param list     member list
     * @param roonName room name
     * @return data
     */
    private static Object configCreate(List<String> list, String roonName, Configurator configurator, ClassLoader classLoader) {

        Object entityObj = null;
        try {
            if (configurator.getVersion() < Configurator.CODE_CHANGED_VERSION_672) {
                Class entityClz = HookProxy.findClass(configurator.getRoomEntityClz(), classLoader);
                Constructor entityConstructor = entityClz.getDeclaredConstructor();
                entityObj = entityConstructor.newInstance();
                Object var = HookProxy.getObjectField(entityObj, configurator.getRoomEntityVar());
                HookProxy.setObjectField(var, configurator.getRoomEntityStrParam(), roonName);
                HookProxy.setObjectField(var, configurator.getRoomEntityListParam(), list);
            } else {
                Class entityClz = HookProxy.findClass(configurator.getCreateRoomEntityClz(), classLoader);
                Constructor entityConstructor = HookProxy.findConstructor(entityClz, String.class, List.class);
                Object entityObject = entityConstructor.newInstance("", list);

                Class parentEntityClz = HookProxy.findClass(configurator.getCreateRoomEntityParentClz(), classLoader);
                Object parentEntity = HookProxy.callStaticMethod(parentEntityClz, configurator.getCreateRoomGetParentEntityFunc(), true);
                HookProxy.setObjectField(parentEntity, configurator.getCreateRoomVarInParent(), entityObject);

                Class bootClz = HookProxy.findClass(configurator.getCreateRoomBootClz(), classLoader);
                Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getCreateRoomBootFunc());
                Object bootInstance = HookProxy.getObjectField(bootObj, configurator.getCreateRoomBootInstance());

                HookProxy.callMethod(bootInstance,
                        configurator.getCreateRoomSendFunc(),
                        HookProxy.callMethod(entityObject, configurator.getCreateRoomVarGetTypeFunc()),
                        HookProxy.getObjectField(parentEntity, configurator.getCreateRoomCallbackVar()));
                HookProxy.callMethod(bootInstance, configurator.getCreateRoomSendFunc(), entityObject, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityObj;
    }

    public static void createRoom(final List<String> list, String str, final ClassLoader classLoader) {

        if (list == null || list.size() <= 0 || classLoader == null) {
            return;
        }

        final Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        if (configurator.getVersion() < Configurator.CODE_CHANGED_VERSION_672) {

            Object obj = configCreate(list, str, configurator, classLoader);

            if (obj == null) {
                return;
            }

            Class bootClz = HookProxy.findClass(configurator.getRoomEntitySubmitClz(), classLoader);
            Object bootObj = HookProxy.getStaticObjectField(bootClz, configurator.getRoomEntitySubmitInstance());
            HookProxy.callMethod(bootObj, configurator.getRoomEntitySubmitFunc(), obj);
        } else {

            configCreate(list, str, configurator, classLoader);

            EventTool.instance().register(EventTool.EVENT_ROOM, new EventTool.onEventCallback() {

                @Override
                public void onBack(Object object) {
                    if (object != null) {
                        String roomName = (String) object;

                        Class refreshClz = HookProxy.findClass(configurator.getCreateRoomRefreshUIClz(), classLoader);
                        HookProxy.callStaticMethod(refreshClz, configurator.getCreateRoomRefreshUIFunc(), roomName, list, "你邀请%s加入了群聊", false, null);
                    }
                }
            });
        }
    }

    private static Object configAdd(List<String> list, String str, Configurator configurator, ClassLoader classLoader) {
        Object entity = null;
        try {
            Class entityClz = HookProxy.findClass(configurator.getAddRoomMemberEntityClz(), classLoader);
            Constructor entityConstructor = entityClz.getConstructor(String.class, List.class, String.class);
            entity = entityConstructor.newInstance(str, list, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    /**
     * add member in room
     *
     * @param list   member list
     * @param roomId room id
     */
    public static void addMember(List<String> list, String roomId, ClassLoader classLoader) {

        if (list == null || list.size() <= 0 || TextUtils.isEmpty(roomId) || classLoader == null)
            return;

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        Object obj = configAdd(list, roomId, configurator, classLoader);

        if (obj == null)
            return;

        Class bootClz = HookProxy.findClass(configurator.getAddRoomMemberBootClz(), classLoader);
        Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getAddRoomMemberBootFunc());
        HookProxy.callMethod(bootObj, configurator.getAddRoomMemberSendFunc(), obj, 0);

    }

    /**
     * remove member
     *
     * @param list   member list
     * @param roomId room id
     */
    public static void removeMember(List<String> list, String roomId, ClassLoader classLoader) {

        if (TextUtils.isEmpty(roomId) || list == null || list.size() <= 0 || classLoader == null) {
            return;
        }
        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        Object obj = configRemove(list, roomId, configurator, classLoader);

        if (obj == null)
            return;

        Class bootClz = HookProxy.findClass(configurator.getRemoveRoomMemberBootClz(), classLoader);
        Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getRemoveRoomMemberBootFunc());
        HookProxy.callMethod(bootObj, configurator.getRemoveRoomMemberSendFunc(), obj, 0);

    }

    private static Object configRemove(List<String> list, String str, Configurator configurator, ClassLoader classLoader) {
        Object entity = null;
        try {
            if (configurator.getVersion() < Configurator.CODE_CHANGED_VERSION_672) {
                Class entityClz = HookProxy.findClass(configurator.getRemoveRoomMemberEntityClz(), classLoader);
                Constructor entityConstructor = entityClz.getDeclaredConstructor(String.class, List.class);
                entity = entityConstructor.newInstance(str, list);
            } else {
                Class entityClz = HookProxy.findClass(configurator.getRemoveRoomMemberEntityClz(), classLoader);
                Constructor entityConstructor = entityClz.getDeclaredConstructor(String.class, List.class, int.class);
                entity = entityConstructor.newInstance(str, list, 0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public static void atAll(String roomId, String content, ClassLoader classLoader) {

        if (TextUtils.isEmpty(roomId) || TextUtils.isEmpty(content) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        Object obj = configNotifyAll(roomId, content, configurator, classLoader);

        if (obj == null)
            return;

        Class bootClz = HookProxy.findClass(configurator.getNotifyAllRoomMemberBootClz(), classLoader);
        Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getNotifyAllRoomMemberBootFunc());
        HookProxy.callMethod(bootObj, configurator.getNotifyAllRoomMemberSendFunc(), obj, 0);
    }

    private static Object configNotifyAll(String roomId, String content, Configurator configurator, ClassLoader classLoader) {
        Object entity = null;

        try {
            Class entityClz = HookProxy.findClass(configurator.getNotifyAllMemberEntityClz(), classLoader);
            Constructor entityConstructor = entityClz.getDeclaredConstructor(String.class, String.class);
            entity = entityConstructor.newInstance(roomId, content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return entity;
    }

    public static JSONArray roomList() {

        JSONArray roomList = null;

        if (FieldTool.instance().getDbObject() != null) {

            String sql = "select c.memberlist,c.roomowner,c.chatroomname,c.displayname,r.nickname from chatroom c left join rcontact r on c.chatroomname = r.username ";

            roomList = RoomInfo.convertAsJSON(DBTool.rawQuery(FieldTool.instance().getDbObject(), sql, null));

        }
        return roomList;
    }

    public static void amendRoomName(String roomId, String newName, ClassLoader classLoader) {
        if (TextUtils.isEmpty(roomId) || TextUtils.isEmpty(newName) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        Object data = configRoomName(roomId, newName, configurator, classLoader);

        if (data == null) {
            return;
        }

        HookProxy.callMethod(data, configurator.getRoonNameShowDialogFunc(), FieldTool.instance().getActivity(), "", true, null);
        Object dialogObj = HookProxy.getObjectField(data, configurator.getRoomNameDialogInstance());
        HookProxy.callMethod(dialogObj, configurator.getRoomNameDismissFunc());

    }

    private static Object configRoomName(String roomId, String newName, Configurator configurator, ClassLoader classLoader) {

        Object entity = null;
        try {
            Class getRoomNameObj = HookProxy.findClass(configurator.getGetRoomNameEntityClz(), classLoader);
            Object roomNameEntity = HookProxy.callStaticMethod(getRoomNameObj, configurator.getGetRoomNameEntityFunc(), roomId);
            entity = HookProxy.callMethod(roomNameEntity, configurator.getRoomNameAmendFunc(), roomId, newName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entity;
    }

    public static void exitRoom(String roomId, ClassLoader classLoader) {
        if (TextUtils.isEmpty(roomId) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {

            Class jClz = HookProxy.findClass(configurator.getExitRoomInvokeParamsClz(), classLoader);
            Class gClz = HookProxy.findClass(configurator.getExitRoomInvokeClz(), classLoader);
            Object rObj = HookProxy.callStaticMethod(gClz, configurator.getExitRoomInvokeFunc(), jClz);

            Object bootObj = HookProxy.callMethod(rObj, configurator.getExitRoomGetInvokeFunc());
            Class aClz = HookProxy.findClass(configurator.getExitRoomRefreshUIEntityClz(), classLoader);
            Constructor constructor = aClz.getDeclaredConstructor(String.class);
            Object aObj = constructor.newInstance(roomId);
            HookProxy.callMethod(bootObj, configurator.getExitRoomRefreshUIFunc(), aObj);

            Class abClz = HookProxy.findClass(configurator.getExitRoomBootClz(), classLoader);
            Object ykObj = HookProxy.callStaticMethod(abClz, configurator.getExitRoomBootFunc1(), roomId);
            Object enObj = HookProxy.callMethod(ykObj, configurator.getExitRoomBootFunc2(), roomId);
            HookProxy.callMethod(enObj, configurator.getExitRoomFunc());
        } catch (Throwable e) {
            e.printStackTrace();
        }


    }

    private static Object configAtone(String roomId, List<String> at, String content, Configurator configurator, ClassLoader classLoader) {
        Object entityObj = null;

        try {

            if (FieldTool.instance().getDbObject() == null) {
                return null;
            }

            Class entityClz = XposedHelpers.findClass(configurator.getAtoneEntityClz(), classLoader);

            // wxid
            StringBuilder usernames = new StringBuilder();
            // nickname
            StringBuilder nickname = new StringBuilder();

            for (int i = 0; i < at.size(); i++) {
                // wxid
                usernames.append(at.get(i));
                if (i != at.size() - 1) {
                    usernames.append(",");
                }

                String sql = "select nickname from rcontact where username = ? ";
                ContactInfo info = ContactInfo.convert2Bean(DBTool.rawQuery(FieldTool.instance().getDbObject(), sql, new String[]{at.get(i)}));
                nickname.append("@" + info.getNickname() + " ");
            }

            HashMap<String, String> map = new HashMap<>(1);
            map.put("atuserlist", "<![CDATA[" + usernames.toString() + "]]>");

            entityObj = XposedHelpers.newInstance(entityClz, roomId,
                    nickname.toString() + content, 1, 291, map);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityObj;
    }

    public static void atSomebody(String roomId, List<String> at, String content, ClassLoader classLoader) {
        if (TextUtils.isEmpty(roomId) || classLoader == null || at == null || at.size() <= 0) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        Object obj = configAtone(roomId, at, content, configurator, classLoader);

        if (obj == null) {
            return;
        }

        Class bootClz = XposedHelpers.findClass(configurator.getAtoneBootClz(), classLoader);
        Object bootObj = XposedHelpers.callStaticMethod(bootClz, configurator.getAtoneBootFunc());
        XposedHelpers.callMethod(bootObj, configurator.getAtoneSendFunc(), obj, 0);
    }
}
