package com.vibhav2k17.android.vibhav2k17;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsFeed extends AppCompatActivity {

    private ListView listView;
    private View parentView;

    private ArrayList<Contact> contactList;
    private ContactAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);




        /**
         * Array List for Binding Data from JSON to this List
         */
        contactList = new ArrayList<>();

        parentView = findViewById(R.id.parentLayout);

        /**
         * Getting List and Setting List Adapter
         */
        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String linkfb=contactList.get(position).getLink();
                if(linkfb!= null) {

                    Uri uri = Uri.parse(linkfb);

                    if (Build.VERSION.SDK_INT > 15) {
                        CustomTabsIntent.Builder intentBuilder = new CustomTabsIntent.Builder();
                        intentBuilder.setToolbarColor(ContextCompat.getColor(NewsFeed.this, R.color.colorPrimary));
                        intentBuilder.setSecondaryToolbarColor(ContextCompat.getColor(NewsFeed.this, R.color.colorPrimaryDark));
                        intentBuilder.setStartAnimations(NewsFeed.this, android.R.anim.fade_in, android.R.anim.fade_out);
                        intentBuilder.setExitAnimations(NewsFeed.this, android.R.anim.fade_in, android.R.anim.fade_out);
                        CustomTabsIntent customTabsIntent = intentBuilder.build();
                        customTabsIntent.launchUrl(NewsFeed.this, uri);
                    } else {
                        startActivity(Intent.createChooser(new Intent(Intent.ACTION_VIEW, uri), "Choose Browser..."));
                    }
                }
            }
        });

        /**
         * Just to know onClick and Printing Hello Toast in Center.
         */

        if (InternetConnection.checkConnection(getApplicationContext())) {
            final ProgressDialog dialog;
            /**
             * Progress Dialog for User Interaction
             */
            dialog = new ProgressDialog(NewsFeed.this);
            dialog.setTitle(getString(R.string.string_getting_json_title));
            dialog.setMessage(getString(R.string.string_getting_json_message));
            dialog.show();

            //Creating an object of our api interface
            ApiService api = RetroClient.getApiService();

            /**
             * Calling JSON
             */
            Call<ContactList> call = api.getMyJSON();

            /**
             * Enqueue Callback will be call when get response...
             */
            call.enqueue(new Callback<ContactList>() {
                @Override
                public void onResponse(Call<ContactList> call, Response<ContactList> response) {
                    //Dismiss Dialog
                    dialog.dismiss();

                    if(response.isSuccessful()) {
                        /**
                         * Got Successfully
                         */
                        contactList = response.body().getContacts();

                        /**
                         * Binding that List to Adapter
                         */
                        adapter = new ContactAdapter(NewsFeed.this, contactList);
                        listView.setAdapter(adapter);

                    } else {
                        Toast.makeText(NewsFeed.this,R.string.string_some_thing_wrong,Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<ContactList> call, Throwable t) {
                    dialog.dismiss();
                }
            });

        } else {
            Toast.makeText(NewsFeed.this,R.string.string_internet_connection_not_available,Toast.LENGTH_LONG).show();
        }
    }
}



