package com.example.mainhomefeed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class CommentsFragment extends Fragment {


    private RecyclerView commentRecView;
    private CommentsRecViewAdapter commentAdapter;


    public CommentsFragment() {
        // Required empty public constructor
    }




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_comments, container, false);
        commentAdapter = new CommentsRecViewAdapter(this.getContext(),this);
        commentRecView = v.findViewById(R.id.commentsRecyclerView);

        commentRecView.setAdapter(commentAdapter);
        commentRecView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        return v;
    }
}