package com.onisq.phez;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private SharedPref sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {



        sharedPref = new SharedPref(this);
        if(sharedPref.loadNightModeState() == true){
            setTheme(R.style.darkTheme);
        }
        else setTheme(R.style.AppTheme);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpager_id);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        //Fragments:

        adapter.AddFragment(new FragmentHome(), "");
        adapter.AddFragment(new FragmentBook(), "");
        adapter.AddFragment(new FragmentTask(), "");


        viewPager.setAdapter(adapter);

        this.tabLayout.setupWithViewPager(viewPager);
        this.tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        this.tabLayout.getTabAt(1).setIcon(R.drawable.ic_book_black_24dp);
        this.tabLayout.getTabAt(2).setIcon(R.drawable.ic_format_list_bulleted_black_24dp);




        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }


}
