package com.t3h.basemvp.interact;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.t3h.basemvp.module.ItemStudent;
import com.t3h.basemvp.module.ItemUser;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by dungtx on 8/15/17.
 */

class ApiConnectorDB {
    private static ApiConnectorDB instance = new ApiConnectorDB();
    private ApiService apiService;

    public static ApiConnectorDB getInstance() {
        return instance;
    }

    private ApiConnectorDB(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);

        Retrofit.Builder retrofit = new Retrofit.Builder();
        retrofit.baseUrl("http://dungtx.000webhostapp.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build());

        apiService = retrofit.build().create(ApiService.class);
    }

    // post: insert DB
    public Observable<String> insertDB(String name, String birth, String address){
        return apiService.insertDB(name, birth, address).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    // get
    public Observable<List<ItemStudent>> queryStudent(){
        return apiService.queryStudent().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    // post: update DB
    public Observable<String> updateDB(String id, String name, String birth, String address){
        return apiService.updateDB(id, name, birth, address).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    // post: delete DB
    public Observable<String> deleteDB(String id){
        return apiService.deleteDB(id).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    // post: register user
    public Observable<ItemUser> registerUser(String username, String password){
        return apiService.registerUser(username, password).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }

    // get: login user
    public Observable<List<ItemUser>> loginUser(){
        return apiService.loginUser().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
    }
}
