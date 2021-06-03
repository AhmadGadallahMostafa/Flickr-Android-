package com.example.mainhomefeed;

import java.util.ArrayList;
import java.util.Date;

public class Post {
    private final String postId;
    private final UserProfile postUserProfile;
    private final String imageURL;
    private int position; //position of post in recycle viewer array to reuse data
    private int favouriteCount;
    private int commentCount;
    private ArrayList<Comment> commentsArray;
    private ArrayList<UserProfile> favourtiesUsersArray;
    private String caption;
    private Date datePosted;
    private String timeSincePosted;//temp

    public Post(String postId, UserProfile postUserProfile, String imageURL,int position) {
        this.postUserProfile = postUserProfile;
        this.imageURL = imageURL;
        this.postId = postId;
        this.position = position;
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

    public void setFavouriteCount(int favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public ArrayList<Comment> getCommentsArray() {
        return commentsArray;
    }

    public void setCommentsArray(ArrayList<Comment> commentsArray) {
        this.commentsArray = commentsArray;
    }

    public ArrayList<UserProfile> getFavourtiesUsersArray() {
        return favourtiesUsersArray;
    }

    public void setFavourtiesUsersArray(ArrayList<UserProfile> favourtiesUsersArray) {
        this.favourtiesUsersArray = favourtiesUsersArray;
    }

    public String getPostId() {
        return postId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public String getTimeSincePosted() {
        return timeSincePosted;
    }

    public void setTimeSincePosted(String timeSincePosted) {
        this.timeSincePosted = timeSincePosted;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
