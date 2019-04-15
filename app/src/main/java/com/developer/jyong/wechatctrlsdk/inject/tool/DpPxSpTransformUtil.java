package com.developer.jyong.wechatctrlsdk.inject.tool;


public class DpPxSpTransformUtil {
    private static float scale;

    /**
     * 初始化获得屏幕密度
     *
     * @return 屏幕密度
     */
    public static void init(float scale) {
        DpPxSpTransformUtil.scale = scale;
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(float dpValue) {
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(float pxValue) {
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @return
     */
    public static int px2sp(float pxValue) {
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @return
     */
    public static int sp2px(float spValue) {
        return (int) (spValue * scale + 0.5f);
    }
}
