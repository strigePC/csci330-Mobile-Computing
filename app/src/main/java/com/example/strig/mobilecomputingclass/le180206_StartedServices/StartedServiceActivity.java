package com.example.strig.mobilecomputingclass.le180206_StartedServices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.strig.mobilecomputingclass.R;

public class StartedServiceActivity extends AppCompatActivity {
    private Button b;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_started_service);

        b = findViewById(R.id.le180206_button);
        i = new Intent(this, LogMessageService.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(i);
            }
        });
    }
}
