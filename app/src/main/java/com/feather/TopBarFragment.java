package com.feather;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TopBarFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_bar, container, false);

        getFragmentManager().beginTransaction().setReorderingAllowed(true)
                .add(R.id.fragmentContent, PlaylistContentFragment.class, null).commit();

        return view;
    }
}