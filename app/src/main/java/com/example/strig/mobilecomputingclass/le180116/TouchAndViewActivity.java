package com.example.strig.mobilecomputingclass.le180116;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.strig.mobilecomputingclass.R;

import static android.content.ContentValues.TAG;

public class TouchAndViewActivity extends AppCompatActivity
        implements View.OnTouchListener {

    private InteractingView interactingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_and_view);


        interactingView = findViewById(R.id.le180116_interacting_view);
        interactingView.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Log.d(TAG, "Touch happened " + motionEvent.getAction());
        Log.d(TAG, "x coordinate: " + String.valueOf(motionEvent.getX()));
        Log.d(TAG, "y coordinate: " + String.valueOf(motionEvent.getY()));

        interactingView.respondToTouch(motionEvent.getX(), motionEvent.getY());

        return true;
    }
}
