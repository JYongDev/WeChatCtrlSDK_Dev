package com.developer.jyong.wechatctrlsdk.inject.info;


import android.database.Cursor;

import com.developer.jyong.wechatctrlsdk.inject.core.contact.ContactTool;

import org.json.JSONArray;
import org.json.JSONObject;

public class ContactInfo extends Info {

    public final static String WX_IMGFLAG_COLUMNNAME_RESERVED2 = "reserved2";

    public final static String WX_RCONTACT_COLUMNNAME_USERNAME = "username";
    public final static String WX_RCONTACT_COLUMNNAME_ALIAS = "alias";
    public final static String WX_RCONTACT_COLUMNNAME_NICKNAME = "nickname";
    public final static String WX_RCONTACT_COLUMNNAME_LVBUFF = "lvbuff";
    public final static String WX_RCONTACT_COLUMNNAME_CONREMARK = "conRemark";
    public final static String WX_RCONTACT_COLUMNNAME_TYPE = "type";

    public final static String WX_AVATAR = "avatar";
    public final static String WX_SEX = "sex";
    public final static String WX_SIGNATURE = "signature";
    public final static String WX_PROVINCE = "province";
    public final static String WX_CITY = "city";
    public final static String WX_ORIGIN = "origin";
    public final static String WX_TENCENTWEIBO = "tencentWeibo";
    public final static String WX_OFFICEACCOUONTNAME = "officeAccountName";
    public final static String WX_CITYCODE = "cityCode";
    public final static String WX_WSTORE = "wStore";
    public final static String WX_PHONE = "phone";
    public final static String WX_V2USERNAME = "v2UserName";
    public final static String WX_NEWTYPE = "newType";
    public final static String WX_NEWNICKNAME = "newNickname";
    public final static String WX_NEWREMARK = "newRemark";


    private String username = "";
    private String nickname = "";
    private String alias = "";
    private String conRemark = "";
    private String avatar = "";
    private int sex = 0;  /* 1= man,2=women */
    private String signature = "";
    private String province = "";
    private String city = "";
    private String origin = "";
    private String tencentWeibo = "";
    private String officeAccountName = "";
    private String cityCode = "";
    private String wStore = "";
    private String phone = "";
    private String v2Username = "";
    private int type = -1;
    private int newType = -1;
    private String newNickname = "";
    private String newRemark = "";

    public ContactInfo() {
    }

    public String getNewNickname() {
        return newNickname;
    }

    public void setNewNickname(String newNickname) {
        this.newNickname = newNickname;
    }

    public String getNewRemark() {
        return newRemark;
    }

    public void setNewRemark(String newRemark) {
        this.newRemark = newRemark;
    }

    public int getNewType() {
        return newType;
    }

    public void setNewType(int newType) {
        this.newType = newType;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getConRemark() {
        return conRemark;
    }

    public void setConRemark(String conRemark) {
        this.conRemark = conRemark;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTencentWeibo() {
        return tencentWeibo;
    }

    public void setTencentWeibo(String tencentWeibo) {
        this.tencentWeibo = tencentWeibo;
    }

    public String getOfficeAccountName() {
        return officeAccountName;
    }

    public void setOfficeAccountName(String officeAccountName) {
        this.officeAccountName = officeAccountName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getwStore() {
        return wStore;
    }

    public void setwStore(String wStore) {
        this.wStore = wStore;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getV2Username() {
        return v2Username;
    }

    public void setV2Username(String v2Username) {
        this.v2Username = v2Username;
    }

    private static ContactInfo convert(Cursor cursor) {
        ContactInfo contact = new ContactInfo();
        if (cursor != null) {
            contact.setNewType(0);
            contact.setNewNickname("");
            contact.setNewRemark("");
            contact.setType(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_TYPE) == -1 ? -1 : cursor.getInt(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_TYPE)));
            contact.setUsername(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_USERNAME) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_USERNAME)));
            contact.setNickname(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_NICKNAME) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_NICKNAME)));
            contact.setAlias(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_ALIAS) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_ALIAS)));
            contact.setConRemark(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_CONREMARK) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_CONREMARK)));
            contact.setAvatar(cursor.getColumnIndex(WX_IMGFLAG_COLUMNNAME_RESERVED2) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_IMGFLAG_COLUMNNAME_RESERVED2)));

            if (cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_LVBUFF) != -1) {
                byte data[] = cursor.getBlob(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_LVBUFF));
                if (data != null) {
                    ContactInfo extra = ContactTool.getExtraInfo(data);
                    contact.setSex(extra.getSex());
                    contact.setSignature(extra.getSignature());
                    contact.setProvince(extra.getProvince());
                    contact.setCity(extra.getCity());
                    contact.setOrigin(extra.getOrigin());
                    contact.setTencentWeibo(extra.getTencentWeibo());
                    contact.setOfficeAccountName(extra.getOfficeAccountName());
                    contact.setCityCode(extra.getCityCode());
                    contact.setwStore(extra.getwStore());
                    contact.setPhone(extra.getPhone());
                    contact.setV2Username(extra.getV2Username());
                }
            }
        }
        return contact;
    }

    public static ContactInfo convert2Bean(Cursor cursor) {
        ContactInfo contact = null;
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                while (cursor.moveToNext()) {
                    contact = convert(cursor);
                }
            }
            cursor.close();
        }
        return contact;
    }

    public static JSONArray convert2JsonArr(Cursor cursor) {
        JSONArray arr = null;
        if (cursor != null) {
            if (cursor.getCount() > 0) {

                arr = new JSONArray();

                while (cursor.moveToNext()) {
                    try {
                        JSONObject obj = new JSONObject();

                        obj.put(WX_RCONTACT_COLUMNNAME_USERNAME, cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_USERNAME) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_USERNAME)));
                        obj.put(WX_RCONTACT_COLUMNNAME_NICKNAME, cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_NICKNAME) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_NICKNAME)));
                        obj.put(WX_RCONTACT_COLUMNNAME_ALIAS, cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_ALIAS) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_ALIAS)));
                        obj.put(WX_RCONTACT_COLUMNNAME_CONREMARK, cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_CONREMARK) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_CONREMARK)));
                        obj.put(WX_AVATAR, cursor.getColumnIndex(WX_IMGFLAG_COLUMNNAME_RESERVED2) == -1 ? "" : cursor.getString(cursor.getColumnIndex(WX_IMGFLAG_COLUMNNAME_RESERVED2)));
//                        obj.put(WX_NEWTYPE, 0);
//                        obj.put(WX_RCONTACT_COLUMNNAME_TYPE, cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_TYPE) == -1 ? -1 : cursor.getString(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_TYPE)));
//                        obj.put(WX_NEWNICKNAME,"");
//                        obj.put(WX_NEWREMARK,"");

                        if (cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_LVBUFF) != -1) {
                            byte data[] = cursor.getBlob(cursor.getColumnIndex(WX_RCONTACT_COLUMNNAME_LVBUFF));
                            if (data != null) {
                                ContactInfo contactInfo = ContactTool.getExtraInfo(data);
                                obj.put(WX_SEX, contactInfo.getSex());
                                obj.put(WX_SIGNATURE, contactInfo.getSignature());
                                obj.put(WX_PROVINCE, contactInfo.getProvince());
                                obj.put(WX_CITY, contactInfo.getCity());
                                obj.put(WX_ORIGIN, contactInfo.getOrigin());
                                obj.put(WX_TENCENTWEIBO, contactInfo.getTencentWeibo());
                                obj.put(WX_OFFICEACCOUONTNAME, contactInfo.getOfficeAccountName());
                                obj.put(WX_CITYCODE, contactInfo.getCityCode());
                                obj.put(WX_WSTORE, contactInfo.getwStore());
                                obj.put(WX_PHONE, contactInfo.getPhone());
//                                obj.put(WX_V2USERNAME, contactInfo.getV2Username());
                            }
                        }

                        arr.put(obj);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                cursor.close();
            }
            cursor.close();
        }
        return arr;
    }

    public static JSONObject convert2JsonObj(ContactInfo info) {
        if (info == null) {
            return null;
        }

        JSONObject obj = new JSONObject();

        try {
//            obj.put(WX_RCONTACT_COLUMNNAME_TYPE, info.getType());
            obj.put(WX_RCONTACT_COLUMNNAME_USERNAME, info.getUsername());
            obj.put(WX_RCONTACT_COLUMNNAME_NICKNAME, info.getNickname());
            obj.put(WX_RCONTACT_COLUMNNAME_ALIAS, info.getAlias());
            obj.put(WX_RCONTACT_COLUMNNAME_CONREMARK, info.getConRemark());
            obj.put(WX_AVATAR, info.getAvatar());
            obj.put(WX_SEX, info.getSex());
            obj.put(WX_SIGNATURE, info.getSignature());
            obj.put(WX_PROVINCE, info.getProvince());
            obj.put(WX_CITY, info.getCity());
            obj.put(WX_ORIGIN, info.getOrigin());
            obj.put(WX_TENCENTWEIBO, info.getTencentWeibo());
            obj.put(WX_OFFICEACCOUONTNAME, info.getOfficeAccountName());
            obj.put(WX_CITYCODE, info.getCityCode());
            obj.put(WX_WSTORE, info.getwStore());
            obj.put(WX_PHONE, info.getPhone());
//            obj.put(WX_V2USERNAME, info.getV2Username());
//            obj.put(WX_NEWTYPE, info.getNewType());
//            obj.put(WX_NEWNICKNAME ,info.getNewNickname());
//            obj.put(WX_NEWREMARK,info.getNewRemark());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
