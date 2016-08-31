package com.nightfarmer.themelib.handler;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.widget.TextView;

import com.nightfarmer.themelib.intf.ThemeChangeHandler;

/**
 * Created by zhangfan on 16-8-31.
 */
public class TextHandler extends ThemeChangeHandler {

    public TextHandler(View view, int[] attr) {
        super(view, attr);
    }

    @Override
    public void onChange(Resources.Theme theme) {
        TypedArray ta = theme.obtainStyledAttributes(attr);
        int resourceId = ta.getColor(0, 0);
        ((TextView) view).setTextColor(resourceId);
        ta.recycle();
    }
}
