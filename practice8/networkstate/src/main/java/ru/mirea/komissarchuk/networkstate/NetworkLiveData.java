package ru.mirea.komissarchuk.networkstate;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import androidx.lifecycle.LiveData;

public class NetworkLiveData extends LiveData<String> {
    private Context context;
    private BroadcastReceiver broadcastReceiver;
    private static NetworkLiveData instance;

    static NetworkLiveData getInstance(Context context) {
        if (instance == null) {
            instance = new NetworkLiveData(context);
        }
        return instance;
    }

    private NetworkLiveData(Context context) {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class");
        }
        this.context = context;
    }

    private void prepareReciever(Context context) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, android.content.Intent intent) {
                ConnectivityManager connectivityManger = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManger.getActiveNetworkInfo();
                if (networkInfo != null && networkInfo.isConnected()) {
                    postValue(networkInfo.getTypeName());
                } else {
                    postValue(null);
                }
            }
        };
        context.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override
    protected void onActive() {
        super.onActive();
        prepareReciever(context);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        context.unregisterReceiver(broadcastReceiver);
        broadcastReceiver = null;
    }
}

