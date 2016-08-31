package com.nightfarmer.themelib.view;

import android.content.Context;
import android.util.AttributeSet;

import com.nightfarmer.themelib.handler.TextHandler;
import com.nightfarmer.themelib.util.ViewAttributeUtil;
import com.nightfarmer.themelib.handler.BackGroundHandler;
import com.nightfarmer.themelib.intf.ThemeChangeHandler;
import com.nightfarmer.themelib.intf.ThemeInterface;

/**
 * Created by zhangfan on 16-8-31.
 */
public class Button extends android.widget.Button implements ThemeInterface {

    private int backgroundAttribute;
    private int attr_textColor;

    public Button(Context context) {
        super(context);
    }

    public Button(Context context, AttributeSet attrs) {
        super(context, attrs);

        backgroundAttribute = ViewAttributeUtil.getBackgroundAttibute(attrs);
        attr_textColor = ViewAttributeUtil.getTextColorAttribute(attrs);
    }

    public Button(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        backgroundAttribute = ViewAttributeUtil.getBackgroundAttibute(attrs);
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
