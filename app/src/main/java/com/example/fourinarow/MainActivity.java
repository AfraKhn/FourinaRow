package com.example.fourinarow;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements IGameMain {

    SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ProgressBar progressBar = findViewById(R.id.progressBar);
        Button btnNewGame = findViewById(R.id.btn_newGame);
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snack(v, "Starting a new Game...");
                progressBar.setVisibility(View.VISIBLE);
                new CountDownTimer(1000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        progressBar.incrementProgressBy(10);
                    }

                    @Override
                    public void onFinish() {
                        snack(v, "Done!");
                        progressBar.setVisibility(View.INVISIBLE);
                        new CountDownTimer(1000, 1000) {
                            @Override
                            public void onTick(long millisUntilFinished) {
                            }

                            @Override
                            public void onFinish() {
                                Intent intent = new Intent(v.getContext(), Arena.class);
                                startActivity(intent);
                            }
                        }.start();

                    }
                }.start();

            }
        });

        Button btnContinue = findViewById(R.id.btn_continue);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snack(v, "This Feature is Not Yet Implemented, Access Denied!");
            }
        });

        Button btnScore = findViewById(R.id.btn_score);
        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score();
            }
        });


    }

    public void score() {
        pref = getApplicationContext().getSharedPreferences(PREF, 0);
        int redScore = pref.getInt(Red, 0);
        int blueScore = pref.getInt(Blue, 0);
        LayoutInflater factory = LayoutInflater.from(this);
        final View dialogView = factory.inflate(R.layout.scores, null);
        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(dialogView);
        TextView twBlue = dialogView.findViewById(R.id.score_blue);
        TextView twRed = dialogView.findViewById(R.id.score_red);
        twBlue.setText(blueScore+"");
        twRed.setText(redScore+"");
        dialog.show();
    }
    public static void snack(View v, String message) {
        Snackbar.make(v, message, Snackbar.LENGTH_LONG).show();
    }
}