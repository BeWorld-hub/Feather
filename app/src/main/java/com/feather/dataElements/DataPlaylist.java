package com.feather.dataElements;


import java.util.ArrayList;

public class DataPlaylist {
    public int imagePlaylistID;
    private ArrayList<Integer> songsID;

    public DataPlaylist(int imageID) {
        imagePlaylistID = imageID;
    }

    public ArrayList<Integer> getSongsID() {
        return songsID;
    }
}
