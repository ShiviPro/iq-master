package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Splash extends AppCompatActivity {
    private final int SPLASH_SCREEN_DISPLAY_TIME = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        TextView primary_tv = (TextView) findViewById(R.id.textView);
        TextView secondary_tv = (TextView) findViewById(R.id.textView2);

        Typeface primary_tf = ResourcesCompat.getFont(this, R.font.comfortaa_variable_font_wght);

        primary_tv.setTypeface(primary_tf);
        secondary_tv.setTypeface(primary_tf);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(Splash.this, MainActivity.class);
                startActivity(homeIntent);
                Splash.this.finish();
            }
        }, SPLASH_SCREEN_DISPLAY_TIME);
    }
}