package com.example.FlickrReplicaAndroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class CommentsFragment extends Fragment {


    private RecyclerView commentRecView;
    private CommentsRecViewAdapter commentAdapter;
    private ArrayList<Comment> comments;
    private static final String TAG = MainActivity.class.getName();
    private Post post;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;


    public CommentsFragment(Post post) {
        // Required empty public constructor
        this.post = post;
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
        mRequestQueue = MySingleton.getInstance(getContext().getApplicationContext()).
                getRequestQueue();
        comments = new ArrayList<>();
        getComments();
        return v;
    }

    public void getComments(){
        //String url ="https://flickrreplica.free.beeceptor.com/comments/"+ post.getPostId();
        String url ="https://run.mocky.io/v3/6cf691ec-9e8a-4afe-a61e-5da04ed859f0";
        System.out.println(url);


        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray jsonArray;

                try{
                    //jsonArray = new JSONArray(response);
                    JSONObject jsonObject = new JSONObject(response);
                    int size = jsonObject.getInt("size");
                    jsonArray = jsonObject.getJSONArray("comments");
                    for (int i=0;i<size;i++){
                        jsonObject = jsonArray.getJSONObject(i);
                        String userName = jsonObject.getString("name");
                        UserProfile userProfile = new UserProfile();
                        userProfile.setName(userName);
                        userProfile.setProfilePicURL("https://www.worldfuturecouncil.org/wp-content/uploads/2020/02/dummy-profile-pic-300x300-1.png");
                        String commentText = jsonObject.getString("comment");
                        Comment commentPtr = new Comment();
                        commentPtr.setCommentText(commentText);
                        commentPtr.setCommentUserProfile(userProfile);
                        comments.add(commentPtr);
                        commentAdapter.setComments(comments);
                    }

                }catch(Throwable tx){
                    jsonArray=null;
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.i(TAG,"Error :" + error.toString());
            }
        });
        mRequestQueue.add(mStringRequest);
    }

}