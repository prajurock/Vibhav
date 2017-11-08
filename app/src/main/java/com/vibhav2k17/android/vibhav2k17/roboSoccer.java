package com.vibhav2k17.android.vibhav2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ShareActionProvider;

import com.vibhav2k17.android.vibhav2k17.registation.RoboSoccerRegistration;

public class roboSoccer extends AppCompatActivity {
    private static Button about;
    private ShareActionProvider mShareActionProvider;
    private   AlertDialog.Builder about_builder;
    private   AlertDialog.Builder rules_builder;
    private   AlertDialog.Builder judgingCriteria_builder;
    private   AlertDialog.Builder prizes_builder;
    private   AlertDialog.Builder contactUs_builder;
    private  AlertDialog.Builder payment_builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aavis);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ImageView imageView=(ImageView)findViewById(R.id.titleImage);
        imageView.setImageResource(R.drawable.robosoccertemp
        );
        CollapsingToolbarLayout ll = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);




    }
    public void register(View view) {
        startActivity(new Intent(roboSoccer.this,RoboSoccerRegistration.class));

    }

    public void about(View view) {
        about_builder = new AlertDialog.Builder(roboSoccer.this);
        about_builder.setMessage(R.string.aboutrobo);
        AlertDialog alert_about = about_builder.create();
        alert_about.setTitle("About");
        // alert_about.setTitle(Html.fromHtml("<font color='#FF7F27'>About</font>"));
        alert_about.show();
    }
    public void rules(View view){
        rules_builder= new AlertDialog.Builder(roboSoccer.this);
        rules_builder.setMessage(R.string.rulesrobo);
        AlertDialog alert_about = rules_builder.create();
        alert_about.setTitle("Rules");
        alert_about.show();
        // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //  .setAction("Action", null).show();

    }
    public void judgingCriteria(View view){
        judgingCriteria_builder= new AlertDialog.Builder(roboSoccer.this);
        judgingCriteria_builder.setMessage(R.string.judgingCriteriarobo);
        AlertDialog alert_about = judgingCriteria_builder.create();
        alert_about.setTitle("Judging Criteria");
        alert_about.show();

    }
    public void prizes(View view){
        prizes_builder= new AlertDialog.Builder(roboSoccer.this);
        prizes_builder.setMessage(R.string.prizesrobo);
        AlertDialog alert_about = prizes_builder.create();
        alert_about.setTitle("Prizes");
        alert_about.show();

    }
    public void contactUs(View view){
        contactUs_builder= new AlertDialog.Builder(roboSoccer.this);
        contactUs_builder.setMessage(R.string.contactsrobo);
        AlertDialog alert_about = contactUs_builder.create();
        alert_about.setTitle("Contact Us");
        alert_about.show();

    }
    public void payments(View view){
        payment_builder= new AlertDialog.Builder(roboSoccer.this);
        payment_builder.setMessage(R.string.contactrobo);
        AlertDialog alert_about = payment_builder.create();
        alert_about.setTitle("Payment Details");
        alert_about.show();

    }


}

//public void onButtonClickListener(){
//    about =(Button)findViewById(R.id.about);
//   about.setOnClickListener(
//  new View.OnClickListener(){
//@Override
//public void onClick(View v){
// about_builder= new AlertDialog.Builder(placement_fever.this);
// about_builder.setMessage("ftf");
// AlertDialog alert_about = about_builder.create();
// alert_about.setTitle("About");
// alert_about.show();
//  }

//  }
//  );