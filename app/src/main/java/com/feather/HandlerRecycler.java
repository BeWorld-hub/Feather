package com.feather;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.Adapters.PlaylistAdapter;
import com.feather.dataElements.DataPlaylist;

import java.util.ArrayList;

public class HandlerRecycler {
    private View mView;
    private int mRecyclerID;
    private RecyclerView recyclerView;
    private PlaylistAdapter mAdapter;
    private ArrayList<DataPlaylist> playlists;

    public HandlerRecycler(View parentView, int recyclerID) {
        mView = parentView;
        mRecyclerID = recyclerID;

        recyclerView = mView.findViewById(recyclerID);
        playlists = new ArrayList<DataPlaylist>();
    }

    public void createVerticalNonScrollablePlaylists(int playlistsAmount, boolean isScrollable) {
        for (int numPlaylist = 0; numPlaylist < playlistsAmount; numPlaylist++) {
            playlists.add(new DataPlaylist(R.drawable.test));
        }

        mAdapter = new PlaylistAdapter(playlists);

        if (isScrollable) {
            recyclerView.setLayoutManager(new GridLayoutManager(mView.getContext(), 2));
        }
        else {
            recyclerView.setLayoutManager(new GridLayoutManager(mView.getContext(), 2) {
                @Override
                public boolean canScrollVertically() {
                    return false;
                }
            });
        }

        recyclerView.setAdapter(mAdapter);
    }

    public void createHorizontalScrollablePlaylists(int playlistsAmount, int rowAmount) {
        for (int numPlaylist = 0; numPlaylist < playlistsAmount; numPlaylist++) {
            playlists.add(new DataPlaylist(R.drawable.test));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mAdapter = new PlaylistAdapter(playlists);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(mAdapter);
    }
}
