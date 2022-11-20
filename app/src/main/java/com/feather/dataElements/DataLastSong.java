package com.feather.dataElements;

public class DataLastSong {
    private String mNameSong;
    private int mSongImageID;
    private int mSongID;

    public DataLastSong(String nameSong, int imageID, int songID) {
        mNameSong = nameSong;
        mSongImageID = imageID;
        mSongID = songID;
    }

    public int getSongID() { return mSongID; }
}
