package com.feather;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class TopAndNavBarsFragment extends Fragment implements NavigationBarView.OnItemSelectedListener, View.OnClickListener {
    private BottomNavigationView mMenu;
    private ImageButton mButtonSetting;
    private ImageButton mButtonHistory;
    private ImageButton mButtonSearch;

    private MainFragment mMainFragment;
    private PlaylistsFragment mPlaylistsFragment;
    private StreamingFragment mStreamingFragment;
    private ProfileFragment mProfileFragment;
    private SettingsFragment mSettingsFragment;
    private HistoryFragment mHistoryFragment;
    private SearchFragment mSearchFragment;

    public TopAndNavBarsFragment() {
        super(R.layout.fragment_top_and_nav_bars);

        mMainFragment = new MainFragment();
        mPlaylistsFragment = new PlaylistsFragment();
        mStreamingFragment = new StreamingFragment();
        mProfileFragment = new ProfileFragment();
        mSettingsFragment = new SettingsFragment();
        mHistoryFragment = new HistoryFragment();
        mSearchFragment = new SearchFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_top_and_nav_bars, container, false);

        if (savedInstanceState == null) {
            getParentFragmentManager().beginTransaction().setReorderingAllowed(true)
                    .add(R.id.fragmentMain, MainFragment.class, null).commit();
        }

        mMenu = view.findViewById(R.id.bottom_menu);
        mMenu.setOnItemSelectedListener(this);

        mButtonSetting = view.findViewById(R.id.buttonSettings);
        mButtonSetting.setOnClickListener(this);

        mButtonHistory = view.findViewById(R.id.buttonHistory);
        mButtonHistory.setOnClickListener(this);

        mButtonSearch = view.findViewById(R.id.buttonSearch);
        mButtonSearch.setOnClickListener(this);


        return view;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        Fragment newFragment = new Fragment();

        if (item.getItemId() == R.id.mainButtonMenu) {
            newFragment = mMainFragment;
        } else if (item.getItemId() == R.id.playlistsButtonMenu) {
            newFragment = mPlaylistsFragment;
        } else if (item.getItemId() == R.id.streamingButtonMenu) {
            newFragment = mStreamingFragment;
        } else if (item.getItemId() == R.id.profileButtonMenu) {
            newFragment = mProfileFragment;
        }
        fragmentTransaction.setReorderingAllowed(true).replace(R.id.fragmentMain, newFragment).commit();

        return false;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager()
                .beginTransaction().setReorderingAllowed(true);

        if (view.getId() == R.id.buttonSettings){
            fragmentTransaction.replace(R.id.fragmentMainActivity, mSettingsFragment).commit();
        }
        else if (view.getId() == R.id.buttonHistory) {
            fragmentTransaction.replace(R.id.fragmentMainActivity, mHistoryFragment).commit();
        }
        else if (view.getId() == R.id.buttonSearch) {
            fragmentTransaction.replace(R.id.fragmentMainActivity, mSearchFragment).commit();
        }
    }
}