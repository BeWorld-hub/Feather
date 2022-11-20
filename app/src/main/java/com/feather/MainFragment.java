package com.feather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.feather.dataElements.DataLastSong;

import java.util.Stack;

public class MainFragment extends Fragment implements View.OnClickListener, LastSongRecyclerAdapter.OnCardListener {
    private Button mNewForButton;
    private View mView;
    private NewForFragment mNewForFragment;

    private Stack<DataLastSong> lastSongs;

    private void initalizeData() {
        lastSongs = new Stack<DataLastSong>();

        lastSongs.add(new DataLastSong("test", R.drawable.icon_awesome_book_open, 1));
        lastSongs.add(new DataLastSong("test", R.drawable.icon_awesome_book_open, 1));
        lastSongs.add(new DataLastSong("test", R.drawable.icon_awesome_book_open, 1));
        lastSongs.add(new DataLastSong("test", R.drawable.icon_awesome_book_open, 1));
        lastSongs.add(new DataLastSong("test", R.drawable.icon_awesome_book_open, 1));
        lastSongs.add(new DataLastSong("test", R.drawable.icon_awesome_book_open, 1));
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main, container, false);

        mNewForButton = (Button) mView.findViewById(R.id.newForButton);
        mNewForButton.setOnClickListener(this);

        mNewForFragment = new NewForFragment();

        initalizeData();
        RecyclerView recyclerView = mView.findViewById(R.id.recyclerLastSongs);
        recyclerView.setLayoutManager(new GridLayoutManager(mView.getContext(), 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });

        LastSongRecyclerAdapter recyclerAdapter = new LastSongRecyclerAdapter(lastSongs, this);
        recyclerView.setAdapter(recyclerAdapter);

        return mView;
    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        if (view.getId() == R.id.newForButton) {
            fragmentTransaction.setReorderingAllowed(true).replace(R.id.fragmentMainActivity, mNewForFragment).commit();
        }
    }

    @Override
    public void onCardClick(int position) {
        getActivity().getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragmentMainActivity, new PlaylistFragment()).commit();
    }
}