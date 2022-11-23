package com.feather;

import android.view.View;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.Adapters.SongRecyclerAdapter;
import com.feather.dataElements.DataSong;

import java.util.Stack;

public class HandlerRecyclerSongs implements SongRecyclerAdapter.OnSongCardListener {
    private View mView;
    private int mRecyclerID;
    private RecyclerView mRecyclerView;
    private SongRecyclerAdapter mAdapter;
    private Stack<DataSong> mSongs;
    private FragmentActivity mParentActivity;

    public HandlerRecyclerSongs(View parentView, FragmentActivity parentActivity, int recyclerID, Stack<DataSong> songs) {
        mView = parentView;
        mParentActivity = parentActivity;
        mRecyclerID = recyclerID;
        mSongs = songs;
        mRecyclerView = mView.findViewById(recyclerID);
    }
    public HandlerRecyclerSongs(View parentView, FragmentActivity parentActivity, RecyclerView recyclerView, Stack<DataSong> songs) {
        mView = parentView;
        mParentActivity = parentActivity;
        mRecyclerView = recyclerView;
        mSongs = songs;
    }

    public void createSongsList(boolean isScrollable) {
        mAdapter = new SongRecyclerAdapter(mSongs, this, R.layout.card_view_song);

        LinearLayoutManager linearLayoutManager;

        linearLayoutManager = new LinearLayoutManager(mView.getContext()) {
            @Override
            public boolean canScrollVertically() {
                return isScrollable;
            }
        };

        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onSongCardClick(int position) {
        mParentActivity.getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragmentMainActivity, new PlaylistFragment()).commit();
    }
}
