package com.feather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class NewForFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_for, container, false);

        HandlerRecyclerPlaylists handlerRecyclerNewForYou = new HandlerRecyclerPlaylists(view,
                R.id.recyclerNewForYou, getActivity());
        handlerRecyclerNewForYou.createPlaylists(8, true, GridLayoutManager.HORIZONTAL, 2);

        HandlerRecyclerPlaylists handlerRecyclerYouSubscribe = new HandlerRecyclerPlaylists(view,
                R.id.recyclerYouSubscribe, getActivity());
        handlerRecyclerYouSubscribe.createPlaylists(6, false, GridLayoutManager.VERTICAL, 2);

        return view;
    }
}