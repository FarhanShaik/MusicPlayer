package com.example.farhan.musicplayer;

import android.app.Service;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Farhan on 9/30/2017.
 */

public class MyService extends Service{
    private MediaPlayer player = new MediaPlayer();
    boolean isPaused = true;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        try {

            player.setAudioStreamType(AudioManager.STREAM_MUSIC);
            player.setDataSource("https://s3.amazonaws.com/ametest-nbcuni/test.mp3");
            player.prepare();
            player.start();

        } catch (Exception e) {
            Toast.makeText(MyService.this, "ERROR", Toast.LENGTH_SHORT).show();
        }



        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
    }
}
