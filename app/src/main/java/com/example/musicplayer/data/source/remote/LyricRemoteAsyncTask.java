package com.example.musicplayer.data.source.remote;

import com.example.musicplayer.data.source.TrackDataSource;

import java.util.List;

public class LyricRemoteAsyncTask extends BaseRemoteAsyncTask {

    public LyricRemoteAsyncTask(TrackDataSource.DataCallback callback) {
        super(callback);
    }

    @Override
    public List convertJson(String jsonString) {
        return null;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        return null;
    }
}
