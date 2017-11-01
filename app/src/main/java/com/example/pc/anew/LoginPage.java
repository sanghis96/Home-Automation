package com.example.pc.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by kanak on 10-10-2017.
 */

public class LoginPage extends AppCompatActivity
{
    private Button btn1;
    private Button btn2;
    private EditText email;
    private EditText pwd;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        email=(EditText) findViewById(R.id.name);
        pwd=(EditText) findViewById(R.id.pwd);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i=new Intent(LoginPage.this,MainActivity.class);
                startActivity(i);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                Intent i=new Intent(LoginPage.this,SignUp.class);
                startActivity(i);

            }
        });

    }



}
