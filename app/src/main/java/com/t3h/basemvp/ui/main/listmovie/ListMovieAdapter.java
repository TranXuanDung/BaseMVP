package com.t3h.basemvp.ui.main.listmovie;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemMovieSearch;
import com.t3h.basemvp.ui.main.playmusic.IGetPosition;

/**
 * Created by dungtx on 8/2/17.
 */

public class ListMovieAdapter extends RecyclerView.Adapter<ListMovieAdapter.ViewHolderListMovie> implements View.OnClickListener {

    private IListMovieAdapter mInterf;


    public ListMovieAdapter(IListMovieAdapter interf) {
        mInterf = interf;
    }

    @Override
    public ViewHolderListMovie onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list_movie_search, parent, false);
        return new ViewHolderListMovie(view, this);
    }

    @Override
    public void onBindViewHolder(ViewHolderListMovie holder, int position) {
        ItemMovieSearch.Results itemMovieSearch = mInterf.getData(position);

        holder.tvName.setText(itemMovieSearch.getTitle());
        holder.tvRate.setText(itemMovieSearch.getVoteCount());

        if (itemMovieSearch.getPosterPath() == null || itemMovieSearch.getPosterPath() .isEmpty()){
            return;
        }

        Picasso.with(holder.itemView.getContext())
                .load("http://image.tmdb.org/t/p/w185/" + itemMovieSearch.getPosterPath() )
                .placeholder(R.drawable.gb_loading)
                .error(R.drawable.gb_loading)
                .into(holder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return mInterf.getCount();
    }

    @Override
    public void onClick(View v) {
        IGetPosition position = (IGetPosition) v.getTag();
        int po = position.getPosition();
        mInterf.onClick(po);
    }

    static class ViewHolderListMovie extends RecyclerView.ViewHolder {
        private ImageView ivAvatar;
        private TextView tvName;
        private TextView tvRate;

        public ViewHolderListMovie(View itemView, View.OnClickListener onClickListener) {
            super(itemView);
            ivAvatar = (ImageView)itemView.findViewById(R.id.iv_avatar);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvRate = (TextView) itemView.findViewById(R.id.tv_rate);

            itemView.setOnClickListener(onClickListener);
            IGetPosition position = new IGetPosition() {
                @Override
                public int getPosition() {
                    return getAdapterPosition();
                }
            };
            itemView.setTag(position);
        }
    }

    public interface IListMovieAdapter{
        int getCount();
        ItemMovieSearch.Results getData(int positionn);

        void onClick(int position);
    }
}
