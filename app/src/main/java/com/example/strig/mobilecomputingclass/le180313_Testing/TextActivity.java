package com.example.strig.mobilecomputingclass.le180313_Testing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.strig.mobilecomputingclass.R;

public class TextActivity extends AppCompatActivity {

    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);

        t = findViewById(R.id.le180313_names);

        String fullname = getIntent().getStringExtra("fullname");

        t.setText(fullname);
    }
}
