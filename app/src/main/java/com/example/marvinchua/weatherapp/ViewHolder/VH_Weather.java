package com.example.marvinchua.weatherapp.ViewHolder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.marvinchua.weatherapp.ActivityWeatherDetail;
import com.example.marvinchua.weatherapp.AdapterNestedWeather;
import com.example.marvinchua.weatherapp.R;
import com.example.marvinchua.weatherapp.databinding.ItemLocationBinding;
import com.example.marvinchua.weatherapp.model.Locations;
import com.example.marvinchua.weatherapp.model.WeatherDetail;

public class VH_Weather extends RecyclerView.ViewHolder
{
    public final ItemLocationBinding binding;

    public VH_Weather(ItemLocationBinding binding)
    {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(Context context, Locations item)
    {
        binding.setLocations(item);
        binding.executePendingBindings();

        binding.listViewWeather.setAdapter(
                new AdapterNestedWeather(context, R.layout.item_weather, R.id.textView_weather,
                        item.weatherDetails));
        binding.listViewWeather.setOnItemClickListener((adapterView, view, i, l) -> {
            Bundle bundle = new Bundle();
            Intent intent = new Intent(context, ActivityWeatherDetail.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            bundle.putSerializable("weather",
                    (WeatherDetail) adapterView.getAdapter().getItem(i));
            intent.putExtras(bundle);
            context.startActivity(intent);
        });
    }

}