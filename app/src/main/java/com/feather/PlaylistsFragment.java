package com.feather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlaylistsFragment extends Fragment {

    public PlaylistsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlists, container, false);

        HandlerRecyclerPlaylists handlerRecyclerNewPlaylists = new HandlerRecyclerPlaylists(view,
                R.id.recyclerNewPlaylists, getActivity());
        handlerRecyclerNewPlaylists.createPlaylists(4, false,
                GridLayoutManager.VERTICAL, 2, R.layout.card_view_playlist);

        HandlerRecyclerPlaylists handlerRecyclerAtTrendPlaylists = new HandlerRecyclerPlaylists(view,
                R.id.recyclerAtTrendPlaylists, getActivity());
        handlerRecyclerAtTrendPlaylists.createPlaylists(4, false,
                GridLayoutManager.VERTICAL, 2, R.layout.card_view_playlist);

        HandlerRecyclerPlaylists handlerRecyclerSelectionPlaylists = new HandlerRecyclerPlaylists(view,
                R.id.recyclerSelectionPlaylists, getActivity());
        handlerRecyclerSelectionPlaylists.createPlaylists(4, true,
                GridLayoutManager.HORIZONTAL, 1, R.layout.card_view_playlist);

        return view;
    }
}