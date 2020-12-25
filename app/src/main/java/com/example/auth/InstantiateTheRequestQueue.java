package com.example.auth;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class InstantiateTheRequestQueue {

    public void createTheRequestQueue(Object main, requestQueueListener requestQueueListener) {

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue((Context) main);
        String url = "https://api.openweathermap.org/data/2.5/onecall?lat=51.7887729&lon=54.8021706&exclude=hourly,daily,minutely,hourly,alerts&appid=bea62f32f1568bbde18365f14b7d9f45";

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                response -> {

                    requestQueueListener.onSuccess(response);

                }, error -> requestQueueListener.onError("error")
        );

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
