package com.sdt.alexander.lifelibrary.service;

import android.location.Location;

/**
 * Created by Alexander on 3/27/2016.
 */
public interface TrackerObserver {
    void observe(Location location);
}
