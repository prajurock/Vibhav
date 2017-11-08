package com.vibhav2k17.android.vibhav2k17.registation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vibhav2k17.android.vibhav2k17.InternetConnection;
import com.vibhav2k17.android.vibhav2k17.MainActivity;
import com.vibhav2k17.android.vibhav2k17.R;
import com.firebase.client.Firebase;

/**
 * Created by prajwal on 29/10/17.
 */

public class registrationPaper extends AppCompatActivity {
    private EditText mValueField1;
    private EditText mValueField2;
    private EditText mValueField3;
    private EditText mValueField4;
    private EditText mValueField5;
    private EditText mValueField6;
    private EditText mValueField7;
    private EditText mValueField8;
    private EditText mValueField9;
    private EditText mValueField10;
    private EditText mValueField11;
    private EditText mValueField12;
    private EditText mValueField13;


    private Button massBtn1;
    private Firebase mRootref1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paceline_registration);

        Firebase.setAndroidContext(this);
        massBtn1= (Button) findViewById(R.id.addBtn);
        mValueField1= (EditText) findViewById(R.id.TeamNAmeField);
        mValueField2= (EditText) findViewById(R.id.valueField2);
        mValueField3= (EditText) findViewById(R.id.rollnodata1);
        mValueField4= (EditText) findViewById(R.id.phonenodata);
        mValueField5= (EditText) findViewById(R.id.valueField3);
        mValueField6= (EditText) findViewById(R.id.rollnodata2);
        mValueField7= (EditText) findViewById(R.id.phoneno2data);
        mValueField8= (EditText) findViewById(R.id.valueField4);
        mValueField9= (EditText) findViewById(R.id.rollnodata3);
        mValueField10= (EditText) findViewById(R.id.phoneno3data);
        mValueField11= (EditText) findViewById(R.id.valueField5);
        mValueField12= (EditText) findViewById(R.id.rollnodata4);
        mValueField13= (EditText) findViewById(R.id.phoneno4data);



        mRootref1=new Firebase("https://vibhav-4b5b9.firebaseio.com/PaperPresentation");

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
                    String name3=mValueField8.getText().toString();
                    String Rollno3=mValueField9.getText().toString();
                    String Phoneno3=mValueField10.getText().toString();
                    String name4=mValueField11.getText().toString();
                    String Rollno4=mValueField12.getText().toString();
                    String Phoneno4=mValueField13.getText().toString();


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
                    if(name1.isEmpty()==true||Rollno1.isEmpty()==true||Phoneno1.isEmpty()==true||isPhonenovalid(Phoneno1)==false)
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
                        childRef.child("Name3").setValue(name3);
                        childRef.child("Roll no3").setValue(Rollno3);
                        childRef.child("Phone no3").setValue(Phoneno3);
                        childRef.child("Name4").setValue(name4);
                        childRef.child("Roll no4").setValue(Rollno4);
                        childRef.child("Phone no4").setValue(Phoneno4);




                        Toast.makeText(registrationPaper.this, "Registration done For Paper Presentation ",
                                Toast.LENGTH_LONG).show();
                        startActivity(new Intent(registrationPaper.this, MainActivity.class));
                    }

                }
                else
                {
                    Toast.makeText(registrationPaper.this,R.string.string_internet_connection_not_available,
                            Toast.LENGTH_LONG).show();}}
        });
    }
    private boolean isPhonenovalid(String Phone){
        return Phone.length()==10;
    }
}
