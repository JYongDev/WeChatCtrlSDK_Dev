package com.developer.jyong.wechatctrlsdk.inject.core.contact;


import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.info.ContactInfo;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

import javax.xml.parsers.DocumentBuilderFactory;

public class ContactTool {

    private static String getOrigin(int key) {
        // TODO: 2018/6/29 get more type about origin
        String result = "未知";
        switch (key) {
            case 1000018:       //  被动添加，通过附近的人添加
                result = "对方通过附近的人添加";
                break;
            case 18:            //  主动添加，通过附近的人添加
                result = "通过附近的人添加";
                break;
            case 3:             //  主动添加，通过微信号码添加
                result = "通过搜索微信号添加";
                break;
            case 1000003:       //  被动添加，通过微信号码添加
                result = "对方通过搜索微信号添加";
                break;
            case 30:            //  主动添加，通过扫码添加
                result = "通过扫一扫添加";
                break;
            case 1000030:       //  被动添加，通过扫码添加
                result = "对方通过扫一扫添加";
                break;
            case 1:             //  被动添加，通过qq号添加
                // TODO: 2018/6/28 no sure is add by myself
                result = "通过搜索QQ号添加";
                break;
            case 1000001:       //  被动添加，通过qq号添加
                result = "对方通过搜索QQ号添加";
                break;
            case 17:
                result = "通过名片分享添加";
                break;
            case 1000017:
                result = "对方通过名片分享添加";
                break;
            case 14:
                result = "通过群聊添加";
                break;
            case 1000014:
                result = "对方通过群聊添加";
                break;
            case 15:            //  主动添加，通过手机号码添加
                result = "通过搜索手机号添加";
                break;
            case 48:            //  主动添加，通过雷达添加
                result = "雷达";
                break;
            default:
                result = "未知";
                break;
        }
        return result;
    }

    public static ContactInfo getExtraInfo(byte[] data) {
        ByteBuffer bytebuf = parse(data);
        ContactInfo contactInfo = null;
        if (bytebuf != null) {
            contactInfo = get(bytebuf);
        }
        return contactInfo;

    }

    private static ContactInfo get(ByteBuffer byteBuf) {
        ContactInfo contactInfo = new ContactInfo();

        int sex = 0;
        String signature = "";
        String province = "";
        String city = "";
        int origin = 0;
        String tencentWeibo = "";
        String officeAccountName = "";
        String cityCode = "";
        String wStore = "";
        String phone = "";
        String v2Username = "";


        try {
            getInt(byteBuf);
            sex = getInt(byteBuf);
            getString(byteBuf);
            getLong(byteBuf);
            /*qq number */
            getInt(byteBuf);
            getString(byteBuf);
            getString(byteBuf);
            getInt(byteBuf);
            getInt(byteBuf);
            getString(byteBuf);
            getString(byteBuf);
            getInt(byteBuf);
            getInt(byteBuf);
          /*签名*/
            signature = getString(byteBuf);
           /*省份*/
            province = getString(byteBuf);
            /*城市*/
            city = getString(byteBuf);
            getString(byteBuf);
            getInt(byteBuf);
           /*添加来源*/
            origin = getInt(byteBuf);
          /*腾讯微博*/
            tencentWeibo = getString(byteBuf);
            /*int field_verifyFlag =*/
            getInt(byteBuf);
          /*公众号名称*/
            officeAccountName = getString(byteBuf);
         /*城市编码*/
            cityCode = getString(byteBuf);
            getInt(byteBuf);
            getInt(byteBuf);
            getString(byteBuf);
            getString(byteBuf);
            getString(byteBuf);
            getString(byteBuf);
            getString(byteBuf);
          /*微店*/
            wStore = getString(byteBuf);
           /*手机号码*/
            phone = getString(byteBuf);
           /*v2_username*/
            v2Username = getString(byteBuf);
//        getInt(byteBuf);
//            getString(byteBuf);
//            getInt(byteBuf);
//            getString(byteBuf);

            contactInfo.setSex(sex);
            contactInfo.setSignature(signature == null ? "" : signature);
            contactInfo.setProvince(province == null ? "" : province);
            contactInfo.setCity(city == null ? "" : city);
            contactInfo.setOrigin(getOrigin(origin));
            contactInfo.setTencentWeibo(tencentWeibo == null ? "" : tencentWeibo);
            contactInfo.setOfficeAccountName(officeAccountName == null ? "" : officeAccountName);
            contactInfo.setCityCode(cityCode == null ? "" : cityCode);
            contactInfo.setwStore(wStore == null ? "" : wStore);
            contactInfo.setPhone(phone == null ? "" : phone);
            contactInfo.setV2Username(v2Username == null ? "" : v2Username);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactInfo;
    }

    private static ByteBuffer parse(byte[] data) {
        boolean flag = (data == null || data.length == 0) || (data[0] != (byte) 123 || (data[data.length + -1] != (byte) 125));

        if (flag) {
            return null;
        }
        ByteBuffer byteBuf = ByteBuffer.wrap(data);
        byteBuf.position(1);
        return byteBuf;
    }

    private static int getInt(ByteBuffer byteBuf) {
        return byteBuf.getInt();
    }

    private static long getLong(ByteBuffer byteBuf) {
        return byteBuf.getLong();
    }

    private static String getString(ByteBuffer byteBuf) {
        short s = byteBuf.getShort();
        if (s > (short) 2048) {
            return "";
        } else if (s == (short) 0) {
            return "";
        } else {
            byte[] data = new byte[s];
            byteBuf.get(data, 0, s);
            return new String(data, Charset.forName("UTF-8"));
        }
    }

    public static String getTicket(String content) {
        String ticket = "";
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(content.getBytes("UTF-8")));

            NodeList node = document.getElementsByTagName("msg");
            if (node != null && node.getLength() == 1) {
                NamedNodeMap map = node.item(0).getAttributes();
                if (map != null && map.getLength() > 0) {
                    ticket = map.getNamedItem("ticket").getNodeValue();
                    return ticket;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ticket;
    }

    public static ContactInfo convert(String xml) {
        ContactInfo contact = null;

        if (TextUtils.isEmpty(xml)) {
            return null;
        }

        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes("UTF-8")));

            NodeList node = document.getElementsByTagName("msg");
            if (node != null && node.getLength() == 1) {
                NamedNodeMap map = node.item(0).getAttributes();
                if (map != null && map.getLength() > 0) {
                    contact = new ContactInfo();

                    contact.setUsername(map.getNamedItem("fromusername").getNodeValue());
                    contact.setNickname(map.getNamedItem("fromnickname").getNodeValue());
                    contact.setSignature(map.getNamedItem("sign").getNodeValue());
                    contact.setSex(Integer.parseInt(map.getNamedItem("sex").getNodeValue() == null ? "0" : map.getNamedItem("sex").getNodeValue()));
                    contact.setAlias(map.getNamedItem("alias").getNodeValue());
                    contact.setAvatar(map.getNamedItem("smallheadimgurl").getNodeValue());
                    contact.setCity(map.getNamedItem("city").getNodeValue());
                    contact.setProvince(map.getNamedItem("province").getNodeValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contact;
    }

    public static boolean isFriends(int type) {
        boolean flag = false;
        if (type == -1) {
            flag = false;
        }

        if (((type & 1) != 0) && ((type & 8) == 0) && ((type & 32) == 0)) {
            flag = true;
        }
        return flag;
    }

    public static boolean isBlacklist(int type) {
        boolean flag = false;
        if (type == -1) {
            flag = false;
        }

        if ((type & 8) != 0 && (type & 1) != 0 && (type & 32) == 0) {
            flag = true;
        }

        return flag;
    }

    public static boolean isFake(String username) {
        return !TextUtils.isEmpty(username) && username.startsWith("fake_");
    }

    public static boolean isRoom(String username) {
        return !TextUtils.isEmpty(username) && username.endsWith("@chatroom");
    }

    public static boolean isStranger(String username) {
        return !TextUtils.isEmpty(username) && username.endsWith("@stranger");
    }

    public static boolean isNews(String username) {
        return !TextUtils.isEmpty(username) && username.startsWith("gh_");
    }

    public static boolean useless(String username) {

        return (TextUtils.isEmpty(username) ||
                isFake(username) ||
                isStranger(username) ||
                isNews(username));
    }
}
