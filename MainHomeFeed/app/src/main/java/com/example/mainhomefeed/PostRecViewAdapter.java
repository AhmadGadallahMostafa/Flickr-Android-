package com.example.mainhomefeed;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PostRecViewAdapter extends RecyclerView.Adapter<PostRecViewAdapter.ViewHolder>{
    private static final String TAG = "PostRecViewAdapter";

    private ArrayList<Post> posts = new ArrayList<>();
    private Context parentContext;
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

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder: Called");
        holder.userNameTxt.setText(posts.get(position).getPostUserProfile().getName());
        Glide.with(fragmentContext).asBitmap().load(posts.get(position).getImageURL()).into(holder.postImg);

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(parentContext, " post" + position+ " selected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private CardView parent;
        private ImageView postImg;
        private TextView userNameTxt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.cardView_parent);
            postImg = itemView.findViewById(R.id.postImage);
            userNameTxt = itemView.findViewById(R.id.userProfileName);

        }
    }
}
