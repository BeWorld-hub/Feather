package com.feather.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.R;
import com.feather.dataElements.DataPlaylist;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistsViewHolder> {
    private ArrayList<DataPlaylist> playlists;
    private FragmentActivity parentActivity;

    private final OnPlaylistListener onPlaylistListener;

    public interface OnPlaylistListener {
        void OnPlaylistClick(int position, FragmentActivity activity);
    }

    public PlaylistAdapter(ArrayList<DataPlaylist> playlists, OnPlaylistListener onPlaylistListener, FragmentActivity parentActivity) {
        this.playlists = playlists;
        this.onPlaylistListener = onPlaylistListener;
        this.parentActivity = parentActivity;
    }

    @NonNull
    @Override
    public PlaylistsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_playlist,
                parent, false);

        return new PlaylistsViewHolder(view, onPlaylistListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistsViewHolder holder, int position) {
        holder.imagePlaylist.setImageResource(playlists.get(position).imagePlaylistID);
    }

    @Override
    public int getItemCount() {
        return playlists.size();
    }

    class PlaylistsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imagePlaylist;
        public OnPlaylistListener onPlaylistListener;

        public PlaylistsViewHolder(@NonNull View itemView, OnPlaylistListener onPlaylistListener) {
            super(itemView);

            imagePlaylist = itemView.findViewById(R.id.imagePlaylist);
            this.onPlaylistListener = onPlaylistListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onPlaylistListener.OnPlaylistClick(getAdapterPosition(), parentActivity);
        }
    }
}
