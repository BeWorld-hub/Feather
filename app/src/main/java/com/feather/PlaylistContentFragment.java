package com.feather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.feather.dataElements.DataSong;

import java.util.Stack;

public class PlaylistContentFragment extends Fragment {
    public PlaylistContentFragment() {
        super(R.layout.fragment_playlist_content);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist_content, container, false);

        Stack<DataSong> songs = new Stack<>();
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));
        songs.add(new DataSong("TEST", R.drawable.test2, 1));


        HandlerRecyclerSongs handlerRecyclerSongs = new HandlerRecyclerSongs(
                view, getActivity(), R.id.recyclerPlaylistSongs, songs);
        handlerRecyclerSongs.createSongsList(true);

        return view;
    }
}