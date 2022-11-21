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

import com.feather.Adapters.LastSongRecyclerAdapter;
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

        RecyclerView recyclerLastSongs = mView.findViewById(R.id.recyclerLastSongs);
        recyclerLastSongs.setLayoutManager(new GridLayoutManager(mView.getContext(), 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        LastSongRecyclerAdapter lastSongsRecyclerAdapter = new LastSongRecyclerAdapter(lastSongs, this);
        recyclerLastSongs.setAdapter(lastSongsRecyclerAdapter);

        HandlerRecyclerPlaylists handlerRecyclerPlaylists = new HandlerRecyclerPlaylists(mView, R.id.recyclerPlaylistsNewForYou, getActivity());
        handlerRecyclerPlaylists.createVerticalNonScrollablePlaylists(4, false);

        HandlerRecyclerPlaylists handlerRecyclerAtTrend = new HandlerRecyclerPlaylists(mView, R.id.recyclerAtTrend, getActivity());
        handlerRecyclerAtTrend.createVerticalNonScrollablePlaylists(4, false);

        HandlerRecyclerPlaylists handlerRecyclerMusicalSelections = new HandlerRecyclerPlaylists(mView, R.id.recyclerMusicalSelections, getActivity());
        handlerRecyclerMusicalSelections.createHorizontalScrollablePlaylists(4, 1);



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