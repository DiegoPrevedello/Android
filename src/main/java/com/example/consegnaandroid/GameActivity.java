package com.example.consegnaandroid;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.consegnaandroid.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;



public class GameActivity extends AppCompatActivity {

    public void push(Button button, ArrayList<Button> griglia, ArrayList<Button> grigliaRes) {
        Random rnd = new Random();
        Button index;

        button.setBackgroundResource(R.drawable.x);
        button.setText("x");
        button.setEnabled(false);
        griglia.remove(button);

        if(verify(grigliaRes)){
            reset(grigliaRes,griglia);
            return;
        }

        System.out.println(griglia.size());

        if (griglia.size() > 1) {
            do {
                index = griglia.get(rnd.nextInt(griglia.size()));
            } while (!(index.isEnabled()));
            index.setBackgroundResource(R.drawable.o);
            index.setText("o");
            index.setEnabled(false);
            griglia.remove(index);

            if (verify(grigliaRes)) reset(grigliaRes, griglia);

        } else{
            Toast.makeText(this, "draw", Toast.LENGTH_LONG).show();
            reset(grigliaRes, griglia);
        }
    }



    public boolean verify(ArrayList<Button> griglia) {

        if(griglia.get(0).getText() == "x" && griglia.get(1).getText() == "x" & griglia.get(2).getText() == "x"){
            Toast.makeText(this, R.string.win_x,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(0).getText() == "o" && griglia.get(1).getText() == "o" & griglia.get(2).getText() == "o"){
            Toast.makeText(this, R.string.win_o,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(3).getText() == "x" && griglia.get(4).getText() == "x" & griglia.get(5).getText() == "x"){
            Toast.makeText(this, R.string.win_x,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(3).getText() == "o" && griglia.get(4).getText() == "o" & griglia.get(5).getText() == "o"){
            Toast.makeText(this, R.string.win_o,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(6).getText() == "x" && griglia.get(7).getText() == "x" & griglia.get(8).getText() == "x"){
            Toast.makeText(this, R.string.win_x,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(6).getText() == "o" && griglia.get(7).getText() == "o" & griglia.get(8).getText() == "o"){
            Toast.makeText(this, R.string.win_o,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(0).getText() == "x" && griglia.get(4).getText() == "x" & griglia.get(8).getText() == "x"){
            Toast.makeText(this, R.string.win_x,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(0).getText() == "o" && griglia.get(4).getText() == "o" & griglia.get(8).getText() == "o"){
            Toast.makeText(this, R.string.win_o,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(2).getText() == "x" && griglia.get(4).getText() == "x" & griglia.get(6).getText() == "x"){
            Toast.makeText(this, R.string.win_x,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(2).getText() == "o" && griglia.get(4).getText() == "o" & griglia.get(6).getText() == "o"){
            Toast.makeText(this, R.string.win_o,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(0).getText() == "x" && griglia.get(3).getText() == "x" & griglia.get(6).getText() == "x"){
            Toast.makeText(this, R.string.win_x,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(0).getText() == "o" && griglia.get(3).getText() == "o" & griglia.get(6).getText() == "o"){
            Toast.makeText(this, R.string.win_o,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(1).getText() == "x" && griglia.get(4).getText() == "x" & griglia.get(7).getText() == "x"){
            Toast.makeText(this, R.string.win_x,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(1).getText() == "o" && griglia.get(4).getText() == "o" & griglia.get(7).getText() == "o"){
            Toast.makeText(this, R.string.win_o,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(2).getText() == "x" && griglia.get(5).getText() == "x" & griglia.get(8).getText() == "x"){
            Toast.makeText(this, R.string.win_x,Toast.LENGTH_SHORT).show();
            return true;
        }
        else if(griglia.get(2).getText() == "o" && griglia.get(5).getText() == "o" & griglia.get(8).getText() == "o"){
            Toast.makeText(this, R.string.win_o,Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }

    @SuppressLint("ResourceAsColor")
    public void reset(ArrayList<Button> grigliaRes, ArrayList<Button> newGriglia){

        for(int i = 0; i < newGriglia.size(); i++){
            newGriglia.remove(i);
        }

        for (int i2 = 0; i2 < grigliaRes.size(); i2++) {

            grigliaRes.get(i2).setEnabled(true);
            grigliaRes.get(i2).setBackgroundResource(R.color.spazioVuoto);
            grigliaRes.get(i2).setText("");
            newGriglia.add(grigliaRes.get(i2));
        }

    }


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



        bottone1.setOnClickListener(
                (View) -> {
                    push(bottone1,griglia,grigliaGioco);

                }

        );
        bottone2.setOnClickListener(
                (View) -> {
                    push(bottone2,griglia,grigliaGioco);

                }

        );
        bottone3.setOnClickListener(
                (View) -> {
                    push(bottone3,griglia,grigliaGioco);

                }

        );
        bottone4.setOnClickListener(
                (View) -> {
                    push(bottone4,griglia,grigliaGioco);

                }
        );
        bottone5.setOnClickListener(
                (View) -> {
                    push(bottone5,griglia,grigliaGioco);

                }

        );
        bottone6.setOnClickListener(
                (View) -> {
                    push(bottone6,griglia,grigliaGioco);

                }

        );
        bottone7.setOnClickListener(
                (View) -> {
                    push(bottone7,griglia,grigliaGioco);

                }

        );
        bottone8.setOnClickListener(
                (View) -> {
                    push(bottone8,griglia,grigliaGioco);

                }

        );
        bottone9.setOnClickListener(
                (View) -> {
                    push(bottone9,griglia,grigliaGioco);

                }

        );

    }

}

