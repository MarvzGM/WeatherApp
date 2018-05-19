package com.example.marvinchua.weatherapp.networking;

import retrofit2.Retrofit;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class RepoApi
{

    private static final String BASE_URL = "https://api.openweathermap.org/";

    private static Retrofit retrofit;
    private static RepoService repoService;

    public static RepoService getInstance()
    {
        if (repoService != null)
        {
            return repoService;
        }
        if (retrofit == null)
        {
            initializeRetrofit();
        }
        repoService = retrofit.create(RepoService.class);
        return repoService;
    }

    private static void initializeRetrofit()
    {

//        OkHttpClient client = new OkHttpClient();
//        client.interceptors().add(chain -> chain.proceed(chain.request()));

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create()).build();
    }

    private RepoApi()
    {

    }
}
