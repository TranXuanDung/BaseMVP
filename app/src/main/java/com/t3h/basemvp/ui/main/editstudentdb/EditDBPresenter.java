package com.t3h.basemvp.ui.main.editstudentdb;

import com.t3h.basemvp.interact.AccountInteractor;
import com.t3h.basemvp.ui.base.Action;
import com.t3h.basemvp.ui.base.BasePresenter;

/**
 * Created by dungtx on 8/16/17.
 */

public class EditDBPresenter extends BasePresenter<IEditDB.View> implements IEditDB.Presenter {
    public EditDBPresenter(IEditDB.View view) {
        super(view);
    }

    @Override
    public void editDB(String id, String name, String birth, String address) {
        interact(AccountInteractor.getInstance().updateDB(id, name, birth, address), new Action<String>() {
            @Override
            public void call(String s) {
                mView.finishEditDB(s);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorEditDB(throwable);
            }
        });
    }
}
