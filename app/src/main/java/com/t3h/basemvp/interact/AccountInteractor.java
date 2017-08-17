package com.t3h.basemvp.interact;

import com.t3h.basemvp.common.Constants;
import com.t3h.basemvp.module.ItemIdol;
import com.t3h.basemvp.module.ItemMovie;
import com.t3h.basemvp.module.ItemMovieSearch;
import com.t3h.basemvp.module.ItemSongReponse;
import com.t3h.basemvp.module.ItemSongSearch;
import com.t3h.basemvp.module.ItemStories;
import com.t3h.basemvp.module.ItemStudent;
import com.t3h.basemvp.module.ItemUser;

import java.util.List;

import io.reactivex.Observable;

public class AccountInteractor {
    private static AccountInteractor instance = new AccountInteractor();

    private AccountInteractor() {

    }

    public static AccountInteractor getInstance() {
        return instance;
    }

    public Observable<List<ItemSongReponse>> getMusic(String name) {
        return ApiConnector.getInstance().getMusic(name);

    }

    public Observable<List<ItemSongSearch>> getListMusic(String nameMusic) {
        return ApiConnector.getInstance().getListMusic(nameMusic,
                Constants.WEB_SITE_NAME,
                Constants.CODE);
    }


    // get The movie
    public Observable<ItemMovieSearch> getListMovie(String nameMovie){
        return ApiConnectorMovie.getInstance().getListMovie(nameMovie, Constants.API_KEY_MOVIE);
    }

    // get the top movie
    public Observable<ItemMovie> getTopMovie(){
        return ApiConnectorMovie.getInstance().getTopMovie(Constants.API_KEY_MOVIE);
    }

    // get the story
    public Observable<ItemStories> getStories(){
        return ApiConnectorStory.getInstance().getStories(Constants.API_KEY_NYTIME);
    }

    // get the idol
    public Observable<ItemIdol> getIdol(){
        return ApiConnectorIdol.getInstance().getIdol();
    }

    // insert DB
    public Observable<String> insertDB(String name, String birth, String address){
        return ApiConnectorDB.getInstance().insertDB(name, birth, address);
    }

    // get student
    public Observable<List<ItemStudent>> queryStudent(){
        return ApiConnectorDB.getInstance().queryStudent();
    }

    // update DB
    public Observable<String> updateDB(String id, String name, String birth, String address){
        return ApiConnectorDB.getInstance().updateDB(id, name, birth, address);
    }

    // delete DB
    public Observable<String> deleteDB(String id){
        return ApiConnectorDB.getInstance().deleteDB(id);
    }

    // register user
    public Observable<ItemUser> registerUser(String username, String password){
        return ApiConnectorDB.getInstance().registerUser(username, password);
    }

    // login user
    public Observable<List<ItemUser>> loginUser(){
        return ApiConnectorDB.getInstance().loginUser();
    }
}
