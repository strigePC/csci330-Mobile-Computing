package com.example.strig.mobilecomputingclass.le180123_Sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.strig.mobilecomputingclass.R;

public class SensorActivity extends AppCompatActivity
        implements SensorEventListener {

    SensorManager m;
    Sensor acc;
    AccView av;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        m = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        assert m != null;
        acc = m.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        m.registerListener(this, acc, SensorManager.SENSOR_DELAY_UI);

        av = findViewById(R.id.le180123_acc_view);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        av.setDisplacement(sensorEvent);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
