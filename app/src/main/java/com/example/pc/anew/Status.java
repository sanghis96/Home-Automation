package com.example.pc.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by kanak on 26-10-2017.
 */

public class Status extends AppCompatActivity
{
    private static final String TAG ="ERROR" ;

    ListView listview;
    ArrayList<String> list = new ArrayList<>();
    FirebaseAuth firebaseAuth;
    UserInformation usr;
    private DatabaseReference databaseAppliance;
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_appliances);
        listview=(ListView)findViewById(R.id.listview);
        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseAppliance = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());
        databaseAppliance.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                usr=dataSnapshot.getValue(UserInformation.class);
                flag=true;
                for(UserAppliance ua:usr.getAppliances())
                {
                    list.add(ua.getAddappliance()+"\t\t\t\t\t\t"+ua.getStatus());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(Status.this, android.R.layout.simple_list_item_1, list);
                listview.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}