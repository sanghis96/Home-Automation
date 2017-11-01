package com.example.pc.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ManageAppliance extends AppCompatActivity {
    private Button add1;
    private Button remove1;
    private FirebaseAuth firebaseAuth;
    private TextView a;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_appliances);
        firebaseAuth = FirebaseAuth.getInstance();


        FirebaseUser user = firebaseAuth.getCurrentUser();

        add1 = (Button) findViewById(R.id.btnadd);
        remove1 = (Button) findViewById(R.id.btnrmv);
        a = (TextView) findViewById(R.id.tw);

        add1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(ManageAppliance.this, AddAppliance.class);
                startActivity(i);

            }
        });
    }
}