package com.nightfarmer.themelib.intf;

import android.content.res.Resources;
import android.view.View;

/**
 * Created by zhangfan on 16-8-31.
 */
public abstract class ThemeChangeHandler {

    public View view;
    public int[] attr;

    public ThemeChangeHandler(View view, int[] attr) {
        this.view = view;
        this.attr = attr;
    }

    public abstract void onChange(Resources.Theme theme);

    public boolean isAttrAvailable() {
        return attr != null && attr.length > 0 && attr[0] > 0;
    }

    public int[] getAttr() {
        return attr;
    }

    public void setAttr(int[] attr) {
        this.attr = attr;
    }

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
