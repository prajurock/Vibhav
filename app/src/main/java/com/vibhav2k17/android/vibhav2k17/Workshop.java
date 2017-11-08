package com.vibhav2k17.android.vibhav2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Workshop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workshop);
    }
    public void matlab(View view){
        Intent i=new Intent(this,Matlab.class);
        startActivity(i);

    }
    public void iot(View view){
        Intent i=new Intent(this,Iot.class);
        startActivity(i);

    }
}