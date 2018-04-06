package com.example.strig.mobilecomputingclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.strig.mobilecomputingclass.hw01_Clicker.EyeBallClicker;
import com.example.strig.mobilecomputingclass.hw02_MapsAssignment.Mapito;

public class HomeworkActivity extends AppCompatActivity {
    private ListView homeworkList;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);

        homeworkList = findViewById(R.id.homework_list);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent = new Intent(HomeworkActivity.this, EyeBallClicker.class);
                        break;
                    case 1:
                        intent = new Intent(HomeworkActivity.this, Mapito.class);
                        break;
                }

                startActivity(intent);
            }
        };

        homeworkList.setOnItemClickListener(listener);
    }
}
