package com.example.tp5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    EditText etTaille, etPoids, etAge;
    RadioButton rbFemme, rbHomme;
    TextView tvResult, tvWarning;
    Button btnCalculer, btnAnnuler, btnConseils;

    double dernierIMG = 0;
    boolean dernierSexeHomme = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etTaille = findViewById(R.id.etTaille);
        etPoids = findViewById(R.id.etPoids);
        etAge = findViewById(R.id.etAge);
        rbFemme = findViewById(R.id.rbFemme);
        rbHomme = findViewById(R.id.rbHomme);
        tvResult = findViewById(R.id.tvResult);
        tvWarning = findViewById(R.id.tvWarning);
        btnCalculer = findViewById(R.id.btnCalculer);
        btnAnnuler = findViewById(R.id.btnAnnuler);
        btnConseils = findViewById(R.id.btnConseils);

        btnCalculer.setOnClickListener(v -> calculerIMG());

        btnAnnuler.setOnClickListener(v -> {
            etTaille.setText("");
            etPoids.setText("");
            etAge.setText("");
            tvResult.setText("Votre IMG = -");
            tvWarning.setText("");
            tvWarning.setVisibility(View.GONE);
            rbHomme.setChecked(false);
            rbFemme.setChecked(false);
        });

        btnConseils.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ConseilsActivity.class);
            intent.putExtra("resultatIMG", String.valueOf(dernierIMG));
            intent.putExtra("sexeHomme", dernierSexeHomme);
            startActivity(intent);
        });
    }

    private void calculerIMG() {
        if (etTaille.getText().toString().isEmpty() ||
                etPoids.getText().toString().isEmpty() ||
                etAge.getText().toString().isEmpty() ||
                (!rbHomme.isChecked() && !rbFemme.isChecked())) {

            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        double taille = Double.parseDouble(etTaille.getText().toString()) / 100.0;
        double poids = Double.parseDouble(etPoids.getText().toString());
        int age = Integer.parseInt(etAge.getText().toString());
        int S = rbHomme.isChecked() ? 1 : 0;

        double img = (1.2 * (poids / (taille * taille))) + (0.23 * age) - (10.83 * S) - 5.4;

        String interpretation;
        if (S == 0) { // Femme
            if (img < 25) interpretation = "Vous êtes trop maigre";
            else if (img <= 30) interpretation = "Vous êtes normale";
            else interpretation = "Vous avez trop de masse grasse";
        } else { // Homme
            if (img < 15) interpretation = "Vous êtes trop maigre";
            else if (img <= 20) interpretation = "Vous êtes normal";
            else interpretation = "Vous avez trop de masse grasse";
        }

        tvResult.setText(String.format("Votre IMG = %.2f", img));
        tvWarning.setText(interpretation);
        tvWarning.setVisibility(View.VISIBLE);

        // Stocker les dernières données pour le bouton Conseils
        dernierIMG = img;
        dernierSexeHomme = rbHomme.isChecked();
    }
}
