package com.example.mainhomefeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class PostImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_image);
        Intent intent = getIntent();
        //String postIdIntent="";
        String postIdIntent=intent.getStringExtra("postIdIntent");
        Toast.makeText(this, "postImage , postID "+ postIdIntent,Toast.LENGTH_SHORT).show();
    }
}