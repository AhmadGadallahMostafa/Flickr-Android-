package com.example.FlickrReplicaAndroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class PostImageActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView imageViewPost;
    private MaterialToolbar topToolbar;
    private MaterialToolbar bottomToolbar;
    private MaterialToolbar captionToolbar;
    private ConstraintLayout constraintLayout;
    private boolean isVisible =true;
    private Post postOfImage;
    private TextView userNameText;
    private ImageView profImg;
    private TextView captionText;


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
        String postIdIntent=intent.getStringExtra("postPosition");
        Toast.makeText(this, "postImage , postID "+ postIdIntent,Toast.LENGTH_SHORT).show();
        postOfImage  = (Post)getIntent().getSerializableExtra("post");
        imageViewPost = findViewById(R.id.imageViewPostImg);
        topToolbar = findViewById(R.id.imgTopToolbar);
        bottomToolbar = findViewById(R.id.imgBottomToolbar);
        captionToolbar = findViewById(R.id.imgCaptionToolbar);
        constraintLayout = findViewById(R.id.postImageLayout);
        userNameText = findViewById(R.id.userNamePostImg);
        profImg = findViewById(R.id.profileImgPostImg);
        captionText = findViewById(R.id.captionPostImg);
        constraintLayout.setOnClickListener(this);
        imageViewPost.setOnClickListener(this);
        userNameText.setText(postOfImage.getPostUserProfile().getName()+"'s Photo");
        Glide.with(this).asBitmap().load(postOfImage.getPostUserProfile().getProfilePicURL()).into(profImg);
        Glide.with(this).asBitmap().load(postOfImage.getImageURL()).into(imageViewPost);
        String cap = postOfImage.getCaption();
        if (cap == null) cap = "";
        captionText.setText(cap);

    }
}