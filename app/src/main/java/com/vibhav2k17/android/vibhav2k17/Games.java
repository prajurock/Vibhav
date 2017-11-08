package com.vibhav2k17.android.vibhav2k17;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Games extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
    }

    public void mini(View view) {
        Intent i = new Intent(this, minimilitia.class);
        startActivity(i);

    }

    public void cs(View view) {
        Intent i = new Intent(this, csgo.class);
        startActivity(i);

    }
}
