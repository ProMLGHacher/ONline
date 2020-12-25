package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView textView = findViewById(R.id.textView);


        InstantiateTheRequestQueue InstantiateTheRequestQueue = new InstantiateTheRequestQueue();

        InstantiateTheRequestQueue.createTheRequestQueue(this, new requestQueueListener() {
            @Override
            public void onError(String response) {
                transferTemperature(response);
            }

            @Override
            public void onSuccess(String response) {
                transferTemperature(response);
            }
        });

    }

   void transferTemperature(String response) {

       TextView textView = findViewById(R.id.textView);

       String forReturn = response.substring(response.indexOf("temp") + 6, response.indexOf("temp") + 9);

       int aa = Integer.parseInt(forReturn) - 273;

       textView.setText(String.valueOf(aa));
   }
}