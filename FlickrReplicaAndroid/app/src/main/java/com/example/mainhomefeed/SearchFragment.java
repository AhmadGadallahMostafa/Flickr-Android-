package com.example.mainhomefeed;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


public class SearchFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_search, container, false);
        ImageView img = v.findViewById(R.id.imageView1);
        Glide.with(this).load("https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png").into(img);
        return v;
    }
}