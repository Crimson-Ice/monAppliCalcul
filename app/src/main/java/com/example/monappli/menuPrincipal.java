package com.example.monappli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class menuPrincipal extends AppCompatActivity {

    private Button boutonJeu;
    private Button boutonHighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        boutonJeu = findViewById(R.id.boutonJouer);
        boutonHighScore = findViewById(R.id.boutonHighScore);

        boutonJeu.setOnClickListener(view -> {

            Intent intent = new Intent(menuPrincipal.this,pageJeu.class);
            startActivity(intent);
        });

        boutonHighScore.setOnClickListener(view -> {

            Intent intent = new Intent(menuPrincipal.this,highScore.class);
            startActivity(intent);
        });
    }
}