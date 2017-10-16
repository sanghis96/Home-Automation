package com.example.pc.anew;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by kanak on 16-10-2017.
 */

public class SignUp extends AppCompatActivity
{
    private Button btnc;
    private EditText email;
    private EditText pwd;
    private EditText name;
    private EditText loginid;
    private TextView signin;
    private EditText a;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        email=(EditText) findViewById(R.id.email1);
        pwd=(EditText) findViewById(R.id.pawd);
        name=(EditText) findViewById(R.id.name);
        loginid=(EditText) findViewById(R.id.id);
        signin=(TextView) findViewById(R.id.link);
        btnc = (Button) findViewById(R.id.create);

        btnc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i=new Intent(SignUp.this,MainActivity.class);
                startActivity(i);

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i=new Intent(SignUp.this,LoginPage.class);
                startActivity(i);

            }
        });


    }



}