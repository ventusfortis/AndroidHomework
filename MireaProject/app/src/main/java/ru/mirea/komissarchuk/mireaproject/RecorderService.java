package ru.mirea.komissarchuk.mireaproject;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;


import java.io.IOException;

public class RecorderService extends Service {
    private MediaPlayer mediaPlayer;
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
    @Override
    public void onCreate(){
        mediaPlayer = new MediaPlayer();
    }

    public void onPrepared(MediaPlayer player) {
        player.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId){
        Log.d("RecorderService", intent.getStringExtra("audioFilePath"));
        try {
            mediaPlayer.setDataSource(intent.getStringExtra("audioFilePath"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        mediaPlayer.setOnPreparedListener(this::onPrepared);
        mediaPlayer.prepareAsync();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        mediaPlayer.stop();
    }
}