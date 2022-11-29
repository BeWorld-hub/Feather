package com.feather;

import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feather.Handlers.HandlerHistory;
import com.feather.dataElements.DataSong;

import java.util.Stack;

public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        Stack<DataSong> songs = new Stack<>();

        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));
        songs.add(new DataSong("Test", R.drawable.icon_awesome_book_open, 1));


        SearchView searchView = view.findViewById(R.id.searchView);

        HandlerHistory handlerHistory = new HandlerHistory(view, getActivity(),
                R.id.recyclerSearchedHistorySongs);
        handlerHistory.createSearchedHistoryList(songs);

        return view;
    }
}