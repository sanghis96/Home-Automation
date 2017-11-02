package com.example.pc.anew;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by kanak on 08-10-2017.
 */

public class Control extends AppCompatActivity {


    public int App_index = -1;
    public Boolean App_Status;
    String[] words;
    private TextView voiceInput;
    private TextView speakButton;
    private final int REQ_CODE_SPEECH_INPUT = 100;
    public ArrayList<String> Appliances = new ArrayList<>();
    Control() {
        Appliances.add("fan");
        Appliances.add("tubelight");
        Appliances.add("led");
        Appliances.add("tv");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_speech);

        voiceInput = (TextView) findViewById(R.id.voiceInput);
        speakButton = (TextView) findViewById(R.id.btnSpeak);


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
                    System.out.println(result.get(0));
                    System.out.println("0");
                    words = result.get(0).split(" ");
                    Iterator itr = Appliances.iterator();
                    while(itr.hasNext())
                    {
                        System.out.println("1");
                        String koibhi = itr.next().toString();
                        System.out.println(koibhi);
                        int i = 0;
                        for(i=0;i<words.length;i++)
                        {
                            System.out.println("2");
                            System.out.println(words[i]);
                            if(words[i].equals(koibhi))
                            {
                                System.out.println("3");
                                App_index = i;
                                break;
                            }
                        }
                        if( i!= words.length)
                            break;
                        System.out.println("4");
                    }
                    for(int i=0;i<words.length;i++)
                    {
                        System.out.println("5");
                        if(words[i].equals("on")) {
                            System.out.println("6");
                            App_Status = true;
                            break;
                        }
                        if(words[i].equals("off")) {
                            System.out.println("7");
                            App_Status = false;
                            break;
                        }
                        System.out.println("8");
                    }
                    System.out.println("9");
                }
                break;
            }


        }
    }
}