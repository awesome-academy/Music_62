package com.example.musicplayer.utils;

import android.net.Uri;
import com.example.musicplayer.data.model.Track;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import static com.example.musicplayer.utils.Constants.Genre.ARTWORK_URL;
import static com.example.musicplayer.utils.Constants.Genre.COLLECTION;
import static com.example.musicplayer.utils.Constants.Genre.DOWNLOADABLE;
import static com.example.musicplayer.utils.Constants.Genre.DURATION;
import static com.example.musicplayer.utils.Constants.Genre.ID;
import static com.example.musicplayer.utils.Constants.Genre.KEY_USER;
import static com.example.musicplayer.utils.Constants.Genre.KEY_USER_NAME;
import static com.example.musicplayer.utils.Constants.Genre.TITLE;
import static com.example.musicplayer.utils.Constants.Genre.TRACK;

public class StringUtil {
    private static Uri.Builder sBuilder;

    public static String initLyricApi(String trackIdMusix) {
        sBuilder.scheme("https")
                .authority("api.musixmatch.com")
                .appendPath("ws")
                .appendPath("1.1")
                .appendPath("track.lyrics.get")
                .appendQueryParameter("format", "jsonp")
                .appendQueryParameter("callback", "callback")
                .appendQueryParameter("track_id", trackIdMusix)
                .appendQueryParameter("apikey", "");
        return sBuilder.build().toString();
    }

    public static List<Track> parseTrack(String jsonString) throws JSONException {
        List<Track> tracks = new ArrayList<>();
        JSONObject result = new JSONObject(jsonString);
        JSONArray collection = result.getJSONArray(COLLECTION);
        for (int i = 0; i < collection.length(); i++) {
            JSONObject trackDetail = collection.getJSONObject(i);
            JSONObject track = trackDetail.getJSONObject(TRACK);
            int id = track.getInt(ID);
            long duration = track.getLong(DURATION);
            String title = track.getString(TITLE);
            String artworkUrl = track.getString(ARTWORK_URL);
            String streamUrl = StringUtil.initStreamUrl(id);
            String artist = track.getJSONObject(KEY_USER)
                    .getString(KEY_USER_NAME);
            boolean isDownloadable = track.getBoolean(DOWNLOADABLE);
            String downloadUrl = StringUtil.initDownloadUrl(id);
            if (isDownloadable) {
                downloadUrl = StringUtil.initDownloadUrl(id);
            }
            Track trackObject = new Track(id, duration, title, artist,
                    streamUrl, downloadUrl, artworkUrl, isDownloadable);
            tracks.add(trackObject);
        }
        return tracks;
    }
}
