package com.t3h.basemvp.ui.main.listidol;

import com.t3h.basemvp.interact.AccountInteractor;
import com.t3h.basemvp.module.ItemIdol;
import com.t3h.basemvp.ui.base.Action;
import com.t3h.basemvp.ui.base.BasePresenter;

/**
 * Created by dungtx on 8/10/17.
 */

public class ListIdolPresenter extends BasePresenter<IListIdol.View> implements IListIdol.Presenter {
    public ListIdolPresenter(IListIdol.View view) {
        super(view);
    }

    @Override
    public void getListIdol() {
        interact(AccountInteractor.getInstance().getIdol(), new Action<ItemIdol>() {
            @Override
            public void call(ItemIdol itemIdol) {
                mView.fininhGetListIdol(itemIdol);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorGetListIdol(throwable);
            }
        });
    }
}
