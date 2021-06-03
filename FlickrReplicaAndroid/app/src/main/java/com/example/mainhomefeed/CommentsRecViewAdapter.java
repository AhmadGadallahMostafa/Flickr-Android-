package com.example.mainhomefeed;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
public class CommentsRecViewAdapter extends RecyclerView.Adapter<CommentsRecViewAdapter.ViewHolder>{
    private static final String TAG = "CommentsRecViewAdapter";

    private ArrayList<Comment> comments = new ArrayList<>();
    private final Context parentContext;
    private Fragment fragmentContext;

    public CommentsRecViewAdapter(Context parentContext) {
        this.parentContext = parentContext;
    }
    public CommentsRecViewAdapter(Context parentContext,Fragment fragmentContext) {
        this.parentContext = parentContext;
        this.fragmentContext = fragmentContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_comment,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    /**
     * This functions handles clicks on the screen and check which part of the View v was clicked and its position and
     * the commentId is passed along with it to use to send as intent
     * @param v the view itself
     * @param position the position in the recycle viewer
     * @param commentId the id of the comment that is being clicked on
     */
    public void onClick(View v,int position,String commentId){
        Intent intent;
        switch(v.getId()){


            default:
                break;
        }
    }

    /**
     * sets the data of the comment to its view in the cardview and sets the onclick listiner
     * @param holder the cardview that contains all the views
     * @param position the postion of the cardview in the recycle view
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder: Called");
        //set values for the views
        holder.proLabelButton.setVisibility(View.INVISIBLE);
        if(comments.get(position).getCommentUserProfile().isPro()){
            holder.proLabelButton.setVisibility(View.VISIBLE);
        }
        holder.userNameTextView.setText(comments.get(position).getCommentUserProfile().getName());
        holder.commentTextView.setText(comments.get(position).getCommentText());
        Glide.with(fragmentContext).asBitmap().load(comments.get(position).getCommentUserProfile().getProfilePicURL()).into(holder.userCommentProfilePic);
        //set onclick listners


    }

    /**
     * gets the size of the array of comments
     * @return Size of the array of comments
     */
    @Override
    public int getItemCount() {
        return comments.size();
    }

    /**
     * sets the comments array for the class and notifies if data set is changed
     * @param comments list of comments
     */
    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private final CardView parent;
        private final TextView userNameTextView;
        private final TextView commentTextView;
        private final Button proLabelButton;
        private final ImageView userCommentProfilePic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.commentsCardView);
            userNameTextView = itemView.findViewById(R.id.commentUserName);
            commentTextView = itemView.findViewById(R.id.userComment);
            proLabelButton = itemView.findViewById(R.id.proLabelButton);
            userCommentProfilePic = itemView.findViewById(R.id.userCommentProfilePic);
        }
    }
}
