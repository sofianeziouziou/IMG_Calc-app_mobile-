package com.example.tp5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class InscriptionActivity extends AppCompatActivity {

    EditText etNom, etEmail, etTel, etPassword;
    Button btnInscrire, btnVersLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        etNom = findViewById(R.id.etNom);
        etEmail = findViewById(R.id.etEmail);
        etTel = findViewById(R.id.etTel);
        etPassword = findViewById(R.id.etPassword);
        btnInscrire = findViewById(R.id.btnInscrire);
        btnVersLogin = findViewById(R.id.btnVersLogin);

        btnInscrire.setOnClickListener(v -> {
            String nom = etNom.getText().toString();
            String email = etEmail.getText().toString();
            String tel = etTel.getText().toString();
            String pass = etPassword.getText().toString();

            if (nom.isEmpty() || email.isEmpty() || tel.isEmpty() || pass.isEmpty()) {
                Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                return;
            }

            SharedPreferences prefs = getSharedPreferences("UserData", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("nom", nom);
            editor.putString("email", email);
            editor.putString("tel", tel);
            editor.putString("password", pass);
            editor.apply();

            Toast.makeText(this, "Compte créé avec succès", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, LoginActivity.class));
        });

        btnVersLogin.setOnClickListener(v ->
                startActivity(new Intent(this, LoginActivity.class)));
    }
}
