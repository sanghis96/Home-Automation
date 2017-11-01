package com.example.pc.anew;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity
{
    private Button cnrlbtn;
    private Button stsbtn;
    private FirebaseAuth firebaseAuth;
    private Button logout;
    private Button manage;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();



        FirebaseUser user = firebaseAuth.getCurrentUser();

        cnrlbtn = (Button) findViewById(R.id.cnrlbtn);
        stsbtn = (Button) findViewById(R.id.stsbtn);
        logout = (Button) findViewById(R.id.logout);
        manage = (Button) findViewById(R.id.manage);
        cnrlbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                Intent i=new Intent(MainActivity.this,Control.class);
                startActivity(i);

            }
        });
        manage.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                Intent i=new Intent(MainActivity.this,ManageAppliance.class);
                startActivity(i);


            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                    firebaseAuth.signOut();
                    finish();
                    Intent i=new Intent(MainActivity.this,LoginPage.class);
                    startActivity(i);            }
        });
        stsbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
               Intent i=new Intent(MainActivity.this,MainActivity.class);
               startActivity(i);

            }
        });

    }



}
