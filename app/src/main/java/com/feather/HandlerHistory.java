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

    public HandlerHistory(View parentView, FragmentActivity parentActivity) {
        this.mParentView = parentView;
        mFragmentContainer = parentView.findViewById(R.id.fragmentHistory);
    }

    public void createHistoryList(ArrayList<Stack<DataSong>> songs) {
        songs.stream().forEach((currentDateSongs) -> {
            TextView nameDay = new TextView(mFragmentContainer.getContext());

            /*
            я здесь должен создавать recyclerview, его внутренний контейнер
            и каждый раз через handlerSongs динамически его заполнять,
            после чего добавлять этот recycler в фрагмент
             */
            nameDay.setText("TEST");

            //HandlerRecyclerSongs handlerRecyclerSongs = new HandlerRecyclerSongs();

            RecyclerView recyclerView = new RecyclerView(mFragmentContainer.getContext());
        });
    }
}
