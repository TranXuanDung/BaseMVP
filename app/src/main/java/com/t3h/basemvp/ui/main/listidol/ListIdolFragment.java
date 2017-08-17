package com.t3h.basemvp.ui.main.listidol;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemIdol;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;

/**
 * Created by dungtx on 8/10/17.
 */

public class ListIdolFragment extends BaseMvpFragment<IListIdol.Presenter> implements IListIdol.View, ListIdolAdapter.IListIdolAdapter, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView rcIdol;
    private ListIdolAdapter mAdapter;
    private ItemIdol itemIdol;
    private SwipeRefreshLayout refreshLayout;

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_list_idol;
    }

    @Override
    public void findViewByIds() {
        refreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeRefresh);
        rcIdol = (RecyclerView) getView().findViewById(R.id.rc_idol);
        mAdapter = new ListIdolAdapter(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        rcIdol.setLayoutManager(manager);
        rcIdol.setAdapter(mAdapter);
    }

    @Override
    public void initComponents() {
        mPresenter = new ListIdolPresenter(this);
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void setEvents() {
        refreshLayout.setRefreshing(true);
        mPresenter.getListIdol();
    }

    @Override
    public void fininhGetListIdol(ItemIdol response) {
        refreshLayout.setRefreshing(false);
        itemIdol = response;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorGetListIdol(Throwable error) {
        showMessage(error.getMessage());
        refreshLayout.setRefreshing(false);
    }

    @Override
    public int getCount() {
        if (itemIdol == null){
            return 0;
        }
        return itemIdol.getResults().size();
    }

    @Override
    public ItemIdol.Result getData(int position) {
        return itemIdol.getResults().get(position);
    }

    @Override
    public void onRefresh() {
        mPresenter.getListIdol();
    }
}
