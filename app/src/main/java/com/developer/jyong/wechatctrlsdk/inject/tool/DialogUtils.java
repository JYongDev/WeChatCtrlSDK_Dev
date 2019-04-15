package com.developer.jyong.wechatctrlsdk.inject.tool;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class DialogUtils {

    public DialogUtils() {
    }

    public View menuView(Context context) {
        DpPxSpTransformUtil.init(context.getResources().getDisplayMetrics().density);

        RelativeLayout parentView = new RelativeLayout(context);
        LinearLayout container = new LinearLayout(context);

        TextView versionTextView = new TextView(context);
        versionTextView.setText("version : " + String.valueOf("1111"));
        versionTextView.setTextColor(Color.GRAY);
        versionTextView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        versionTextView.setTextSize(13);
        versionTextView.setSingleLine();
        versionTextView.setBackgroundColor(Color.WHITE);
        LinearLayout.LayoutParams versionParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DpPxSpTransformUtil.dip2px(20));
        container.addView(versionTextView, versionParams);

        TextView infoTextView = new TextView(context);
        infoTextView.setText("微信信息");
        infoTextView.setTextColor(Color.BLACK);
        infoTextView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        infoTextView.setTextSize(15);
        infoTextView.setTag("infoTextView");
        infoTextView.setSingleLine();
        infoTextView.setBackgroundColor(Color.WHITE);
        LinearLayout.LayoutParams infoParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DpPxSpTransformUtil.dip2px(40));
        infoParams.setMargins(0, DpPxSpTransformUtil.dip2px(10), 0, 0);
        container.addView(infoTextView, infoParams);

        TextView updateTextView = new TextView(context);
        updateTextView.setText("更新");
        updateTextView.setTextColor(Color.BLACK);
        updateTextView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        updateTextView.setTextSize(15);
        updateTextView.setTag("updateTextView");
        updateTextView.setSingleLine();
        updateTextView.setBackgroundColor(Color.WHITE);
        LinearLayout.LayoutParams updateParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DpPxSpTransformUtil.dip2px(40));
        updateParams.setMargins(0, DpPxSpTransformUtil.dip2px(10), 0, 0);
        container.addView(updateTextView, updateParams);

        container.setPadding(DpPxSpTransformUtil.dip2px(20), DpPxSpTransformUtil.dip2px(10), DpPxSpTransformUtil.dip2px(20), DpPxSpTransformUtil.dip2px(10));
        container.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout.LayoutParams containerParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        container.setBackgroundColor(Color.WHITE);
        parentView.addView(container, containerParams);

        return parentView;
    }

    public View loginView(Context context) {
        DpPxSpTransformUtil.init(context.getResources().getDisplayMetrics().density);

        RelativeLayout parentView = new RelativeLayout(context);
        LinearLayout container = new LinearLayout(context);

        TextView titleTextView = new TextView(context);
        titleTextView.setText("login...");
        titleTextView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        titleTextView.setTextSize(13);
        titleTextView.setTextColor(Color.GRAY);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DpPxSpTransformUtil.dip2px(20));
        titleParams.setMargins(0, DpPxSpTransformUtil.dip2px(10), 0, 0);
        container.addView(titleTextView, titleParams);

        EditText userEdit = new EditText(context);
        userEdit.setBackgroundColor(Color.WHITE);
        userEdit.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        userEdit.setHint("imgId");
        userEdit.setHintTextColor(Color.GRAY);
        userEdit.setTextSize(15);
        userEdit.setTag("usernameEdit");
        userEdit.setSingleLine(true);
        userEdit.setTextColor(Color.BLACK);
        LinearLayout.LayoutParams userEditParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DpPxSpTransformUtil.dip2px(40));
        userEditParams.setMargins(0, DpPxSpTransformUtil.dip2px(5), 0, 0);
        container.addView(userEdit, userEditParams);

        EditText passwordEdit = new EditText(context);
        passwordEdit.setBackgroundColor(Color.WHITE);
        passwordEdit.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        passwordEdit.setHint("msgId");
        passwordEdit.setHintTextColor(Color.GRAY);
        passwordEdit.setSingleLine(true);
        passwordEdit.setTextSize(15);
        passwordEdit.setTag("passwordEdit");
        passwordEdit.setInputType(EditorInfo.TYPE_TEXT_VARIATION_PASSWORD);
        passwordEdit.setTextColor(Color.BLACK);
        LinearLayout.LayoutParams passwordEditParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DpPxSpTransformUtil.dip2px(40));
        passwordEditParams.setMargins(0, DpPxSpTransformUtil.dip2px(5), 0, 0);
        container.addView(passwordEdit, passwordEditParams);

        RelativeLayout btnWrapper = new RelativeLayout(context);
        LinearLayout.LayoutParams btnWrapperParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        btnWrapper.setPadding(0, 0, DpPxSpTransformUtil.dip2px(5), 0);
        btnWrapper.setBackgroundColor(Color.WHITE);
        btnWrapperParams.setMargins(0, DpPxSpTransformUtil.dip2px(5), 0, 0);
        container.addView(btnWrapper, btnWrapperParams);

        Button ensureBtn = new Button(context);
        RelativeLayout.LayoutParams ensureBtnParams = new RelativeLayout.LayoutParams(DpPxSpTransformUtil.dip2px(45), DpPxSpTransformUtil.dip2px(35));
        ensureBtn.setTag("ensureBtn");
        ensureBtn.setGravity(Gravity.CENTER);
        ensureBtn.setText("OK");
        ensureBtn.setTextColor(Color.BLACK);
        ensureBtn.setTextSize(13);
        ensureBtn.setBackgroundColor(Color.WHITE);
        ensureBtnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        btnWrapper.addView(ensureBtn, ensureBtnParams);

        container.setBackgroundColor(Color.WHITE);
        container.setPadding(DpPxSpTransformUtil.dip2px(20), DpPxSpTransformUtil.dip2px(10), DpPxSpTransformUtil.dip2px(20), DpPxSpTransformUtil.dip2px(10));
        container.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout.LayoutParams containerParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        parentView.addView(container, containerParams);

        return parentView;
    }

    public View loginViewForToken(Context context) {
        DpPxSpTransformUtil.init(context.getResources().getDisplayMetrics().density);

        RelativeLayout parentView = new RelativeLayout(context);
        LinearLayout container = new LinearLayout(context);

        TextView titleTextView = new TextView(context);
        titleTextView.setText("login...");
        titleTextView.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        titleTextView.setTextSize(13);
        titleTextView.setTextColor(Color.GRAY);
        LinearLayout.LayoutParams titleParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DpPxSpTransformUtil.dip2px(20));
        titleParams.setMargins(0, DpPxSpTransformUtil.dip2px(5), 0, 0);
        container.addView(titleTextView, titleParams);

        TextView userEdit = new TextView(context);
        userEdit.setBackgroundColor(Color.WHITE);
        userEdit.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);
        userEdit.setText("login system ?");
        userEdit.setTextSize(15);
        userEdit.setTag("usernameText");
        userEdit.setSingleLine(true);
        userEdit.setTextColor(Color.BLACK);
        LinearLayout.LayoutParams userEditParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, DpPxSpTransformUtil.dip2px(40));
        userEditParams.setMargins(0, DpPxSpTransformUtil.dip2px(5), 0, 0);
        container.addView(userEdit, userEditParams);

        RelativeLayout btnWrapper = new RelativeLayout(context);
        LinearLayout.LayoutParams btnWrapperParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        btnWrapper.setPadding(0, 0, DpPxSpTransformUtil.dip2px(5), 0);
        btnWrapper.setBackgroundColor(Color.WHITE);
        btnWrapperParams.setMargins(0, DpPxSpTransformUtil.dip2px(5), 0, 0);
        container.addView(btnWrapper, btnWrapperParams);

        Button ensureBtn = new Button(context);
        RelativeLayout.LayoutParams ensureBtnParams = new RelativeLayout.LayoutParams(DpPxSpTransformUtil.dip2px(45), DpPxSpTransformUtil.dip2px(35));
        ensureBtn.setTag("ensureBtn");
        ensureBtn.setGravity(Gravity.CENTER);
        ensureBtn.setText("OK");
        ensureBtn.setTextColor(Color.BLACK);
        ensureBtn.setTextSize(13);
        ensureBtn.setBackgroundColor(Color.WHITE);
        ensureBtnParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        btnWrapper.addView(ensureBtn, ensureBtnParams);

        container.setBackgroundColor(Color.WHITE);
        container.setPadding(DpPxSpTransformUtil.dip2px(20), 0, DpPxSpTransformUtil.dip2px(20), 0);
        container.setOrientation(LinearLayout.VERTICAL);
        RelativeLayout.LayoutParams containerParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        containerParams.setMargins(0, DpPxSpTransformUtil.dip2px(10), 0, DpPxSpTransformUtil.dip2px(10));
        parentView.addView(container, containerParams);

        return parentView;
    }
}
