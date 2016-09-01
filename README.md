## ThemeLib

### 简介
可扩展的主题支持库</br>
实现app在不重建activity的情况下变更主题配色。</br>

### ScreenShot
![示例1](https://raw.githubusercontent.com/NightFarmer/ThemeLib/master/sample/screenshots/s1.gif "示例1")
![示例1](https://raw.githubusercontent.com/NightFarmer/ThemeLib/master/sample/screenshots/s2.gif "示例1")

### 使用方法

#### 依赖
gradle

/build.gradle
```
repositories {
    ...
    maven {
        url "https://jitpack.io"
    }
}
```
/app/build.gradle
```
dependencies {
    ...
    compile 'com.github.NightFarmer:ThemeLib:1.0.0'
}
```
#### 使用
在Application中初始化调用
```java
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ThemeLib.init(this, R.style.def);//设置默认主题
	...
    }
}
```

在Activity的Ui线程中任意地方调用切换主题方法
```java
    ThemeLib.setTheme(this, R.style.def);//直接切换
```
OR
```java
    ThemeLib.setThemeSoft(this, R.style.def);//带有300毫秒的渐变动画
```
OR
```java
    ThemeLib.setThemeSoft(this, R.style.def, 400);//自定义渐变时间
```

#### 主题定义

在values文件夹下新增attrs文件，并自定义主题参数
```xml
<resources>
    <attr name="textcolor" format="reference|color" />
    <attr name="buttonBackcolor" format="reference|color" />
    ....
<resources>
```

在不同的Theme中定义不同的值
style_def.xml
```xml
    <style name="def" parent="AppBase">
        <item name="buttonBackcolor">#0000FF</item>
        <item name="textcolor">#ff0000</item>
        ...
    </style>
```
styel_dark.xml
```xml
    <style name="def" parent="AppBase">
        <item name="buttonBackcolor">#000000</item>
        <item name="textcolor">#FFFFFF</item>
        ...
    </style>
```

在xml布局文件中使用
```xml
        <com.nightfarmer.themelib.view.Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:background="?attr/buttonBackcolor"
            android:textColor="?attr/textcolor"
            android:text="主题测试" />
```

#### 扩展
ThemeLib提供了一些预制的View供运行时变更主题使用，包括Button/TextView/LinearLayout/RelativeLayout等
同时ThemeLib提供了对其他View的扩展支持，支持对自定义View或其他没有内置支持的View进行扩展。

如Button：
自定义Button继承自Button，并实现ThemeInterface接口
```java
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

如此，在xml布局文件中讲Button替换为此Button即可。

```


