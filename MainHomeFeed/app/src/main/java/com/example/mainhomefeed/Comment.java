package com.example.mainhomefeed;


public class Comment {
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