package com.t3h.basemvp.ui.main.topstories;

import com.t3h.basemvp.module.ItemStories;
import com.t3h.basemvp.ui.base.BasePresenter;
import com.t3h.basemvp.ui.base.IBasePresenter;
import com.t3h.basemvp.ui.base.IViewMain;

/**
 * Created by dungtx on 8/10/17.
 */

public interface IListTopStories {
    interface View extends IViewMain{
        void finishGetTopStories(ItemStories response);
        void errorGetTopStories(Throwable error);
    }

    interface Presenter extends IBasePresenter{
        void getTopStories();
    }
}
