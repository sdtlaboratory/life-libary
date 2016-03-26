package com.sdt.alexander.lifelibrary.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import com.sdt.alexander.lifelibrary.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 3/23/2016.
 */
public class ConnectivityReceiver extends BroadcastReceiver {

    public final static List<ConnectivityObserver> observers = new ArrayList<>();
    public Boolean isNetworkEnabled = false;

    private ConnectivityReceiver() {
        ConnectivityManager cm = (ConnectivityManager) App.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        isNetworkEnabled = cm.getActiveNetworkInfo().isConnected();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction().equalsIgnoreCase(ConnectivityManager.CONNECTIVITY_ACTION)) {
            Boolean connected = intent.getExtras().getBoolean(ConnectivityManager.EXTRA_NO_CONNECTIVITY, Boolean.FALSE);
            for (ConnectivityObserver observer : observers) {
                observer.observe(connected);
            }
        }
    }

    public interface ConnectivityObserver {
        void observe(Boolean connected);
    }
}
