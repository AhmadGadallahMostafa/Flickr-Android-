package com.example.FlickrReplicaAndroid;

import android.icu.util.TimeUnit;

import junit.framework.TestCase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PostTest extends TestCase {
    UserProfile userProfile = new UserProfile();
    Post post = new Post("id",userProfile,"url",1);
    Date d = new Date();
    public void testGetTimeSincePostedString() {
        assertEquals("moments ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 3600 * 1000);
        assertEquals("1 hour ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 1800 * 1000);
        assertEquals("30 minutes ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 3600 * 1000 *2);
        assertEquals("2 hours ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 3600 * 1000 * 5);
        assertEquals("5 hours ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 3600 * 1000 * 24);
        assertEquals("1 day ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 3600 * 1000 * 32);
        assertEquals("1 day ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 3600 * 1000 * 24 * 4);
        assertEquals("4 days ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 3600 * 1000 * 24 * 7);
        assertEquals("1 week ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 3600 * 1000 * 24 * 7 - 3600 * 1000 * 24 * 7 *3);
        assertEquals("1 month ago",post.getTimeSincePostedString(d));
        d = new Date(System.currentTimeMillis()  - 3600 * 1000 * 24 * 7 * 3 - 3600 * 1000 * 24 * 7 *3 - 3600 * 1000 * 24 * 7 * 2);
        assertEquals("2 months ago",post.getTimeSincePostedString(d));
        String Date1="8/9/2020";
        try{d=new SimpleDateFormat("dd/MM/yyyy").parse(Date1);}catch(Throwable tx){};
        assertEquals("9 months ago",post.getTimeSincePostedString(d));
        Date1="8/6/2020";
        try{d=new SimpleDateFormat("dd/MM/yyyy").parse(Date1);}catch(Throwable tx){};
        assertEquals("1 year ago",post.getTimeSincePostedString(d));
    }



}