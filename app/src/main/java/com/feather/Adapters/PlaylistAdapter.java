package com.feather.Adapters;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.R;
import com.feather.dataElements.DataPlaylist;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class PlaylistAdapter extends RecyclerView.Adapter<PlaylistAdapter.PlaylistsViewHolder> {
    private ArrayList<DataPlaylist> playlists;
    private FragmentActivity parentActivity;
    private int mCardViewID;
    private DataPlaylist mPlaylist;

    private final OnPlaylistListener onPlaylistListener;

    public interface OnPlaylistListener {
        void OnPlaylistClick(int position, FragmentActivity activity);
    }

    public PlaylistAdapter(ArrayList<DataPlaylist> playlists, OnPlaylistListener onPlaylistListener,
                           FragmentActivity parentActivity, int card_viewID) {
        this.playlists = playlists;
        this.onPlaylistListener = onPlaylistListener;
        this.parentActivity = parentActivity;
        mCardViewID = card_viewID;
    }
    public PlaylistAdapter(DataPlaylist playlist, OnPlaylistListener onPlaylistListener,
                           FragmentActivity parentActivity, int card_viewID) {
        this.playlists = null;
        this.mPlaylist = playlist;
        this.onPlaylistListener = onPlaylistListener;
        this.parentActivity = parentActivity;
        mCardViewID = card_viewID;
    }

    @NonNull
    @Override
    public PlaylistsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mCardViewID,
                parent, false);

        return new PlaylistsViewHolder(view, onPlaylistListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaylistsViewHolder holder, int position) {
        if (playlists != null) {
            //holder.imagePlaylist.setImageResource(playlists.get(position).imagePlaylistID);
        }
    }

    @Override
    public int getItemCount() {
        if (playlists == null) {
            return 1;
        }

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
