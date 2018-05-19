package com.example.marvinchua.weatherapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.marvinchua.weatherapp.databinding.ActivityMainBinding;

public class ActivityMain extends AppCompatActivity
{
    ActivityMainBinding binding;
    @Override protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.button.setOnClickListener(view -> {
            throw new RuntimeException("This is a crash");
        });

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                == PackageManager.PERMISSION_DENIED)
        {
            ActivityCompat
                    .requestPermissions(this, new String[] {Manifest.permission.CAMERA}, 0);
        }
        //        setContentView(R.layout.activity_main);
    }
}
