package com.example.strig.mobilecomputingclass.hw01_Clicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.strig.mobilecomputingclass.R;

import java.util.Random;

public class EyeBallClicker extends AppCompatActivity {

    private TextView counterText;
    private ImageView eyeball;
    private Double counter = 0.0;
    private Double speed = 1.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye_ball_clicker);

        eyeball = findViewById(R.id.eyeballImage);
        counterText = findViewById(R.id.clickCounter);

        eyeball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                counter += speed;

                String counterString = "";
                if (counter < 100) {
                } else if (counter < 1000) {
                    speed = counter * 0.1 * random.nextDouble();
                } else if (counter < 10000) {
                    speed = counter * 0.08 * random.nextDouble();
                } else if (counter < 1000000) {
                    speed = counter * 0.04 * random.nextDouble();
                } else if (counter >= 1000000) {
                    speed = counter * 0.01 * random.nextDouble();
                }

                counterString = String.format("%.0f", counter);
                String end = (counter.intValue() % 10 == 1) ? "" : "(s)";

                String newCounterText = String.format(
                        getResources().getString(R.string.hw01_counter_template),
                        counterString,
                        end);
                counterText.setText(newCounterText);
            }
        });
    }
}
