package com.vibhav2k17.android.vibhav2k17.registation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vibhav2k17.android.vibhav2k17.InternetConnection;
import com.vibhav2k17.android.vibhav2k17.MainActivity;
import com.vibhav2k17.android.vibhav2k17.R;
import com.firebase.client.Firebase;

public class BrainRegistartion extends AppCompatActivity {
    private EditText mValueField1;
    private EditText mValueField2;
    private EditText mValueField3;
    private EditText mValueField4;
    private EditText mValueField5;
    private EditText mValueField6;
    private EditText mValueField7;

    private Button massBtn1;
    private Firebase mRootref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brain_registartion);

        Firebase.setAndroidContext(this);
        massBtn1= (Button) findViewById(R.id.addBtn);
        mValueField1= (EditText) findViewById(R.id.TeamNAmeField);
        mValueField2= (EditText) findViewById(R.id.valueField2);
        mValueField3= (EditText) findViewById(R.id.rollnodata1);
        mValueField4= (EditText) findViewById(R.id.phonenodata);
        mValueField5= (EditText) findViewById(R.id.valueField3);
        mValueField6= (EditText) findViewById(R.id.rollnodata2);
        mValueField7= (EditText) findViewById(R.id.phoneno2data);
      ;


        mRootref1=new Firebase("https://vibhav-4b5b9.firebaseio.com/BrainOriddle");

        massBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (InternetConnection.checkConnection(getApplicationContext())){
                    String TeamName=mValueField1.getText().toString();
                    String name1=mValueField2.getText().toString();
                    String Rollno1=mValueField3.getText().toString();
                    String Phoneno1=mValueField4.getText().toString();
                    String name2=mValueField5.getText().toString();
                    String Rollno2=mValueField6.getText().toString();
                    String Phoneno2=mValueField7.getText().toString();


                    Firebase childRef=mRootref1.child(Phoneno1);
                    boolean cancel = false;
                    View focusView = null;
                    if(TextUtils.isEmpty(TeamName)){
                        mValueField1.setError(getString(R.string.error_field_required));
                        focusView=mValueField1;
                        cancel=true;
                    }
                    if (TextUtils.isEmpty(name1)) {
                        mValueField2.setError(getString(R.string.error_field_required));
                        focusView = mValueField2;
                        cancel = true;
                    }
                    if (TextUtils.isEmpty(Rollno1)) {
                        mValueField3.setError(getString(R.string.error_field_required));
                        focusView = mValueField3;
                        cancel = true;
                    }
                    if (TextUtils.isEmpty(Phoneno1)) {
                        mValueField4.setError(getString(R.string.error_field_required));
                        focusView = mValueField4;
                        cancel = true;
                    }else if (!isPhonenovalid(Phoneno1)){
                        mValueField4.setError(getString(R.string.Invalid_no));
                        focusView=mValueField4;
                        cancel=true;
                    }






                    //childRef.setValue(value);
                    if(TeamName.isEmpty()==true||name1.isEmpty()==true||Rollno1.isEmpty()==true||Phoneno1.isEmpty()==true||isPhonenovalid(Phoneno1)==false)
                    {

                    }
                    else {
                        childRef.child("Team No").setValue(TeamName);
                        childRef.child("Name1").setValue(name1);
                        childRef.child("Roll no1").setValue(Rollno1);
                        childRef.child("Phone no1").setValue(Phoneno1);
                        childRef.child("Name2").setValue(name2);
                        childRef.child("Roll no2").setValue(Rollno2);
                        childRef.child("Phone no2").setValue(Phoneno2);




                        Toast.makeText(BrainRegistartion.this, "Registration done For Brain 0 Riddle",
                                Toast.LENGTH_LONG).show();
                        startActivity(new Intent(BrainRegistartion.this, MainActivity.class));
                    }

                }
                else
                {
                    Toast.makeText(BrainRegistartion.this,R.string.string_internet_connection_not_available,
                            Toast.LENGTH_LONG).show();}}
        });
    }
    private boolean isPhonenovalid(String Phone){
        return Phone.length()==10;
    }
}
