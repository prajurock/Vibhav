package com.vibhav2k17.android.vibhav2k17;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

public class developers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developers);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView imageView=(ImageView)findViewById(R.id.titleImage);
        imageView.setImageResource(R.drawable.develop);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void prajfb(View view){
        String uri = "https://www.facebook.com/prajwal.singh.144";
         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);

    }
    public void pragfb(View view) {
        String uri = "https://www.facebook.com/pragyesh.mishra.50";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
    public void praglink  (View view) {
        String uri = "https://www.linkedin.com/in/pragyesh-mishra-223330b4";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
    public void prajlink  (View view) {
        String uri = "https://linkedin.com/in/prajwal-singh-06a62813a";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
    public void khofb  (View view) {
        String uri = "https://www.facebook.com/kowshik.unique";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
    public void tvsfb  (View view) {
        String uri = "https://www.facebook.com/thammana.gowtham";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
    public void jksfb  (View view) {
        String uri = "https://www.facebook.com/jks.suryarao";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
    public void shalini  (View view) {
        String uri = "https://www.facebook.com/profile.php?id=100013024865542";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
        startActivity(intent);
    }
}
