package com.idealogics.youtube.Activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.idealogics.youtube.Adapters.PagerAdapter;
import com.idealogics.youtube.R;

public class MainActivity extends AppCompatActivity {

    Context context;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    ViewPager viewPager;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        initViews();
    }

    private void initViews() {
        toolbar = findViewById(R.id.toolbar);

        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation_view);
        bottomNav = findViewById(R.id.bottomNavigationView);
        viewPager = findViewById(R.id.pager);
        setToolbar();
        setViewPager();


    }


    public void setToolbar() {

        ActionBarDrawerToggle actionBarDrawerToggle =
                new ActionBarDrawerToggle((Activity) context,
                        drawerLayout, toolbar, R.string.app_name, R.string.app_name);

        actionBarDrawerToggle.syncState();
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

    }


    private void setViewPager() {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        bottomNav.getMenu().findItem(R.id.item0).setChecked(true);
                        break;
                    case 1:
                        bottomNav.getMenu().findItem(R.id.item1).setChecked(true);
                        break;
                    case 2:
                        bottomNav.getMenu().findItem(R.id.item2).setChecked(true);
                        break;
                    case 3:
                        bottomNav.getMenu().findItem(R.id.item3).setChecked(true);
                        break;
                    case 4:
                        bottomNav.getMenu().findItem(R.id.item4).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        bottomNav.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.item0:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.item1:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.item2:
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.item3:
                    viewPager.setCurrentItem(3);
                    break;
                case R.id.item4:
                    viewPager.setCurrentItem(4);
                    break;
            }
            return false;
        });
    }


}