package com.t3h.basemvp.ui.main.liststudent;

import com.t3h.basemvp.module.ItemStudent;
import com.t3h.basemvp.ui.base.IBasePresenter;
import com.t3h.basemvp.ui.base.IViewMain;

import java.util.List;

/**
 * Created by dungtx on 8/15/17.
 */

public interface IListStudent {
    interface View extends IViewMain{
        void finishQueryStudent(List<ItemStudent> response);
        void errorQueryStudent(Throwable error);
        void finishDeleteDB(String reponse);
        void errorDeleteDB(Throwable error);
    }

    interface Presenter extends IBasePresenter{
        void queryStudent();
        void deleteDB(String id);
    }
}
