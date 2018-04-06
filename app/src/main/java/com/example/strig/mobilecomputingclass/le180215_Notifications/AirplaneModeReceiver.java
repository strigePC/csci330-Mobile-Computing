package com.example.strig.mobilecomputingclass.le180215_Notifications;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AirplaneModeReceiver extends BroadcastReceiver {
    private static final String TAG = "AirplaneModeReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "USB Connected");
        Toast.makeText(context, "USB Connected", Toast.LENGTH_SHORT).show();
    }
}
