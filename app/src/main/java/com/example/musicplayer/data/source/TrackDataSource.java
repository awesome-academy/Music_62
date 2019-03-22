package com.example.musicplayer.data.source;

import android.provider.ContactsContract;

import com.example.musicplayer.data.model.Track;

import java.util.List;

public interface TrackDataSource {

    interface DataCallback<T> {
        void onSuccess(List<T> data);

        void onFail(String message);
    }

    interface Local {
        void getLocalTracks(DataCallback<Track> callback);
    }

    interface Remote extends TrackDataSource {
        void searchRemoteTracks(String url, DataCallback<Track> callback);

        void getRemoteTracks(String url, DataCallback<Track> callback);
    }
}
