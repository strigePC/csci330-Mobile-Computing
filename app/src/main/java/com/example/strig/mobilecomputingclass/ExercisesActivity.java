package com.example.strig.mobilecomputingclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.strig.mobilecomputingclass.le180116.TouchAndViewActivity;
import com.example.strig.mobilecomputingclass.le180329.LiveWallpaperActivity;

public class ExercisesActivity extends AppCompatActivity {
    private ListView exercisesList;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        exercisesList = (ListView) findViewById(R.id.exercises_list);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    intent = new Intent(ExercisesActivity.this, TouchAndViewActivity.class);
                    startActivity(intent);
                } else if (i == 16) {
                    intent = new Intent(ExercisesActivity.this, LiveWallpaperActivity.class);
                    startActivity(intent);
                }
            }
        };

        exercisesList.setOnItemClickListener(listener);
    }
}
