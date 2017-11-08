package com.vibhav2k17.android.vibhav2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

public class timetable extends AppCompatActivity implements android.support.v7.app.ActionBar.TabListener {
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {


        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(timetable.this,MainActivity.class));
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(timetable.this,events.class));
                    return true;
                case R.id.navigation_notifications:
                    return true;

            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        View view = navigation.findViewById(R.id.navigation_notifications);
        view.performClick();


        final android.support.v7.app.ActionBar ab=getSupportActionBar();
        ab.setNavigationMode(android.support.v7.app.ActionBar.NAVIGATION_MODE_TABS);
        ab.addTab(ab.newTab().setText("DAY 1").setTabListener(this));
        ab.addTab(ab.newTab().setText("DAY 2").setTabListener(this));

    }


    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

        if(tab.getPosition()==0){
            day1fragment f=new day1fragment();
            getFragmentManager().beginTransaction().replace(R.id.container,f).commit();

        }
        if(tab.getPosition()==1
                ){
            day2fragment f=new day2fragment();
            getFragmentManager().beginTransaction().replace(R.id.container,f).commit();

        }

    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction ft) {

    }
}
