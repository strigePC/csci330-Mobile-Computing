package com.example.strig.mobilecomputingclass.le180206_StartedServices;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

public class LogMessageService extends IntentService {

    public LogMessageService(){
        super("LogMessageService");
    }

    public LogMessageService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Log.d(TAG, "Message Service Ran");
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        Log.d(TAG, "Service started!");
        Toast.makeText(getApplicationContext(),
                "Service Started",
                Toast.LENGTH_SHORT).show();

        return super.onStartCommand(intent, flags, startId);
    }
}
