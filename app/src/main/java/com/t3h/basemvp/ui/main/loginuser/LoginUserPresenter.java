package com.t3h.basemvp.ui.main.loginuser;

import com.t3h.basemvp.interact.AccountInteractor;
import com.t3h.basemvp.module.ItemUser;
import com.t3h.basemvp.ui.base.Action;
import com.t3h.basemvp.ui.base.BasePresenter;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;

import java.util.List;

/**
 * Created by dungtx on 8/17/17.
 */

public class LoginUserPresenter extends BasePresenter<ILoginUser.View> implements ILoginUser.Presenter {

    public LoginUserPresenter(ILoginUser.View view) {
        super(view);
    }

    @Override
    public void loginUser() {
        interact(AccountInteractor.getInstance().loginUser(), new Action<List<ItemUser>>() {
            @Override
            public void call(List<ItemUser> itemUsers) {
                mView.finishLoginUser(itemUsers);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorLoginUser(throwable);
            }
        });
    }
}
