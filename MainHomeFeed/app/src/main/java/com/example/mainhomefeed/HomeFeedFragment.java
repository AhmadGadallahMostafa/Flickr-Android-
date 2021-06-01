package com.example.mainhomefeed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class HomeFeedFragment extends Fragment {

    private RecyclerView postRecView;
    private PostRecViewAdapter postAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_feed, container, false);
        postAdapter = new PostRecViewAdapter(this.getContext(),this);
        postRecView = v.findViewById(R.id.postRecView);

        postRecView.setAdapter(postAdapter);
        postRecView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        UserProfile tempProf = new UserProfile();
        tempProf.setName("cufe");
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(11,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        posts.add(new Post(22,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        posts.add(new Post(33,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        posts.add(new Post(44,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        posts.add(new Post(55,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        posts.add(new Post(66,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));

        postAdapter.setPosts(posts);
        return v;
    }
}