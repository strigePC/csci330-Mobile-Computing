package com.example.strig.mobilecomputingclass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private ListView assignmentsList;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignmentsList = findViewById(R.id.assignments_list);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    intent = new Intent(MainActivity.this, HomeworkActivity.class);
                    startActivity(intent);
                } else if (i == 1) {
                    intent = new Intent(MainActivity.this, ExercisesActivity.class);
                    startActivity(intent);
                }
            }
        };

        assignmentsList.setOnItemClickListener(listener);
    }
}
