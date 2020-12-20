package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RegistrationActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //получение кнопок
        Button reg = findViewById(R.id.reg);
        Button authOnRegButton = findViewById(R.id.authOnRegButton);

        //получение объектов PlainText'ов
        EditText name = findViewById(R.id.name);
        EditText number = findViewById(R.id.number);
        EditText eMail = findViewById(R.id.eMail);
        EditText password = findViewById(R.id.password);
        EditText passwordConfirm = findViewById(R.id.passwordConfirm);

        //для вывода ошибки о нессответствии пароля к требованиям
        TextView passError = findViewById(R.id.passError);

        Intent intent = new Intent(RegistrationActivity.this, AuthActivity.class);



        SharedPreferences applicationData = getSharedPreferences("appdata", MODE_PRIVATE);
        SharedPreferences.Editor editor = applicationData.edit();



        reg.setOnClickListener(v -> {
            String tempName = name.getText().toString();
            String tempNumber = number.getText().toString();
            String tempeMail = eMail.getText().toString();
            String tempPassword = password.getText().toString();
            String tempPasswordConfirm = passwordConfirm.getText().toString();

            if (tempPassword.equals(tempPasswordConfirm)) {
                if (tempPassword.length() != 0 & tempPassword.length() > 10) {
                    if (tempPassword.matches(".*[a-zA-Z]+.*") & tempPassword.matches(".*[0-9]+.*")) {

                        intent.putExtra("mail", tempeMail);
                        intent.putExtra("password", tempPassword);
                        startActivity(intent);

                    } else passError.setText("Пароль не соответствует требованиям (минимум одна заглавная буква, минимум одна цифра, только латинские буквы)");
                } else passError.setText("Пароль не соответствует требованиям (не менее 10 символов)");
            } else passError.setText("Пароли не совпадают");

        });

        authOnRegButton.setOnClickListener(v -> {
            startActivity(intent);
        });

    }
}