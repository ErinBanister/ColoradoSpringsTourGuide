package com.example.android.cstg;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        //set viewpager to enable swiping
        ViewPager viewPager = findViewById(R.id.viewpager);

        //categoryadapter ensures the pages are displayed in the correct order
        CategoryAdapter adapter = new CategoryAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

}

/**
 * Icons made by Smashicons (https://www.flaticon.com/authors/smashicons)
 * from Flaticon (www.flaticon.com) is licensed by
 * Creative Commons BY 3.0 http://creativecommons.org/licenses/by/3.0/
 */
