package com.example.strig.mobilecomputingclass.le180213_Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.strig.mobilecomputingclass.R;

public class MovieFragment extends Fragment {
    private long id;

    TextView movieTitle;
    TextView movieDirector;
    TextView movieDescription;
    ImageView moviePoster;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.movie_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        View view = getView();
        if (view != null) {
            movieTitle = view.findViewById(R.id.le180213_movie_title);
            movieDirector = view.findViewById(R.id.le180213_movie_director);
            movieDescription = view.findViewById(R.id.le180213_movie_description);
            moviePoster = view.findViewById(R.id.le180213_movie_poster);

            Movie m = Movie.movies[(int) id];

            movieTitle.setText(m.getTitle());
            movieDirector.setText(m.getDirector());
            movieDescription.setText(m.getDescription());
            moviePoster.setImageResource(m.getPoster());
        }
    }

    public void setId(long id) {
        this.id = id;
    }
}
