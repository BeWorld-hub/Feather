package com.feather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feather.Handlers.HandlerHistory;
import com.feather.dataElements.DataSong;

import java.util.ArrayList;
import java.util.Stack;

public class HistoryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        Stack<DataSong> stack1 = new Stack<>();
        Stack<DataSong> stack2 = new Stack<>();

        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 1));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 2));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 3));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 1));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 2));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 3));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 1));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 2));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 3));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 1));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 2));
        stack1.add(new DataSong("test", R.drawable.icon_awesome_book_open, 3));

        stack2.add(new DataSong("test", R.drawable.icon_awesome_book_open, 3));
        stack2.add(new DataSong("test", R.drawable.icon_awesome_book_open, 4));


        ArrayList<Stack<DataSong>> arrayList = new ArrayList<>();
        arrayList.add(stack1);
        arrayList.add(stack2);

        HandlerHistory handlerHistory = new HandlerHistory(view, getActivity());
        handlerHistory.createListenedHistoryList(arrayList);

        return view;
    }
}