package com.example.nicossubmission;

import android.os.Parcel;
import android.os.Parcelable;

public class Batik implements Parcelable {
    private String title;
    private String description;
    private String photo;

    protected Batik(Parcel in) {
        title = in.readString();
        description = in.readString();
        photo = in.readString();
    }

    public Batik() {

    }

    public static final Creator<Batik> CREATOR = new Creator<Batik>() {
        @Override
        public Batik createFromParcel(Parcel in) {
            return new Batik(in);
        }

        @Override
        public Batik[] newArray(int size) {
            return new Batik[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(photo);
    }
}