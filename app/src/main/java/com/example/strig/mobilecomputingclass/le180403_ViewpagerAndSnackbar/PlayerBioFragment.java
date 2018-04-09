package com.example.strig.mobilecomputingclass.le180403_ViewpagerAndSnackbar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.strig.mobilecomputingclass.R;

public class PlayerBioFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player_bio, container, false);
    }

}
