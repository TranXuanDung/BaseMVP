package com.t3h.basemvp.ui.main.topmovie;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemMovie;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;
import com.t3h.basemvp.ui.base.fragment.OpenFragmentUltil;
import com.t3h.basemvp.ui.main.listmovie.ListMovieAdapter;

/**
 * Created by dungtx on 8/9/17.
 */

public class TopMovieFragment extends BaseMvpFragment<IListTopMovie.Presenter> implements ListTopMovieAdapter.IListTopMovie, IListTopMovie.View, SwipeRefreshLayout.OnRefreshListener, AdapterView.OnItemClickListener {

    private GridView gvTopMovie;
    private ListTopMovieAdapter mAdapter;
    private SwipeRefreshLayout refreshLayout;
    private ItemMovie itemMovie;

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_toprate;
    }

    @Override
    public void findViewByIds() {
        gvTopMovie = (GridView) getView().findViewById(R.id.gv_top_movie);
        refreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.swipeRefresh);
        mAdapter = new ListTopMovieAdapter(this);
        gvTopMovie.setAdapter(mAdapter);

    }

    @Override
    public void initComponents() {
        mPresenter = new ListTopMoviePresenter(this);
        refreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void setEvents() {
        refreshLayout.setRefreshing(true);
        mPresenter.getTopMovie();
        gvTopMovie.setOnItemClickListener(this);
    }

    @Override
    public int getCount() {
        if (itemMovie == null){
            return 0;
        }
        return itemMovie.getResultses().size();
    }

    @Override
    public ItemMovie.Results getData(int position) {
        return itemMovie.getResultses().get(position);
    }

    @Override
    public void finishGetTopMovie(ItemMovie responses) {
        refreshLayout.setRefreshing(false);
        itemMovie = responses;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorGetListMovie(Throwable error) {
        showMessage(error.getMessage());
        refreshLayout.setRefreshing(false);
    }

    @Override
    public void onRefresh() {
        mPresenter.getTopMovie();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        getBaseActivity().hideKeyBoard();
        ItemMovie.Results results = itemMovie.getResultses().get(position);
        OpenFragmentUltil.openOverviewFragment(getBaseActivity(), results.getPosterPath(), results.getTitle(), results.getVoteCount(), results.getOverview());
    }
}
