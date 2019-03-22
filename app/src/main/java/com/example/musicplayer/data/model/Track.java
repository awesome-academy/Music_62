package com.example.musicplayer.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Track implements Parcelable {
    private int mId;
    private long mDuration;
    private String mTitle;
    private String mArtist;
    private String mStreamUrl;
    private String mDownloadUrl;
    private String mArtworkUrl;
    private boolean mIsDownloadable;
    private String mLyrics;

    public Track(int id, long duration, String title, String artist, String streamUrl,
                 String downloadUrl, String artworkUrl, boolean isDownloadable) {
        mId = id;
        mDuration = duration;
        mTitle = title;
        mArtist = artist;
        mStreamUrl = streamUrl;
        mDownloadUrl = downloadUrl;
        mArtworkUrl = artworkUrl;
        mIsDownloadable = isDownloadable;
    }

    protected Track(Parcel in) {
        mId = in.readInt();
        mDuration = in.readInt();
        mTitle = in.readString();
        mArtist = in.readString();
        mStreamUrl = in.readString();
        mDownloadUrl = in.readString();
        mArtworkUrl = in.readString();
        mIsDownloadable = in.readByte() != 0;
        mLyrics = in.readString();
    }

    public static final Creator<Track> CREATOR = new Creator<Track>() {
        @Override
        public Track createFromParcel(Parcel in) {
            return new Track(in);
        }

        @Override
        public Track[] newArray(int size) {
            return new Track[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeLong(mDuration);
        dest.writeString(mTitle);
        dest.writeString(mArtist);
        dest.writeString(mStreamUrl);
        dest.writeString(mDownloadUrl);
        dest.writeString(mArtworkUrl);
        dest.writeByte((byte) (mIsDownloadable ? 1 : 0));
        dest.writeString(mLyrics);
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public long getDuration() {
        return mDuration;
    }

    public void setDuration(int duration) {
        mDuration = duration;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public String getStreamUrl() {
        return mStreamUrl;
    }

    public void setStreamUrl(String streamUrl) {
        mStreamUrl = streamUrl;
    }

    public String getDownloadUrl() {
        return mDownloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        mDownloadUrl = downloadUrl;
    }

    public String getArtworkUrl() {
        return mArtworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        mArtworkUrl = artworkUrl;
    }

    public boolean isDownloadable() {
        return mIsDownloadable;
    }

    public void setDownloadable(boolean downloadable) {
        mIsDownloadable = downloadable;
    }

    public void setDuration(long duration) {
        mDuration = duration;
    }

    public String getLyrics() {
        return mLyrics;
    }

    public void setLyrics(String lyrics) {
        mLyrics = lyrics;
    }
}
