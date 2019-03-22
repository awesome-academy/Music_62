package com.example.musicplayer.utils;

public interface Constants {

    interface MusixMatch {
        String API_KEY = "15b11b810da0b7922ac9bd9b85395054";
        String BASE_URL_SEARCH = "http://api.musixmatch.com/ws/1.1/track.search?" +
                "apikey=%s&q_track=%s&page_size=1";
        String BASE_URL_LYRIC = "https://api.musixmatch.com/ws/1.1/track.lyrics.get?" +
                "format=jsonp&callback=callback&track_id=%s&apikey=%s";
    }

    interface SoundClound {
        String API_KEY = "PBilYl3cVAK9m3Vqg4TEPlhWAO4okIJ0";
        String BASE_URL_GENRE
                = "https://api-v2.soundcloud.com/charts?kind=%s&genre=soundcloud%3Agenres%3A%s" +
                "&client_id=%s&limit=%d&offset=%d";
        String BASE_URL_SEARCH
                = "http://api.soundcloud.com/tracks?q=%s&client_id=%s&limit=%d&offset=%d";
        String BASE_URL_STREAM
                = "https://api.soundcloud.com/tracks/%s/stream?client_id=%s";
        String BASE_URL_DOWNLOAD
                = "https://api.soundcloud.com/tracks/%s/download?client_id=%s";
    }

    interface Genre {
        String ARTWORK_URL = "artwork_url";
        String DURATION = "duration";
        String COLLECTION = "collection";
        String ID = "id";
        String KEY_USER = "user";
        String KEY_USER_NAME = "username";
        String TITLE = "title";
        String TRACK = "track";
        String DOWNLOADABLE = "downloadable";
        int LIMIT = 50;
        int OFFSET = 0;
    }

}
