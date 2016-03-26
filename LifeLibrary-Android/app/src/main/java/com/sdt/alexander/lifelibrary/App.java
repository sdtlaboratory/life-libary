package com.sdt.alexander.lifelibrary;

import android.app.Application;
import android.content.Context;

/**
 * Created by Alexander on 3/24/2016.
 */
public class App extends Application {
    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;
    }

    public static Context getAppContext() {
        return appContext;
    }
}
