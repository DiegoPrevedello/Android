package com.example.consegnaandroid;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    static final int ACTIVITY_GAME = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bottone_O = findViewById(R.id.buttonO);
        Button bottone_X = findViewById(R.id.buttonX);
        Button start = findViewById(R.id.play);
        Button bottone3 = findViewById(R.id.B3);
        Button bottone5 = findViewById(R.id.B5);
        Button bottoneF = findViewById(R.id.Bfree);
        Button bChoice = findViewById(R.id.Choice);

        TextView choiseView = findViewById(R.id.textView);
        TextView leftRow = findViewById(R.id.leftRow);
        TextView rightRow = findViewById(R.id.rightRow);

        Intent i = new Intent();

        bottone_O.setOnClickListener(
                (View) -> {
                   // put extras
                    Bundle extras = new Bundle();
                    extras.putBoolean("turnGame",false);
                    i.putExtras(extras);

                    bottone_O.setBackground(getResources().getDrawable(R.drawable.button_clicked));
                    bottone_O.setTextColor(Color.RED);
                    bottone_X.setBackground(getResources().getDrawable(R.drawable.button_background));
                    bottone_X.setTextColor(Color.WHITE);
                    bChoice.setVisibility(android.view.View.INVISIBLE);
                    choiseView.setVisibility(android.view.View.INVISIBLE);
                    leftRow.setVisibility(android.view.View.INVISIBLE);
                    rightRow.setVisibility(android.view.View.INVISIBLE);

                    start.setEnabled(true);

                }
        );

       bottone_X.setOnClickListener(
                (View) -> {

                    // put extras
                    Bundle extras = new Bundle();
                    extras.putBoolean("turnGame", true);
                    i.putExtras(extras);

                    bottone_X.setBackground(getResources().getDrawable(R.drawable.button_clicked));
                    bottone_X.setTextColor(Color.RED);
                    bottone_O.setBackground(getResources().getDrawable(R.drawable.button_background));
                    bottone_O.setTextColor(Color.WHITE);
                    bChoice.setVisibility(android.view.View.INVISIBLE); choiseView.setVisibility(android.view.View.INVISIBLE);
                    leftRow.setVisibility(android.view.View.INVISIBLE);
                    rightRow.setVisibility(android.view.View.INVISIBLE);


                    start.setEnabled(true);
                }
        );

       bChoice.setOnClickListener(
               (View) -> {
                   choiseView.setVisibility(android.view.View.VISIBLE);
                   rightRow.setVisibility(android.view.View.VISIBLE);
                   leftRow.setVisibility(android.view.View.VISIBLE);

                   bChoice.setVisibility(android.view.View.INVISIBLE);
               }
       );

       start.setOnClickListener(
               (View) -> {

                   start.setVisibility(android.view.View.INVISIBLE);
                   bottone3.setVisibility(android.view.View.VISIBLE);
                   bottone3.setBackground(getResources().getDrawable(R.drawable.button_clicked));
                   bottone5.setVisibility(android.view.View.VISIBLE);
                   bottone5.setBackground(getResources().getDrawable(R.drawable.button_clicked));
                   bottoneF.setVisibility(android.view.View.VISIBLE);
                   bottoneF.setBackground(getResources().getDrawable(R.drawable.button_clicked));

               }
       );

       bottone3.setOnClickListener(
               (View) -> {
                   Intent i1 = new Intent(this, GameActivity.class);
                   i1.putExtras(i);
                   Bundle extras = new Bundle();
                   extras.putInt("game", 0);
                   i1.putExtras(extras);
                   startActivityForResult(i1, ACTIVITY_GAME);

               }
       );

        bottone5.setOnClickListener(
                (View) -> {
                    Intent i2 = new Intent(this, GameActivity.class);
                    i2.putExtras(i);
                    Bundle extras = new Bundle();
                    extras.putInt("game", 1);
                    i2.putExtras(extras);
                    startActivityForResult(i2, ACTIVITY_GAME);

                }
        );

        bottoneF.setOnClickListener(
                (View) -> {
                    Intent i3 = new Intent(this, GameActivity.class);
                    i3.putExtras(i);
                    Bundle extras = new Bundle();
                    extras.putInt("game", -1);
                    i3.putExtras(extras);
                    startActivityForResult(i3, ACTIVITY_GAME);

                }
        );
    }
}
