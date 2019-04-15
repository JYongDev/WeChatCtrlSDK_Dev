package com.developer.jyong.wechatctrlsdk.inject.core.message;

import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class MediaTool {

    private static final String SDCARD_PATH = Environment.getExternalStorageDirectory().getPath() + File.separator;
    private static final String APP_PATH = SDCARD_PATH + "wechatctrlsdk" + File.separator;
    private static final String JPG_SUFFIX = ".jpg";
    private static final String MP4_SUFFIX = ".mp4";

    public static String saveImg2SDCard(Bitmap bitmap, String imgName) {

        if (bitmap == null || TextUtils.isEmpty(imgName)) {
            return "";
        }

        String path = APP_PATH + imgName + JPG_SUFFIX;

        try {

            File fileDir = new File(APP_PATH);
            if (!fileDir.exists()) {
                fileDir.mkdir();
            }

            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }

            FileOutputStream fos = new FileOutputStream(file);

            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);

            fos.flush();
            fos.close();

            return path;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

    public static String getVideoThumbImgPath(String videoPath) {
        String thumbImgPath = "";

        if (TextUtils.isEmpty(videoPath)) {
            return thumbImgPath;
        }

        Bitmap bitmap = ThumbnailUtils.createVideoThumbnail(videoPath, ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        thumbImgPath = saveImg2SDCard(bitmap, getVideoName(videoPath));
        return thumbImgPath;
    }

    private static String getVideoName(String videoPath) {
        if (TextUtils.isEmpty(videoPath)) {
            return "";
        }

        String path = "";
        String arr[] = videoPath.split(File.separator);

        if (arr != null && arr.length > 0) {
            path = (arr[arr.length - 1].endsWith(MP4_SUFFIX)) ? arr[arr.length - 1] : "";
        }
        return path.replace(MP4_SUFFIX, "");
    }

    public static File modifyVoiceFile(String origin, String target) {

        if (TextUtils.isEmpty(origin) || TextUtils.isEmpty(target)) {
            return null;
        }

        File targetFile = null;

        try {
            targetFile = new File(target);
            File originFile = new File(origin);

            FileInputStream fis = new FileInputStream(originFile);
            FileOutputStream fos = new FileOutputStream(targetFile);

            int len;
            byte[] buff = new byte[1024];

            while ((len = fis.read(buff, 0, buff.length)) != -1) {
                fos.write(buff, 0, len);
                fos.flush();
            }

            fis.close();
            fos.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return targetFile;
    }

}
