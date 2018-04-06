package com.example.strig.mobilecomputingclass.le180215_Notifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.strig.mobilecomputingclass.R;

public class NotificationActivity extends AppCompatActivity {
    private NotificationManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        AirplaneModeReceiver reciever = new AirplaneModeReceiver();

        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel;
        Notification.Builder nb;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel("default",
                    "Notification Activity", NotificationManager.IMPORTANCE_DEFAULT);

            channel.setLightColor(Color.GREEN);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            manager.createNotificationChannel(channel);

            nb = new Notification.Builder(this, "default");
        } else {
            nb = new Notification.Builder(this);
        }

        final Notification n = nb.setContentTitle("Message")
                .setContentText("Some sample text from activity")
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .setAutoCancel(true)
                .build();

        findViewById(R.id.le180215_notify_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                manager.notify(1, n);
            }
        });
    }
}
