package com.nightfarmer.themelib.view;

import android.content.Context;
import android.util.AttributeSet;

import com.nightfarmer.themelib.util.ViewAttributeUtil;
import com.nightfarmer.themelib.handler.BackGroundHandler;
import com.nightfarmer.themelib.intf.ThemeChangeHandler;
import com.nightfarmer.themelib.intf.ThemeInterface;

/**
 * Created by zhangfan on 16-8-31.
 */
public class LinearLayout extends android.widget.LinearLayout implements ThemeInterface {
    private int backgroundAttribute;

    public LinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        backgroundAttribute = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    @Override
    public ThemeChangeHandler[] getThemeChangeHandlers() {
        return new ThemeChangeHandler[]{
                new BackGroundHandler(this, new int[]{backgroundAttribute})
        };
    }
}
