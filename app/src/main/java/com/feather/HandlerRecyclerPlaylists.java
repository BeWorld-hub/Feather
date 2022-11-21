package com.feather;

import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.Adapters.PlaylistAdapter;
import com.feather.dataElements.DataPlaylist;

import java.util.ArrayList;

public class HandlerRecyclerPlaylists implements PlaylistAdapter.OnPlaylistListener {
    private View mView;
    private int mRecyclerID;
    private RecyclerView recyclerView;
    private PlaylistAdapter mAdapter;
    private ArrayList<DataPlaylist> playlists;
    private FragmentActivity mParentActivity;

    public HandlerRecyclerPlaylists(View parentView, int recyclerID, FragmentActivity parentActivity) {
        mView = parentView;
        mRecyclerID = recyclerID;

        recyclerView = mView.findViewById(recyclerID);
        playlists = new ArrayList<DataPlaylist>();
        mParentActivity = parentActivity;
    }

    public void createVerticalNonScrollablePlaylists(int playlistsAmount, boolean isScrollable) {
        for (int numPlaylist = 0; numPlaylist < playlistsAmount; numPlaylist++) {
            playlists.add(new DataPlaylist(R.drawable.icon_awesome_book_open));
        }

        mAdapter = new PlaylistAdapter(playlists, (PlaylistAdapter.OnPlaylistListener) this, mParentActivity);

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
            playlists.add(new DataPlaylist(R.drawable.icon_awesome_book_open));
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);

        mAdapter = new PlaylistAdapter(playlists, (PlaylistAdapter.OnPlaylistListener) this, mParentActivity);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void OnPlaylistClick(int position, FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragmentMainActivity, new PlaylistFragment()).commit();
    }
}
