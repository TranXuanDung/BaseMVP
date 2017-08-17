package com.t3h.basemvp.ui.main.topmovie;

import com.t3h.basemvp.interact.AccountInteractor;
import com.t3h.basemvp.module.ItemMovie;
import com.t3h.basemvp.ui.base.Action;
import com.t3h.basemvp.ui.base.BasePresenter;

/**
 * Created by dungtx on 8/9/17.
 */

public class ListTopMoviePresenter extends BasePresenter<IListTopMovie.View> implements IListTopMovie.Presenter{
    public ListTopMoviePresenter(IListTopMovie.View view) {
        super(view);
    }

    @Override
    public void getTopMovie() {
        interact(AccountInteractor.getInstance().getTopMovie(), new Action<ItemMovie>() {
            @Override
            public void call(ItemMovie itemMovie) {
                mView.finishGetTopMovie(itemMovie);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorGetListMovie(throwable);
            }
        });
    }
}
