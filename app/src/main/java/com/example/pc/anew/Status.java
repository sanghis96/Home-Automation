package com.example.pc.anew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by kanak on 26-10-2017.
 */

/*public class Status extends AppCompatActivity
{
    private Button add_btn;
    private EditText add_appliance;
    private FirebaseAuth firebaseAuth;

    private DatabaseReference databaseAppliance;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_appliance);

        firebaseAuth = FirebaseAuth.getInstance();
        add_appliance = (EditText) findViewById(R.id.add_app);
        add_btn = (Button) findViewById(R.id.add_btn);
        if(firebaseAuth.getCurrentUser() != null)
        {
            finish();
            Intent i=new Intent(Status.this,LoginPage.class);
            startActivity(i);
        }

        databaseAppliance = FirebaseDatabase.getInstance().getReference("appliances");

        add_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                saveuserAppliance();
            }
        });
    }
    private void saveuserAppliance()
    {
        String add = add_appliance.getText().toString().trim();
        if(!TextUtils.isEmpty(add))
        {
            String id = databaseAppliance.push().getKey();
            UserAppliance usr = new UserAppliance(id, add);
            databaseAppliance.child(id).setValue(usr);
            Toast.makeText(this,"Information Saved",Toast.LENGTH_LONG).show();

        }

    }
}*/