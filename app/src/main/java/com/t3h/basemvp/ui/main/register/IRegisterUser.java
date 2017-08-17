package com.t3h.basemvp.ui.main.register;

import com.t3h.basemvp.module.ItemUser;
import com.t3h.basemvp.ui.base.IBasePresenter;
import com.t3h.basemvp.ui.base.IViewMain;

/**
 * Created by dungtx on 8/17/17.
 */

public interface IRegisterUser {
    interface View extends IViewMain{
        void finishRegisterUser(ItemUser response);
        void errorRegisterUser(Throwable error);
    }

    interface Presenter extends IBasePresenter{
        void registerUser(String username, String password);
    }
}
