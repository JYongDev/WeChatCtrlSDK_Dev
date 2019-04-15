package com.developer.jyong.wechatctrlsdk.inject.tool;


import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileTool {

    public static void disable(String path) {
        if (TextUtils.isEmpty(path)) {
            return;
        }

        File file = new File(path);

        if (file == null) {
            return;
        }

        if (file.exists()) {
            file.setReadable(false);
            file.setWritable(false);
            file.setExecutable(false);
        }

    }

    public static boolean copy(String srcPath, String destPath) {
        boolean flag = false;

        if (TextUtils.isEmpty(srcPath)) {
            return flag;
        }

        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //  创建复制的文件
            destFile.createNewFile();

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            byte[] data = new byte[2048];
            int len;
            while ((len = fis.read(data, 0, data.length)) != -1) {
                fos.write(data, 0, len);
                fos.flush();
            }

            fis.close();
            fos.close();
            //  复制完成
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}
