package com.feather;

import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
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

    public void createPlaylists(int playlistsAmount, boolean isScrollable, int orientation, int spanCount) {
        for (int numPlaylist = 0; numPlaylist < playlistsAmount; numPlaylist++) {
            playlists.add(new DataPlaylist(R.drawable.icon_awesome_book_open));
        }

        mAdapter = new PlaylistAdapter(playlists, (PlaylistAdapter.OnPlaylistListener) this, mParentActivity);
        GridLayoutManager gridLayoutManager;

        if (orientation == GridLayoutManager.HORIZONTAL) {
            gridLayoutManager = new GridLayoutManager(mView.getContext(), spanCount) {
                @Override
                public boolean canScrollHorizontally() {
                    return isScrollable;
                }
            };
        }
        else {
            gridLayoutManager = new GridLayoutManager(mView.getContext(), spanCount) {
                @Override
                public boolean canScrollVertically() {
                    return isScrollable;
                }
            };
        }

        gridLayoutManager.setOrientation(orientation);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void OnPlaylistClick(int position, FragmentActivity activity) {
        activity.getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragmentMainActivity, new PlaylistFragment()).commit();
    }
}
