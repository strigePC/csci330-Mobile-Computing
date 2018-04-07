package com.example.strig.mobilecomputingclass.le180208_BoundServices;

import android.Manifest;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

public class GPSService extends Service {
    public final IBinder binder = new GPSServiceBinder();
    private LocationManager locationManager;
    private double latitude;
    private double longitude;

    public GPSService() {
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        final Handler handler = new Handler();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        final Context context = this;

        handler.post(new Runnable() {
            @Override
            public void run() {
                String provider = locationManager.getBestProvider(new Criteria(), true);
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                locationManager.requestLocationUpdates(provider, 1000, 1, new LocationListener() {
                    @Override
                    public void onLocationChanged(Location location) {
                        Log.e("LOC", String.valueOf(location.getLatitude()));
                        latitude = location.getLatitude();
                        longitude = location.getLongitude();
                    }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                });
                handler.postDelayed(this, 2000);
            }
        });
    }

    public String getInfo() {
        Log.e("ms", "MyService info requested");
        return longitude + ", " + latitude;
    }

    public class GPSServiceBinder extends Binder {
        GPSService getGPSService() {
            return GPSService.this;
        }
    }
}
