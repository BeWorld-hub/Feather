package com.feather.dataElements;

public class DataSong {
    public String mNameSong;
    public int mSongImageID;
    private int mSongID;

    public DataSong(String nameSong, int imageID, int songID) {
        mNameSong = nameSong;
        mSongImageID = imageID;
        mSongID = songID;
    }
}
