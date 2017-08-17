package com.t3h.basemvp.ui.main.listmovie;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.t3h.basemvp.R;
import com.t3h.basemvp.common.Constants;
import com.t3h.basemvp.module.ItemMovieSearch;
import com.t3h.basemvp.ui.base.activity.BaseActivity;
import com.t3h.basemvp.ui.base.fragment.BaseMvpFragment;

import java.io.File;

/**
 * Created by dungtx on 8/9/17.
 */

public class OverviewMovieFragment extends BaseMvpFragment<IListMovie.Presenter> implements View.OnClickListener {

    private TextView tvMovieName;
    private TextView tvRating;
    private TextView tvOverview;
    private ImageView ivImageMovie;
    private Bundle bundle;

    @Override
    public int getLayoutMain() {
        return R.layout.fragment_overview_movie;
    }

    @Override
    public void findViewByIds() {
        tvMovieName = (TextView) getView().findViewById(R.id.tv_show_name);
        tvRating = (TextView) getView().findViewById(R.id.tv_rating);
        tvOverview = (TextView) getView().findViewById(R.id.tv_overview);
        ivImageMovie = (ImageView) getView().findViewById(R.id.show_image);
    }

    @Override
    public void initComponents() {
        bundle = getArguments();
        tvMovieName.setText(bundle.getString(Constants.NAME_MOVIE));
        tvRating.setText(bundle.getString(Constants.RATING));
        tvOverview.setText(bundle.getString(Constants.OVERVIEW));

        String urlImage = "http://image.tmdb.org/t/p/w185/" + bundle.getString(Constants.AVATAR);
        Picasso.with(getContext())
                .load(urlImage)
                .placeholder(R.drawable.gb_loading)
                .error(R.drawable.gb_loading)
                .into(ivImageMovie);

    }

    @Override
    public void setEvents() {

    }


    @Override
    public void onBackRoot() {
        super.onBackRoot();
    }


    @Override
    public void onClick(View v) {
        getBaseActivity().hideKeyBoard();
        onBackRoot();
    }
}
