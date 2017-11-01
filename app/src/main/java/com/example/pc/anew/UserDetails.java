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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kanak on 26-10-2017.
 */

public class UserDetails extends AppCompatActivity {
    private Button save;
    private EditText name;
    private EditText address;
    private EditText phone;
    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseReference;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details);

        firebaseAuth = FirebaseAuth.getInstance();
        name = (EditText) findViewById(R.id.u_name);
        phone = (EditText) findViewById(R.id.u_phone);
        address = (EditText) findViewById(R.id.u_address);
        save = (Button) findViewById(R.id.u_save);
        if(firebaseAuth.getCurrentUser() != null)
        {
            finish();
            Intent i=new Intent(UserDetails.this,LoginPage.class);
            startActivity(i);
        }

        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                saveuserInformation();
            }
        });
    }
    private void saveuserInformation()
    {
        String name1 = name.getText().toString().trim();
        String phone1 = phone.getText().toString().trim();
        String address1 = address.getText().toString().trim();

        UserInformation userInformation = new UserInformation(name1,phone1,address1);

        FirebaseUser user = firebaseAuth.getCurrentUser();
         databaseReference.child(user.getUid()).setValue(userInformation);

        Toast.makeText(this,"Information Saved",Toast.LENGTH_LONG).show();
        Intent i=new Intent(UserDetails.this,MainActivity.class);
        startActivity(i);
    }
}

