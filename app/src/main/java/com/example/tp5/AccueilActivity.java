package com.example.tp5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AccueilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Button btn = findViewById(R.id.btnCommencer);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aller vers LoginActivity
                Intent intent = new Intent(AccueilActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
