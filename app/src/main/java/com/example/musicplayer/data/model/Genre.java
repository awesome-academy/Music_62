package com.example.musicplayer.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Genre implements Parcelable {
    private String mName;
    private String mKey;
    private int mImageId;

    public Genre(String name, String key, int imageId) {
        mName = name;
        mKey = key;
        mImageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mKey);
        dest.writeInt(mImageId);
    }

    public static final Creator<Genre> CREATOR = new Creator<Genre>() {
        @Override
        public Genre createFromParcel(Parcel in) {
            return new Genre(in);
        }

        @Override
        public Genre[] newArray(int size) {
            return new Genre[size];
        }
    };

    public String getName() {
        return mName;
    }

    public String getKey() {
        return mKey;
    }

    public int getImageId() {
        return mImageId;
    }

    public void setName(String name) {
        mName = name;
    }

    public void setKey(String key) {
        mKey = key;
    }

    public void setImageId(int imageId) {
        mImageId = imageId;
    }

    protected Genre(Parcel in) {
        mName = in.readString();
        mKey = in.readString();
        mImageId = in.readInt();
    }
}
