package com.feather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class BasicConstructionFragment extends Fragment implements NavigationBarView.OnItemSelectedListener {
    private BottomNavigationView mMenu;

    private MainFragment mMainFragment;
    private PlaylistsFragment mPlaylistsFragment;
    private StreamingFragment mStreamingFragment;
    private ProfileFragment mProfileFragment;

    public BasicConstructionFragment() {
        super(R.layout.fragment_basic_construction);

        mMainFragment = new MainFragment();
        mPlaylistsFragment = new PlaylistsFragment();
        mStreamingFragment = new StreamingFragment();
        mProfileFragment = new ProfileFragment();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_basic_construction, container, false);

        if (savedInstanceState == null) {
            getParentFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.fragmentMain, MainFragment.class, null).commit();
        }

        mMenu = view.findViewById(R.id.bottom_menu);
        mMenu.setOnItemSelectedListener(this);


        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        Fragment newFragment = new Fragment();

        if (item.getItemId() == R.id.mainButtonMenu) {
            newFragment = mMainFragment;
        }
        else if (item.getItemId() == R.id.playlistsButtonMenu) {
            newFragment = mPlaylistsFragment;
        }
        else if (item.getItemId() == R.id.streamingButtonMenu) {
            newFragment = mStreamingFragment;
        }
        else if (item.getItemId() == R.id.profileButtonMenu) {
            newFragment = mProfileFragment;
        }
        fragmentTransaction.setReorderingAllowed(true).replace(R.id.fragmentMain, newFragment).commit();

        return false;
    }
}