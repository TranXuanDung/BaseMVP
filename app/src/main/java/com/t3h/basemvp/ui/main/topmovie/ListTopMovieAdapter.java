package com.t3h.basemvp.ui.main.topmovie;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemMovie;

/**
 * Created by dungtx on 8/9/17.
 */

public class ListTopMovieAdapter extends BaseAdapter{

    private IListTopMovie mInterf;

    public ListTopMovieAdapter(IListTopMovie interf) {
        mInterf = interf;
    }

    @Override
    public int getCount() {
        return mInterf.getCount();
    }

    @Override
    public Object getItem(int position) {
        return mInterf.getData(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (null == convertView){
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.item_getmovies, parent, false);
            ImageView ivMovie = (ImageView)convertView.findViewById(R.id.iv_poster);
            holder = new ViewHolder();
            holder.ivMovie = ivMovie;
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        ItemMovie.Results results = mInterf.getData(position);

        Picasso.with(convertView.getContext())
                .load("http://image.tmdb.org/t/p/w185/" + results.getPosterPath() )
                .placeholder(R.drawable.gb_loading)
                .error(R.drawable.gb_loading)
                .into(holder.ivMovie);

        return convertView;
    }

    public static class ViewHolder {
        private ImageView ivMovie;

    }

    public interface IListTopMovie{
        int getCount();
        ItemMovie.Results getData(int position);
    }
}
