package com.example.fourinarow;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Arena extends AppCompatActivity implements IGameMain {
    private Button btnCol0, btnCol1, btnCol2, btnCol3, btnCol4, btnCol5, btnCol6;
    private ImageView iv0, iv1, iv2, iv3, iv4, iv5,
            iv6, iv7, iv8, iv9, iv10,
            iv11, iv12, iv13, iv14, iv15,
            iv16, iv17, iv18, iv19, iv20,
            iv21, iv22, iv23, iv24, iv25,
            iv26, iv27, iv28, iv29, iv30,
            iv31, iv32, iv33, iv34, iv35,
            iv36, iv37, iv38, iv39, iv40,
            iv41, iv;
    SharedPreferences pref;

    private TextView tv;
    private GameMain g = new GameMain();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);
        pref = getApplicationContext().getSharedPreferences(PREF, 0);

        iv = findViewById(R.id.iv);
        tv = findViewById(R.id.tv);
        iv0 = findViewById(R.id.iv0);
        iv1 = findViewById(R.id.iv1);
        iv2 = findViewById(R.id.iv2);
        iv3 = findViewById(R.id.iv3);
        iv4 = findViewById(R.id.iv4);
        iv5 = findViewById(R.id.iv5);
        iv6 = findViewById(R.id.iv6);
        iv7 = findViewById(R.id.iv7);
        iv8 = findViewById(R.id.iv8);
        iv9 = findViewById(R.id.iv9);
        iv10 = findViewById(R.id.iv10);
        iv11 = findViewById(R.id.iv11);
        iv12 = findViewById(R.id.iv12);
        iv13 = findViewById(R.id.iv13);
        iv14 = findViewById(R.id.iv14);
        iv15 = findViewById(R.id.iv15);
        iv16 = findViewById(R.id.iv16);
        iv17 = findViewById(R.id.iv17);
        iv18 = findViewById(R.id.iv18);
        iv19 = findViewById(R.id.iv19);
        iv20 = findViewById(R.id.iv20);
        iv21 = findViewById(R.id.iv21);
        iv22 = findViewById(R.id.iv22);
        iv23 = findViewById(R.id.iv23);
        iv24 = findViewById(R.id.iv24);
        iv25 = findViewById(R.id.iv25);
        iv26 = findViewById(R.id.iv26);
        iv27 = findViewById(R.id.iv27);
        iv28 = findViewById(R.id.iv28);
        iv29 = findViewById(R.id.iv29);
        iv30 = findViewById(R.id.iv30);
        iv31 = findViewById(R.id.iv31);
        iv32 = findViewById(R.id.iv32);
        iv33 = findViewById(R.id.iv33);
        iv34 = findViewById(R.id.iv34);
        iv35 = findViewById(R.id.iv35);
        iv36 = findViewById(R.id.iv36);
        iv37 = findViewById(R.id.iv37);
        iv38 = findViewById(R.id.iv38);
        iv39 = findViewById(R.id.iv39);
        iv40 = findViewById(R.id.iv40);
        iv41 = findViewById(R.id.iv41);

        btnCol0 = findViewById(R.id.btn_col_0);
        btnCol1 = findViewById(R.id.btn_col_1);
        btnCol2 = findViewById(R.id.btn_col_2);
        btnCol3 = findViewById(R.id.btn_col_3);
        btnCol4 = findViewById(R.id.btn_col_4);
        btnCol5 = findViewById(R.id.btn_col_5);
        btnCol6 = findViewById(R.id.btn_col_6);
        click(btnCol0, 0);
        click(btnCol1, 1);
        click(btnCol2, 2);
        click(btnCol3, 3);
        click(btnCol4, 4);
        click(btnCol5, 5);
        click(btnCol6, 6);
    }


    private void click(Button btn, int num) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(v, "Button Clicked is " + num, Snackbar.LENGTH_SHORT).show();
                int index = g.put(num);
                if (index != -1) { // zamani -1 ke sotoon por bashe
                    ImageView imageView = getIv(index);
                    if (g.getTurn().equals("red")) {
                        make_iv_Red(imageView);
                    } else {
                        make_iv_Blue(imageView);
                    }
                    boolean win = g.didWin();
                    if (win) {
                        alert_win("Player " + g.getTurn() + " Won The Game!!", g.getTurn());
                    } else if (g.didDraw()) {
                        alert_win("Draw !!!", "draw");
                    }
                    updateTv(g.getTurn());
                }

            }
        });
    }

    public void make_iv_Red(ImageView iv) {
        iv.setBackgroundResource(R.drawable.btn_red);
        iv.setImageResource(R.drawable.ic_red_star);
    }

    public void make_iv_Blue(ImageView iv) {
        iv.setBackgroundResource(R.drawable.btn_blue);
        iv.setImageResource(R.drawable.ic_blue_star);
    }

    private ImageView getIv(int index) {
        switch (index) {
            case 0:
                return iv0;
            case 1:
                return iv1;
            case 2:
                return iv2;
            case 3:
                return iv3;
            case 4:
                return iv4;
            case 5:
                return iv5;
            case 6:
                return iv6;
            case 7:
                return iv7;
            case 8:
                return iv8;
            case 9:
                return iv9;
            case 10:
                return iv10;
            case 11:
                return iv11;
            case 12:
                return iv12;
            case 13:
                return iv13;
            case 14:
                return iv14;
            case 15:
                return iv15;
            case 16:
                return iv16;
            case 17:
                return iv17;
            case 18:
                return iv18;
            case 19:
                return iv19;
            case 20:
                return iv20;
            case 21:
                return iv21;
            case 22:
                return iv22;
            case 23:
                return iv23;
            case 24:
                return iv24;
            case 25:
                return iv25;
            case 26:
                return iv26;
            case 27:
                return iv27;
            case 28:
                return iv28;
            case 29:
                return iv29;
            case 30:
                return iv30;
            case 31:
                return iv31;
            case 32:
                return iv32;
            case 33:
                return iv33;
            case 34:
                return iv34;
            case 35:
                return iv35;
            case 36:
                return iv36;
            case 37:
                return iv37;
            case 38:
                return iv38;
            case 39:
                return iv39;
            case 40:
                return iv40;
            case 41:
                return iv41;
            default:
                return null;
        }
    }

    public void alert_win(String message, String colorWon) {

        if(colorWon.equals("draw")){
            //stuff
            LayoutInflater factory = LayoutInflater.from(this);
            final View dialogView = factory.inflate(R.layout.alert_win, null);
            final AlertDialog dialog = new AlertDialog.Builder(this).create();
            dialog.setView(dialogView);
            TextView twWon = dialogView.findViewById(R.id.dialog_tw_won);
            TextView twWould = dialogView.findViewById(R.id.dialog_tw_would);

            Button btnYes = dialogView.findViewById(R.id.dialog_btn_yes);
            TextView twNote = dialogView.findViewById(R.id.dialog_tw_note);
            Button btnPlayAgain = dialogView.findViewById(R.id.dialog_btn_playagain);
            Button btnMainMenu = dialogView.findViewById(R.id.dialog_btn_mainmenu);
            btnYes.setVisibility(View.INVISIBLE);
            btnPlayAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create Intent From Start?
                    Intent intent = new Intent(v.getContext(), Arena.class);
                    startActivity(intent);
                }
            });
            btnMainMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            twWould.setVisibility(View.INVISIBLE);
            twNote.setVisibility(View.INVISIBLE);
            dialog.show();
        }

        else {
            LayoutInflater factory = LayoutInflater.from(this);
            final View dialogView = factory.inflate(R.layout.alert_win, null);
            final AlertDialog dialog = new AlertDialog.Builder(this).create();
            dialog.setView(dialogView);
            TextView twSaved = dialogView.findViewById(R.id.dialog_tw_saved);
            TextView twWon = dialogView.findViewById(R.id.dialog_tw_won);
            TextView twNote = dialogView.findViewById(R.id.dialog_tw_note);
            ImageView ivWon = dialogView.findViewById(R.id.dialog_iv_won);
            Button btnYes = dialogView.findViewById(R.id.dialog_btn_yes);
            Button btnPlayAgain = dialogView.findViewById(R.id.dialog_btn_playagain);
            Button btnMainMenu = dialogView.findViewById(R.id.dialog_btn_mainmenu);
            btnYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveToDatabase(colorWon.equals(Blue) ? Blue : Red);
                    twSaved.setVisibility(View.VISIBLE);
                    btnYes.setVisibility(View.INVISIBLE);
                    twNote.setVisibility(View.INVISIBLE);
                }
            });
            btnPlayAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Create Intent From Start?
                    Intent intent = new Intent(v.getContext(), Arena.class);
                    startActivity(intent);
                }
            });
            btnMainMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
            });
            twWon.setText(colorWon.equals(Blue) ? "Blue Won The Game!" : "Red Won The Game!");
            if (colorWon.equals(Blue)) {
                make_iv_Blue(ivWon);
            } else {
                make_iv_Red(ivWon);
            }
            dialog.show();
        }
    }

    private void updateTv(String turn) {
        if (turn.equals("red")) {
            tv.setText("Red's turn");
            make_iv_Red(iv);
        } else {
            tv.setText("Blue's turn");
            make_iv_Blue(iv);
        }
    }


    private void saveToDatabase(String colorWon) {
        pref = getApplicationContext().getSharedPreferences(PREF, 0);
        SharedPreferences.Editor editor = pref.edit();
        int score = pref.getInt(colorWon, -1);
        if (score == -1) {
            editor.putInt(colorWon, 1);
        } else {
            editor.putInt(colorWon, ++score);
        }
        editor.apply();
    }


}