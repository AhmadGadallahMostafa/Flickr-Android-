package com.example.mainhomefeed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {

    private TabLayout tabLayout ;
    private ViewPager viewPager2;
    private MyPagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tabLayout = findViewById(R.id.homePageTabLayout);
        viewPager2 = findViewById(R.id.homePageViewPager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager2.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager2);
        InitTabLayoutTabs();

    }

    /**
     * Intializes the icons for the tablayout in the homepage
     */
    void InitTabLayoutTabs(){
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_feed);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_profile);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_notification_bell);
        tabLayout.getTabAt(4).setIcon(R.drawable.ic_camera);

    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {


        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        /**
         * Loads in the fragment that is selected by the tab layout of the viewpager depending on
         * the position
         * @param position the position of the selected fragement in the tab layout
         * @return the fragment that should be selected
         */
        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position) {

                case 0: return new HomeFeedFragment();
                case 1: return new SearchFragment();
                case 2: return new SearchFragment();
                case 3: return new SearchFragment();
                case 4: return new SearchFragment();
                default: return new HomeFeedFragment();
            }

        }

        /**
         * gets the number of tabs in this tablayout
         * @return the number of tabs in this tablayout
         */
        @Override
        public int getCount() {
            return 5;
        }
    }
}