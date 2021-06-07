package com.example.FlickrReplicaAndroid;

import java.io.Serializable;

public class UserProfile implements Serializable {
    private String name;
    private String profilePicURL;
    private boolean isPro;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProfilePicURL(String profilePicURL) {
        this.profilePicURL = profilePicURL;
    }

    public String getProfilePicURL() {
        return profilePicURL;
    }

    public void setPro(boolean pro) {
        isPro = pro;
    }

    public boolean isPro() {
        return isPro;
    }
}
