package com.example.strig.mobilecomputingclass.le180313_Testing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.strig.mobilecomputingclass.R;

import java.util.regex.Pattern;

public class TestingActivity extends AppCompatActivity {

    Intent i;
    EditText fname, lname;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);

        fname = findViewById(R.id.le180313_fname);
        lname = findViewById(R.id.le180313_lname);
        b = findViewById(R.id.le180313_submit_button);
        i = new Intent(this, TextActivity.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = "";
                if (areValid(fname.getText().toString(), lname.getText().toString())) {
                    fullname = String.format("%s %s", fname.getText().toString(), lname.getText().toString());
                }
                i.putExtra("fullname", fullname);
                startActivity(i);
            }
        });
    }

    public static boolean areValid(String fname, String lname) {
        String regexp = "^[A-Z][a-z]+$";
        return Pattern.matches(regexp, fname) && Pattern.matches(regexp, lname);
    }
}
