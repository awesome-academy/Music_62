package com.example.musicplayer.data.source.remote;

import com.example.musicplayer.data.model.Track;
import com.example.musicplayer.data.source.TrackDataSource;
import com.example.musicplayer.utils.StringUtil;

import org.json.JSONException;

import java.util.List;

public class TrackRemoteAsyncTask extends BaseRemoteAsyncTask<Track> {

    public TrackRemoteAsyncTask(TrackDataSource.DataCallback<Track> callback) {
        super(callback);
    }

    @Override
    public List convertJson(String jsonString) {
        try {
            return StringUtil.parseTrack(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
