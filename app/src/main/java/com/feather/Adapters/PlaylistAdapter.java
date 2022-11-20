package com.feather.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.R;
import com.feather.dataElements.DataPlaylist;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistsViewHolder> {
    private ArrayList<DataPlaylist> playlists;

    public PlaylistAdapter(ArrayList<DataPlaylist> playlists) {
        this.playlists = playlists;
    }

    @NonNull
    @Override
    public PlaylistsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_playlist,
                parent, false);

        return new PlaylistsViewHolder(view);
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

        public PlaylistsViewHolder(@NonNull View itemView) {
            super(itemView);

            imagePlaylist = itemView.findViewById(R.id.imagePlaylist);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
