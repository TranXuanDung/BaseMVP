package com.t3h.basemvp.ui.main.listmovie;

import com.t3h.basemvp.interact.AccountInteractor;
import com.t3h.basemvp.module.ItemMovieSearch;
import com.t3h.basemvp.ui.base.Action;
import com.t3h.basemvp.ui.base.BasePresenter;

import java.util.List;

import retrofit2.Response;

/**
 * Created by dungtx on 8/2/17.
 */

public class ListMoviePresenter extends BasePresenter<IListMovie.View> implements IListMovie.Presenter{
    public ListMoviePresenter(IListMovie.View view) {
        super(view);
    }

    @Override
    public void getItemMovieSearch(String nameMovie) {
//        interact(AccountInteractor.getInstance().getListMovie(nameMovie)
//                , new Action<List<ItemMovieSearch>>() {
//            @Override
//            public void call(List<ItemMovieSearch> itemMovieSearches) {
//                mView.finishGetListMovie(itemMovieSearches);
//            }
//        }, new Action<Throwable>() {
//            @Override
//            public void call(Throwable throwable) {
//                mView.errorGetListMovie(throwable);
//            }
//        });

        interact(AccountInteractor.getInstance().getListMovie(nameMovie), new Action<ItemMovieSearch>() {
            @Override
            public void call(ItemMovieSearch itemMovieSearches) {
                mView.finishGetListMovie(itemMovieSearches);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorGetListMovie(throwable);
            }
        });
    }
}
