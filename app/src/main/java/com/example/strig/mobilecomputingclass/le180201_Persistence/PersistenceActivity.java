package com.example.strig.mobilecomputingclass.le180201_Persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.strig.mobilecomputingclass.R;

public class PersistenceActivity extends AppCompatActivity {
    SQLiteOpenHelper dbHelper;

    Button search;
    Button add;

    EditText fullname_input;
    EditText country_input;
    EditText age_input;
    EditText skill_input;

    LinearLayout players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persistence);

        dbHelper = new FIFA18PlayersDatabaseHelper(this);

        search = findViewById(R.id.le180201_search_button);
        add = findViewById(R.id.le180201_add_button);

        fullname_input = findViewById(R.id.le180201_fullname_input);
        country_input = findViewById(R.id.le180201_country_input);
        age_input = findViewById(R.id.le180201_age_input);
        skill_input = findViewById(R.id.le180201_skill_input);

        players = findViewById(R.id.le180201_players);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchPlayer(fullname_input.getText().toString());
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPlayer(fullname_input.getText().toString(),
                        country_input.getText().toString(),
                        age_input.getText().toString(),
                        skill_input.getText().toString());
            }
        });

    }

    public void addPlayer(String fullname, String country, String age, String skill) {
        ContentValues player = new ContentValues();
        if (fullname.isEmpty() || country.isEmpty() || age.isEmpty() || skill.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "All fields should be specified",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        player.put("FULLNAME", fullname);
        player.put("COUNTRY", country);
        player.put("AGE", age);
        player.put("SKILL", skill);

        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.insert("PLAYERS", null, player);
        fullname_input.setText("");
        country_input.setText("");
        age_input.setText("");
        skill_input.setText("");
        Toast.makeText(getApplicationContext(),
                "Player " + fullname + " added",
                Toast.LENGTH_LONG).show();
        db.close();

    }

    public void searchPlayer(String fullname) {
        if (fullname.isEmpty()) {
            Toast.makeText(getApplicationContext(),
                    "Fullname field should be specified",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        String query = "SELECT * FROM PLAYERS WHERE FULLNAME LIKE '%" + fullname + "%'";

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if((players).getChildCount() > 0)
            (players).removeAllViews();

        if (cursor.moveToFirst()) {
            do {
                TextView t = new TextView(this);
                t.setLayoutParams(new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

                t.setText(String.format("%s (%s), Age: %s - %s",
                        cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
                players.addView(t);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }
}
