package com.example.FlickrReplicaAndroid;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import org.jetbrains.annotations.NotNull;

public class profileFragmentsAdapter extends FragmentStateAdapter {


    public profileFragmentsAdapter(@NonNull @NotNull FragmentManager fragmentManager, @NonNull @NotNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @NotNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {

            case 0:
                return  new profilef1();
            case 1:
                return new profilef2();

            case 2:
                return  new profilef3();

            case 3:
                return  new profilef4();





        }
        return new profilef1();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
