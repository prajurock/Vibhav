package com.vibhav2k17.android.vibhav2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Robo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_robo);
    }
    public void rs(View view) {
        Intent i = new Intent(this, roboSoccer.class);
        startActivity(i);

    }


    public void line(View view) {
        Intent i = new Intent(this, robotics.class);
        startActivity(i);

    }
}
