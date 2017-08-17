package com.t3h.basemvp.interact;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.t3h.basemvp.module.ItemStories;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dungtx on 8/10/17.
 */

class ApiConnectorStory {
    private static ApiConnectorStory instance = new ApiConnectorStory();
    private ApiService apiService;

    public static ApiConnectorStory getInstance() {
        return instance;
    }

    private ApiConnectorStory(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        Retrofit.Builder retrofit = new Retrofit.Builder();
        retrofit.baseUrl("https://api.nytimes.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build());

        apiService = retrofit.build().create(ApiService.class);
    }

    public Observable<ItemStories> getStories(String key){
        return apiService.queryStories(key).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }
}
