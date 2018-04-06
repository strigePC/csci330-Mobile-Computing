package com.example.strig.mobilecomputingclass;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.strig.mobilecomputingclass.le180116_TouchAndCustomViews.TouchAndViewActivity;
import com.example.strig.mobilecomputingclass.le180118_ToolbarAndRESTAPIs.ToolbarRESTActivity;
import com.example.strig.mobilecomputingclass.le180123_Sensors.SensorActivity;
import com.example.strig.mobilecomputingclass.le180125_Camera.CameraActivity;
import com.example.strig.mobilecomputingclass.le180201_Persistence.PersistenceActivity;
import com.example.strig.mobilecomputingclass.le180206_StartedServices.StartedServiceActivity;
import com.example.strig.mobilecomputingclass.le180208_BoundServices.BoundServiceActivity;
import com.example.strig.mobilecomputingclass.le180213_Fragments.FragmentsActivity;
import com.example.strig.mobilecomputingclass.le180215_Notifications.NotificationActivity;
import com.example.strig.mobilecomputingclass.le180222_GoogleMaps.MapsActivity;
import com.example.strig.mobilecomputingclass.le180301_OpenGL.OpenGLES20Activity;
import com.example.strig.mobilecomputingclass.le180313_Testing.TestingActivity;
import com.example.strig.mobilecomputingclass.le180329_LiveWallpaper.LiveWallpaperActivity;

public class ExercisesActivity extends AppCompatActivity {
    private ListView exercisesList;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        exercisesList = findViewById(R.id.exercises_list);

        AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        intent = new Intent(ExercisesActivity.this, TouchAndViewActivity.class);
                        break;
                    case 1:
                        intent = new Intent(ExercisesActivity.this, ToolbarRESTActivity.class);
                        break;
                    case 2:
                        intent = new Intent(ExercisesActivity.this, SensorActivity.class);
                        break;
                    case 3:
                        intent = new Intent(ExercisesActivity.this, CameraActivity.class);
                        break;
                    case 4:
//                        intent = new Intent(ExercisesActivity.this, ListsActivity.class);
                        break;
                    case 5:
                        intent = new Intent(ExercisesActivity.this, PersistenceActivity.class);
                        break;
                    case 6:
                        intent = new Intent(ExercisesActivity.this, StartedServiceActivity.class);
                        break;
                    case 7:
                        intent = new Intent(ExercisesActivity.this, BoundServiceActivity.class);
                        break;
                    case 8:
                        intent = new Intent(ExercisesActivity.this, FragmentsActivity.class);
                        break;
                    case 9:
                        intent = new Intent(ExercisesActivity.this, NotificationActivity.class);
                        break;
                    case 10:
//                        intent = new Intent(ExercisesActivity.this, FirebaseActivity.class);
                        break;
                    case 11:
                        intent = new Intent(ExercisesActivity.this, MapsActivity.class);
                        break;
                    case 12:
//                        intent = new Intent(ExercisesActivity.this, WifiDirectActivity.class);
                        break;
                    case 13:
                        intent = new Intent(ExercisesActivity.this, OpenGLES20Activity.class);
                        break;
                    case 14:
//                        intent = new Intent(ExercisesActivity.this, OpenGLES3D20Activity.class);
                        break;
                    case 15:
                        intent = new Intent(ExercisesActivity.this, TestingActivity.class);
                        break;
                    case 16:
                        intent = new Intent(ExercisesActivity.this, LiveWallpaperActivity.class);
                        break;
                    case 17:
//                        intent = new Intent(ExercisesActivity.this, PagerActivity.class);
                        break;
                }

                startActivity(intent);
            }
        };

        exercisesList.setOnItemClickListener(listener);
    }
}
