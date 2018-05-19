package com.example.marvinchua.weatherapp.model;

import java.io.Serializable;

public class WeatherDetail implements Serializable
{
    private static final long serialVersionUID = 233532388193404244L;
    //    "weather": [
//    {
//        "id": 300,
//            "main": "Drizzle",
//            "description": "light intensity drizzle",
//            "icon": "09d"
//    }
//	]

    public long id;
    public String main;
    public String description;
    public String icon;

    public WeatherDetail(long id, String main, String description, String icon)
    {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }
}
