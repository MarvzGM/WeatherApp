package com.example.marvinchua.weatherapp.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.marvinchua.weatherapp.model.GroupLocation;
import com.example.marvinchua.weatherapp.model.Locations;
import com.example.marvinchua.weatherapp.networking.RepoApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VM_ActivityMain extends ViewModel
{
    private final MutableLiveData<List<Locations>> locations = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loadError = new MutableLiveData<>();
    private final MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private Call<GroupLocation> locationCall;

    private final String LOCATION_IDS = "1701668,5391959,3067696,2643743";
    private final String METRIC = "metric";
    private final String API_KEY = "971af8b2cfbd75634428407ca3231068";

    public LiveData<List<Locations>> getLocations()
    {
        return locations;
    }

    public LiveData<Boolean> getLoadingError()
    {
        return loadError;
    }

    public LiveData<Boolean> getLoading()
    {
        return loading;
    }


    public VM_ActivityMain()
    {
        fetchLocations();
    }

    public void refresh(){
        fetchLocations();
    }

    private void fetchLocations()
    {
        loading.setValue(true);
        locationCall = RepoApi.getInstance().getLocations(LOCATION_IDS,METRIC,API_KEY);
        locationCall.enqueue(new Callback<GroupLocation>()
        {
            @Override public void onResponse(@NonNull Call<GroupLocation> call,
                    @NonNull Response<GroupLocation> response)
            {
                loadError.setValue(false);
                locations.setValue(response.body().list);
                loading.setValue(false);
                locationCall = null;
            }

            @Override
            public void onFailure(@NonNull Call<GroupLocation> call, @NonNull Throwable t)
            {
                Log.e("API_CALL", "Error loading locations", t);
                loadError.setValue(true);
                loading.setValue(false);
                locationCall = null;
            }
        });
    }

    @Override protected void onCleared()
    {
        super.onCleared();
        if (locationCall != null)
        {
            locationCall.cancel();
            locationCall = null;
        }
    }
}
