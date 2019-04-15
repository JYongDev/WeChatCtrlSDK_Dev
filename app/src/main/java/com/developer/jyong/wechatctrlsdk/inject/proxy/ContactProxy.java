package com.developer.jyong.wechatctrlsdk.inject.proxy;


import com.developer.jyong.wechatctrlsdk.inject.core.contact.Contact;

import org.json.JSONArray;
import org.json.JSONObject;

public class ContactProxy {

    public static JSONArray contactList() {
        return Contact.contactList();
    }

    public static JSONObject contact(String wxid) {
        return Contact.contact(wxid);
    }

    public static JSONObject personalInfo() {
        return Contact.personalInfo();
    }

    public static void agreeFriends(String username, ClassLoader classLoader) {
        Contact.agreeFriends(username, classLoader);
    }

    public static void amendRemark(String username, String newRemark, ClassLoader classLoader) {
        Contact.amendRemark(username, newRemark, classLoader);
    }

    public static void delContact(String username ,ClassLoader classLoader){
        Contact.delContact(username,classLoader);
    }

}
