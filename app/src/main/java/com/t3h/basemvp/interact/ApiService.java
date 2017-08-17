package com.t3h.basemvp.interact;

import com.t3h.basemvp.module.ItemIdol;
import com.t3h.basemvp.module.ItemMovie;
import com.t3h.basemvp.module.ItemMovieSearch;
import com.t3h.basemvp.module.ItemSongReponse;
import com.t3h.basemvp.module.ItemSongSearch;
import com.t3h.basemvp.module.ItemStories;
import com.t3h.basemvp.module.ItemStudent;
import com.t3h.basemvp.module.ItemUser;
import com.t3h.basemvp.module.UpdateDB;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by ducnd on 5/25/17.
 */

public interface ApiService {
    @GET("jOut.ashx")
    Observable<List<ItemSongSearch>> queryMusic(@Query("k") String musicName, @Query("h") String webSite,
                                               @Query("code") String code);

    @GET("3/search/movie")
    Observable<ItemMovieSearch> queryMovie(@Query("query") String movieName, @Query("api_key") String key);

    @GET("3/movie/top_rated")
    Observable<ItemMovie> queryTopMovie(@Query("api_key") String key);

    @GET("svc/topstories/v2/home.json")
    Observable<ItemStories> queryStories(@Query("api-key") String key);

    @GET("api/actress")
    Observable<ItemIdol> queryIdol();

    @FormUrlEncoded
    @POST("insert.php")
    Observable<String> insertDB(@Field("nameSV") String name, @Field("birthSV") String birth, @Field("addressSV") String address);

    @GET("getdata.php")
    Observable<List<ItemStudent>> queryStudent();

    @FormUrlEncoded
    @POST("update.php")
    Observable<String> updateDB(@Field("idSV") String id, @Field("nameSV") String name, @Field("birthSV") String birth, @Field("addressSV") String address);

    @FormUrlEncoded
    @POST("delete.php")
    Observable<String> deleteDB(@Field("idSV") String id);

    @FormUrlEncoded
    @POST("register.php")
    Observable<ItemUser> registerUser(@Field("userName") String username, @Field("passWord") String password);

    @GET("login.php")
    Observable<List<ItemUser>> loginUser();
}
