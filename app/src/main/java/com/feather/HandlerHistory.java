package com.feather;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.dataElements.DataSong;

import java.util.ArrayList;
import java.util.Stack;

public class HandlerHistory {
    private View mParentView;
    private FragmentActivity mParentActivity;
    private LinearLayout mFragmentContainer;
    private LinearLayout mListSongs;

    public HandlerHistory(View parentView, FragmentActivity parentActivity) {
        this.mParentView = parentView;
        mFragmentContainer = parentView.findViewById(R.id.fragmentHistory);
        mListSongs = parentView.findViewById(R.id.linearLayoutSongsList);
        mParentActivity = parentActivity;
    }

    public void createHistoryList(ArrayList<Stack<DataSong>> songs) {
        songs.stream().forEach((currentDateSongs) -> {
            TextView nameDay = new TextView(mListSongs.getContext());
            nameDay.setText("TEST");

            RecyclerView recyclerView = new RecyclerView(mListSongs.getContext());
            recyclerView.setTag("test");

            mListSongs.addView(nameDay);
            mListSongs.addView(recyclerView);

            HandlerRecyclerSongs handlerRecyclerSongs = new HandlerRecyclerSongs(mParentView,
                    mParentActivity, recyclerView, currentDateSongs);
            handlerRecyclerSongs.createSongsList();
        });
    }
}
