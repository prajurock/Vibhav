package com.vibhav2k17.android.vibhav2k17.registation;

import android.app.Activity;
import android.content.Intent;
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

/**
 * Created by prajwal on 24/10/17.
 */

public class registrationPlacement extends Activity {


    private EditText mValueField1;
    private EditText mValueField2;
    private EditText mValueField3;
    private EditText mValueField4;
        private Button massBtn;
    private Firebase mRootref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_placement);

        Firebase.setAndroidContext(this);

        mRootref=new Firebase("https://vibhav-4b5b9.firebaseio.com/PlacementFever");

        mValueField1= (EditText) findViewById(R.id.valueField);
        massBtn= (Button) findViewById(R.id.addBtn);
        mValueField2= (EditText) findViewById(R.id.valueField2);
        mValueField3= (EditText) findViewById(R.id.editText3);
        mValueField4= (EditText) findViewById(R.id.editText4);

        massBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (InternetConnection.checkConnection(getApplicationContext())){
                    String name=mValueField1.getText().toString();
                    String Rollno=mValueField2.getText().toString();
                    String Phoneno=mValueField3.getText().toString();
                    String email=mValueField4.getText().toString();
                    Firebase childRef=mRootref.child(Rollno);
                    boolean cancel = false;
                    View focusView = null;
                    if (TextUtils.isEmpty(name)) {
                        mValueField1.setError(getString(R.string.error_field_required));
                        focusView = mValueField1;
                        cancel = true;
                    }
                    if (TextUtils.isEmpty(Rollno)) {
                        mValueField2.setError(getString(R.string.error_field_required));
                        focusView = mValueField2;
                        cancel = true;
                    }
                    if (TextUtils.isEmpty(Phoneno)) {
                        mValueField3.setError(getString(R.string.error_field_required));
                        focusView = mValueField3;
                        cancel = true;
                    }else if (!isPhonenovalid(Phoneno)){
                        mValueField3.setError(getString(R.string.Invalid_no));
                        focusView=mValueField3;
                        cancel=true;
                    }

                    if (TextUtils.isEmpty(email)) {
                        mValueField4.setError(getString(R.string.error_field_required));
                        focusView = mValueField4;
                        cancel = true;
                    } else if (!isEmailValid(email)) {
                        mValueField4.setError(getString(R.string.error_invalid_email));
                        focusView = mValueField4;
                        cancel = true;
                    }

                    //childRef.setValue(value);
                    if(name.isEmpty()==true||Rollno.isEmpty()==true||Phoneno.isEmpty()==true||email.isEmpty()==true||isEmailValid(email)==false||isPhonenovalid(Phoneno)==false)
                    {

                    }
                    else {
                        childRef.child("Name").setValue(name);
                        childRef.child("Roll no").setValue(Rollno);
                        childRef.child("Phone no").setValue(Phoneno);
                        childRef.child("Email").setValue(email);


                        Toast.makeText(registrationPlacement.this, "Registration done For Placement Fever",
                                Toast.LENGTH_LONG).show();
                        startActivity(new Intent(registrationPlacement.this, MainActivity.class));
                    }

                }
                else
                {
                    Toast.makeText(registrationPlacement.this,R.string.string_internet_connection_not_available,
                            Toast.LENGTH_LONG).show();}}
        });

    }
    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }
    private boolean isPhonenovalid(String Phone){
        return Phone.length()==10;
    }
}


