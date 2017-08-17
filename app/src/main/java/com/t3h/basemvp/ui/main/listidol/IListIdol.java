package com.t3h.basemvp.ui.main.listidol;

import com.t3h.basemvp.module.ItemIdol;
import com.t3h.basemvp.ui.base.IBasePresenter;
import com.t3h.basemvp.ui.base.IViewMain;

/**
 * Created by dungtx on 8/10/17.
 */

public interface IListIdol {
    interface View extends IViewMain{
        void fininhGetListIdol(ItemIdol response);
        void errorGetListIdol(Throwable error);
    }

    interface Presenter extends IBasePresenter{
        void getListIdol();
    }
}
