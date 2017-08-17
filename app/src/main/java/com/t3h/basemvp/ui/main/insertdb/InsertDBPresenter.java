package com.t3h.basemvp.ui.main.insertdb;

import com.t3h.basemvp.interact.AccountInteractor;
import com.t3h.basemvp.ui.base.Action;
import com.t3h.basemvp.ui.base.BasePresenter;

/**
 * Created by dungtx on 8/15/17.
 */

public class InsertDBPresenter extends BasePresenter<IInsertDB.View> implements IInsertDB.Presenter {
    public InsertDBPresenter(IInsertDB.View view) {
        super(view);
    }

    @Override
    public void insertDB(String name, String birth, String address) {
        interact(AccountInteractor.getInstance().insertDB(name, birth, address), new Action<String>() {
            @Override
            public void call(String updateDB) {
                mView.finishUpdateDB(updateDB);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorUpdateDB(throwable);
            }
        });
    }
}
