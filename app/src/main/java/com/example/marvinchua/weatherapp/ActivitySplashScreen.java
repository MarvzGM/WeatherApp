package com.example.marvinchua.weatherapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class ActivitySplashScreen extends AppCompatActivity
{

    @Override protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Fabric.with(this, new Crashlytics());
        new Handler().postDelayed(new Runnable()
        {
            @Override public void run()
            {
                startActivity(new Intent(ActivitySplashScreen.this, ActivityMain.class));
                finish();
            }
        }, 2000);
    }
}
