package com.example.monappli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.monappli.DAO.HighScoreBaseHelper;
import com.example.monappli.DAO.HighScoreDao;
import com.example.monappli.model.entities.HighScore;

import org.w3c.dom.Text;

public class pagePerdu extends AppCompatActivity {

    private TextView textScore;
    private EditText textPseudo;
    private Button boutonEnrengistrement;
    private HighScoreDao highScoreDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_perdu);

        String score = getIntent().getStringExtra("score");
        System.out.println(score);

        textScore = findViewById(R.id.scoreFinal);
        textPseudo = findViewById(R.id.textPseudo);
        boutonEnrengistrement = findViewById(R.id.boutonSaveScore);
        highScoreDao = new HighScoreDao((new HighScoreBaseHelper(this,"BDD",1)));


        textScore.setText("Votre score final est : " + score);

        boutonEnrengistrement.setOnClickListener(view -> {

            enregistrementHighScore(textPseudo.getText().toString(), Integer.valueOf(score));

            Intent intent = new Intent(pagePerdu.this,menuPrincipal.class);
            startActivity(intent);
        });
    }

    private void enregistrementHighScore(String playerName, Integer score){
        HighScore monHighScore = new HighScore(playerName, score);
        highScoreDao.create(monHighScore);
    }
}