package com.t3h.basemvp.ui.main.listidol;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemIdol;

/**
 * Created by dungtx on 8/10/17.
 */

public class ListIdolAdapter extends RecyclerView.Adapter<ListIdolAdapter.ViewHolerListIdol> {

    private IListIdolAdapter mInterf;

    public ListIdolAdapter(IListIdolAdapter interf) {
        mInterf = interf;
    }

    @Override
    public ViewHolerListIdol onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_idol, parent, false);
        return new ViewHolerListIdol(view);
    }

    @Override
    public void onBindViewHolder(ViewHolerListIdol holder, int position) {
        ItemIdol.Result result = mInterf.getData(position);

        if (result.getSiteUrl() == null || result.getSiteUrl().isEmpty()){
            return;
        }

        Picasso.with(holder.ivIdol.getContext())
                .load(result.getImageUrl())
                .placeholder(R.drawable.gb_loading)
                .error(R.drawable.gb_loading)
                .into(holder.ivIdol);
    }

    @Override
    public int getItemCount() {
        return mInterf.getCount();
    }

    public class ViewHolerListIdol extends RecyclerView.ViewHolder {
        private ImageView ivIdol;
        public ViewHolerListIdol(View itemView) {
            super(itemView);
            ivIdol = (ImageView) itemView.findViewById(R.id.iv_avatar);
        }
    }

    public interface IListIdolAdapter{
        int getCount();
        ItemIdol.Result getData(int position);
    }
}
