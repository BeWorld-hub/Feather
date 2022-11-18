package com.feather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class MainFragment extends Fragment {
    Button newFor;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        newFor = (Button) view.findViewById(R.id.newForButton);

        newFor.setOnClickListener(view1 -> {
            NewForFragment newForFragment = new NewForFragment();

            //getParentFragmentManager().beginTransaction().replace(R.id.main_frame, newForFragment).commit();
        });

        return view;
    }
}