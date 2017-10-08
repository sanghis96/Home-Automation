package com.example.pc.anew;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by kanak on 08-10-2017.
 */

public class Status extends ActionBarActivity {
    Switch mySwitch,switch3,switch4,switch5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.status_appliances);
        mySwitch = (Switch) findViewById(R.id.mySwitch);
        switch3 = (Switch) findViewById(R.id.switch3);
        switch4 = (Switch) findViewById(R.id.switch4);
        switch5 = (Switch) findViewById(R.id.switch5);
    }
}
