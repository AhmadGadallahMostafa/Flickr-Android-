package com.example.FlickrReplicaAndroid;

import android.os.Bundle;

import androidx.annotation.NonNull;
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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class HomeFeedFragment extends Fragment {

    private RecyclerView postRecView;
    private PostRecViewAdapter postAdapter;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private static final String TAG = MainActivity.class.getName();
    private ArrayList<Post> posts;
    private int pageNum = 1;

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
        postRecView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            /**
             * checks if the user scrolled to the end of the screen, when he does load in the next
             * 10 posts
             * @param recyclerView
             * @param newState
             */
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(!recyclerView.canScrollVertically(1)){
                    System.out.println("end");
                    getPhotos();
                }
            }
        });
        //mRequestQueue = new RequestQueue();
        mRequestQueue = MySingleton.getInstance(getContext().getApplicationContext()).
                getRequestQueue();

        //UserProfile tempProf = new UserProfile();
        //tempProf.setName("cufe");
        posts = new ArrayList<>();
        //posts.add(new Post(11,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        //posts.add(new Post(22,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        //posts.add(new Post(33,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        //posts.add(new Post(44,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        //posts.add(new Post(55,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        //posts.add(new Post(66,tempProf,"https://sites.google.com/site/riskcufe/_/rsrc/1343260633090/home/Faculty%20LOGO.png"));
        //posts = new ArrayList<>();
        getPhotos();
        //postAdapter.setPosts(posts);
        return v;
    }

    /**
     * Loads the next 10 posts, by creating the user and the post intances and intializing thier
     * data, into the posts array that loads into the recycle viewer
     */
    private void getPhotos(){
        String url ="https://api.unsplash.com/photos?client_id=lw8JVwKlDWjEhUxqdnB2tRel7Fduqc2Z1_DdXyAzNzI&page="+ pageNum;
        System.out.println(url);

        mStringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray jsonArray;

                try{
                    jsonArray = new JSONArray(response);
                    //posts = new ArrayList<>();
                    for(int i=0;i<10;i++){
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String idImg=jsonObject.get("id").toString();
                        System.out.println("id:"+idImg);
                        UserProfile userProfile = new UserProfile();
                        String userName = jsonObject.getJSONObject("user").get("name").toString();
                        System.out.println("username:"+userName);
                        userProfile.setName(userName);
                        String urlProfImg =jsonObject.getJSONObject("user").getJSONObject("profile_image").get("small").toString();
                        userProfile.setProfilePicURL(urlProfImg);
                        String urlImg =jsonObject.getJSONObject("urls").get("raw").toString();
                        System.out.println("url:"+urlImg);
                        Post postPointer = new Post(idImg,userProfile,urlImg,i);
                        String caption = jsonObject.get("alt_description").toString();
                        postPointer.setCaption(caption);
                        String date = jsonObject.get("created_at").toString();
                        String daten = date.substring(0,19);
                        daten = daten + ".0" + date.substring(19,25);
                        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                        Date datePosted = d.parse(daten);
                        postPointer.setDatePosted(datePosted);
                        posts.add(postPointer);

                        postAdapter.setPosts(posts);

                    }
                    //pageNum++;
                    pageNum=pageNum+1;
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