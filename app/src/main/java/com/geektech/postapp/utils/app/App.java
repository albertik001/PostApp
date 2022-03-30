package com.geektech.postapp.utils.app;

import android.app.Application;

import com.geektech.postapp.data.remote.PostApi;
import com.geektech.postapp.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static PostApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.createApi();
    }
}
