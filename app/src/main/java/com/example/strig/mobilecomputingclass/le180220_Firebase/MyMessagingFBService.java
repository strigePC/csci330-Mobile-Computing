package com.example.strig.mobilecomputingclass.le180220_Firebase;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MyMessagingFBService extends FirebaseInstanceIdService {
    private static final String TAG = "FBService";

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);
    }
}
