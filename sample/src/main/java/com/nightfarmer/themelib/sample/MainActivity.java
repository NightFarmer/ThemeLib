package com.nightfarmer.themelib.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nightfarmer.themelib.ThemeLib;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int style = 0;

    public void changeTheme(View view) {
        if (style % 2 != 0) {
            ThemeLib.setThemeSoft(this, R.style.hehe1, 300);
        } else {
            ThemeLib.setThemeSoft(this, R.style.hehe2, 300);
//            ThemeLib.setTheme(this, R.style.hehe2);
        }
        style++;
    }
}
