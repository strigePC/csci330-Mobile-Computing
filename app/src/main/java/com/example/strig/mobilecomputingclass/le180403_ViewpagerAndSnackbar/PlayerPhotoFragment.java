package com.example.strig.mobilecomputingclass.le180403_ViewpagerAndSnackbar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.strig.mobilecomputingclass.R;

public class PlayerPhotoFragment extends Fragment {
    public PlayerPhotoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_photo, container, false);
    }
}
