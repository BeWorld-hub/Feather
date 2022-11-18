package com.feather;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity implements NavigationBarView.OnItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    MainFragment mainFragment = new MainFragment();
    PlaylistsFragment playlistsFragment = new PlaylistsFragment();
    StreamingFragment streamingFragment = new StreamingFragment();
    ProfileFragment profileFragment = new ProfileFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);

        bottomNavigationView = findViewById(R.id.bottom_menu);

        bottomNavigationView.setOnItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.main);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.main:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, mainFragment).commit();
                return true;
            case R.id.playlists:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, playlistsFragment).commit();
                return true;
            case R.id.streaming:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, streamingFragment).commit();
                return true;
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, profileFragment).commit();
                return true;
        }
        return false;
    }
    /*
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == )
        }
    }

*/
}