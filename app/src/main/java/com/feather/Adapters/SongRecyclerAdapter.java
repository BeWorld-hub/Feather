package com.feather.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.R;
import com.feather.dataElements.DataSong;

import java.util.Stack;

public class SongRecyclerAdapter extends RecyclerView.Adapter<SongRecyclerAdapter.SongsViewHolder> {
    private Stack<DataSong> mSongs;
    private int mCardViewID;


    private final OnSongCardListener onSongCardListener;

    public interface OnSongCardListener {
        void onSongCardClick(int position);
    }

    public SongRecyclerAdapter(Stack<DataSong> songs, OnSongCardListener onCardListener, int cardViewID) {
        this.mSongs = songs;
        this.onSongCardListener = onCardListener;
        mCardViewID = cardViewID;
    }

    @NonNull
    @Override
    public SongsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mCardViewID,
                parent, false);

        return new SongsViewHolder(view, onSongCardListener);
    }

    @Override
    public void onBindViewHolder(@NonNull SongsViewHolder holder, int position) {
        holder.imageSong.setImageResource(mSongs.get(position).mSongImageID);
        holder.songName.setText(mSongs.get(position).mNameSong);
    }

    @Override
    public int getItemCount() {
        return mSongs.size();
    }

    class SongsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageSong;
        public TextView songName;
        public OnSongCardListener onCardListener;

        public SongsViewHolder(@NonNull View itemView, OnSongCardListener onCardListener) {
            super(itemView);

            imageSong = itemView.findViewById(R.id.imageSong);
            songName = itemView.findViewById(R.id.nameSong);

            this.onCardListener = onCardListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCardListener.onSongCardClick(getAdapterPosition());
        }
    }
}