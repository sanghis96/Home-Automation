package com.example.pc.anew;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
{
    private Button cnrlbtn;
    private Button stsbtn;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cnrlbtn = (Button) findViewById(R.id.cnrlbtn);
        stsbtn = (Button) findViewById(R.id.stsbtn);
        cnrlbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i=new Intent(MainActivity.this,Control.class);
                startActivity(i);

            }
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
