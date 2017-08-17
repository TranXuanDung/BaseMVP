package com.t3h.basemvp.ui.main.insertdb;

import com.t3h.basemvp.ui.base.IBasePresenter;
import com.t3h.basemvp.ui.base.IViewMain;

/**
 * Created by dungtx on 8/15/17.
 */

public interface IInsertDB {
    interface View extends IViewMain{
        void finishUpdateDB(String response);
        void errorUpdateDB(Throwable error);
    }

    interface Presenter extends IBasePresenter{
        void insertDB(String name, String birth, String address);
    }
}
