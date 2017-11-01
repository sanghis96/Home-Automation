package com.example.pc.anew;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

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
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        firebaseAuth = FirebaseAuth.getInstance();
        email=(EditText) findViewById(R.id.email1);
        pwd=(EditText) findViewById(R.id.pwd);
        signin=(TextView) findViewById(R.id.link);
        btnc = (Button) findViewById(R.id.create);
        progressDialog = new ProgressDialog(this);

        btnc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                registerUser();
                Intent i=new Intent(SignUp.this,UserDetails.class);
                startActivity(i);
            }
        });


        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                finish();
                Intent i=new Intent(SignUp.this,LoginPage.class);
                startActivity(i);

            }
        });
    }
    private void registerUser()
    {
        String email1 = email.getText().toString().trim();
        String pwd1 = pwd.getText().toString().trim();

        if(TextUtils.isEmpty(email1)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(pwd1)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }
        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email1,pwd1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if(task.isSuccessful())
                        {
                            Toast.makeText(SignUp.this,"Successfully registered",Toast.LENGTH_LONG).show();


                        }
                        else
                            {
                                Toast.makeText(SignUp.this,"Registration Error",Toast.LENGTH_LONG).show();
                            }
                        progressDialog.dismiss();
                    }
                });

    }

}
