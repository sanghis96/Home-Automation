package com.example.pc.anew;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity
{
    private static final String TAG = "ERROR";
    private Button cnrlbtn;
    private Button stsbtn;
    private FirebaseAuth firebaseAuth;
    private Button logout;
    private Button manage;
    ArrayList<UserAppliance> list = new ArrayList<>();
    UserInformation usr;
    private DatabaseReference databaseAppliance;
    boolean flag=false;

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
               Intent i=new Intent(MainActivity.this,Status.class);
               startActivity(i);

            }
        });


        }

    }
