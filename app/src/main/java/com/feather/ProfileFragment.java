package com.feather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.feather.dataElements.DataPlaylist;
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

        songs = new Stack<>();
        songs.add(new DataSong("test", R.drawable.test, 1));
        songs.add(new DataSong("test", R.drawable.icon_awesome_book_open, 2));
        songs.add(new DataSong("test", R.drawable.icon_awesome_book_open, 3));
        songs.add(new DataSong("test", R.drawable.icon_awesome_book_open, 4));

        DataPlaylist dataPlaylist = new DataPlaylist(R.drawable.icon_awesome_book_open);
        HandlerRecyclerPlaylists handlerRecyclerPlaylists = new HandlerRecyclerPlaylists(
          view, R.id.recyclerFavouritePlaylist, getActivity());
        handlerRecyclerPlaylists.createPlaylist(dataPlaylist,
                R.layout.card_view_favourite_playlist);

        HandlerRecyclerPlaylists handlerRecyclerSongListProfile = new HandlerRecyclerPlaylists(
                view, R.id.recyclerProfileSongList, getActivity());
        handlerRecyclerSongListProfile.createPlaylists(6, true,
                GridLayout.VERTICAL, 1, R.layout.card_view_horizontal_playlist);

        return view;
    }
}