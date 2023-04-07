package com.example.monappli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class pageJeu extends AppCompatActivity implements View.OnClickListener {

    private TextView monText;
    private TextView TextVie;
    private TextView TextScore;
    private EditText monEntreeUser;
    private int mesVies;
    private int monScore;

    private Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jeu);

        monText = findViewById(R.id.myText);
        TextVie = findViewById(R.id.vie);
        TextScore = findViewById(R.id.score);
        myButton = findViewById(R.id.myButton);
        monEntreeUser = findViewById(R.id.editText);
        mesVies = 3;
        monScore = 0;
        String vies = getString(R.string.showVie);
        String score = getString(R.string.showScore);
        TextVie.setText(vies + mesVies);
        TextScore.setText(score + monScore);


        AtomicReference<Double> result = new AtomicReference<>(giveCalcul(monText));

        monEntreeUser.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if ((actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)))
                if ((actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                        && (event == null || event.getAction() == KeyEvent.ACTION_UP)) {
                    myButton.performClick(); // Cliquez sur le bouton pour soumettre la réponse
                    return true;
                }
                return false;
            }
        });

        myButton.setOnClickListener((v) -> {

            System.out.println(result.toString());
            System.out.println(monEntreeUser.getText().toString());

            if (Objects.equals(result.get(), Double.valueOf(monEntreeUser.getText().toString()))) {
                Toast.makeText(pageJeu.this, "Bien joué", Toast.LENGTH_LONG).show();
                monScore += 1;

            } else {
                Toast.makeText(pageJeu.this, "Dommage", Toast.LENGTH_LONG).show();
                mesVies -= 1;

                if (mesVies <= 0) {
                    finish();
                    Intent intent = new Intent(pageJeu.this, pagePerdu.class);
                    intent.putExtra("score", String.valueOf(monScore));
                    startActivity(intent);
                }
            }
            result.set(giveCalcul(monText));
            monEntreeUser.setText("");

            TextVie.setText(vies + mesVies);
            TextScore.setText(score + monScore);
        });
    }

    private double giveCalcul(TextView monText) {

        int min = 0;
        int max = 10;
        double res = 0;
        Integer a = (int) (Math.random() * (max - min));
        Integer b = (int) (Math.random() * (max - min));

        List<Character> mesOperandes = List.of('+', '-', '*', '/'); //La liste des opérandes disponibles
        Character monOperande = mesOperandes.get(new Random().nextInt(mesOperandes.size())); //Get un random parmi cette liste.

        switch (monOperande) {
            case '+':
                res = a + b;
                break;
            case '-':
                res = a - b;
                break;
            case '*':
                res = a * b;
                break;
            case '/':
                b = 2;
                res = (float) a / (float) b;
                break;
            default:
                System.out.println("Erreur");
                break;
        }

        monText.setText("" + a + monOperande + b);

        return res;
    }


    @Override
    public void onClick(View v) {

    }
}