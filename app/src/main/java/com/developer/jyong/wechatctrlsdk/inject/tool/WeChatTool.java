package com.developer.jyong.wechatctrlsdk.inject.tool;

import android.content.Context;
import android.content.pm.PackageManager;

import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import java.io.File;

import javax.xml.parsers.DocumentBuilderFactory;

import de.robv.android.xposed.XposedHelpers;

import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;


public class WeChatTool {

    private final static String WECHAT_PACKAGE_NAME = "com.tencent.mm";

    public static String currentWX(Context context) {
        String loginWXID = "";
        if (null != context)
            loginWXID = context.getSharedPreferences("notify_key_pref_no_account", Context.MODE_PRIVATE).getString("login_weixin_username", "");
        return loginWXID;
    }

    public static int currentUin(Context context) {
        int uinCode = 0;
        if (null != context) {
            uinCode = context.getSharedPreferences("system_config_prefs", Context.MODE_PRIVATE).getInt("default_uin", 0);

            if (uinCode == 0) {
                uinCode = Integer.parseInt(getUin());
            }
        }

        return uinCode;
    }

    public static void disableTinker() {
        FileTool.disable("/data/data/com.tencent.mm/tinker");
        FileTool.disable("/data/data/com.tencent.mm/tinker_temp");
    }

    private static String getUin() {
        String uin = "0";
        try {

            File file = new File("/data/data/com.tencent.mm/shared_prefs/auth_info_key_prefs.xml");

            if (file == null || !file.exists()) {
                return uin;
            }

            Element documentElement = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getDocumentElement();

            NodeList nodeList = documentElement.getChildNodes();

            if (nodeList != null && nodeList.getLength() > 0) {

                for (int n = 0; n < nodeList.getLength(); n++) {

                    if (nodeList.item(n).getNodeName().equals("int")) {

                        NamedNodeMap map = nodeList.item(n).getAttributes();

                        if (map != null) {
                            if (map.getNamedItem("name").getNodeValue().equals("_auth_uin")) {
                                uin = map.getNamedItem("value").getNodeValue();
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uin;
    }

    public static String getVersion() {

        String version = "";

        try {

            Context wxContext = getWXContext();

            if (wxContext != null) {
                version = wxContext.getPackageManager().getPackageInfo(WECHAT_PACKAGE_NAME, 0).versionName;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return version;
    }

    public static Context getContext() {
        return (Context) callMethod(callStaticMethod(XposedHelpers.findClass("android.app.ActivityThread", null), "currentActivityThread", new Object[0]), "getSystemContext", new Object[0]);
    }

    public static Context getWXContext() {

        Context context = getContext();

        if (context == null) {
            return null;
        }

        Context wxContext = null;
        try {
            wxContext = context.createPackageContext(WECHAT_PACKAGE_NAME, Context.MODE_PRIVATE);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return wxContext;
    }

}
