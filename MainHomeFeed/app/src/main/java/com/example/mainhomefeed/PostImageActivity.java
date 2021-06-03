package com.example.mainhomefeed;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.appbar.MaterialToolbar;

public class PostImageActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageViewPost;
    private MaterialToolbar topToolbar;
    private MaterialToolbar bottomToolbar;
    private MaterialToolbar captionToolbar;
    private ConstraintLayout constraintLayout;
    private boolean isVisible =false;

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.postImageLayout):
            case(R.id.imageViewPostImg):
                if(isVisible){
                    topToolbar.setVisibility(View.GONE);
                    bottomToolbar.setVisibility(View.GONE);
                    captionToolbar.setVisibility(View.GONE);
                    isVisible=false;
                }else{
                    topToolbar.setVisibility(View.VISIBLE);
                    bottomToolbar.setVisibility(View.VISIBLE);
                    captionToolbar.setVisibility(View.VISIBLE);
                    isVisible=true;
                }
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_image);
        Intent intent = getIntent();
        //String postIdIntent="";
        String postIdIntent=intent.getStringExtra("postIdIntent");
        Toast.makeText(this, "postImage , postID "+ postIdIntent,Toast.LENGTH_SHORT).show();
        imageViewPost = findViewById(R.id.imageViewPostImg);
        topToolbar = findViewById(R.id.imgTopToolbar);
        bottomToolbar = findViewById(R.id.imgBottomToolbar);
        captionToolbar = findViewById(R.id.imgCaptionToolbar);
        constraintLayout = findViewById(R.id.postImageLayout);
        constraintLayout.setOnClickListener(this);
        imageViewPost.setOnClickListener(this);
    }
}