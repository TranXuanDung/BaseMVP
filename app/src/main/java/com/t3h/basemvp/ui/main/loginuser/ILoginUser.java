package com.t3h.basemvp.ui.main.loginuser;

import com.t3h.basemvp.module.ItemUser;
import com.t3h.basemvp.ui.base.IBasePresenter;
import com.t3h.basemvp.ui.base.IViewMain;

import java.util.List;

/**
 * Created by dungtx on 8/17/17.
 */

public interface ILoginUser {
    interface View extends IViewMain{
        void finishLoginUser(List<ItemUser> response);
        void errorLoginUser(Throwable error);
    }

    interface Presenter extends IBasePresenter{
        void loginUser();
    }
}
