package com.example.mainhomefeed;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class FavouritesCommentsActivity extends AppCompatActivity {

    private TabLayout tabLayout ;
    private ViewPager viewPager;
    private FavouritesCommentsActivity.MyPagerAdapter pagerAdapter;

    /**
     * Overriden function added tablayout and viewpager integeration and setting the current tab
     * to the tab selected in the intent.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites_comments);
        Intent intent = getIntent();
        String tabLayoutChoice=intent.getStringExtra("tabLayout");
        tabLayout = findViewById(R.id.favesCommentsTabLayout);
        viewPager = findViewById(R.id.favesCommentsViewPager);
        pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        intializeTabLayout();
        Toast.makeText(this, "comments , postID "+ (Integer.parseInt(tabLayoutChoice)),Toast.LENGTH_SHORT).show();
        tabLayout.getTabAt((Integer.parseInt(tabLayoutChoice))).select();
    }

    /**
     * Intializes the tab layout attributes
     */
    public void intializeTabLayout(){
        tabLayout.getTabAt(0).setText("Faves");
        tabLayout.getTabAt(1).setText("Comments");
    }

    private class MyPagerAdapter extends FragmentStatePagerAdapter {


        public MyPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch(position) {

                case 0: return new FavouritesListFragment();
                case 1: return new CommentsFragment();
                default: return new FavouritesListFragment();
            }

        }

        /**
         * Number of tabs
         * @return Number of tabs
         */
        @Override
        public int getCount() {
            return 2;
        }
    }
}