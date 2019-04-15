package com.developer.jyong.wechatctrlsdk.inject.core.main;

import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;

import com.developer.jyong.wechatctrlsdk.inject.tool.FieldTool;
import com.developer.jyong.wechatctrlsdk.inject.tool.XposedInjectMethodProxy;

public class LauncherInvader extends XposedInjectMethodProxy {

    public final static String CtrlSDK = "CtrlSDK";

    private MenuClickListener listener = null;
    private ClassLoader classLoader;

    public LauncherInvader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public void before(MethodHookParam param) {
        final Activity activity = (Activity) param.thisObject;
        FieldTool.instance().setActivity(activity);

        if (null != activity) {
            listener = new MenuClickListener(classLoader);

            Menu menu = (Menu) param.args[0];
            menu.add(0, 1008611, 0, CtrlSDK);

            menu.add(0, 1008612, 0, "text");
            menu.add(0, 1008613, 0, "image");
            menu.add(0, 1008614, 0, "voice");
            menu.add(0, 1008615, 0, "video");
            menu.add(0, 1008616, 0, "link");
            menu.add(0, 1008617, 0, "card");
            menu.add(0, 1008618, 0, "snsTxt");
            menu.add(0, 1008619, 0, "snsImg");
            menu.add(0, 1008620, 0, "snsVideo");
            menu.add(0, 1008621, 0, "createtRoom");
            menu.add(0, 1008622, 0, "addMember");
            menu.add(0, 1008623, 0, "@all");
            menu.add(0, 1008624, 0, "exitRoom");
            menu.add(0, 1008625, 0, "removeMember");
            menu.add(0, 1008626, 0, "amendRoomName");
            menu.add(0, 1008627, 0, "agreeFriends");
            menu.add(0, 1008628, 0, "subscriptionCard");
            menu.add(0, 1008629, 0, "amendRemark");
            menu.add(0, 1008630, 0, "remittance");
            menu.add(0, 1008631, 0, "delContacts");
            menu.add(0, 1008632, 0, "atSomebody");


            for (int i = 0; i < menu.size(); i++) {
                MenuItem item = menu.getItem(i);
                switch (item.getTitle().toString()) {
                    case CtrlSDK:
                    case "text":
                    case "image":
                    case "voice":
                    case "video":
                    case "link":
                    case "card":
                    case "snsTxt":
                    case "snsImg":
                    case "snsVideo":
                    case "createtRoom":
                    case "addMember":
                    case "@all":
                    case "exitRoom":
                    case "removeMember":
                    case "amendRoomName":
                    case "agreeFriends":
                    case "subscriptionCard":
                    case "amendRemark":
                    case "remittance":
                    case "delContacts":
                    case "atSomebody":
                        item.setOnMenuItemClickListener(listener);
                        break;
                }
            }

        }
    }

    @Override
    public void after(MethodHookParam param) {

    }


}
