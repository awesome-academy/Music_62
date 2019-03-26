package com.example.musicplayer.application;

import android.app.Application;

public class MusicApplication extends Application {
    private static MusicApplication sApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }

    public static MusicApplication getApplication() {
        return sApplication;
    }
}
