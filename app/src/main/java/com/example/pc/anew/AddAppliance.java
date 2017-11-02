package com.example.pc.anew;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by kanak on 26-10-2017.
 */

public class AddAppliance extends AppCompatActivity
{
    private static final String TAG ="LOG" ;
    private Button addb;
    private EditText addapp;
    private TextView addpli;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseAppliance;
    UserInformation usr;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_appliance);

        firebaseAuth = FirebaseAuth.getInstance();
        addapp=(EditText) findViewById(R.id.add_app);
        addpli=(TextView) findViewById(R.id.tw3);
        addb = (Button) findViewById(R.id.add_appbtn);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseAppliance = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        final String add_appname = addapp.getText().toString().trim();
        databaseAppliance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                usr=dataSnapshot.getValue(UserInformation.class);
                /*ArrayList<UserAppliance> arrayList=usr.getAppliances();
                if(arrayList.size()==0){
                    UserAppliance userAppliance = new UserAppliance(0, add_appname );
                    arrayList.add(userAppliance);
                }else{
                    UserAppliance userAppliance = new UserAppliance(arrayList.size()+1, add_appname );
                    arrayList.add(userAppliance);
                }

                usr.setAppliances(arrayList);
                UpdateingUsr=usr;*/
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
        addb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                registerApp();
            }
        });

    }
    private void registerApp()
    {
        final String add_appname = addapp.getText().toString().trim();

        if(!TextUtils.isEmpty(add_appname))
        {
            ArrayList<UserAppliance> arrayList=usr.getAppliances();
            if(arrayList.size()==0){
                UserAppliance userAppliance = new UserAppliance(0, add_appname );
                arrayList.add(userAppliance);
            }else{
                UserAppliance userAppliance = new UserAppliance(arrayList.size()+1, add_appname );
                arrayList.add(userAppliance);
            }

            usr.setAppliances(arrayList);

            databaseAppliance.setValue(usr);

//            databaseAppliance.child(user.getUid()).child("appliances").child(id1).setValue(userAppliance);
            Toast.makeText(this,"Information Saved",Toast.LENGTH_LONG).show();
        }
    }



}