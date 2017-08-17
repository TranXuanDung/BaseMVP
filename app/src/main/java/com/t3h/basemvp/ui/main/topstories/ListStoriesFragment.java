package com.t3h.basemvp.ui.main.topstories;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemStories;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;

/**
 * Created by dungtx on 8/10/17.
 */

public class ListStoriesFragment extends BaseMvpFragment<IListTopStories.Presenter> implements IListTopStories.View, ListTopStoryAdapter.IListTopStoriesAdapter, SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView rcStory;
    private ListTopStoryAdapter mAdapter;
    private SwipeRefreshLayout refreshLayout;
    private ItemStories stories;

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_top_story;
    }

    @Override
    public void findViewByIds() {
        rcStory = (RecyclerView) getView().findViewById(R.id.rc_story);
        refreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeRefresh);
        mAdapter = new ListTopStoryAdapter(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        rcStory.setLayoutManager(manager);
        rcStory.setAdapter(mAdapter);
    }

    @Override
    public void initComponents() {
        mPresenter = new ListTopStoriesPresenter(this);
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void setEvents() {
        refreshLayout.setRefreshing(true);
        mPresenter.getTopStories();
    }

    @Override
    public void finishGetTopStories(ItemStories response) {
        refreshLayout.setRefreshing(false);
        stories = response;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorGetTopStories(Throwable error) {
        showMessage(error.getMessage());
        refreshLayout.setRefreshing(false);
    }

    @Override
    public int getCount() {
        if (stories == null){
            return 0;
        }
        return stories.getResultses().size();
    }

    @Override
    public ItemStories.Results getData(int position) {
        return stories.getResultses().get(position);
    }

    @Override
    public void onRefresh() {
        mPresenter.getTopStories();
    }
}
