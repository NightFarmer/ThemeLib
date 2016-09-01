package com.nightfarmer.themelib.view;

import android.content.Context;
import android.util.AttributeSet;

import com.nightfarmer.themelib.handler.BackGroundHandler;
import com.nightfarmer.themelib.intf.ThemeChangeHandler;
import com.nightfarmer.themelib.intf.ThemeInterface;
import com.nightfarmer.themelib.util.ViewAttributeUtil;

/**
 * Created by zhangfan on 16-9-1.
 */
public class RelativeLayout extends android.widget.RelativeLayout implements ThemeInterface {
    private int backgroundAttribute;

    public RelativeLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        backgroundAttribute = ViewAttributeUtil.getBackgroundAttibute(attrs);
    }

    public RelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
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
