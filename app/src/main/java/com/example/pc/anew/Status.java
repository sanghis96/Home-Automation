package com.example.pc.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
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

/*public class Status extends AppCompatActivity {
    Switch switch1,switch3,switch4,switch2,switch5;
    TextView app1,app2,app3,app4;
    Control c = new Control();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_appliances);
        app1 = (TextView) findViewById(R.id.t1);
        app2 = (TextView) findViewById(R.id.t2);
        app3 = (TextView) findViewById(R.id.t3);
        app4 = (TextView) findViewById(R.id.t4);

        app1.setText(c.Appliances.get(0));
        app2.setText(c.Appliances.get(1));
        app3.setText(c.Appliances.get(2));
        app4.setText(c.Appliances.get(3));

        switch1 = (Switch) findViewById(R.id.switch1);
        switch2 = (Switch) findViewById(R.id.switch2);
        switch3 = (Switch) findViewById(R.id.switch3);
        switch4 = (Switch) findViewById(R.id.switch4);
        switch5 = (Switch) findViewById(R.id.switch5);

        switch (c.App_index) {
            case 0:
                if (switch1.getShowText()) {
                    if (c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch1.toggle();
                    }
                } else {
                    if (c.App_Status) {
                        switch1.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case 1:
                if (switch2.getShowText()) {
                    if (c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch2.toggle();
                    }
                } else {
                    if (c.App_Status) {
                        switch2.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case 2:
                if (switch3.getShowText()) {
                    if (c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch3.toggle();
                    }
                } else {
                    if (c.App_Status) {
                        switch3.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case 3:
                if (switch4.getShowText()) {
                    if (c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch4.toggle();
                    }
                } else {
                    if (c.App_Status) {
                        switch4.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            default:
                if (switch5.getShowText()) {
                    if (c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch5.toggle();
                    }
                } else {
                    if (c.App_Status) {
                        switch5.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
          }
        }
    }*/

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