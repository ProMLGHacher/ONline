package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.textView);


        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url ="https://api.openweathermap.org/data/2.5/onecall?lat=51.7887729&lon=54.8021706&exclude=hourly,daily,minutely,hourly,alerts&appid=bea62f32f1568bbde18365f14b7d9f45";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {

                    transferTemperature(response);

                }, error -> textView.setText("That didn't work!")
        );

        // Add the request to the RequestQueue.
        queue.add(stringRequest);


        textView.setText("лох");

    }

   void transferTemperature(String response) {

       TextView textView = findViewById(R.id.textView);

       String forReturn = response.substring(response.indexOf("temp") + 6, response.indexOf("temp") + 9);

       int aa = Integer.parseInt(forReturn) - 273;

       textView.setText(String.valueOf(aa));
   }
}