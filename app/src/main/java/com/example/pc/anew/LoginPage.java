package com.example.pc.anew;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by kanak on 10-10-2017.
 */

public class LoginPage extends AppCompatActivity
{
    private Button btn1;
    private Button btn2;
    private EditText email;
    private EditText pwd;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() != null)
        {
            finish();
            Intent i=new Intent(LoginPage.this,LoginPage.class);
            startActivity(i);
        }

        email=(EditText) findViewById(R.id.u_name);
        pwd=(EditText) findViewById(R.id.pwd);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        progressDialog = new ProgressDialog(this);
        btn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                userLogin();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                finish();
                Intent i=new Intent(LoginPage.this,SignUp.class);
                startActivity(i);

            }
        });


    }
    private void userLogin(){
        String email1 = email.getText().toString().trim();
        String password1  = pwd.getText().toString().trim();

        if(TextUtils.isEmpty(email1)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password1)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        progressDialog.setMessage("Logging In Please Wait...");
        progressDialog.show();

        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(email1, password1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        if(task.isSuccessful())
                        {
                            finish();
                            Intent i=new Intent(LoginPage.this,MainActivity.class);
                            startActivity(i);
                        }
                        else
                        {
                            Toast.makeText(LoginPage.this,"Enter Valid Email/Password",Toast.LENGTH_LONG).show();
                        }
                    }
                });

    }



}
