package com.feather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feather.dataElements.DataSong;

import java.util.Stack;


public class ProfileFragment extends Fragment {
    Stack<DataSong> songs;

    public ProfileFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        songs = new Stack<DataSong>();
        songs.add(new DataSong("test", R.drawable.test, 1));
        songs.add(new DataSong("test", R.drawable.icon_awesome_book_open, 2));
        songs.add(new DataSong("test", R.drawable.icon_awesome_book_open, 3));
        songs.add(new DataSong("test", R.drawable.icon_awesome_book_open, 4));

        HandlerRecyclerSongs handlerRecyclerSongs = new HandlerRecyclerSongs(view, getActivity(),
                R.id.recyclerProfileSongs, songs);

        handlerRecyclerSongs.createSongsList(false);

        return view;
    }
}