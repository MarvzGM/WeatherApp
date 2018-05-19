package com.example.marvinchua.weatherapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.marvinchua.weatherapp.databinding.ActivityWeatherDetailBinding;
import com.example.marvinchua.weatherapp.model.WeatherDetail;

public class ActivityWeatherDetail extends AppCompatActivity
{
    ActivityWeatherDetailBinding binding;
    private WeatherDetail weatherDetail;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_weather_detail);
        weatherDetail = (WeatherDetail) getIntent().getSerializableExtra("weather");
        binding.setWeatherDetail(weatherDetail);

        RequestOptions option = new RequestOptions().centerCrop();
        Glide.with(this).load("http://openweathermap.org/img/w/" + weatherDetail.icon + ".png")
                .apply(option).into(binding.imageViewWeather);
    }
}
