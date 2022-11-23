package com.feather;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.dataElements.DataSong;

import java.util.ArrayList;
import java.util.Stack;

public class HandlerHistory {
    private View mParentView;
    private FragmentActivity mParentActivity;
    private LinearLayout mListSongs;
    private RecyclerView mRecyclerSongs;

    public HandlerHistory(View parentView, FragmentActivity parentActivity,
                          int containerSongsID) {
        this.mParentView = parentView;
        mParentActivity = parentActivity;
        mRecyclerSongs = parentView.findViewById(containerSongsID);
    }
    public HandlerHistory(View parentView, FragmentActivity parentActivity) {
        this.mParentView = parentView;
        mParentActivity = parentActivity;
    }

    public void createListenedHistoryList(ArrayList<Stack<DataSong>> songs) {
        mListSongs = mParentView.findViewById(R.id.linearLayoutListenedSongsList);

        songs.stream().forEach((currentDateSongs) -> {
            TextView nameDay = new TextView(mListSongs.getContext());
            nameDay.setText("TEST");

            RecyclerView recyclerView = new RecyclerView(mListSongs.getContext());

            mListSongs.addView(nameDay);
            mListSongs.addView(recyclerView);

            HandlerRecyclerSongs handlerRecyclerSongs = new HandlerRecyclerSongs(mParentView,
                    mParentActivity, recyclerView, currentDateSongs);
            handlerRecyclerSongs.createSongsList(false);
        });
    }

    public void createSearchedHistoryList(Stack<DataSong> songs) {
        HandlerRecyclerSongs handlerRecyclerSongs = new HandlerRecyclerSongs(mParentView,
                mParentActivity, mRecyclerSongs, songs);
        handlerRecyclerSongs.createSongsList(true);
    }


}
