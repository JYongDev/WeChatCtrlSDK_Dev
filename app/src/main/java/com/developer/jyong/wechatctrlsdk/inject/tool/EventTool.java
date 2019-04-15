package com.developer.jyong.wechatctrlsdk.inject.tool;

import java.util.HashMap;

public class EventTool {

    public final static String EVENT_ROOM = "create_chatroom";

    private static HashMap<String, Object> work = new HashMap<>();
    private static EventTool eventTool = new EventTool();

    public interface onEventCallback {
        void onBack(Object object);
    }

    private EventTool() {
    }

    public static EventTool instance() {
        if (eventTool == null) {
            eventTool = new EventTool();
        }
        return eventTool;
    }

    public void trigger(String key, Object obj) {

        if (key == null || key.length() <= 0) {
            return;
        }

        if (obj == null || work == null) {
            return;
        }

        if (work.containsKey(key)) {
            if (key.equals(EVENT_ROOM)) {
                ((onEventCallback) work.get(key)).onBack(obj);
                TLog.log(" work length before " + work.size());
                work.remove(key);
                TLog.log(" work length after " + work.size());
            }
        }

    }

    public void register(String key, onEventCallback obj) {
        if (key == null || key.length() <= 0) {
            return;
        }

        if (obj == null || work == null) {
            return;
        }

        if (!work.containsKey(key)) {
            work.put(key, obj);
        }
    }

}
