package com.t3h.basemvp.ui.main.register;

import com.t3h.basemvp.interact.AccountInteractor;
import com.t3h.basemvp.module.ItemUser;
import com.t3h.basemvp.ui.base.Action;
import com.t3h.basemvp.ui.base.BasePresenter;

/**
 * Created by dungtx on 8/17/17.
 */

public class RegisterUserPresenter extends BasePresenter<IRegisterUser.View> implements IRegisterUser.Presenter {

    public RegisterUserPresenter(IRegisterUser.View view) {
        super(view);
    }

    @Override
    public void registerUser(String username, String password) {
        interact(AccountInteractor.getInstance().registerUser(username, password), new Action<ItemUser>() {
            @Override
            public void call(ItemUser itemUser) {
                mView.finishRegisterUser(itemUser);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorRegisterUser(throwable);
            }
        });
    }
}
