package com.vibhav2k17.android.vibhav2k17;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsIntent;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import ss.com.bannerslider.banners.Banner;
import ss.com.bannerslider.banners.RemoteBanner;
import ss.com.bannerslider.events.OnBannerClickListener;
import ss.com.bannerslider.views.BannerSlider;
import ss.com.bannerslider.views.indicators.IndicatorShape;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private BannerSlider bannerSlider;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    startActivity(new Intent(MainActivity.this, events.class));
                    return true;
                case R.id.navigation_notifications:
                    startActivity(new Intent(MainActivity.this, timetable.class));
                    return true;

            }
            return false;
        }

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        View view = navigation.findViewById(R.id.navigation_home);
        view.performClick();
        setupViews();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ImageView image= (ImageView) findViewById(R.id.toolbar_logo);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NewsFeed .class));
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }
    public void vibhav(View view){
        TextView t=(TextView)findViewById(R.id.tex);
        t.setText(R.string.aboutus);
        TextView b1=(TextView)findViewById(R.id.b1);
        TextView b2=(TextView)findViewById(R.id.b2);
        b1.setBackgroundColor(getResources().getColor(R.color.b));
        b2.setBackgroundColor(getResources().getColor(R.color.b1));
    }
    public void ees(View view){
        TextView t=(TextView)findViewById(R.id.tex);
        t.setText(R.string.aboutees);
        TextView b1=(TextView)findViewById(R.id.b1);
        TextView b2=(TextView)findViewById(R.id.b2);
        b2.setBackgroundColor(getResources().getColor(R.color.b));
        b1.setBackgroundColor(getResources().getColor(R.color.b1));
    }

    public void events(View view){
        Intent i=new Intent(this, com.vibhav2k17.android.vibhav2k17.events.class);
        view.getContext().startActivity(i);
    }
    public void timetable(View view){
        Intent i=new Intent(this, com.vibhav2k17.android.vibhav2k17.timetable.class);
        startActivity(i);
    }

    private void setupViews() {
        setupBannerSlider();
        setupPageIndicatorChooser();
        setupSettingsUi();
    }

    private void setupSettingsUi() {
        bannerSlider.setInterval(5000);
        bannerSlider.setIndicatorSize(20);
        bannerSlider.setLoopSlides(true);
        bannerSlider.setMustAnimateIndicators(true);

    }

    private void setupBannerSlider(){
        bannerSlider = (BannerSlider) findViewById(R.id.banner_slider1);
        addBanners();

        bannerSlider.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void onClick(int position) {
                if (position==0){

                    Uri uri = Uri.parse("https://www.facebook.com/vibhav.iitismdhanbad/");

                    if (Build.VERSION.SDK_INT>15) {
                        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
                        intentBuilder.setToolbarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimaryDark));
                        intentBuilder.setStartAnimations(MainActivity.this, android.R.anim.fade_in, android.R.anim.fade_out);
                        intentBuilder.setExitAnimations(MainActivity.this, android.R.anim.fade_in, android.R.anim.fade_out);
                        CustomTabsIntent customTabsIntent = intentBuilder.build();
                        customTabsIntent.launchUrl(MainActivity.this, uri);
                    }else {
                        startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW,uri),"Choose Browser..."));
                    }

                }
            }
        });
    }
    private void addBanners(){
        List<Banner> remoteBanners=new ArrayList<>();
        //Add banners using image urls
        remoteBanners.add(new RemoteBanner(
                "https://scontent.xx.fbcdn.net/v/t1.0-9/22815500_1620938917928193_4606782602657146746_n.jpg?oh=43f701d4e6cdaa56aec66b1b74bd6f45&oe=5A73DCC9"
        ));
        remoteBanners.add(new RemoteBanner(
                "https://scontent.xx.fbcdn.net/v/t1.0-9/q82/s720x720/22853165_1620123888009696_2807943154833065944_n.jpg?oh=18ef0a2d71739232a16d7f9a32c9d99c&oe=5AA6A920"
        ));
        remoteBanners.add(new RemoteBanner(
                "https://scontent.xx.fbcdn.net/v/t1.0-9/s720x720/22815266_1620123181343100_1666241700264044754_n.jpg?oh=50e25041cd5771c31150ca1aaf64f311&oe=5AAD89A9"
        ));
        remoteBanners.add(new RemoteBanner(
                "https://scontent.xx.fbcdn.net/v/t1.0-9/s720x720/22853023_1620119508010134_3761771046839345468_n.jpg?oh=315257f9ae091c436bbdd6e2e30d02fe&oe=5A75BFF6"
        ));
        remoteBanners.add(new RemoteBanner(
                 "https://scontent.xx.fbcdn.net/v/t1.0-9/22815591_1620914687930616_5427313704476769776_n.png?oh=3530ce0663084b710b218d89ca08c4a0&oe=5AA480CB"
        ));

        bannerSlider.setBanners(remoteBanners);

    }

    private void setupPageIndicatorChooser(){

        bannerSlider.setDefaultIndicator(IndicatorShape.CIRCLE);




    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }





    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_registration) {
            startActivity(new Intent(MainActivity.this,NewsFeed.class));

        } else if(id==R.id.nav_youtube){
            startActivity(new Intent(MainActivity.this,video.class));
        }
        else if (id == R.id.nav_contact) {
            startActivity(new Intent(MainActivity.this,contactsUs.class));

        } else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=com.vibhav2k17.android.vibhav2k17");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);

        } else if (id == R.id.nav_developers) {
            startActivity(new Intent(MainActivity.this,developers.class
            ));

        }
        else  if(id==R.id.nav_query){
            startActivity(new Intent(MainActivity.this,FAQs.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}