package com.example.strig.mobilecomputingclass.le180208_BoundServices;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.strig.mobilecomputingclass.R;

public class BoundServiceActivity extends AppCompatActivity {
    private GPSService s;
    private boolean servicebound = false;
    private TextView t;

    private ServiceConnection sc = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            GPSService.GPSServiceBinder b = (GPSService.GPSServiceBinder) iBinder;
            s = b.getGPSService();
            servicebound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            servicebound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent i = new Intent(this, GPSService.class);
        bindService(i, sc, Context.BIND_AUTO_CREATE);

        this.interactWithService();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (servicebound) {
            unbindService(sc);
            servicebound = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);

        t = findViewById(R.id.le180208_text);
    }

    private void interactWithService() {
        final Handler h = new Handler();
        h.post(new Runnable() {
            @Override
            public void run() {
                if (servicebound) {
                    t.setText(s.getInfo());
                }

                h.postDelayed(this, 1000);
            }
        });
    }
}
