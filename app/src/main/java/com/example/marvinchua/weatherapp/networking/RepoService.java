package com.example.marvinchua.weatherapp.networking;

import com.example.marvinchua.weatherapp.model.GroupLocation;
import com.example.marvinchua.weatherapp.model.Locations;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RepoService
{
    @GET("data/2.5/group") Call<GroupLocation> getLocations(@Query("id") String id,
            @Query("units") String units, @Query("APPID") String apiKey);
}
