package com.sdt.alexander.lifelibrary.service;

import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.sdt.alexander.lifelibrary.App;
import com.sdt.alexander.lifelibrary.R;

/**
 * Created by Alexander on 3/24/2016.
 */
public class GPSTracker extends Service implements LocationListener {

    TrackerObserver observer;
    private static final long MIN_DISTANCE = 10; // 10 meters
    private static final long MIN_TIME = 1000 * 60; // 1 minute
    private LocationManager locationManager;
    Location location;


    public GPSTracker(Context context) {
        locationManager = (LocationManager) App.getAppContext().getSystemService(LOCATION_SERVICE);
    }

    public Location startTracker() {
        if (locationManager == null) {
            return null;
        }

        boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

        if (isGPSEnabled) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
        } else if (isNetworkEnabled) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, this);
        }

        return location;
    }

    public void stopTracker() {
        if (locationManager != null) {
            locationManager.removeUpdates(GPSTracker.this);
        }
    }

    public void showSettingsAlert(final Context context) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(context);

        Resources resources = context.getResources();

        alertDialog.setTitle(resources.getString(R.string.gps_alert_title));
        alertDialog.setMessage(resources.getString(R.string.gps_alert_message));
        alertDialog.setPositiveButton(resources.getString(R.string.settings), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });
        alertDialog.setNegativeButton(resources.getString(R.string.cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        alertDialog.show();
    }

    @Override
    public void onLocationChanged(Location location) {
        this.location = location;
        observer.observe(location);
    }

    @Override
    public void onProviderDisabled(String provider) {
    }

    @Override
    public void onProviderEnabled(String provider) {
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }

    public interface TrackerObserver {
        void observe(Location location);
    }
}
