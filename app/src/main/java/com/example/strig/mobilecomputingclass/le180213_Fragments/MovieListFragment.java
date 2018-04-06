package com.example.strig.mobilecomputingclass.le180213_Fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MovieListFragment extends ListFragment {
    interface MovieListener {
        void itemClicked(long id);
    }

    private MovieListener l;
    public MovieListFragment() {}

    ArrayAdapter<String> adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String[] movieTitles = new String[Movie.movies.length];
        for (int i = 0; i < Movie.movies.length; i++) {
            movieTitles[i] = Movie.movies[i].getTitle();
        }

        adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1,
                movieTitles);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            l = (MovieListener) activity;
        }
    }

    @Override
    public void onListItemClick(ListView listView, View v, int position, long id) {
        if (l != null) {
            l.itemClicked(id);
        }
    }
}
