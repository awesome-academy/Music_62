package com.example.musicplayer.data.source.local;

import com.example.musicplayer.data.model.Track;
import com.example.musicplayer.data.source.TrackDataSource;

public class TrackLocalDataSource implements TrackDataSource.Local {
    private static TrackLocalDataSource sInstance;

    private TrackLocalDataSource() {

    }

    public static TrackLocalDataSource getInstance() {
        if (sInstance == null){
            sInstance = new TrackLocalDataSource();
        }
        return sInstance;
    }

    @Override
    public void getLocalTracks(TrackDataSource.DataCallback<Track> callback) {
        //TODO next
    }
}
