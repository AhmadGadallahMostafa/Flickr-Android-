package com.example.FlickrReplicaAndroid;


import java.io.Serializable;

public class Comment implements Serializable {
    private UserProfile commentUserProfile;
    private String commentText;

    public void setCommentUserProfile(UserProfile commentUserProfile) {
        this.commentUserProfile = commentUserProfile;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public UserProfile getCommentUserProfile() {
        return commentUserProfile;
    }

    public String getCommentText() {
        return commentText;
    }
}