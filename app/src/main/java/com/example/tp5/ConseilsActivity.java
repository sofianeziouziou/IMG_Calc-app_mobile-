package com.example.tp5;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ConseilsActivity extends AppCompatActivity {

    TextView tvConseilsPersonnalises;
    Button btnRetourConseils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conseils);

        tvConseilsPersonnalises = findViewById(R.id.tvConseils);
        btnRetourConseils = findViewById(R.id.btnRetourConseils);

        // Récupérer IMG et sexe depuis l'Intent
        String imgStr = getIntent().getStringExtra("resultatIMG");
        boolean isHomme = getIntent().getBooleanExtra("sexeHomme", true);

        double img = Double.parseDouble(imgStr);

        String conseils = "";

        if (isHomme) {
            if (img < 15) conseils = "🔹 Vous êtes trop maigre.\nMangez plus de protéines et pratiquez la musculation régulièrement.";
            else if (img <= 20) conseils = "🔹 Votre IMG est normal.\nMaintenez une alimentation équilibrée et continuez vos activités physiques.";
            else conseils = "🔹 Vous avez trop de masse grasse.\nRéduisez les sucres et pratiquez du cardio régulièrement.";
        } else {
            if (img < 25) conseils = "🔹 Vous êtes trop maigre.\nMangez équilibré et renforcez vos muscles.";
            else if (img <= 30) conseils = "🔹 Votre IMG est normal.\nContinuez une alimentation saine et une activité physique régulière.";
            else conseils = "🔹 Vous avez trop de masse grasse.\nFaites attention à l’alimentation et augmentez vos exercices cardio.";
        }

        tvConseilsPersonnalises.setText(conseils);

        btnRetourConseils.setOnClickListener(v -> finish()); // Retour à MainActivity
    }
}
