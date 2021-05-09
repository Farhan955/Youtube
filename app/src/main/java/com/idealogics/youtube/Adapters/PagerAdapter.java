package com.idealogics.youtube.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.idealogics.youtube.Fragments.EarnFragment;
import com.idealogics.youtube.Fragments.LikesFragment;
import com.idealogics.youtube.Fragments.NotificationsFragment;
import com.idealogics.youtube.Fragments.VideosFragment;
import com.idealogics.youtube.Fragments.YoutubeFragment;

/**
 * Created by FA on 5/7/2021.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new YoutubeFragment();
            case 1:
                return new LikesFragment();
            case 2:
                return new VideosFragment();
            case 3:
                return new NotificationsFragment();
            case 4:
                return new EarnFragment();

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String name;
        if (position == 0) {
            name = "Upcomming";
        } else {
            name = "Past";
        }

        return name;
    }
}
