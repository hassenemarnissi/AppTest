package com.example.testapp.adapter;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.testapp.R;
import com.example.testapp.data.model.PictureDetails;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class AlbumAdapter extends RecyclerView.Adapter<PlaceViewHolder> {

    private Context context;
    private List<PictureDetails> album;


    public AlbumAdapter(Context context, List<PictureDetails> album) {
        this.context = context;
        this.album = album;
    }


    @Override
    public PlaceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_custom_layout,
                parent, false);
        return new PlaceViewHolder(view);

    }

    @Override
    public void onBindViewHolder(PlaceViewHolder holder, int position) {
        // load picture by glid
        RequestBuilder<Drawable> thumbnailRequest = Glide
                        .with(context)
                        .load(album.get(position).getThumbnailUrl());
                Glide
                        .with(context)
                        .load(album.get(position).getUrl())
                        .fitCenter()
                        .thumbnail(thumbnailRequest)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                        .skipMemoryCache(true)
                        .into(holder.ivPicture);
                //set textValue with title value
                holder.tvTitle.setText(album.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return album.size();
    }
}

class PlaceViewHolder extends RecyclerView.ViewHolder {
    //imageview in the cadre view of the recyclerview item
    ImageView ivPicture;
    //TextView in the cadre view of the recyclerview item
    TextView tvTitle;

    public PlaceViewHolder(View itemView) {
        super(itemView);
        ivPicture = itemView.findViewById(R.id.ivPicture);
        tvTitle = itemView.findViewById(R.id.tvTitle);
    }
}
