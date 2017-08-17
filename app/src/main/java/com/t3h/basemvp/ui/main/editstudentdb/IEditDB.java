package com.t3h.basemvp.ui.main.editstudentdb;

import com.t3h.basemvp.ui.base.IBasePresenter;
import com.t3h.basemvp.ui.base.IViewMain;

/**
 * Created by dungtx on 8/15/17.
 */

public interface IEditDB {
    interface View extends IViewMain{
        void finishEditDB(String response);
        void errorEditDB(Throwable error);
    }

    interface Presenter extends IBasePresenter{
        void editDB(String id, String name, String birth, String address);
    }
}
