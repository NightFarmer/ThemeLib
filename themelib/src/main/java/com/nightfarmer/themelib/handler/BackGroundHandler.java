package com.nightfarmer.themelib.handler;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.nightfarmer.themelib.intf.ThemeChangeHandler;

/**
 * Created by zhangfan on 16-8-31.
 */
public class BackGroundHandler extends ThemeChangeHandler {

    public BackGroundHandler(View view, int[] attr) {
        super(view, attr);
    }

    @Override
    public void onChange(Resources.Theme theme) {
        TypedArray ta = theme.obtainStyledAttributes(attr);
        Drawable drawable = ta.getDrawable(0);
        view.setBackgroundDrawable(drawable);
        ta.recycle();
    }


}
