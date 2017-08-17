package com.t3h.basemvp.ui.main.listmovie;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemMovieSearch;
import com.t3h.basemvp.ui.base.animation.ScreenAnimation;
import com.t3h.basemvp.ui.base.fragment.BaseFragment;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;
import com.t3h.basemvp.ui.base.fragment.OpenFragmentUltil;
import com.t3h.basemvp.ui.main.MainActivity;
import com.t3h.basemvp.ui.main.playmusic.PlayMusicFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dungtx on 8/2/17.
 */

public class ListMovieFragment extends BaseMvpFragment<IListMovie.Presenter> implements ListMovieAdapter.IListMovieAdapter, TextWatcher, IListMovie.View {

    private RecyclerView rcMovie;
    private EditText edtMovie;
    private ListMovieAdapter mAdapter;
    private ItemMovieSearch itemMovieSearches;

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_list_music;
    }

    @Override
    public void findViewByIds() {
        rcMovie = (RecyclerView) getView().findViewById(R.id.rc_music);
        edtMovie = (EditText) getView().findViewById(R.id.edt_search);

        mAdapter = new ListMovieAdapter(this);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        rcMovie.setLayoutManager(manager);
        rcMovie.setAdapter(mAdapter);
    }

    @Override
    public void initComponents() {
        mPresenter = new ListMoviePresenter(this);
    }

    @Override
    public void setEvents() {
        edtMovie.addTextChangedListener(this);
    }

    @Override
    public int getCount() {
        if (itemMovieSearches == null ){
            return 0;
        }
        return itemMovieSearches.getResultses().size();
    }

    @Override
    public ItemMovieSearch.Results getData(int position) {
        return itemMovieSearches.getResultses().get(position);
    }

    @Override
    public void onClick(int position) {
        getBaseActivity().hideKeyBoard();
        ItemMovieSearch.Results results = itemMovieSearches.getResultses().get(position);
        OpenFragmentUltil.openOverviewFragment(getBaseActivity(), results.getPosterPath(), results.getTitle(), results.getVoteCount(), results.getOverview());
//        MainActivity activity = (MainActivity) getActivity();
//
//        BaseFragment fragment = BaseFragment.getCurrentBaseFragment(activity.getSupportFragmentManager());
//        //Log.d(TAG, fragment.getClass().getName() + "");
//        FragmentManager manager = activity.getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        if (fragment != null) {
//            BaseFragment.hideFragment(manager, transaction, fragment.getClass(),
//                    ScreenAnimation.OPEN_FULL, false, false);
//        }
//
//        BaseFragment.openFragment(manager, transaction,
//                OverviewMovieFragment.class, ScreenAnimation.OPEN_FULL, null, false, true);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        String content = s.toString().trim();
        mPresenter.onDestroy();
        mPresenter.getItemMovieSearch(content);
    }

    @Override
    public void finishGetListMovie(ItemMovieSearch reponses) {
        itemMovieSearches = reponses;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void errorGetListMovie(Throwable error) {

    }
}
