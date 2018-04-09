package com.example.strig.mobilecomputingclass.le180403_ViewpagerAndSnackbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.strig.mobilecomputingclass.R;

public class ViewpagerAndSnackbarActivity extends AppCompatActivity {

    PlayerPagerAdapter adapter;
    ViewPager pager;
    Snackbar snackbar1;
    Snackbar snackbar2;
    Snackbar snackbar3;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager_and_snackbar);

        adapter = new PlayerPagerAdapter(getSupportFragmentManager());
        pager = findViewById(R.id.le180403_pager);
        pager.setAdapter(adapter);

        snackbar1 = Snackbar.make(findViewById(R.id.le180403_pager),
                "This is Player's Photo Page!",
                Snackbar.LENGTH_LONG);
        snackbar2 = Snackbar.make(findViewById(R.id.le180403_pager),
                "This is Player's Bio Page!",
                Snackbar.LENGTH_LONG);
        snackbar3 = Snackbar.make(findViewById(R.id.le180403_pager),
                "This is Player's Stats Page!",
                Snackbar.LENGTH_LONG);

    }


    private class PlayerPagerAdapter extends FragmentPagerAdapter {
        public PlayerPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new PlayerPhotoFragment();
                case 1:
                    snackbar1.show();
                    return new PlayerBioFragment();
                case 2:
                    snackbar2.show();
                    return new PlayerStatsFragment();
            }
            snackbar3.show();
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
