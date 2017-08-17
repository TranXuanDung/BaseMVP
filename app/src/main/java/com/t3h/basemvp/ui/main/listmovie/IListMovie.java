package com.t3h.basemvp.ui.main.listmovie;

import com.t3h.basemvp.module.ItemMovieReponse;
import com.t3h.basemvp.module.ItemMovieSearch;
import com.t3h.basemvp.ui.base.BasePresenter;
import com.t3h.basemvp.ui.base.IBasePresenter;
import com.t3h.basemvp.ui.base.IViewMain;

import java.util.List;

import retrofit2.Response;

/**
 * Created by dungtx on 8/2/17.
 */

public interface IListMovie {
    interface View extends IViewMain{
        void finishGetListMovie(ItemMovieSearch reponses);
        void errorGetListMovie(Throwable error);
    }

    interface Presenter extends IBasePresenter{
        void getItemMovieSearch(String nameMovie);
    }
}
