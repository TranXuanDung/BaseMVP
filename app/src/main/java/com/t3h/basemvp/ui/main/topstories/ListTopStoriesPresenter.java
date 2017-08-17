package com.t3h.basemvp.ui.main.topstories;

import com.t3h.basemvp.interact.AccountInteractor;
import com.t3h.basemvp.module.ItemStories;
import com.t3h.basemvp.ui.base.Action;
import com.t3h.basemvp.ui.base.BasePresenter;

/**
 * Created by dungtx on 8/10/17.
 */

public class ListTopStoriesPresenter extends BasePresenter<IListTopStories.View> implements IListTopStories.Presenter {
    public ListTopStoriesPresenter(IListTopStories.View view) {
        super(view);
    }

    @Override
    public void getTopStories() {
        interact(AccountInteractor.getInstance().getStories(), new Action<ItemStories>() {
            @Override
            public void call(ItemStories itemStories) {
                mView.finishGetTopStories(itemStories);
            }
        }, new Action<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                mView.errorGetTopStories(throwable);
            }
        });
    }
}
