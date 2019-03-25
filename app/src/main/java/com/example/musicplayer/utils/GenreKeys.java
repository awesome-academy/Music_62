package com.example.musicplayer.utils;

import android.support.annotation.StringDef;
import static com.example.musicplayer.utils.GenreKeys.ARTWORK_URL;
import static com.example.musicplayer.utils.GenreKeys.COLLECTION;
import static com.example.musicplayer.utils.GenreKeys.DURATION;
import static com.example.musicplayer.utils.GenreKeys.ID;
import static com.example.musicplayer.utils.GenreKeys.KEY_USER;
import static com.example.musicplayer.utils.GenreKeys.KEY_USER_NAME;
import static com.example.musicplayer.utils.GenreKeys.TITLE;
import static com.example.musicplayer.utils.GenreKeys.TRACK;

@StringDef({ARTWORK_URL, DURATION, COLLECTION, ID, KEY_USER, KEY_USER_NAME, TITLE, TRACK})
public @interface GenreKeys {
    String ARTWORK_URL = "artwork_url";
    String DURATION = "duration";
    String COLLECTION = "collection";
    String ID = "id";
    String KEY_USER = "user";
    String KEY_USER_NAME = "username";
    String TITLE = "title";
    String TRACK = "track";
    String DOWNLOADABLE = "downloadable";
}
