package com.example.strig.mobilecomputingclass.le180118_ToolbarAndRESTAPIs;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.strig.mobilecomputingclass.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.DateFormat;
import java.util.Date;

public class ToolbarRESTActivity extends AppCompatActivity {

    private static final String TAG = "";

    private RelativeLayout progress;
    private LinearLayout data;
    private TextView temperatureView;
    private TextView lastUpdatedView;

    private double temperature = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_rest);

        progress = findViewById(R.id.le180118_progress);
        data = findViewById(R.id.le180118_data);
        temperatureView = findViewById(R.id.le180118_temperature);
        lastUpdatedView = findViewById(R.id.le180118_temperatureText2);

        String strTemperatureFormat = getResources().getString(R.string.temperature_value);
        String strTemperature = String.format(strTemperatureFormat, 0.0);

        String strLastUpdatedFormat = getResources().getString(R.string.temperature_text_2);
        String strLastUpdated = String.format(strLastUpdatedFormat, "");

        temperatureView.setText(strTemperature);
        lastUpdatedView.setText(strLastUpdated);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.weather_item:
                WeatherAsyncTask loadInfo = new WeatherAsyncTask();
                loadInfo.execute(getString(R.string.weather_api_url));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class WeatherAsyncTask extends AsyncTask<String, Void, Double> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progress.setVisibility(View.VISIBLE);
            data.setVisibility(View.GONE);
        }

        @Override
        protected Double doInBackground(String... urls) {
            String url = urls[0];

            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

            try {
                JSONObject forecastObject = new JSONObject(restTemplate.getForObject(url, String.class, "Android"));
                JSONObject currentlyObject = forecastObject.getJSONObject("currently");
                temperature = (currentlyObject.getDouble("temperature") - 32) / 1.8;
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return temperature;
        }

        protected void onPostExecute(Double result) {
            String lastUpdated = DateFormat.getDateTimeInstance().format(new Date());

            String strTemperatureFormat = getResources().getString(R.string.temperature_value);
            String strTemperature = String.format(strTemperatureFormat, result);

            String strLastUpdatedFormat = getResources().getString(R.string.temperature_text_2);
            String strLastUpdated = String.format(strLastUpdatedFormat, lastUpdated);

            temperatureView.setText(strTemperature);
            lastUpdatedView.setText(strLastUpdated);

            progress.setVisibility(View.GONE);

            data.setVisibility(View.VISIBLE);
        }
    }

}
