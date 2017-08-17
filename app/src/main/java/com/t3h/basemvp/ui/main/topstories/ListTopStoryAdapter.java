package com.t3h.basemvp.ui.main.topstories;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.t3h.basemvp.R;
import com.t3h.basemvp.module.ItemStories;

/**
 * Created by dungtx on 8/10/17.
 */

public class ListTopStoryAdapter extends RecyclerView.Adapter<ListTopStoryAdapter.ViewHolderTopStories> {

    private IListTopStoriesAdapter mInterf;

    public ListTopStoryAdapter(IListTopStoriesAdapter interf){
        mInterf = interf;
    }

    @Override
    public ViewHolderTopStories onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_new, parent, false);
        return new ViewHolderTopStories(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderTopStories holder, int position) {
        ItemStories.Results results = mInterf.getData(position);
//        ItemStories.Results.Multimedia multimedia = results.getMultimedias().get(0);

        holder.tvTitle.setText(results.getTitle());
        holder.tvCaption.setText(results.getAbstracts());
        holder.ivNewImage.setImageResource(R.drawable.news);
//        if (multimedia.getUrl() == null || multimedia.getUrl().isEmpty()){
//            return;
//        }

//        Picasso.with(holder.itemView.getContext())
//                .load(multimedia.getUrl())
//                .placeholder(R.drawable.news)
//                .error(R.drawable.news)
//                .into(holder.ivNewImage);

    }

    @Override
    public int getItemCount() {
        return mInterf.getCount();
    }

    public class ViewHolderTopStories extends RecyclerView.ViewHolder {
        private ImageView ivNewImage;
        private TextView tvTitle;
        private TextView tvCaption;
        public ViewHolderTopStories(View itemView) {
            super(itemView);
            ivNewImage = (ImageView) itemView.findViewById(R.id.iv_news_item_image);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvCaption = (TextView) itemView.findViewById(R.id.tv_caption);
        }
    }

    public interface IListTopStoriesAdapter{
        int getCount();
        ItemStories.Results getData(int position);
    }
}
