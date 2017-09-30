package com.example.farhan.musicplayer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button start,stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        if(view==start)
            startService(new Intent(this, MyService.class));

        if(view==stop)
            stopService(new Intent(this, MyService.class));

        }
    }

