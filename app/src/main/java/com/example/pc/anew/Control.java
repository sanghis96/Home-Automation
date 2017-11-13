package com.example.pc.anew;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

/**
 * Created by kanak on 08-10-2017.
 */

public class Control extends AppCompatActivity {


    public int App_index = -1;
    public String App_Status;
    String[] words;
    private TextView voiceInput;
    private TextView speakButton;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    public ArrayList<String> Appliances = new ArrayList<>();
    public ArrayList<String> Status1 = new ArrayList<>();
    private static final String TAG = "ERROR";
    private FirebaseAuth firebaseAuth;
    UserInformation usr;
    private DatabaseReference databaseAppliance;
    boolean flag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_speech);

        voiceInput = (TextView) findViewById(R.id.voiceInput);
        speakButton = (TextView) findViewById(R.id.btnSpeak);


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
                    Appliances.add(ua.getAddappliance());
                    Status1.add(ua.getStatus());
                }
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

        speakButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                askSpeechInput();
            }
        });

    }

    // Showing google speech input dialog

    private void askSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hi speak something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }

    // Receiving speech input

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    voiceInput.setText(result.get(0));
                    System.out.println(result.get(0).toLowerCase());
                    System.out.println("0");
                    words = result.get(0).toLowerCase().split(" ");
                    Iterator itr = Appliances.iterator();
                    int j = 0;
                    while(itr.hasNext())
                    {
                        System.out.println("1");
                        String appliance = itr.next().toString();
                        System.out.println(appliance);
                        int i = 0;
                        for(i=0;i<words.length;i++)
                        {
                            System.out.println("2");
                            System.out.println(words[i]);
                            if(words[i].equals(appliance))
                            {
                                System.out.println("3");
                                App_index = j;
                                break;
                            }
                        }
                        if( i!= words.length)
                            break;
                        System.out.println("4");
                        j++;
                    }
                    for(int i=0;i<words.length;i++)
                    {
                        System.out.println("5");
                        if(words[i].equals("on")) {
                            System.out.println("6");
                            App_Status = "on";
                            break;
                        }
                        if(words[i].equals("off") || words[i].equals("of")) {
                            System.out.println("7");
                            App_Status = "off";
                            break;
                        }
                        System.out.println("8");
                    }
                    System.out.println("9");
                    System.out.println(Appliances.get(App_index) + " " + App_Status.toString());
                    System.out.println("Actual Status: " + Status1.get(App_index));
                    if(App_index == -1) {
                        Toast.makeText(this,"Appliance not Found",Toast.LENGTH_LONG).show();
                    } else {
                        if(App_Status.equals(Status1.get(App_index)))
                            Toast.makeText(this,Appliances.get(App_index) + " already " + (App_Status=="on"?"ON":"OFF") ,Toast.LENGTH_LONG).show();
                        else {
                            updateAppStatus(Appliances.get(App_index), App_Status);
                        }
                    }
                }
                break;
            }
        }
        Intent i=new Intent(Control.this,MainActivity.class);
        startActivity(i);
    }

    private void updateAppStatus(final String appliance,final String status) {
        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseAppliance = FirebaseDatabase.getInstance().getReference("Users").child(user.getUid());



        databaseAppliance.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                usr=dataSnapshot.getValue(UserInformation.class);
                //int appId = 0;
                for(UserAppliance ua:usr.getAppliances())
                {
                    if(ua.getAddappliance() == appliance) {
                        ua.setStatus(status);
                    }
                }

                databaseAppliance.setValue(usr);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });
    }
}