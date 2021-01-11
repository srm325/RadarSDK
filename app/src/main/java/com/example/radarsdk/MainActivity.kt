package com.example.radarsdk

import android.Manifest
import android.os.Build
import io.radar.sdk.Radar.initialize
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import com.example.radarsdk.R
import io.radar.sdk.Radar
import io.radar.sdk.RadarTrackingOptions

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // request permissions
        if (Build.VERSION.SDK_INT >= 23) {
            val requestCode = 0
            if (Build.VERSION.SDK_INT >= 29) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_BACKGROUND_LOCATION), requestCode)
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), requestCode)
            }
        }

        // initialize SDK (replace with your publishable API key)
        initialize(this, "prj_live_pk_4600174fdbdbe3e6de143b3c7f3dec1142bad4af")
        // start tracking
        val trackingOptions : RadarTrackingOptions = RadarTrackingOptions.Builder()
                .priority(RadarTrackingPriority.RESPONSIVENESS)
                .offline(RadarTrackingOffline.REPLAY_STOPPED)
                .sync(RadarTrackingSync.ALL)
                .build()
        Radar.startTracking(trackingOptions)

    }
}