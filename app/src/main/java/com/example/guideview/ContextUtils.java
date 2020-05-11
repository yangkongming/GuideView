package com.example.guideview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;

import androidx.annotation.NonNull;

/**
 * 常用工具类,获取Context
 */
public final class ContextUtils {

    @SuppressLint("StaticFieldLeak")
    private static Context context;
    /**
     * 字体图标
     */
    private static Typeface iconFontTypeFace;
    private static Typeface numberTypeFace;

    private ContextUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param context 上下文
     */
    public static void init(@NonNull final Context context) {
        ContextUtils.context = context.getApplicationContext();
    }

    /**
     * 获取ApplicationContext
     *
     * @return ApplicationContext
     */
    public static Context getContext() {
        if (context != null) {
            return context;
        }
        throw new NullPointerException("should be initialized in application");
    }

    public static void initIconFontTypeFace(Typeface iconFontTypeFace) {
        ContextUtils.iconFontTypeFace = iconFontTypeFace;
    }

    public static void initNumberTypeFace(Typeface numberTypeFace) {
        ContextUtils.numberTypeFace = numberTypeFace;
    }

    public static Typeface getIconFontTypeFace() {
        return iconFontTypeFace;
    }

    public static Typeface getNumberTypeFace() {
        return numberTypeFace;
    }
}