package com.example.consegnaandroid;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class GameActivity extends AppCompatActivity {

    public void aggiorna(TextView viewX, TextView viewO, AtomicInteger x, AtomicInteger o){
        Integer scoreX = x.get();
        Integer scoreO = o.get();

        viewX.setText(scoreX.toString());
        viewO.setText(scoreO.toString());
    }

    public void push(Button button, ArrayList<Button> griglia, ArrayList<Button> grigliaRes, boolean turnoGioco, AtomicInteger o, AtomicInteger x, AtomicInteger GIOCATE) {

        Random rnd = new Random();
        Button index;

        if (!turnoGioco) {
            button.setText("x");
            button.setTextColor(getResources().getColor(R.color.colorX));
            button.setBackgroundResource(R.drawable.x);
            button.setEnabled(false);
            griglia.remove(button);
        }else {
            button.setText("o");
            button.setTextColor(Color.WHITE);
            button.setBackgroundResource(R.drawable.o);
            button.setEnabled(false);
            griglia.remove(button);
        }

        if (verify(grigliaRes, turnoGioco, o, x, GIOCATE)) {
            for(int i = 0; i < griglia.size(); i++){
                griglia.get(i).setEnabled(false);
            }

            final Handler handler = new Handler();
            handler.postDelayed(() -> reset(grigliaRes, griglia), 1500);
            return;
        }

        if (griglia.size() > 1) {
            do {
                index = griglia.get(rnd.nextInt(griglia.size()));
            } while (!(index.isEnabled()));
            if (!turnoGioco) {
                index.setText("o");
                index.setTextColor(Color.WHITE);
                index.setBackgroundResource(R.drawable.o);
                index.setEnabled(false);
                griglia.remove(index);
            }else {
                index.setText("x");
                index.setTextColor(getResources().getColor(R.color.colorX));
                index.setBackgroundResource(R.drawable.x);
                index.setEnabled(false);
                griglia.remove(index);
            }

            if (verify(grigliaRes, turnoGioco, o, x, GIOCATE)){
                for(int i = 0; i < griglia.size(); i++){
                    griglia.get(i).setEnabled(false);
                }

                final Handler handler = new Handler();
                handler.postDelayed(() -> reset(grigliaRes, griglia), 1500);
            }
        } else {
            Toast.makeText(this, R.string.pareggio, Toast.LENGTH_LONG).show();
            reset(grigliaRes, griglia);
        }
    }

    public boolean finishGame(AtomicInteger o, AtomicInteger x, AtomicInteger GIOCATE){

        if(GIOCATE.get() == 0){
            if(x.get() == 2 || o.get() == 2) return true;
        }
        else if (GIOCATE.get() == 1){
            if(x.get() == 3 || o.get() == 3) return true;
        }
        else if (GIOCATE.get() == -1) return false;

        return false;
    }


    public void startNewActivity(Intent i, AtomicInteger o, AtomicInteger x){
        i.putExtra("punteggioO", o.toString());
        i.putExtra("punteggioX", x.toString());
        i.putExtra("punteggioXint", x.get());
        i.putExtra("punteggioOint", o.get());
        setResult(RESULT_OK, i);
        startActivityForResult(i, ACTIVITY_RESULT);
        finish();
    }


    public boolean verify(ArrayList<Button> griglia, boolean turno, AtomicInteger o, AtomicInteger x, AtomicInteger GIOCATE) {

        Intent i = new Intent(this, LastActivity.class);
        final Handler handler = new Handler();

        TextView scoreX = findViewById(R.id.setScoreX);
        TextView scoreO = findViewById(R.id.setScoreO);

        if(!turno) {
            if (griglia.get(0).getText() == "x" && griglia.get(1).getText() == "x" && griglia.get(2).getText() == "x") {
                x.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();
                    handler.postDelayed(() -> {},2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(0).getText() == "o" && griglia.get(1).getText() == "o" && griglia.get(2).getText() == "o") {
                o.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();
                    handler.postDelayed(() -> {},2000);

                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(3).getText() == "x" && griglia.get(4).getText() == "x" && griglia.get(5).getText() == "x") {
                x.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();
                    handler.postDelayed(() -> {},2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(3).getText() == "o" && griglia.get(4).getText() == "o" && griglia.get(5).getText() == "o") {
                o.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(6).getText() == "x" && griglia.get(7).getText() == "x" && griglia.get(8).getText() == "x") {
                x.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(6).getText() == "o" && griglia.get(7).getText() == "o" && griglia.get(8).getText() == "o") {
                o.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(0).getText() == "x" && griglia.get(4).getText() == "x" && griglia.get(8).getText() == "x") {
                x.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(0).getText() == "o" && griglia.get(4).getText() == "o" && griglia.get(8).getText() == "o") {
                o.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(2).getText() == "x" && griglia.get(4).getText() == "x" && griglia.get(6).getText() == "x") {
                x.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(2).getText() == "o" && griglia.get(4).getText() == "o" && griglia.get(6).getText() == "o") {
                o.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(0).getText() == "x" && griglia.get(3).getText() == "x" && griglia.get(6).getText() == "x") {
                x.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(0).getText() == "o" && griglia.get(3).getText() == "o" && griglia.get(6).getText() == "o") {
                o.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(1).getText() == "x" && griglia.get(4).getText() == "x" && griglia.get(7).getText() == "x") {
                x.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(1).getText() == "o" && griglia.get(4).getText() == "o" && griglia.get(7).getText() == "o") {
                o.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(2).getText() == "x" && griglia.get(5).getText() == "x" && griglia.get(8).getText() == "x") {
                x.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(2).getText() == "o" && griglia.get(5).getText() == "o" && griglia.get(8).getText() == "o") {
                o.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            }
        } else{
            if (griglia.get(0).getText() == "x" && griglia.get(1).getText() == "x" && griglia.get(2).getText() == "x") {
                x.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                    aggiorna(scoreX, scoreO, x, o);
                    startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(0).getText() == "o" && griglia.get(1).getText() == "o" && griglia.get(2).getText() == "o") {
                o.getAndIncrement();

                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }

                return true;
            } else if (griglia.get(3).getText() == "x" && griglia.get(4).getText() == "x" && griglia.get(5).getText() == "x") {
                x.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(3).getText() == "o" && griglia.get(4).getText() == "o" && griglia.get(5).getText() == "o") {
                o.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(6).getText() == "x" && griglia.get(7).getText() == "x" && griglia.get(8).getText() == "x") {
                x.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(6).getText() == "o" && griglia.get(7).getText() == "o" && griglia.get(8).getText() == "o") {
                o.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(0).getText() == "x" && griglia.get(4).getText() == "x" && griglia.get(8).getText() == "x") {
                x.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(0).getText() == "o" && griglia.get(4).getText() == "o" && griglia.get(8).getText() == "o") {
                o.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(2).getText() == "x" && griglia.get(4).getText() == "x" && griglia.get(6).getText() == "x") {
                x.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(2).getText() == "o" && griglia.get(4).getText() == "o" && griglia.get(6).getText() == "o") {
                o.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(0).getText() == "x" && griglia.get(3).getText() == "x" && griglia.get(6).getText() == "x") {
                x.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(0).getText() == "o" && griglia.get(3).getText() == "o" && griglia.get(6).getText() == "o") {
                o.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(1).getText() == "x" && griglia.get(4).getText() == "x" && griglia.get(7).getText() == "x") {
                x.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(1).getText() == "o" && griglia.get(4).getText() == "o" && griglia.get(7).getText() == "o") {
                o.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(2).getText() == "x" && griglia.get(5).getText() == "x" && griglia.get(8).getText() == "x") {
                x.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.lose, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            } else if (griglia.get(2).getText() == "o" && griglia.get(5).getText() == "o" && griglia.get(8).getText() == "o") {
                o.getAndIncrement();
                if(!finishGame(o, x, GIOCATE)) {
                    aggiorna(scoreX, scoreO, x, o);
                    handler.postDelayed(() -> {
                        Toast.makeText(this, R.string.win, Toast.LENGTH_SHORT).show();

                    },2000);
                } else {
                    handler.postDelayed(() -> {
                        aggiorna(scoreX, scoreO, x, o);
                        startNewActivity(i, o , x);
                    },500);
                }
                return true;
            }
        }
        return false;
    }


    @SuppressLint("ResourceAsColor")
    public void reset(ArrayList<Button> grigliaRes, ArrayList<Button> newGriglia){


        while(newGriglia.size() != 0) {
            for (int i = 0; i < newGriglia.size(); i++) {
                newGriglia.remove(i);
            }
        }

        for (int i2 = 0; i2 < grigliaRes.size(); i2++) {

            grigliaRes.get(i2).setEnabled(true);
            grigliaRes.get(i2).setBackgroundResource(R.color.spazioVuoto);
            grigliaRes.get(i2).setText("");
            newGriglia.add(grigliaRes.get(i2));
        }

    }


    static final int ACTIVITY_RESULT = 1;

    //Main
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        Button bottone1 = findViewById(R.id.button1);
        Button bottone2 = findViewById(R.id.button2);
        Button bottone3 = findViewById(R.id.button3);
        Button bottone4 = findViewById(R.id.button4);
        Button bottone5 = findViewById(R.id.button5);
        Button bottone6 = findViewById(R.id.button6);
        Button bottone7 = findViewById(R.id.button7);
        Button bottone8 = findViewById(R.id.button8);
        Button bottone9 = findViewById(R.id.button9);

        Button backButton = findViewById(R.id.backButton);
        Button endButton = findViewById(R.id.endButton);

        ArrayList<Button> griglia = new ArrayList<>();
        ArrayList<Button> grigliaGioco = new ArrayList<>();

        griglia.add(bottone1);grigliaGioco.add(bottone1);
        griglia.add(bottone2);grigliaGioco.add(bottone2);
        griglia.add(bottone3);grigliaGioco.add(bottone3);
        griglia.add(bottone4);grigliaGioco.add(bottone4);
        griglia.add(bottone5);grigliaGioco.add(bottone5);
        griglia.add(bottone6);grigliaGioco.add(bottone6);
        griglia.add(bottone7);grigliaGioco.add(bottone7);
        griglia.add(bottone8);grigliaGioco.add(bottone8);
        griglia.add(bottone9);grigliaGioco.add(bottone9);


        Bundle bundle = getIntent().getExtras();
        assert bundle != null;
        boolean turnGame = bundle.getBoolean("turnGame");

        AtomicInteger giocate = new AtomicInteger(bundle.getInt("game"));

        AtomicInteger O = new AtomicInteger();
        AtomicInteger X = new AtomicInteger();

        bottone1.setOnClickListener(
                (View) -> push(bottone1, griglia, grigliaGioco, turnGame, X, O, giocate)

        );
        bottone2.setOnClickListener(
                (View) -> push(bottone2, griglia, grigliaGioco, turnGame,X, O, giocate)

        );
        bottone3.setOnClickListener(
                (View) -> push(bottone3, griglia, grigliaGioco, turnGame,X, O, giocate)

        );
        bottone4.setOnClickListener(
                (View) -> push(bottone4, griglia, grigliaGioco, turnGame,X, O, giocate)
        );
        bottone5.setOnClickListener(
                (View) -> push(bottone5, griglia, grigliaGioco, turnGame,X, O, giocate)

        );
        bottone6.setOnClickListener(
                (View) -> push(bottone6, griglia, grigliaGioco, turnGame,X, O, giocate)

        );
        bottone7.setOnClickListener(
                (View) -> push(bottone7, griglia, grigliaGioco, turnGame,X, O, giocate)

        );
        bottone8.setOnClickListener(
                (View) -> push(bottone8, griglia, grigliaGioco, turnGame,X, O, giocate)

        );
        bottone9.setOnClickListener(
                (View) -> push(bottone9, griglia, grigliaGioco, turnGame,X, O, giocate)

        );

        backButton.setOnClickListener(
                (View) -> finish()
        );

        endButton.setOnClickListener(
                (View) -> {
                    Intent i = new Intent(this, LastActivity.class);
                    Bundle extras = new Bundle();
                    extras.putInt("punteggioO", Integer.parseInt(O.toString()));
                    extras.putInt("punteggioX", Integer.parseInt(X.toString()));
                    i.putExtras(extras);
                }
        );

    }
}

