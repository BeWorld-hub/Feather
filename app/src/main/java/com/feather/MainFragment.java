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

import com.feather.Adapters.SongRecyclerAdapter;
import com.feather.Handlers.HandlerRecyclerPlaylists;
import com.feather.dataElements.DataSong;

import java.util.Stack;

public class MainFragment extends Fragment implements View.OnClickListener, SongRecyclerAdapter.OnSongCardListener {
    private Button mNewForButton;
    private View mView;
    private NewForFragment mNewForFragment;

    private Stack<DataSong> lastSongs;

    private void initalizeData() {
        lastSongs = new Stack<DataSong>();

        lastSongs.add(new DataSong("test", R.drawable.test2, 1));
        lastSongs.add(new DataSong("test", R.drawable.test2, 1));
        lastSongs.add(new DataSong("test", R.drawable.test2, 1));
        lastSongs.add(new DataSong("test", R.drawable.test2, 1));
        lastSongs.add(new DataSong("test", R.drawable.test2, 1));
        lastSongs.add(new DataSong("test", R.drawable.test2, 1));
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
        SongRecyclerAdapter lastSongsRecyclerAdapter = new SongRecyclerAdapter(lastSongs, this, R.layout.card_view_last_song);
        recyclerLastSongs.setAdapter(lastSongsRecyclerAdapter);

        HandlerRecyclerPlaylists handlerRecyclerPlaylists = new HandlerRecyclerPlaylists(mView, R.id.recyclerPlaylistsNewForYou, getActivity());
        handlerRecyclerPlaylists.createPlaylists(4, false, GridLayoutManager.VERTICAL, 2, R.layout.card_view_playlist);

        HandlerRecyclerPlaylists handlerRecyclerAtTrend = new HandlerRecyclerPlaylists(mView, R.id.recyclerAtTrend, getActivity());
        handlerRecyclerAtTrend.createPlaylists(4, false, GridLayoutManager.VERTICAL, 2, R.layout.card_view_playlist);

        HandlerRecyclerPlaylists handlerRecyclerMusicalSelections = new HandlerRecyclerPlaylists(mView, R.id.recyclerMusicalSelections, getActivity());
        handlerRecyclerMusicalSelections.createPlaylists(4, true, GridLayoutManager.HORIZONTAL, 1, R.layout.card_view_playlist);



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
    public void onSongCardClick(int position) {
        getActivity().getSupportFragmentManager().beginTransaction().setReorderingAllowed(true)
                .replace(R.id.fragmentMainActivity, new PlaylistFragment()).commit();
    }
}