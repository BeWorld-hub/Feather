package com.feather;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.dataElements.DataLastSong;

import java.util.Stack;

public class LastSongRecyclerAdapter extends RecyclerView.Adapter<LastSongRecyclerAdapter.CardsViewHolder> {
    Stack<DataLastSong> songs;

    private final OnCardListener onCardListener;

    public interface OnCardListener {
        void onCardClick(int position);
    }

    public LastSongRecyclerAdapter(Stack<DataLastSong> songs, OnCardListener onCardListener) {
        this.songs = songs;
        this.onCardListener = onCardListener;
    }

    @NonNull
    @Override
    public CardsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_last_song,
                parent, false);

        return new CardsViewHolder(view, onCardListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CardsViewHolder holder, int position) {
        holder.imageSong.setImageResource(songs.get(position).mSongImageID);
        holder.songName.setText(songs.get(position).mNameSong);
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class CardsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageSong;
        public TextView songName;
        public OnCardListener onCardListener;

        public CardsViewHolder(@NonNull View itemView, OnCardListener onCardListener) {
            super(itemView);

            imageSong = itemView.findViewById(R.id.imageSong);
            songName = itemView.findViewById(R.id.nameSong);

            this.onCardListener = onCardListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onCardListener.onCardClick(getAdapterPosition());
        }
    }
}