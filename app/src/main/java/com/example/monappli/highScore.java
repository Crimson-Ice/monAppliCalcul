package com.example.monappli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.monappli.DAO.HighScoreBaseHelper;
import com.example.monappli.DAO.HighScoreDao;
import com.example.monappli.model.entities.HighScore;

public class highScore extends AppCompatActivity {

    private HighScoreDao highScoreDao;
    private TextView textHightScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        highScoreDao = new HighScoreDao(new HighScoreBaseHelper(this,"BDD",1));
        HighScore monHighScore = highScoreDao.getBestPlayer();
        textHightScore= findViewById(R.id.textPageHighscore);
        if(monHighScore!=null){
            textHightScore.setText("Nom du joueur : " + monHighScore.getPlayerName() + " Score : "+monHighScore.getScore());
        }else{
            textHightScore.setText("AUCUN HIGHSCORE");
        }
    }
}