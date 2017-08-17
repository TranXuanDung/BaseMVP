package com.t3h.basemvp.interact;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.t3h.basemvp.module.ItemMovie;
import com.t3h.basemvp.module.ItemMovieSearch;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dungtx on 8/2/17.
 */

class ApiConnectorMovie {
    private static ApiConnectorMovie instance = new ApiConnectorMovie();
    private ApiService apiService;

    private ApiConnectorMovie() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        Retrofit.Builder retrofit = new Retrofit.Builder();
        retrofit.baseUrl("https://api.themoviedb.org")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build());
        apiService = retrofit.build().create(ApiService.class);
    }

    static ApiConnectorMovie getInstance(){
        return instance;
    }

    public Observable<ItemMovieSearch> getListMovie(String nameMovie, String key){
        return apiService.queryMovie(nameMovie, key).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<ItemMovie> getTopMovie(String key){
        return apiService.queryTopMovie(key).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }
}
