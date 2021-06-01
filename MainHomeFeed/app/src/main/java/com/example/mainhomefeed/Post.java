package com.example.mainhomefeed;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    private int postId;
    private UserProfile postUserProfile;
    private int favouriteCount;
    private int commentCount;
    private ArrayList<Comment> commentsArray;
    private ArrayList<UserProfile> favourtiesUsersArray;
    private String imageURL;
    private String caption;
    private Date datePosted;
    private String timeSincePosted;//temp

    public Post(int postId, UserProfile postUserProfile, String imageURL) {
        this.postUserProfile = postUserProfile;
        this.imageURL = imageURL;
        this.postId = postId;
    }

    public String getImageURL() {
        return imageURL;
    }

    public UserProfile getPostUserProfile() {
        return postUserProfile;
    }

    public int getFavouriteCount() {
        return favouriteCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public ArrayList<Comment> getCommentsArray() {
        return commentsArray;
    }

    public ArrayList<UserProfile> getFavourtiesUsersArray() {
        return favourtiesUsersArray;
    }

    public int getPostId() {
        return postId;
    }

    public String getCaption() {
        return caption;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public String getTimeSincePosted() {
        return timeSincePosted;
    }


}
