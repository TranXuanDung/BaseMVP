package com.t3h.basemvp.ui.main.topmovie;

import com.t3h.basemvp.module.ItemMovie;
import com.t3h.basemvp.ui.base.BasePresenter;
import com.t3h.basemvp.ui.base.IBasePresenter;
import com.t3h.basemvp.ui.base.IViewMain;

/**
 * Created by dungtx on 8/9/17.
 */

public interface IListTopMovie {
    interface View extends IViewMain{
        void finishGetTopMovie(ItemMovie responses);
        void errorGetListMovie(Throwable error);
    }

    interface Presenter extends IBasePresenter{
        void getTopMovie();
    }
}
