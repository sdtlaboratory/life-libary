package com.sdt.alexander.lifelibrary;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.sdt.alexander.lifelibrary.service.GPSTracker;
import com.sdt.alexander.lifelibrary.service.TrackerObserver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button addButton = (Button) findViewById(R.id.add_btn);
        final TrackerObserver observer = new TrackerObserver() {
            @Override
            public void observe(Location location) {
                String message = "Location updated:" + location.getLatitude() + ", " + location.getLongitude();
                Snackbar.make(addButton, message, Snackbar.LENGTH_LONG)
                        .setAction("Action", null)
                        .show();
            }
        };

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                GPSTracker.tracker.addObserver(observer);
            }
        });

        Button removeButton = (Button) findViewById(R.id.remove_btn);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                GPSTracker.tracker.removeObserver(observer);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
