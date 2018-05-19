package com.example.marvinchua.weatherapp.model;

import com.squareup.moshi.Json;

import java.util.List;

public class Locations
{
    public long id;
    public String name;
    @Json(name = "weather")
    public List<WeatherDetail> weatherDetails;
    @Json(name = "main")
    public TempDetail tempDetail;

    public Locations(long id, String name, List<WeatherDetail> weatherDetails, TempDetail tempDetail)
    {
        this.id = id;
        this.name = name;
        this.weatherDetails = weatherDetails;
        this.tempDetail = tempDetail;
    }
}
