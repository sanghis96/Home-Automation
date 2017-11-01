package com.example.pc.anew;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by kanak on 08-10-2017.
 */

public class Status extends ActionBarActivity {
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

        switch(c.App_index) {
            case 0:
                if(switch1.getShowText()) {
                    if(c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch1.toggle();
                    }
                } else {
                    if(c.App_Status) {
                        switch1.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case 1:
                if(switch2.getShowText()) {
                    if(c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch2.toggle();
                    }
                } else {
                    if(c.App_Status) {
                        switch2.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case 2:
                if(switch3.getShowText()) {
                    if(c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch3.toggle();
                    }
                } else {
                    if(c.App_Status) {
                        switch3.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case 3:
                if(switch4.getShowText()) {
                    if(c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch4.toggle();
                    }
                } else {
                    if(c.App_Status) {
                        switch4.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            default:
                if(switch5.getShowText()) {
                    if(c.App_Status) {
                        Toast.makeText(this, "Appliance already ON", Toast.LENGTH_LONG).show();
                    } else {
                        switch5.toggle();
                    }
                } else {
                    if(c.App_Status) {
                        switch5.toggle();
                    } else {
                        Toast.makeText(this, "Appliance already OFF", Toast.LENGTH_LONG).show();
                    }
                }
        }


    }
}
