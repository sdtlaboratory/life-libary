package com.sdt.alexander.lifelibrary.service;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

import com.sdt.alexander.lifelibrary.App;
import com.sdt.alexander.lifelibrary.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 3/24/2016.
 */
public class GPSTracker {
    private final long MIN_DISTANCE = 5; // 5 meters
    private final long MIN_TIME = 1000 * 10; // 10 sec
    private LocationManager locationManager;
    private final List<TrackerObserver> observers = new ArrayList<>();
    private boolean isGPSEnabled = true;
    private LocationListener GPSListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            tracker.notifyObservers(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.OUT_OF_SERVICE:
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    isGPSEnabled = false;
                    tracker.removeNetworkListener();
                    break;
                case LocationProvider.AVAILABLE:
                    isGPSEnabled = true;
                    tracker.addNetworkListener();
                    break;
            }
        }

        @Override
        public void onProviderEnabled(String provider) {
            isGPSEnabled = true;
            tracker.addNetworkListener();
        }

        @Override
        public void onProviderDisabled(String provider) {
            isGPSEnabled = false;
            tracker.removeNetworkListener();
        }
    };

    private boolean isNetworkEnabled = true;
    private LocationListener NetworkListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            tracker.notifyObservers(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case LocationProvider.OUT_OF_SERVICE:
                case LocationProvider.TEMPORARILY_UNAVAILABLE:
                    isNetworkEnabled = false;
                    break;
                case LocationProvider.AVAILABLE:
                    isNetworkEnabled = true;
                    break;
            }
        }

        @Override
        public void onProviderEnabled(String provider) {
            isNetworkEnabled = true;
        }

        @Override
        public void onProviderDisabled(String provider) {
            isNetworkEnabled = false;
        }
    };

    public static final GPSTracker tracker = new GPSTracker();

    Location location;

    private GPSTracker() {
        locationManager = (LocationManager) App.getAppContext().getSystemService(Context.LOCATION_SERVICE);
    }

    public void addObserver(TrackerObserver observer) {
        observers.add(observer);
        if (observers.size() == 1) {
            this.startTracker();
        }
    }

    public void removeObserver(TrackerObserver observer) {
        observers.remove(observer);
        if (observers.size() == 0) {
            this.stopTracker();
        }
    }

    public boolean isLocationAvailable() {
        return isGPSEnabled || isNetworkEnabled;
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

    //------------------------------Private------------------------------
    public void notifyObservers(Location location) {
        this.location = location;
        if (observers.size() != 0) {
            if (observers.size() == 1) {
                observers.get(0).observe(location);
            } else if (observers.size() == 2) {
                observers.get(0).observe(location);
                observers.get(1).observe(location);
            } else {
                for (TrackerObserver observer : observers) {
                    observer.observe(location);
                }
            }
        }
    }

    private void addNetworkListener() {
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, MIN_TIME, MIN_DISTANCE, NetworkListener);
    }

    private void removeNetworkListener() {
        locationManager.removeUpdates(NetworkListener);
    }

    private Location startTracker() {
        if (locationManager == null) {
            return null;
        }

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, MIN_TIME, MIN_DISTANCE, GPSListener);
        this.addNetworkListener();

        return location;
    }

    private void stopTracker() {
        if (locationManager != null) {
            locationManager.removeUpdates(GPSListener);
            this.removeNetworkListener();
        }
    }
}
