package com.developer.jyong.wechatctrlsdk.inject.core.main;

import android.os.Environment;
import android.view.MenuItem;

import com.developer.jyong.wechatctrlsdk.inject.core.contact.Contact;
import com.developer.jyong.wechatctrlsdk.inject.core.message.Emitter;
import com.developer.jyong.wechatctrlsdk.inject.core.moment.Moment;
import com.developer.jyong.wechatctrlsdk.inject.core.room.Room;
import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.TLog;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class MenuClickListener implements MenuItem.OnMenuItemClickListener {

    private ClassLoader classLoader = null;

    public MenuClickListener(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {

        if (item.getTitle().toString().equals(LauncherInvader.CtrlSDK)) {
            TLog.log(" CtrlSDK ");
            // TODO: 2018/7/13 update
        }
        switch (item.getTitle().toString()) {
            case LauncherInvader.CtrlSDK:
                break;
            case "text":
                Emitter.sendText("HJY894199032", "HAHAHA", classLoader);
                break;
            case "image":
                Emitter.sendImage("wxid_34303t9wzkbm21", "HJY894199032", Environment.getExternalStorageDirectory().getPath() + File.separator + "ma.jpg", classLoader);
                break;
            case "voice":
                Emitter.sendVoice("HJY894199032", Environment.getExternalStorageDirectory().getPath() + File.separator + "aa.amr", classLoader);
                break;
            case "video":
                Emitter.sendVideo("HJY894199032", Environment.getExternalStorageDirectory().getPath() + File.separator + "haha.mp4", FieldTool.instance().getActivity(), classLoader);
                break;
            case "link":
                Emitter.transmitLink("269", "HJY894199032", classLoader);
                break;
            case "card":
                Emitter.sendCard("HJY894199032", "wxid_owhdh9f0taut22", classLoader);
                break;
            case "snsTxt":
                Moment.sendText("你们好", classLoader);
                break;
            case "snsImg":
                List<String> list = new ArrayList<String>();
                list.add(Environment.getExternalStorageDirectory().getPath() + File.separator + "ma.jpg");
                Moment.sendImage("哈哈", list, classLoader);
                break;
            case "snsVideo":
                Moment.sendVideo("哈哈哈", Environment.getExternalStorageDirectory().getPath() + File.separator + "haha.mp4", classLoader);
                break;
            case "createtRoom":
                List<String> wxLists = new ArrayList<>();
                wxLists.add("wxid_owhdh9f0taut22");
                wxLists.add("HJY894199032");
                wxLists.add("wxid_34303t9wzkbm21");
                wxLists.add("wxid_ysanfhdkamb922");
                Room.createRoom(wxLists, "test1", classLoader);
                break;
            case "addMember":
                List<String> list1 = new ArrayList<>();
                list1.add("HJY894199032");
                Room.addMember(list1, "5448966278@chatroom", classLoader);
                break;
            case "exitRoom":
                Room.exitRoom("5448966278@chatroom", classLoader);
                break;
            case "@all":
                Room.atAll("5448966278@chatroom", "aaaa", classLoader);
                break;
            case "removeMember":
                List<String> list2 = new ArrayList<>();
                list2.add("HJY894199032");
                Room.removeMember(list2, "5448966278@chatroom", classLoader);
                break;
            case "amendRoomName":
                Room.amendRoomName("5448966278@chatroom", "HappyNewYear2019", classLoader);
                break;
            case "agreeFriends":
                Contact.agreeFriends("HJY894199032", classLoader);
                break;
            case "subscriptionCard":
                Emitter.sendSubscriptionCard("HJY894199032", "gh_bbb5e9aed938", classLoader);
                break;
            case "amendRemark":
                Contact.amendRemark("HJY894199032", "Happy2019", classLoader);
                break;
            case "remittance":
                Emitter.acceptRemittance("273", classLoader);
                break;
            case "delContacts":
                Contact.delContact("HJY894199032", classLoader);
                break;
            case "atSomebody":
                List<String> username = new ArrayList<>();
                username.add("HJY894199032");
                Room.atSomebody("11921218241@chatroom", username, "你们好", classLoader);
                break;
        }
        return false;
    }
}
