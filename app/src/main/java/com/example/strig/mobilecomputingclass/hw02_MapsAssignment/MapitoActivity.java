package com.example.strig.mobilecomputingclass.hw02_MapsAssignment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.strig.mobilecomputingclass.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapitoActivity extends AppCompatActivity
        implements
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        OnMapReadyCallback {

    private GoogleMap mMap;
    private Button refreshButton;
    private TextView refreshText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapito);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.hw02_map);
        mapFragment.getMapAsync(this);

        refreshButton = findViewById(R.id.hw02_refresh_button);
        refreshText = findViewById(R.id.hw02_refresh_text);

        refreshButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CurrencyUpdateAsyncTask loadInfo = new CurrencyUpdateAsyncTask();
                loadInfo.execute("KZT");
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap map) {
        mMap = map;

        mMap.setOnMyLocationButtonClickListener(this);
        mMap.setOnMyLocationClickListener(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }
        mMap.setMyLocationEnabled(true);
    }


    @Override
    public boolean onMyLocationButtonClick() {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show();
        // Return false so that we don't consume the event and the default behavior still occurs
        // (the camera animates to the user's current position).
        return false;
    }

    @Override
    public void onMyLocationClick(@NonNull Location location) {
        Toast.makeText(this, "Current location:\n" + location, Toast.LENGTH_LONG).show();
    }

    public class CurrencyUpdateAsyncTask extends AsyncTask<String, String, List<CurrencyLocation>> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            refreshButton.setEnabled(false);
            refreshButton.setText(getString(R.string.refresh_button_text_update));
        }

        @Override
        protected List<CurrencyLocation> doInBackground(String... params) {
//        Result
            List<CurrencyLocation> currencyLocationList = new ArrayList<>();

//            Arguments
            String userCurrencyCode = params[0];
            Double userCurrency;

//            URLs
            String countriesUrl = getString(R.string.countries_api);
            String currenciesListUrl = getString(R.string.currency_layer_api);

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            try {
                JSONObject currenciesObject = new JSONObject(restTemplate.getForObject(currenciesListUrl, String.class, "Android")).getJSONObject("quotes");
                userCurrency = currenciesObject.getDouble("USD" + userCurrencyCode);
                Iterator<?> keys = currenciesObject.keys();

                Map<String, Double> codeCurrencyMap = new HashMap<>();
                while (keys.hasNext()) {
                    String key = (String) keys.next();
                    codeCurrencyMap.put(key.substring(3), userCurrency / currenciesObject.getDouble(key));
                }

                JSONArray countriesArray = new JSONArray(restTemplate.getForObject(countriesUrl, String.class, "Android"));

                for (int i = 0; i < countriesArray.length(); i++) {
                    JSONObject country = countriesArray.getJSONObject(i);
                    publishProgress(country.getString("name"));
                    try {
                        JSONArray latlng = country.getJSONArray("latlng");

                        JSONObject countryCurrency = country
                                .getJSONArray("currencies")
                                .getJSONObject(0);

                        currencyLocationList.add(new CurrencyLocation(
                                "",
                                codeCurrencyMap.get(countryCurrency.getString("code")),
                                new LatLng(latlng.getDouble(0), latlng.getDouble(1))
                        ));
                    } catch (Exception ignored) {}
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return currencyLocationList;
        }

        @Override
        protected void onProgressUpdate(String... params) {
            super.onProgressUpdate(params);
            String countryName = params[0];

            Log.e("TAG", "Processing " + countryName);
            refreshText.setText(String.format(getString(R.string.refresh_text_template), countryName));
        }

        @Override
        protected void onPostExecute(List<CurrencyLocation> currencyLocations) {
            super.onPostExecute(currencyLocations);
            refreshButton.setEnabled(true);
            refreshButton.setText(getString(R.string.refresh_button_text));
            refreshText.setText("");

            for (CurrencyLocation currencyLocation : currencyLocations) {
                mMap.addGroundOverlay(new GroundOverlayOptions()
                        .image(createPureTextIcon(String.format("%.2f", currencyLocation.getCurrency())))
                        .position(currencyLocation.getLocation(), 500000)
                        .clickable(true));
            }
        }
    }

    public BitmapDescriptor createPureTextIcon(String text) {

        Paint textPaint = new Paint(); // Adapt to your needs

        float textWidth = textPaint.measureText(text);
        float textHeight = textPaint.getTextSize();
        int width = (int) (textWidth);
        int height = (int) (textHeight);

        Bitmap image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);

        canvas.translate(0, height);

        // For development only:
        // Set a background in order to see the
        // full size and positioning of the bitmap.
        // Remove that for a fully transparent icon.
        canvas.drawColor(Color.LTGRAY);

        canvas.drawText(text, 0, 0, textPaint);
        BitmapDescriptor icon = BitmapDescriptorFactory.fromBitmap(image);
        return icon;
    }
}
