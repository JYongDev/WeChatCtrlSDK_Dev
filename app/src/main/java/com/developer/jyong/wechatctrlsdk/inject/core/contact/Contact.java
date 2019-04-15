package com.developer.jyong.wechatctrlsdk.inject.core.contact;

import android.database.Cursor;
import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.core.main.Configurator;
import com.developer.jyong.wechatctrlsdk.inject.info.ContactInfo;
import com.developer.jyong.wechatctrlsdk.inject.info.RequestInfo;
import com.developer.jyong.wechatctrlsdk.inject.tool.DBTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.HookProxy;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Constructor;

import de.robv.android.xposed.XposedHelpers;


public class Contact {

    public static JSONArray contactList() {

        JSONArray contactList = null;

        if (FieldTool.instance().getDbObject() != null) {

            String sql = "select r.type, r.username ,r.nickname ,r.alias,r.conRemark,r.lvbuff,i.reserved2 from rcontact r left join img_flag i on r.username = i.username where (r.type & 1!=0) and r.type & 32=0  and r.type & 8 =0 and r.verifyFlag & 8 =0  and ( r.username not like '%@%' or " +
                    "(( (r.type & 1!=0) and r.type & 8=0 and r.username like '%@talkroom')) or (r.type & 8=0 and r.username like '%@openim')) and r.username <> 'tmessage' and r.username <> 'officialaccounts' and r.username <> 'helper_entry' and r.username <> 'filehelper' and r.username <> 'weixin' and r.username <> 'jkhdfkj@t.qq.com' and r.username <> 'blogapp' ";

            contactList = ContactInfo.convert2JsonArr(DBTool.rawQuery(FieldTool.instance().getDbObject(), sql, null));
        }
        return contactList;
    }

    public static JSONObject contact(String wxid) {
        JSONObject contact = null;

        if (FieldTool.instance().getDbObject() != null) {
            if (!TextUtils.isEmpty(wxid)) {

                String sql = "select r.username ,r.nickname ,r.alias ,r.conRemark ,r.lvbuff ,i.reserved2 from rcontact r left join img_flag i on r.username = i.username where r.username = ? ";

                contact = ContactInfo.convert2JsonObj(ContactInfo.convert2Bean(DBTool.rawQuery(FieldTool.instance().getDbObject(), sql, new String[]{wxid})));
            }
        }
        return contact;
    }

    public static JSONObject personalInfo() {
        JSONObject contact = null;
        String wxid = WeChatTool.currentWX(WeChatTool.getWXContext());
        if (!TextUtils.isEmpty(wxid)) {
            contact = Contact.contact(wxid);
        }
        return contact;
    }

    public static void agreeFriends(String username, ClassLoader classLoader) {

        if (TextUtils.isEmpty(username) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());
        Object obj = FieldTool.instance().getDbObject();

        if (configurator == null || obj == null) {
            return;
        }

        try {

            Object entity = configAgree(username, obj, classLoader, configurator);

            if (entity != null) {
                Class bootClz = HookProxy.findClass(configurator.getAgreeFriendBootClz(), classLoader);
                Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getAgreeFriendBootFunc());
                HookProxy.callMethod(bootObj, configurator.getAgreeFriendSendFunc(), entity, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Object configAgree(String username, Object obj, ClassLoader classLoader, Configurator configurator) throws Exception {

        Object entity = null;

        String sql = "select fmsgContent from fmessage_conversation where talker = ? ";
        Cursor cursor = DBTool.rawQuery(obj, sql, new String[]{username});

        RequestInfo request = RequestInfo.convert(cursor);

        if (request == null) {
            return null;
        }

        String ticket = ContactTool.getTicket(request.getFmsgContent());

        Class entityClz = HookProxy.findClass(configurator.getAgreeFriendEntityClz(), classLoader);

        if (TextUtils.isEmpty(ticket) || entityClz == null) {
            return null;
        }

        if (configurator.getVersion() < Configurator.CODE_CHANGED_VERSION_667) {
            Constructor entityConstructor = entityClz.getDeclaredConstructor(String.class, String.class, int.class);
            entity = entityConstructor.newInstance(username, ticket, 6);
        } else if (configurator.getVersion() >= Configurator.CODE_CHANGED_VERSION_667) {
            Constructor entityConstructor = entityClz.getDeclaredConstructor(String.class, String.class, int.class, byte.class);
            entity = entityConstructor.newInstance(username, ticket, 6, (byte) 0);
        }

        return entity;
    }

    public static void amendRemark(String username, String newRemark, ClassLoader classLoader) {
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(newRemark) || classLoader == null) {
            return;
        }

        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {
            Class bootClz = HookProxy.findClass(configurator.getGetRemarkInfoBootClz(), classLoader);
            Object bootObj = HookProxy.callStaticMethod(bootClz, configurator.getGetRemarkInfoBootFunc());
            Object data = HookProxy.callMethod(bootObj, configurator.getGetRemarkInfoFunc(), username);

            Class amendClz = HookProxy.findClass(configurator.getAmendRemarkClz(), classLoader);
            HookProxy.callStaticMethod(amendClz, configurator.getAmendRemarkFunc(), data, newRemark);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void delContact(String username, ClassLoader classLoader) {
        if (TextUtils.isEmpty(username) || classLoader == null) {
            return;
        }
        Configurator configurator = Configurator.instance(WeChatTool.getVersion());

        if (configurator == null) {
            return;
        }

        try {

            Class entityClz = XposedHelpers.findClass(configurator.getDelContactEntityClz(), classLoader);
            Object entity = XposedHelpers.newInstance(entityClz, username);
            Class bootClz = XposedHelpers.findClass(configurator.getDelContactBootClz(), classLoader);
            Object bootObj = XposedHelpers.callStaticMethod(bootClz, configurator.getDelContactBootFunc());
            XposedHelpers.callMethod(bootObj, configurator.getDelContactFunc(), entity);

            Object refreshObj = XposedHelpers.callStaticMethod(bootClz, configurator.getDelContactRefreshBootFunc());
            XposedHelpers.callMethod(refreshObj, configurator.getDelContactRefreshFunc(), username);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
