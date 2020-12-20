package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        //интент для основного активити
        Intent intent = new Intent(AuthActivity.this, MainActivity.class);


        // создаём SharedPreferences (штука для кеширования)
        SharedPreferences applicationData = getSharedPreferences("appdata", MODE_PRIVATE);
        SharedPreferences.Editor editor = applicationData.edit();

        // получаем объекты с икс эм эльки
        Button auth = findViewById(R.id.auth);
        TextView eMailAuth = findViewById(R.id.eMailAuth);
        TextView passwordAuth = findViewById(R.id.passwordAuth);

        // получаем наддые с прошлого активити
        String eMailRegWindow = getIntent().getStringExtra("mail");
        String passwordGegWindow = getIntent().getStringExtra("password");

        // ствим вщятые данные с прошлого активити в поля для ввода логина и пароля
        eMailAuth.setText(eMailRegWindow);
        passwordAuth.setText(passwordGegWindow);

        // сохраняем логин и пароль в кэш
        editor.putString("mail", eMailRegWindow);
        editor.putString("password", passwordGegWindow);

        // при нажатии на кнопку переходит на след активити
        auth.setOnClickListener(v -> {
            startActivity(intent);
        });
    }
}