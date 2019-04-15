package com.developer.jyong.wechatctrlsdk.inject.tool;

import android.text.TextUtils;

import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {

    /**
     * get file md5 String
     *
     * @param file file
     * @return md5 String
     */
    public static String getFileMD5(File file) {
        if (file == null || !file.exists() || !file.isFile()) {
            return "";
        }
        MessageDigest digest = null;
        byte buffer[] = new byte[1024];
        int len;
        try {
            digest = MessageDigest.getInstance("MD5");
            FileInputStream in = new FileInputStream(file);
            while ((len = in.read(buffer, 0, 1024)) != -1) {
                digest.update(buffer, 0, len);
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        String result = toHex(digest.digest());
        return !TextUtils.isEmpty(result) ? result : "";
    }

    private static String toHex(byte[] buffer) {
        StringBuilder sb = new StringBuilder(buffer.length * 2);
        for (byte aBuffer : buffer) {
            sb.append(Character.forDigit((aBuffer & 240) >> 4, 16));
            sb.append(Character.forDigit(aBuffer & 15, 16));
        }
        return sb.toString();
    }

    /**
     * 获取32位加密MD5
     *
     * @param str
     * @return String
     */
    public static String get32MD5Value(String str) {
        StringBuilder buf = new StringBuilder();
        try {
            MessageDigest bmd5 = MessageDigest.getInstance("MD5");
            bmd5.update(str.getBytes());
            int i;

            byte[] b = bmd5.digest();
            for (byte aB : b) {
                i = aB;
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buf.toString();
    }


    public static String get32MD5VallueCaps(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (byte byte0 : md) {
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取16位加密MD5
     *
     * @param str
     * @return string
     */
    public static String get16MD5Value(String str) throws NoSuchAlgorithmException {
        String result = get32MD5Value(str);
        if (result == null) {
            return result;
        }
        return result.substring(8, 16);
    }

}
