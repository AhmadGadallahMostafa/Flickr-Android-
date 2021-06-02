package com.example.mainhomefeed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 *
 */
public class PostRecViewAdapter extends RecyclerView.Adapter<PostRecViewAdapter.ViewHolder>{
    private static final String TAG = "PostRecViewAdapter";

    private ArrayList<Post> posts = new ArrayList<>();
    private final Context parentContext;
    private Fragment fragmentContext;

    public PostRecViewAdapter(Context parentContext) {
        this.parentContext = parentContext;
    }
    public PostRecViewAdapter(Context parentContext,Fragment fragmentContext) {
        this.parentContext = parentContext;
        this.fragmentContext = fragmentContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_post,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * This functions handles clicks on the screen and check which part of the View v was clicked and its position and
     * the postId is passed along with it to use to send as intent
     * @param v the view itself
     * @param position the position in the recycle viewer
     * @param postId the id of the post that is being clicked on
     */
    public void onClick(View v,int position,int postId){
        switch(v.getId()){
            case(R.id.favButtonPostMenu):
            case(R.id.favourites ):
                Toast.makeText(parentContext, "new fav" + position+ " selected, postID "+ postId ,Toast.LENGTH_SHORT).show();
                Intent intentFCF = new Intent(parentContext,FavouritesCommentsActivity.class );
                intentFCF.putExtra("tabLayout","0");
                intentFCF.putExtra("postIdIntent",String.valueOf(postId));
                parentContext.startActivity(intentFCF);
                break;
            case(R.id.commentsButton):
            case(R.id.comments):
                //Activity activity = new FavouritesCommentsActivity();
                Intent intentFC = new Intent(parentContext,FavouritesCommentsActivity.class );
                intentFC.putExtra("tabLayout","1");
                intentFC.putExtra("postIdIntent",String.valueOf(postId));
                parentContext.startActivity(intentFC);
                //Toast.makeText(parentContext, "new comment" + position+ " selected, postID "+ postId,Toast.LENGTH_SHORT).show();
                break;
            case (R.id.postImage):
                //Intent intent = new Intent(this,activity.class );
                //Activity activity = new PostImageActivity();
                Intent intentPI = new Intent(parentContext,PostImageActivity.class );
                intentPI.putExtra("postIdIntent",String.valueOf(postId));
                parentContext.startActivity(intentPI);
                //Toast.makeText(parentContext, "new image" + position+ " selected, postID "+ postId,Toast.LENGTH_SHORT).show();
            case (R.id.cardView_parent):
                Toast.makeText(parentContext, "new post" + position+ " selected, postID "+ postId ,Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

    /**
     * sets the data of the post to its view in the cardview and sets the onclick listiner
     * @param holder the cardview that contains all the views
     * @param position the postion of the cardview in the recycle view
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder: Called");
        int postId = posts.get(position).getPostId();
        holder.userNameTxt.setText(posts.get(position).getPostUserProfile().getName());
        Glide.with(fragmentContext).asBitmap().load(posts.get(position).getImageURL()).into(holder.postImg);
        holder.postImg.setOnClickListener(v -> onClick(v,position,postId));
        holder.comments.setOnClickListener(v -> onClick(v,position,postId));
        holder.parent.setOnClickListener(v -> onClick(v,position,postId));
        holder.commentsButton.setOnClickListener(v -> onClick(v,position,postId));
        holder.favourites.setOnClickListener(v -> onClick(v,position,postId));
        holder.favouriteButton.setOnClickListener(v -> onClick(v,position,postId));

    }

    /**
     * gets the size of the array of posts
     * @return Size of the array of posts
     */
    @Override
    public int getItemCount() {
        return posts.size();
    }

    /**
     * sets the post for the class and notifies if data set is changed
     * @param posts list of posts
     */
    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final CardView parent;
        private final ImageView postImg;
        private final TextView userNameTxt;
        private final TextView comments;
        private final TextView favourites;
        private final RelativeLayout favouriteButton;
        private final RelativeLayout commentsButton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.cardView_parent);
            postImg = itemView.findViewById(R.id.postImage);
            userNameTxt = itemView.findViewById(R.id.userProfileName);
            comments = itemView.findViewById(R.id.comments);
            commentsButton = itemView.findViewById(R.id.commentsButton);
            favourites = itemView.findViewById(R.id.favourites);
            favouriteButton = itemView.findViewById(R.id.favButtonPostMenu);

        }
    }
}
