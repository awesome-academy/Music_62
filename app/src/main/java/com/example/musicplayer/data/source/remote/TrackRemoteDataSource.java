package com.example.musicplayer.data.source.remote;

import android.os.AsyncTask;

import com.example.musicplayer.data.model.Track;
import com.example.musicplayer.data.source.TrackDataSource;

public class TrackRemoteDataSource implements TrackDataSource.Remote {
    @Override
    public void searchRemoteTracks(String url, DataCallback<Track> callback) {
        new TrackRemoteAsyncTask(callback)
                .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, url);
    }

    @Override
    public void getRemoteTracks(String url, DataCallback<Track> callback) {
        new TrackRemoteAsyncTask(callback)
                .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, url);
    }
}
