package com.example.musicplayer.data.repository;

import com.example.musicplayer.data.model.Track;
import com.example.musicplayer.data.source.TrackDataSource;

public class TrackRepository implements TrackDataSource.Local, TrackDataSource.Remote {
    private TrackRepository sInstance;
    private TrackDataSource.Local mLocal;
    private TrackDataSource.Remote mRemote;

    private TrackRepository(Local local, Remote remote) {
        mLocal = local;
        mRemote = remote;
    }

    public TrackRepository getsInstance(Local local , Remote remote) {
        if (sInstance == null) {
            sInstance = new TrackRepository(local, remote);
        }
        return sInstance;
    }

    @Override
    public void getLocalTracks(DataCallback<Track> callback) {
        mLocal.getLocalTracks(callback);
    }

    @Override
    public void searchRemoteTracks(String url, DataCallback<Track> callback) {
        mRemote.searchRemoteTracks(url, callback);
    }

    @Override
    public void getRemoteTracks(String url, DataCallback<Track> callback) {
        mRemote.getRemoteTracks(url, callback);
    }
}
