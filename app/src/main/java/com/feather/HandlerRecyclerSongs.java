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
    private RecyclerView recyclerView;
    private SongRecyclerAdapter mAdapter;
    private Stack<DataSong> mSongs;
    private FragmentActivity mParentActivity;

    public HandlerRecyclerSongs(View parentView, FragmentActivity parentActivity, int recyclerID, Stack<DataSong> songs) {
        mView = parentView;
        mParentActivity = parentActivity;
        mRecyclerID = recyclerID;
        mSongs = songs;
        recyclerView = mView.findViewById(recyclerID);
    }

    public void createSongsList() {
        mAdapter = new SongRecyclerAdapter(mSongs, this, R.layout.card_view_song);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onSongCardClick(int position) {

    }
}
