package com.exabarermple.latif.bookingapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import gr.net.maroulis.library.EasySplashScreen;
import android.view.View;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashActivity.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(2000);
        View easySplashScreen = config.create();
        setContentView(R.layout.activity_splash);
    }
}
