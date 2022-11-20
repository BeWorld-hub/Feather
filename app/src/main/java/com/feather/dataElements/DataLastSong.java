package com.feather.dataElements;

public class DataLastSong {
    public String mNameSong;
    public int mSongImageID;
    private int mSongID;

    public DataLastSong(String nameSong, int imageID, int songID) {
        mNameSong = nameSong;
        mSongImageID = imageID;
        mSongID = songID;
    }
}
