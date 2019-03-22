package com.example.musicplayer.utils;

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

    public static String initLyricApi(String trackIdMusix) {
        return String.format(Constants.MusixMatch.BASE_URL_LYRIC
                , trackIdMusix
                , Constants.MusixMatch.API_KEY);
    }

    public static String initSearchSmApi(String keySearch, int limit, int offset) {
        return String.format(Constants.MusixMatch.BASE_URL_SEARCH
                , Constants.SoundClound.API_KEY
                , keySearch);
    }


    public static String initGenreApi(String genName, String kind) {
        return String.format(Constants.SoundClound.BASE_URL_GENRE
                , kind
                , genName
                , Constants.SoundClound.API_KEY
                , Constants.Genre.LIMIT
                , Constants.Genre.OFFSET);
    }

    public static String initStreamUrl(int trackId) {
        return String.format(Constants.SoundClound.BASE_URL_STREAM
                , trackId
                , Constants.SoundClound.API_KEY);
    }

    public static String initDownloadUrl(int trackId) {
        return String.format(Constants.SoundClound.BASE_URL_DOWNLOAD
                , trackId
                , Constants.SoundClound.API_KEY);
    }

    public static String initSearchScApi(String keySearch, int limit, int offset) {
        return String.format(Constants.SoundClound.BASE_URL_SEARCH
                , keySearch
                , Constants.SoundClound.API_KEY
                , limit
                , offset);
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
