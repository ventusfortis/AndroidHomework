package ru.mirea.komissarchuk.looper;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import java.util.concurrent.ThreadLocalRandom;

public class MyLooper extends Thread {
    private int number = 0;

    Handler handler;
    @SuppressLint("HandlerLeak")
    @Override
    public void run(){
        Log.d("MyLooper", "run");
        Looper.prepare();
        handler = new Handler(){
            @Override
            public void handleMessage(Message msg){
                Log.d("MyLooper", number + ":"+ msg.getData().getString("KEY"));
                Log.d("MyLooper",number + ":" + msg.getData().getString("JOB"));
                Log.d("MyLooper", number + ":" + msg.getData().getString("AGE"));
                number++;
            }
        };
        Looper.loop();
    }
}