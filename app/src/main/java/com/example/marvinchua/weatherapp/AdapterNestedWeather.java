package com.example.marvinchua.weatherapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.marvinchua.weatherapp.databinding.ItemWeatherBinding;
import com.example.marvinchua.weatherapp.model.Locations;
import com.example.marvinchua.weatherapp.model.WeatherDetail;

import java.util.List;

public class AdapterNestedWeather extends ArrayAdapter<WeatherDetail>
{
    List<WeatherDetail> item;
    public AdapterNestedWeather(@NonNull Context context, int resource, int textViewResourceId,
            @NonNull List<WeatherDetail> item)
    {
        super(context, resource, textViewResourceId, item);
        this.item = item;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater layoutInflater =
                    LayoutInflater.from(parent.getContext());
            ItemWeatherBinding itemBinding =
                    ItemWeatherBinding.inflate(layoutInflater, parent, false);
            itemBinding.textViewWeather.setText(item.get(position).main);
            convertView=itemBinding.getRoot();
            convertView.setTag(itemBinding);
            return itemBinding.getRoot();
        } else {
            return ((ItemWeatherBinding) convertView.getTag()).getRoot();
        }


    }
}
