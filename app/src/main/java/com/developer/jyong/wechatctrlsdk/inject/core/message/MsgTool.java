package com.developer.jyong.wechatctrlsdk.inject.core.message;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.developer.jyong.wechatctrlsdk.inject.info.ContactInfo;
import com.developer.jyong.wechatctrlsdk.inject.info.LinkInfo;
import com.developer.jyong.wechatctrlsdk.inject.tool.FileTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.MD5Utils;
import com.developer.jyong.wechatctrlsdk.inject.tool.WeChatTool;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;

public class MsgTool {

    static String getOwnerChangedTips(String xml) {
        return SysMsgEntity.toEntity(xml).getTemplateStr();
    }

    static String getMemberRemoveTips(String xml) {
        return SysMsgEntity.toEntity(xml).getTemplateStr();
    }

    static boolean isRemoveMemberByMe(String content) {
        boolean flag = false;

        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("你将") && content.contains("移出了群聊")) {
            flag = true;
        }
        return flag;
    }

    static boolean isMeJoinRoomByScan(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }
        if (content.contains("你通过扫描二维码加入群聊")) {
            flag = true;
        }
        return flag;
    }

    static boolean joinRoomByScan(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("通过扫描") && content.contains("加入群聊")) {
            flag = true;
        }
        return flag;
    }

    static String getJoinRoomsTips(String xml) {
        return SysMsgEntity.toEntity(xml).getTemplateStr();
    }

    static boolean joinRoomByInvited(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }
        if (content.contains("邀请") && content.contains("加入了群聊")) {
            flag = true;
        }
        return flag;
    }

    static String getNameChangedTips(String xml) {
        return SysMsgEntity.toEntity(xml).getTemplateStr();
    }

    static boolean isAcceptRedPkg(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("红包") && content.contains("领取了")) {
            flag = true;
        }
        return flag;
    }

    /**
     * is it room owner is me ?
     *
     * @param content message
     * @return result
     */
     static boolean roomOwnerIsMe(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("你已成为新群主")) {
            flag = true;
        }
        return flag;
    }


    /**
     * is it system tips about change room owner
     *
     * @param content message
     * @return result
     */
     static boolean isRoomdOwnerChanged(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("已成为新群主")) {
            flag = true;
        }

        return flag;
    }


    /**
     * is it delete room member by me (sdk user)?
     *
     * @param content message
     * @return result
     */
    public static boolean isDelRoomMemberByMe(String content) {
        boolean flag = false;

        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("移出了群聊")) {
            flag = true;
        }
        return flag;
    }

    /**
     * is it system tips about delete room member ?
     *
     * @param content message
     * @return result
     */
    public static boolean isRemoveMember(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("移出了群聊") ||
                content.contains("移出群聊")) {
            flag = true;
        }
        return flag;
    }

    /**
     * get newcomer wxid when join to room
     *
     * @param content message
     * @return result
     */
    public static String getNewcomerWXID(String content) {
        String keyWXID = "";

        if (TextUtils.isEmpty(content)) {
            return "";
        }

        if (content.contains("邀请")) {
            String arr[] = content.split("name=\"names\"");
            if (arr != null && arr.length == 2) {
                keyWXID = getRoomStatusAmender(arr[arr.length - 1]);
            }
        } else {
            keyWXID = getRoomStatusAmender(content);
        }

        return keyWXID;
    }


    /**
     * is it invite me(sdk user) to join room ?
     *
     * @param content message
     * @return result
     */
    public static boolean isInviteMeToRoom(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("邀请你加入了群聊")) {
            flag = true;
        }
        return flag;
    }

    /**
     * is it system tips about join room ?
     *
     * @param content message
     * @return result
     */
    public static boolean isJoinToRoom(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("加入了群聊") ||
                content.contains("加入群聊")) {
            flag = true;
        }
        return flag;
    }


    /**
     * is it system tips about amend room name ?
     *
     * @param content message
     * @return result
     */
    public static boolean isRoomsNameChanged(String content) {
        return !TextUtils.isEmpty(content) && content.contains("修改群名为");
    }

    /**
     * is it change room name by me (sdk user) ?
     *
     * @param content message
     * @return result
     */
    public static boolean isNameChangeByMe(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }
        if (content.contains("你修改群名为")) {
            flag = true;
        }
        return flag;
    }

    /**
     * get new room name
     *
     * @param content message
     * @return result new room name
     */
    public static String getNewRoomName(String content) {
        String keyWord = "";
        if (TextUtils.isEmpty(content)) {
            return "";
        }

        String regex = "<plain><!\\[CDATA\\[([\\w\\S\\u4e00-\\u9fa5]*)\\]\\]><\\/plain>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                String targetStr = matcher.group(0);
                String keyStr = matcher.group(1);
                if (!TextUtils.isEmpty(targetStr) &&
                        !TextUtils.isEmpty(keyStr) &&
                        targetStr.contains(keyStr)) {
                    keyWord = keyStr;
                }
            }
        }
        return keyWord;
    }

    /**
     * 根据消息内容，获取群聊中改变群信息用户的 wxid
     *
     * @param content 消息内容
     * @return result 目标用户wxid
     */
    public static String getRoomStatusAmender(String content) {
        String keyWord = "";

        if (TextUtils.isEmpty(content)) {
            return "";
        }

        String regex = "<username><!\\[CDATA\\[(\\w*)\\]\\]><\\/username>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            try {
                String targetStr = matcher.group(0);
                String keyStr = matcher.group(1);

                if (!TextUtils.isEmpty(targetStr) && !TextUtils.isEmpty(keyStr) &&
                        targetStr.contains(keyStr)) {
                    keyWord = keyStr;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return keyWord;
    }

    /**
     * 判断是否已经被拉入黑名单
     *
     * @param content 消息内容
     * @return result
     */
    public static boolean isBlacklist(String content) {
        boolean flag = false;

        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("消息已发出，但被对方拒收了")) {
            flag = true;
        }
        return flag;
    }

    public static boolean isGreet(String content) {
        boolean flag = false;
        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("以上是打招呼的内容")) {
            flag = true;
        }
        return flag;
    }

    /**
     * 判断是否被删除好友
     *
     * @param content 消息内容
     * @return result
     */
    public static boolean isRemoveFriends(String content) {
        boolean flag = false;

        if (TextUtils.isEmpty(content)) {
            flag = false;
        }
        if (content.contains("开启了朋友验证") &&
                content.contains("你还不是他（她）朋友。请先发送朋友验证请求")) {
            flag = true;
        }
        return flag;
    }

    public static boolean isAgree(String content) {
        boolean flag = false;

        if (TextUtils.isEmpty(content)) {
            flag = false;
        }

        if (content.contains("你已添加了") &&
                content.contains("现在可以开始聊天了")) {
            flag = true;
        }
        return flag;
    }

    public static boolean isRevoke(String content) {

        if (TextUtils.isEmpty(content)) {
            return false;
        }

        return content.contains("撤回了一条消息") &&
                !content.contains("重新编辑");
    }

    /**
     * 解析名片消息
     *
     * @param xml 消息内容
     * @return 名片关键信息
     */
    public static JSONObject convertCardXML(String xml) {


        if (TextUtils.isEmpty(xml))
            return null;
        JSONObject object = new JSONObject();
        try {

            InputStream in = new ByteArrayInputStream(xml.getBytes("UTF-8"));
            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in).getDocumentElement();

            String username = documentElement.getAttribute(ContactInfo.WX_RCONTACT_COLUMNNAME_USERNAME);
            String nickname = documentElement.getAttribute(ContactInfo.WX_RCONTACT_COLUMNNAME_NICKNAME);
            String alias = documentElement.getAttribute(ContactInfo.WX_RCONTACT_COLUMNNAME_ALIAS);
            String province = documentElement.getAttribute(ContactInfo.WX_PROVINCE);
            String city = documentElement.getAttribute(ContactInfo.WX_CITY);
            String sex = documentElement.getAttribute(ContactInfo.WX_SEX);
            String avatar = documentElement.getAttribute("bigheadimgurl");

            object.put(ContactInfo.WX_RCONTACT_COLUMNNAME_USERNAME, TextUtils.isEmpty(username) ? "" : username);
            object.put(ContactInfo.WX_RCONTACT_COLUMNNAME_NICKNAME, TextUtils.isEmpty(nickname) ? "" : nickname);
            object.put(ContactInfo.WX_RCONTACT_COLUMNNAME_ALIAS, TextUtils.isEmpty(alias) ? "" : alias);
            object.put(ContactInfo.WX_PROVINCE, TextUtils.isEmpty(province) ? "" : province);
            object.put(ContactInfo.WX_CITY, TextUtils.isEmpty(city) ? "" : city);
            object.put(ContactInfo.WX_SEX, TextUtils.isEmpty(sex) ? "" : sex);
            object.put(ContactInfo.WX_AVATAR, TextUtils.isEmpty(avatar) ? "" : avatar);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 获取链接内容
     *
     * @param content 消息内容
     * @return 链接关键内容
     */
    private static LinkInfo getLinkContent(String content) {
        LinkInfo link = null;
        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(content.getBytes("UTF-8")));

            NodeList node = document.getElementsByTagName("msg");
            if (node != null && node.getLength() > 0) {
                NodeList appMsgNode = node.item(0).getChildNodes();
                if (appMsgNode != null && appMsgNode.getLength() > 0) {
                    NodeList childNode = appMsgNode.item(0).getChildNodes();
                    if (childNode != null) {
                        link = new LinkInfo();
                        for (int j = 0; j < childNode.getLength(); j++) {
                            if (childNode.item(j).getNodeName().equals("title")) {
                                link.setTitle(childNode.item(j).getTextContent());
                            } else if (childNode.item(j).getNodeName().equals("url")) {
                                link.setUrl(childNode.item(j).getTextContent());
                            }
                            if (!TextUtils.isEmpty(link.getTitle()) && !TextUtils.isEmpty(link.getUrl())) {
                                return link;
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return link;
    }

    /**
     * 获取链接消息 的 title 和 url
     *
     * @param content 消息内容
     * @return 链接关键内容(title, url)
     */
    public static LinkInfo getMsgLinkContent(String content) {

        if (TextUtils.isEmpty(content))
            return null;

        return getLinkContent(content);
    }


    /**
     * 获取转账消息的描述
     *
     * @param data
     * @return
     */
    public static String getDescFromWallet(String data) {
        String result = "";
        try {
            InputStream in = new ByteArrayInputStream(data.getBytes("UTF-8"));
            NodeList nodelist = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in).getDocumentElement().getChildNodes();

            HashMap<String, String> map = getKeyValue("des", getKeyNodeList("appmsg", nodelist));
            if (null != map)
                result = map.get("des");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static String remittanceTips(String type, int isSend) {
        String flag = "";

        String SEND_REMITTANCE = "发起转账";
        String RECEIVE_REMITTANCE = "收到转账";
        String RETURN_REMITTANCE = "退回转账";

        switch (isSend) {
            case 1:    // message send by salesman
                if (type.equals("1")) {
                    // money belong to salesman 发起转账
                    flag = SEND_REMITTANCE;
                } else if (type.equals("3")) {
                    // money belong to customer 收到转账
                    flag = RECEIVE_REMITTANCE;
                } else if (type.equals("4")) {
                    // return money 退回转账
                    flag = RETURN_REMITTANCE;
                }
                break;
            case 0:     // message send by customer
                if (type.equals("5") || type.equals("3")) {
                    // money belong to salesman 收到转账
                    flag = RECEIVE_REMITTANCE;
                } else if (type.equals("1")) {
                    // money belong to customer 发起转账
                    flag = SEND_REMITTANCE;
                } else if (type.equals("4")) {
                    // return money 退回转账
                    flag = RETURN_REMITTANCE;
                }
                break;
        }
        return flag;
    }

    /**
     * 判断当前转账消息是否由
     * 当前登录的微信发送的
     *
     * @param type   转账状态
     * @param isSend 消息发送方
     * @return
     */
    public static int isRemitter(String type, int isSend) {
        int flag = -1;

        switch (isSend) {
            case 1:
                if (type.equals("1")) {
                    flag = 1;
                } else if (type.equals("3")) {
                    flag = 0;
                } else if (type.equals("4")) {
                    flag = 0;
                }
                break;
            case 0:
                if (type.equals("5") || type.equals("3")) {
                    flag = 1;
                } else if (type.equals("1")) {
                    flag = 0;
                } else if (type.equals("4")) {
                    flag = 1;
                }
                break;
        }
        return flag;
    }

    /**
     * 获取该红包的唯一id
     *
     * @param data 消息内容
     * @return 红包唯一id
     */
    public static String getIDOfRedPacket(String data) {
        String result = "";

        if (TextUtils.isEmpty(data))
            return "";

        try {
            InputStream in = new ByteArrayInputStream(data.getBytes("UTF-8"));
            NodeList nodelist = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(in).getDocumentElement().getChildNodes();

            HashMap<String, String> map = getKeyValue("paymsgid", getKeyNodeList("wcpayinfo", getKeyNodeList("appmsg", nodelist)));
            if (null != map)
                result = map.get("paymsgid");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static NodeList getKeyNodeList(String targetNodeName, NodeList nodeList) {
        NodeList nodes = null;
        if (TextUtils.isEmpty(targetNodeName)) return null;
        if (null == nodeList) return null;

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals(targetNodeName)) {
                nodes = nodeList.item(i).getChildNodes();
            }
        }
        return nodes;
    }

    private static HashMap<String, String> getKeyValue(String targetNodeName, NodeList nodeList) {

        if (TextUtils.isEmpty(targetNodeName)) return null;
        if (null == nodeList) return null;

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < nodeList.getLength(); i++) {
            if (nodeList.item(i).getNodeName().equals(targetNodeName)) {
                map.put(nodeList.item(i).getNodeName(), nodeList.item(i).getTextContent());
            }
        }
        return map;
    }

    private static String getResourceDir(Context context) {
        String path = "";
        String root = Environment.getExternalStorageDirectory().getPath() + File.separator;
        String tencentDir = root + "tencent" + File.separator;
        String microMsgDir = tencentDir + "MicroMsg" + File.separator;
        String currentDir = currentDir(context);
        if (TextUtils.isEmpty(currentDir)) {
            path = "";
        } else {
            path = microMsgDir + currentDir + File.separator;
        }
        return path;
    }

    private static String getImgeDir(Context context) {
        if (context == null) {
            return "";
        }

        String resourceDir = getResourceDir(context);

        if (TextUtils.isEmpty(resourceDir)) {
            return "";
        }

        return resourceDir + "image2" + File.separator;
    }

    private static String getVideoDir(Context context) {
        if (context == null) {
            return "";
        }

        String resourceDir = getResourceDir(context);

        if (TextUtils.isEmpty(resourceDir)) {
            return "";
        }

        return resourceDir + "video" + File.separator;
    }

    private static String getVoiceDir(Context context) {
        if (context == null) {
            return "";
        }

        String resourceDir = getResourceDir(context);

        if (TextUtils.isEmpty(resourceDir)) {
            return "";
        }
        return resourceDir + "voice2" + File.separator;
    }

    public static String getImagePath(Context context, String name, boolean isHD) {
        if (TextUtils.isEmpty(name) || context == null) {
            return "";
        }
        String path = "";
        String src = "";
        String dest = "";

        String thumbHeader = "THUMBNAIL_DIRPATH://th_";
        if (name.contains(thumbHeader)) {
            name = name.replace(thumbHeader, "");
        }
        if (!TextUtils.isEmpty(name)) {
            String dir1 = name.substring(0, 2);
            String dir2 = name.substring(2, 4);
            String imgDir = getImgeDir(context);
            if (!TextUtils.isEmpty(imgDir)) {
                String imgParentDir = imgDir + dir1 + File.separator + dir2 + File.separator;
                if (isHD) {
                    src = imgParentDir + name;
                    dest = imgParentDir + "hd_" + name;
                } else {
                    src = imgParentDir + "th_" + name;
                    dest = imgParentDir + "thumb_" + name + ".jpg";
                }
            }

            if (TextUtils.isEmpty(src)) {
                return path;
            }
            if (FileTool.copy(src, dest)) {
                path = dest;
            }
        }
        return path;
    }

    public static String getVideoPath(Context context, String name) {
        if (TextUtils.isEmpty(name) || context == null) {
            return "";
        }

        String path = "";
        String videoDir = getVideoDir(context);
        if (!TextUtils.isEmpty(videoDir)) {
            path = videoDir + name + ".mp4";
        }
        if (!new File(path).exists()) {
            path = "";
        }
        return path;
    }

    public static String getVoicePath(Context context, String name) {
        if (TextUtils.isEmpty(name) || context == null) {
            return "";
        }
        String path = "";
        String md5Str = MD5Utils.get32MD5Value(name);
        if (!TextUtils.isEmpty(md5Str)) {
            String dir1 = md5Str.substring(0, 2);
            String dir2 = md5Str.substring(2, 4);
            String voiceDir = getVoiceDir(context);
            if (!TextUtils.isEmpty(voiceDir)) {
                path = voiceDir + dir1 + File.separator + dir2 + File.separator + "msg_" + name + ".amr";
            }
        }
        return path;
    }

    public static String currentDir(Context context) {
        String userDir = "";
        if (context != null) {

            int uin = WeChatTool.currentUin(context);

            if (uin == 0) {
                userDir = "";
            } else {
                userDir = MD5Utils.get32MD5Value("mm" + uin);
            }
        }
        return userDir;
    }

}
