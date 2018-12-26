package com.example.adonis.stackice.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Propaganda implements Serializable {

    public String Link;


    public Propaganda(String Link) {
        this.Link = Link;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String Link) {
        this.Link = Link;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(Link);
    }

}
