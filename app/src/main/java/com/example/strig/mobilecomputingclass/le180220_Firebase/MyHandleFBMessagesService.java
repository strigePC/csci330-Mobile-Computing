package com.example.strig.mobilecomputingclass.le180220_Firebase;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class MyHandleFBMessagesService extends FirebaseMessagingService {
    private NotificationManager manager;
    private static final String TAG = "HandleFB";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) { // ...
        // TODO(developer): Handle FCM messages here.
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());

            // Check if message contains a notification payload.
            if (remoteMessage.getNotification() != null) {
                Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
            }

            // Also if you intend on generating your own notifications as a result of a received FCM
            // message, here is where that should be initiated. See sendNotification method below.

            sendNotification(remoteMessage.getNotification());

        }
    }
    public void sendNotification(RemoteMessage.Notification rn) {
        manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationChannel channel;
        Notification.Builder nb;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            channel = new NotificationChannel("default",
                    "Firebase Activity", NotificationManager.IMPORTANCE_DEFAULT);

            channel.setLightColor(Color.GREEN);
            channel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
            manager.createNotificationChannel(channel);

            nb = new Notification.Builder(this, "default");
        } else {
            nb = new Notification.Builder(this);
        }

        Notification n = nb.setContentTitle(rn.getTitle())
                .setContentText(rn.getBody())
                .setSmallIcon(android.R.drawable.ic_dialog_email)
                .setAutoCancel(true)
                .build();

        manager.notify(1, n);
    }
}
