package com.example.tp5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin, btnVersInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnVersInscription = findViewById(R.id.btnVersInscription);

        btnLogin.setOnClickListener(v -> {
            SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
            String savedEmail = prefs.getString("email", "");
            String savedPassword = prefs.getString("password", "");

            String email = etEmail.getText().toString();
            String pass = etPassword.getText().toString();

            if (email.equals(savedEmail) && pass.equals(savedPassword)) {
                Toast.makeText(this, "Connexion réussie", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            } else {
                Toast.makeText(this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
            }
        });

        btnVersInscription.setOnClickListener(v ->
                startActivity(new Intent(this, InscriptionActivity.class)));
    }
}
