package com.developer.jyong.wechatctrlsdk;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    private String TAG = "CtrlSDK";
    private String encrypt;

    static {
        System.loadLibrary("WeChatCtrlSDK");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.decrypt).setOnClickListener(this);
        findViewById(R.id.encrypt).setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.encrypt:
                CtrlSDK.encrypt();
                break;
            case R.id.decrypt:
                try {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {

                        }
                    }).start();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.w(TAG, "onClick: e.getMessage() " + e.getMessage());
                }
                break;

        }
    }
}
