package com.nightfarmer.themelib.view;

import android.content.Context;
import android.util.AttributeSet;

import com.nightfarmer.themelib.util.ViewAttributeUtil;
import com.nightfarmer.themelib.handler.BackGroundHandler;
import com.nightfarmer.themelib.handler.TextHandler;
import com.nightfarmer.themelib.intf.ThemeChangeHandler;
import com.nightfarmer.themelib.intf.ThemeInterface;

/**
 * Created by zhangfan on 16-8-31.
 */
public class TextView extends android.widget.TextView implements ThemeInterface {
    private final int backgroundAttribute;
    //    private final int attr_textAppreance;
    private final int attr_textColor;

    public TextView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        backgroundAttribute = ViewAttributeUtil.getBackgroundAttibute(attrs);
//        attr_textAppreance = ViewAttributeUtil.getTextApperanceAttribute(attrs);
        attr_textColor = ViewAttributeUtil.getTextColorAttribute(attrs);
    }

    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        backgroundAttribute = ViewAttributeUtil.getBackgroundAttibute(attrs);
//        attr_textAppreance = ViewAttributeUtil.getTextApperanceAttribute(attrs);
        attr_textColor = ViewAttributeUtil.getTextColorAttribute(attrs);

    }

    @Override
    public ThemeChangeHandler[] getThemeChangeHandlers() {
        return new ThemeChangeHandler[]{
                new BackGroundHandler(this, new int[]{backgroundAttribute}),
                new TextHandler(this, new int[]{attr_textColor})
        };
    }
}
