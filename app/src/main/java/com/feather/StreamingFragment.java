package com.feather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class StreamingFragment extends Fragment {

    public StreamingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_streaming, container, false);

        HandlerRecyclerPlaylists handlerRecyclerOnAir = new HandlerRecyclerPlaylists(view,
                R.id.recyclerOnAir, getActivity());
        handlerRecyclerOnAir.createPlaylists(8, true,
                GridLayoutManager.HORIZONTAL, 2);

        HandlerRecyclerPlaylists handlerRecyclerPremiers = new HandlerRecyclerPlaylists(view,
                R.id.recyclerPremiers, getActivity());
        handlerRecyclerPremiers.createPlaylists(4, false,
                GridLayoutManager.VERTICAL, 2);

        return view;
    }
}