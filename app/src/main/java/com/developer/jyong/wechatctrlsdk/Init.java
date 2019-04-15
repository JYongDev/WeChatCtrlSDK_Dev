package com.developer.jyong.wechatctrlsdk;


import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONObject;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;


public class Init implements IXposedHookLoadPackage {

    private static BlockingQueue<Object> queue = new LinkedBlockingQueue<>();
    private static ExecutorService executor = Executors.newSingleThreadExecutor();
    private static MessageRunner runner = null;

    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lparam) throws Throwable {


        if (lparam.packageName.equals("com.tencent.mm")) {

            String appPkgName = "com.developer.jyong.wechatctrlsdk";

            final ClassLoader ctrl = CtrlSDK.init(appPkgName, lparam);
            CtrlSDK.listen(ctrl, queue);

            if (runner == null) {
                runner = new MessageRunner(queue, ctrl, lparam.classLoader);
                executor.execute(runner);
                Log.w("CtrlSDK", "handleLoadPackage: set queue ");
            }

            XposedHelpers.findAndHookMethod("com.tencent.mm.ui.LauncherUI",
                    lparam.classLoader,
                    "onCreateOptionsMenu",
                    Menu.class,
                    new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(final MethodHookParam param) throws Throwable {
                            super.afterHookedMethod(param);
                            Menu menu = (Menu) param.args[0];

                            menu.add(0, 123123123, 0, "test");

                            for (int i = 0; i < menu.size(); i++) {
                                if (menu.getItem(i).getTitle().equals("test")) {
                                    menu.getItem(i).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                                        @Override
                                        public boolean onMenuItemClick(MenuItem item) {

                                            try {
                                                CtrlSDK.sendText("HJY894199032", "HHE", ctrl, lparam.classLoader);
//                                                List<String> list = new ArrayList<String>();
//                                                list.add("HJY894199032");
//                                                list.add("wxid_34303t9wzkbm21");
//                                                list.add("wxid_owhdh9f0taut22");
//
//                                                CtrlSDK.roomCreate(list, "haha", ctrl, lparam.classLoader);

                                            } catch (Throwable e) {
                                                e.printStackTrace();
                                                Log.w("CtrlSDK", "onMenuItemClick: e " + e.getMessage());
                                            }
                                            return false;
                                        }
                                    });
                                }
                            }
                        }
                    });
        }
    }

    private static class MessageRunner implements Runnable {

        private BlockingQueue queue = null;
        private ClassLoader ctrl = null;
        private ClassLoader loader = null;

        public MessageRunner(BlockingQueue queue, ClassLoader ctrl, ClassLoader loader) {
            this.queue = queue;
            this.ctrl = ctrl;
            this.loader = loader;
        }

        @Override
        public void run() {

            while (true) {
                try {
                    Object obj = this.queue.take();
                    if (obj != null) {
                        Log.w("CtrlSDK", "run: data is : " + obj.toString());
                        try {
                            JSONObject object = (JSONObject) obj;
                            Log.w("CtrlSDK", "run: objet.toString " + object.toString());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.w("CtrlSDK", "MessageRunner run: e.getMessage" + e.getMessage());
                }
            }
        }

        public void test(String... str) {

        }
    }
}
