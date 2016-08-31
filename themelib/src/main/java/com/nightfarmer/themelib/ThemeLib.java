package com.nightfarmer.themelib;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.StyleRes;
import android.view.View;
import android.view.ViewGroup;

import com.nightfarmer.themelib.intf.ThemeChangeHandler;
import com.nightfarmer.themelib.intf.ThemeInterface;

/**
 * Created by zhangfan on 16-8-31.
 */
public class ThemeLib implements Application.ActivityLifecycleCallbacks {

    private static ThemeLib instance = new ThemeLib();

    private static int style = -1;

    public static void init(Application application, @StyleRes int defaultStyle) {
        ThemeLib.style = defaultStyle;
        application.registerActivityLifecycleCallbacks(instance);
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (style == -1) {
            throw new IllegalStateException("ThemeLib not init. please write 'ThemeLib.init(...) at onCreate in your application'");
        }
        activity.setTheme(style);
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    /**
     * 设置主题，柔和变更，时间300毫秒
     *
     * @param activity activity
     * @param styleRes 主题资源id
     */
    public static void setThemeSoft(final Activity activity, @StyleRes final int styleRes) {
        setThemeSoft(activity, styleRes, 300);
    }

    /**
     * 设置主题，柔和变更
     *
     * @param activity activity
     * @param styleRes 主题资源id
     * @param delay    变更时间，毫秒
     */
    public static void setThemeSoft(final Activity activity, @StyleRes final int styleRes, long delay) {
        final ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache(true);
        final Bitmap localBitmap = Bitmap.createBitmap(decorView.getDrawingCache());
        decorView.setDrawingCacheEnabled(false);
        if (null != localBitmap) {
            final View localView2 = new View(activity);
            localView2.setBackgroundDrawable(new BitmapDrawable(activity.getResources(), localBitmap));
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            decorView.addView(localView2, params);
            ObjectAnimator animator = ObjectAnimator.ofFloat(localView2, "alpha", 1, 0);
            animator.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    setTheme(activity, styleRes);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    decorView.removeView(localView2);
                    localBitmap.recycle();
                }
            });
            animator.start();
        }
    }

    /**
     * 设置主题
     *
     * @param activity activity
     * @param styleRes 主题资源id
     */
    public static void setTheme(Activity activity, @StyleRes int styleRes) {
        ThemeLib.style = styleRes;
        activity.setTheme(styleRes);
        Resources.Theme theme = activity.getTheme();
        View rootView = activity.getWindow().getDecorView().findViewById(android.R.id.content);
        setViewTheme(rootView, theme);
    }

    private static void setViewTheme(View view, Resources.Theme theme) {
        if (view instanceof ThemeInterface) {
            ThemeChangeHandler[] themeChangeHandlers = ((ThemeInterface) view).getThemeChangeHandlers();
            if (themeChangeHandlers != null) {
                for (ThemeChangeHandler handler : themeChangeHandlers) {
                    if (handler.isAttrAvailable()) {
                        handler.onChange(theme);
                    }
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                setViewTheme(viewGroup.getChildAt(i), theme);
            }
        }
    }

}
