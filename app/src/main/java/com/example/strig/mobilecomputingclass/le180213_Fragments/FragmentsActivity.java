package com.example.strig.mobilecomputingclass.le180213_Fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.strig.mobilecomputingclass.R;

public class FragmentsActivity extends AppCompatActivity
        implements MovieListFragment.MovieListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments);
    }

    @Override
    public void itemClicked(long id) {
        MovieFragment f = new MovieFragment();
        f.setId(id);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.le180213_frag_position, f)
                .commit();
    }
}
