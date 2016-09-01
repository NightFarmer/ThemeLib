package com.nightfarmer.themelib.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.nightfarmer.themelib.ThemeLib;
import com.nightfarmer.themelib.sample.samplepage.RecyclerViewActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    int style = 0;

    public void changeTheme(View view) {
        if (style % 2 != 0) {
            ThemeLib.setThemeSoft(this, R.style.def, 300);
        } else {
            ThemeLib.setThemeSoft(this, R.style.dark, 300);
//            ThemeLib.setTheme(this, R.style.hehe2);
        }
        style++;
    }

    public void testRecyclerView(View view) {
        startActivity(new Intent(this, RecyclerViewActivity.class));
    }
}
