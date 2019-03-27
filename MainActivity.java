package com.example.lovecrush;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static ProgressBar progressBar;
    private static TextView counterView;
    TextView Viewmoves;
    private int Row = 8;
    private int Column = 8;
    private boolean swap = false;
    private boolean getAttributes = false;
    public int i1 = 0, j1 = 0;
    public int i2 = 0, j2 = 0;
    public float x1 = 0, y1 = 0;
    public float x2 = 0, y2 = 0;
    public int ID1 = 0, ID2 = 0;
    Handler handler = new Handler();
    public int moves = 22;
    int lessScore = 15000;
    int mediumScore = 22000;
    int highScore = 30000;
    int counter = 0;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[][] matrix = new int[Row][Column];

        reset(matrix);
        int level = 0;

        counterView = findViewById(R.id.counter);
        progressBar = findViewById(R.id.progressBar);
        Viewmoves = findViewById(R.id.moves);
        ImageButton setting = findViewById(R.id.setting);
        ImageButton info = findViewById(R.id.info);
        ImageButton sound = findViewById(R.id.sound);
        ImageButton out = findViewById(R.id.out);

        ImageView sfondo = findViewById(R.id.sfondoGriglia);
        switch (level){
            case 0: {
                sfondo.setBackgroundResource(R.drawable.lvl0);
                break;
            }
            case 1:{
                sfondo.setBackgroundResource(R.drawable.lvl1);
                break;
            }
        }

        TextView target = findViewById(R.id.target);
        target.setText(String.valueOf(highScore));

        ArrayList<ArrayList<ImageButton>> buttonMatrix = new ArrayList<>();

        ImageButton b1 = null;ImageButton b2 = null;ImageButton b3 = null;ImageButton b4 = null;ImageButton b5 = null;ImageButton b6 = null;ImageButton b7 = null;
        ImageButton b8 = null;
        if (Row > 0) {
            ArrayList<ImageButton> row1 = new ArrayList<>();
            b1 = findViewById(R.id.button1);row1.add(b1);
            b2 = findViewById(R.id.button2);row1.add(b2);
            b3 = findViewById(R.id.button3);row1.add(b3);
            b4 = findViewById(R.id.button4);row1.add(b4);
            b5 = findViewById(R.id.button5);row1.add(b5);
            b6 = findViewById(R.id.button6);row1.add(b6);
            b7 = findViewById(R.id.button7);row1.add(b7);
            b8 = findViewById(R.id.button8);row1.add(b8);
            buttonMatrix.add(row1);
        }
        ImageButton b10 = null;ImageButton b11 = null;ImageButton b12 = null;ImageButton b13 = null;ImageButton b14 = null;ImageButton b15 = null;ImageButton b16 = null;
        ImageButton b17 = null;
        if (Row > 1) {
            ArrayList<ImageButton> row2 = new ArrayList<>();
            b10 = findViewById(R.id.button10);row2.add(b10);
            b11 = findViewById(R.id.button11);row2.add(b11);
            b12 = findViewById(R.id.button12);row2.add(b12);
            b13 = findViewById(R.id.button13);row2.add(b13);
            b14 = findViewById(R.id.button14);row2.add(b14);
            b15 = findViewById(R.id.button15);row2.add(b15);
            b16 = findViewById(R.id.button16);row2.add(b16);
            b17 = findViewById(R.id.button17);row2.add(b17);
            buttonMatrix.add(row2);
        }
        ImageButton b19 = null;ImageButton b20 = null;ImageButton b21 = null;ImageButton b22 = null;ImageButton b23 = null;ImageButton b24 = null;ImageButton b25 = null;
        ImageButton b26 = null;
        if (Row > 2) {
            ArrayList<ImageButton> row3 = new ArrayList<>();
            b19 = findViewById(R.id.button19);row3.add(b19);
            b20 = findViewById(R.id.button20);row3.add(b20);
            b21 = findViewById(R.id.button21);row3.add(b21);
            b22 = findViewById(R.id.button22);row3.add(b22);
            b23 = findViewById(R.id.button23);row3.add(b23);
            b24 = findViewById(R.id.button24);row3.add(b24);
            b25 = findViewById(R.id.button25);row3.add(b25);
            b26 = findViewById(R.id.button26);row3.add(b26);
            buttonMatrix.add(row3);
        }
        ImageButton b28 = null;ImageButton b29 = null;ImageButton b30 = null;ImageButton b31 = null;ImageButton b32 = null;ImageButton b33 = null;ImageButton b34 = null;
        ImageButton b35 = null;
        if (Row > 3) {
            ArrayList<ImageButton> row4 = new ArrayList<>();
            b28 = findViewById(R.id.button28);row4.add(b28);
            b29 = findViewById(R.id.button29);row4.add(b29);
            b30 = findViewById(R.id.button30);row4.add(b30);
            b31 = findViewById(R.id.button31);row4.add(b31);
            b32 = findViewById(R.id.button32);row4.add(b32);
            b33 = findViewById(R.id.button33);row4.add(b33);
            b34 = findViewById(R.id.button34);row4.add(b34);
            b35 = findViewById(R.id.button35);row4.add(b35);
            buttonMatrix.add(row4);
        }
        ImageButton b37 = null;ImageButton b38 = null;ImageButton b39 = null;ImageButton b40 = null;ImageButton b41 = null;ImageButton b42 = null;ImageButton b43 = null;
        ImageButton b44 = null;
        if (Row > 4) {
            ArrayList<ImageButton> row5 = new ArrayList<>();
            b37 = findViewById(R.id.button37);row5.add(b37);
            b38 = findViewById(R.id.button38);row5.add(b38);
            b39 = findViewById(R.id.button39);row5.add(b39);
            b40 = findViewById(R.id.button40);row5.add(b40);
            b41 = findViewById(R.id.button41);row5.add(b41);
            b42 = findViewById(R.id.button42);row5.add(b42);
            b43 = findViewById(R.id.button43);row5.add(b43);
            b44 = findViewById(R.id.button44);row5.add(b44);
            buttonMatrix.add(row5);
        }
        ImageButton b46 = null;ImageButton b47 = null;ImageButton b48 = null;ImageButton b49 = null;ImageButton b50 = null;ImageButton b51 = null;ImageButton b52 = null;
        ImageButton b53 = null;
        if (Row > 5) {
            ArrayList<ImageButton> row6 = new ArrayList<>();
            b46 = findViewById(R.id.button46);row6.add(b46);
            b47 = findViewById(R.id.button47);row6.add(b47);
            b48 = findViewById(R.id.button48);row6.add(b48);
            b49 = findViewById(R.id.button49);row6.add(b49);
            b50 = findViewById(R.id.button50);row6.add(b50);
            b51 = findViewById(R.id.button51);row6.add(b51);
            b52 = findViewById(R.id.button52);row6.add(b52);
            b53 = findViewById(R.id.button53);row6.add(b53);
            buttonMatrix.add(row6);
        }
        ImageButton b55 = null;ImageButton b56 = null;ImageButton b57 = null;ImageButton b58 = null;ImageButton b59 = null;ImageButton b60 = null;ImageButton b61 = null;
        ImageButton b62 = null;
        if (Row > 6) {
            ArrayList<ImageButton> row7 = new ArrayList<>();
            b55 = findViewById(R.id.button55);row7.add(b55);
            b56 = findViewById(R.id.button56);row7.add(b56);
            b57 = findViewById(R.id.button57);row7.add(b57);
            b58 = findViewById(R.id.button58);row7.add(b58);
            b59 = findViewById(R.id.button59);row7.add(b59);
            b60 = findViewById(R.id.button60);row7.add(b60);
            b61 = findViewById(R.id.button61);row7.add(b61);
            b62 = findViewById(R.id.button62);row7.add(b62);
            buttonMatrix.add(row7);
        }
        ImageButton b64 = null;ImageButton b65 = null;ImageButton b66 = null;ImageButton b67 = null;ImageButton b68 = null;ImageButton b69 = null;ImageButton b70 = null;
        ImageButton b71 = null;
        if (Row > 7) {
            ArrayList<ImageButton> row8 = new ArrayList<>();
            b64 = findViewById(R.id.button64);row8.add(b64);
            b65 = findViewById(R.id.button65);row8.add(b65);
            b66 = findViewById(R.id.button66);row8.add(b66);
            b67 = findViewById(R.id.button67);row8.add(b67);
            b68 = findViewById(R.id.button68);row8.add(b68);
            b69 = findViewById(R.id.button69);row8.add(b69);
            b70 = findViewById(R.id.button70);row8.add(b70);
            b71 = findViewById(R.id.button71);row8.add(b71);
            buttonMatrix.add(row8);
        }
        finalTable(matrix, level, buttonMatrix);
        setTable(matrix, buttonMatrix);

        setting.setOnClickListener(
                (View) -> {
                    if(out.getVisibility() == android.view.View.INVISIBLE){
                        AnimatorSet setGo = new AnimatorSet();
                        ObjectAnimator out1 = ObjectAnimator.ofFloat(out,"translationY",0f,-300f);
                        ObjectAnimator info1 = ObjectAnimator.ofFloat(info,"translationX",0f,-250f);
                        ObjectAnimator info2 = ObjectAnimator.ofFloat(info,"translationY",0f,-250f);
                        ObjectAnimator sound1 = ObjectAnimator.ofFloat(sound,"translationX",0f,250f);
                        ObjectAnimator sound2 = ObjectAnimator.ofFloat(sound,"translationY",0f,-250f);
                        setGo.playTogether(out1,info1,info2,sound1,sound2);
                        setGo.setDuration(800);
                        setGo.start();
                        AnimatorSet set = new AnimatorSet();
                        ObjectAnimator obj = ObjectAnimator.ofFloat(setting,"rotation", 0f, 180f);
                        set.setDuration(500);
                        set.play(obj);
                        set.start();

                        handler.postDelayed(() -> sound.setVisibility(android.view.View.VISIBLE),350);
                        handler.postDelayed(() -> info.setVisibility(android.view.View.VISIBLE),350);
                        handler.postDelayed(() -> out.setVisibility(android.view.View.VISIBLE),100);
                    } else {
                        AnimatorSet setBack = new AnimatorSet();
                        ObjectAnimator out1 = ObjectAnimator.ofFloat(out,"translationY",0f);
                        ObjectAnimator info1 = ObjectAnimator.ofFloat(info,"translationX",0f);
                        ObjectAnimator info2 = ObjectAnimator.ofFloat(info,"translationY",0f);
                        ObjectAnimator sound1 = ObjectAnimator.ofFloat(sound,"translationX",0f);
                        ObjectAnimator sound2 = ObjectAnimator.ofFloat(sound,"translationY",0f);
                        setBack.playTogether(out1,info1,info2,sound1,sound2);
                        setBack.setDuration(800);
                        setBack.start();
                        AnimatorSet set3 = new AnimatorSet();
                        ObjectAnimator obj = ObjectAnimator.ofFloat(setting,"rotation", 0f, -180f);
                        set3.setDuration(500);
                        set3.play(obj);
                        set3.start();

                        handler.postDelayed(() -> out.setVisibility(android.view.View.INVISIBLE),600);
                        handler.postDelayed(() -> info.setVisibility(android.view.View.INVISIBLE),450);
                        handler.postDelayed(() -> sound.setVisibility(android.view.View.INVISIBLE),450);

                    }

                }
        );

        ImageButton finalB1 = b1;
        b1.setOnClickListener(
                (View) -> {

                        getAttributes(finalB1, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB2 = b2;
        b2.setOnClickListener(
                (View) -> {

                        getAttributes(finalB2, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);

                        }

                }
        );
        ImageButton finalB3 = b3;
        b3.setOnClickListener(
                (View) -> {

                        getAttributes(finalB3, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);

                        }

                }
        );
        ImageButton finalB4 = b4;
        b4.setOnClickListener(
                (View) -> {

                        getAttributes(finalB4, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB5 = b5;
        b5.setOnClickListener(
                (View) -> {

                        getAttributes(finalB5, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }
                    }

        );
        ImageButton finalB6 = b6;
        b6.setOnClickListener(
                (View) -> {

                        getAttributes(finalB6, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB7 = b7;
        b7.setOnClickListener(
                (View) -> {

                        getAttributes(finalB7, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB8 = b8;
        b8.setOnClickListener(
                (View) -> {

                        getAttributes(finalB8, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB10 = b10;
        b10.setOnClickListener(
                (View) -> {

                        getAttributes(finalB10, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB11 = b11;
        b11.setOnClickListener(
                (View) -> {

                        getAttributes(finalB11, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB12 = b12;
        b12.setOnClickListener(
                (View) -> {

                        getAttributes(finalB12, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB13 = b13;
        b13.setOnClickListener(
                (View) -> {

                        getAttributes(finalB13, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB14 = b14;
        b14.setOnClickListener(
                (View) -> {

                        getAttributes(finalB14, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB15 = b15;
        b15.setOnClickListener(
                (View) -> {

                        getAttributes(finalB15, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB16 = b16;
        b16.setOnClickListener(
                (View) -> {

                        getAttributes(finalB16, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB17 = b17;
        b17.setOnClickListener(
                (View) -> {

                        getAttributes(finalB17, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB19 = b19;
        b19.setOnClickListener(
                (View) -> {

                        getAttributes(finalB19, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB20 = b20;
        b20.setOnClickListener(
                (View) -> {

                        getAttributes(finalB20, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB21 = b21;
        b21.setOnClickListener(
                (View) -> {

                        getAttributes(finalB21, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB22 = b22;
        b22.setOnClickListener(
                (View) -> {

                        getAttributes(finalB22, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB23 = b23;
        b23.setOnClickListener(
                (View) -> {

                        getAttributes(finalB23, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB24 = b24;
        b24.setOnClickListener(
                (View) -> {

                        getAttributes(finalB24, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB25 = b25;
        b25.setOnClickListener(
                (View) -> {

                        getAttributes(finalB25, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB26 = b26;
        b26.setOnClickListener(
                (View) -> {

                        getAttributes(finalB26, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB28 = b28;
        b28.setOnClickListener(
                (View) -> {

                        getAttributes(finalB28, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB29 = b29;
        b29.setOnClickListener(
                (View) -> {

                        getAttributes(finalB29, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB30 = b30;
        b30.setOnClickListener(
                (View) -> {

                        getAttributes(finalB30, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB31 = b31;
        b31.setOnClickListener(
                (View) -> {

                        getAttributes(finalB31, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB32 = b32;
        b32.setOnClickListener(
                (View) -> {

                        getAttributes(finalB32, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB33 = b33;
        b33.setOnClickListener(
                (View) -> {

                        getAttributes(finalB33, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB34 = b34;
        b34.setOnClickListener(
                (View) -> {

                        getAttributes(finalB34, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB35 = b35;
        b35.setOnClickListener(
                (View) -> {

                        getAttributes(finalB35, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB37 = b37;
        b37.setOnClickListener(
                (View) -> {

                        getAttributes(finalB37, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB38 = b38;
        b38.setOnClickListener(
                (View) -> {

                        getAttributes(finalB38, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB39 = b39;
        b39.setOnClickListener(
                (View) -> {

                        getAttributes(finalB39, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB40 = b40;
        b40.setOnClickListener(
                (View) -> {

                        getAttributes(finalB40, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);

                    }
                }
        );
        ImageButton finalB41 = b41;
        b41.setOnClickListener(
                (View) -> {

                        getAttributes(finalB41, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB42 = b42;
        b42.setOnClickListener(
                (View) -> {

                        getAttributes(finalB42, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB43 = b43;
        b43.setOnClickListener(
                (View) -> {

                        getAttributes(finalB43, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB44 = b44;
        b44.setOnClickListener(
                (View) -> {

                        getAttributes(finalB44, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB46 = b46;
        b46.setOnClickListener(
                (View) -> {

                        getAttributes(finalB46, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB47 = b47;
        b47.setOnClickListener(
                (View) -> {

                        getAttributes(finalB47, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB48 = b48;
        b48.setOnClickListener(
                (View) -> {

                        getAttributes(finalB48, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB49 = b49;
        b49.setOnClickListener(
                (View) -> {

                        getAttributes(finalB49, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB50 = b50;
        b50.setOnClickListener(
                (View) -> {

                        getAttributes(finalB50, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB51 = b51;
        b51.setOnClickListener(
                (View) -> {

                        getAttributes(finalB51, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB52 = b52;
        b52.setOnClickListener(
                (View) -> {

                        getAttributes(finalB52, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB53 = b53;
        b53.setOnClickListener(
                (View) -> {

                        getAttributes(finalB53, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB55 = b55;
        b55.setOnClickListener(
                (View) -> {

                        getAttributes(finalB55, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB56 = b56;
        b56.setOnClickListener(
                (View) -> {


                        getAttributes(finalB56, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB57 = b57;
        b57.setOnClickListener(
                (View) -> {

                        getAttributes(finalB57, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB58 = b58;
        b58.setOnClickListener(
                (View) -> {

                        getAttributes(finalB58, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB59 = b59;
        b59.setOnClickListener(
                (View) -> {

                        getAttributes(finalB59, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB60 = b60;
        b60.setOnClickListener(
                (View) -> {

                        getAttributes(finalB60, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB61 = b61;
        b61.setOnClickListener(
                (View) -> {

                        getAttributes(finalB61, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB62 = b62;
        b62.setOnClickListener(
                (View) -> {

                        getAttributes(finalB62, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB64 = b64;
        b64.setOnClickListener(
                (View) -> {

                        getAttributes(finalB64, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB65 = b65;
        b65.setOnClickListener(
                (View) -> {

                        getAttributes(finalB65, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB66 = b66;
        b66.setOnClickListener(
                (View) -> {

                        getAttributes(finalB66, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB67 = b67;
        b67.setOnClickListener(
                (View) -> {

                        getAttributes(finalB67, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);
                        }

                }
        );
        ImageButton finalB68 = b68;
        b68.setOnClickListener(
                (View) -> {

                        getAttributes(finalB68, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);

                    }
                }
        );
        ImageButton finalB69 = b69;
        b69.setOnClickListener(
                (View) -> {

                        getAttributes(finalB69, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);

                    }
                }
        );
        ImageButton finalB70 = b70;
        b70.setOnClickListener(
                (View) -> {

                        getAttributes(finalB70, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);

                    }
                }
        );
        ImageButton finalB71 = b71;
        b71.setOnClickListener(
                (View) -> {

                        getAttributes(finalB71, matrix, buttonMatrix);
                        if (swap) {
                            scrollImages(buttonMatrix, matrix);

                    }
                }
        );
    }

    private void finalTable(int[][] matrix, int level, ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        switch (level) {
            case 1: // 8x8
                matrix[0][0] = 0;
                buttonMatrix.get(0).get(0).setEnabled(false);
                matrix[0][7] = 0;
                buttonMatrix.get(0).get(7).setEnabled(false);
                matrix[7][0] = 0;
                buttonMatrix.get(7).get(0).setEnabled(false);
                matrix[7][7] = 0;
                buttonMatrix.get(7).get(7).setEnabled(false);
                matrix[6][0] = 0;
                matrix[6][7] = 0;
                buttonMatrix.get(6).get(0).setEnabled(false);
                buttonMatrix.get(6).get(7).setEnabled(false);
                matrix[7][1] = 0;
                matrix[7][6] = 0;
                buttonMatrix.get(7).get(1).setEnabled(false);
                buttonMatrix.get(7).get(6).setEnabled(false);
                matrix[1][0] = 0;
                matrix[1][7] = 0;
                buttonMatrix.get(1).get(0).setEnabled(false);
                buttonMatrix.get(1).get(7).setEnabled(false);
                break;
            case 2: // 8x8
                matrix[6][0] = 0;
                matrix[6][7] = 0;
                buttonMatrix.get(6).get(0).setEnabled(false);
                buttonMatrix.get(6).get(7).setEnabled(false);
                matrix[7][0] = 0;
                matrix[7][7] = 0;
                buttonMatrix.get(7).get(0).setEnabled(false);
                buttonMatrix.get(7).get(7).setEnabled(false);
                matrix[7][1] = 0;
                matrix[7][6] = 0;
                buttonMatrix.get(7).get(1).setEnabled(false);
                buttonMatrix.get(7).get(6).setEnabled(false);
                break;
            case 3: // 8x8
                matrix[7][4] = 0;
                matrix[6][4] = 0;
                buttonMatrix.get(7).get(4).setEnabled(false);
                buttonMatrix.get(6).get(4).setEnabled(false);
                matrix[7][0] = 0;
                matrix[6][0] = 0;
                matrix[7][7] = 0;
                buttonMatrix.get(7).get(0).setEnabled(false);
                buttonMatrix.get(6).get(0).setEnabled(false);
                buttonMatrix.get(7).get(7).setEnabled(false);
                break;
            case 4: // 8x8
                matrix[0][6] = 0;
                matrix[0][5] = 0;
                buttonMatrix.get(0).get(6).setEnabled(false);
                buttonMatrix.get(0).get(5).setEnabled(false);
                matrix[0][7] = 0;
                matrix[7][0] = 0;
                buttonMatrix.get(0).get(7).setEnabled(false);
                buttonMatrix.get(7).get(0).setEnabled(false);
                matrix[7][1] = 0;
                matrix[7][2] = 0;
                buttonMatrix.get(7).get(1).setEnabled(false);
                buttonMatrix.get(7).get(2).setEnabled(false);
                break;
            case 5: // 8x8
                matrix[0][1] = 0;
                buttonMatrix.get(0).get(1).setEnabled(false);
                matrix[0][2] = 0;
                buttonMatrix.get(0).get(2).setEnabled(false);
                matrix[0][5] = 0;
                buttonMatrix.get(0).get(5).setEnabled(false);
                matrix[0][6] = 0;
                buttonMatrix.get(0).get(6).setEnabled(false);
                buttonMatrix.get(6).get(7).setEnabled(false);
                matrix[7][3] = 0;
                buttonMatrix.get(7).get(3).setEnabled(false);
                matrix[7][4] = 0;
                buttonMatrix.get(7).get(4).setEnabled(false);
                break;
            case 6: // 8x8
                matrix[0][3] = 0;
                matrix[7][3] = 0;
                buttonMatrix.get(0).get(3).setEnabled(false);
                buttonMatrix.get(7).get(3).setEnabled(false);
                matrix[0][4] = 0;
                matrix[7][4] = 0;
                buttonMatrix.get(0).get(4).setEnabled(false);
                buttonMatrix.get(7).get(4).setEnabled(false);
                matrix[0][5] = 0;
                matrix[7][2] = 0;
                buttonMatrix.get(0).get(5).setEnabled(false);
                buttonMatrix.get(7).get(2).setEnabled(false);
                break;
        }
    }

    /**
     * 0 -> unable
     * 1 -> yellow
     * 2 -> green
     * 3 -> orange
     * 4 -> light blue
     * 5 -> pink
     * 7 -> empty
     * 8 -> heart
     */

    public void setTable(int[][] matrix, ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                if (matrix[i][j] == 0) { // unable
                    buttonMatrix.get(i).get(j).setEnabled(false);
                } else if (matrix[i][j] == 1) { // yellow
                    buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    buttonMatrix.get(i).get(j).setBackgroundColor(Color.YELLOW);
                } else if (matrix[i][j] == 2) { // green
                    buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    buttonMatrix.get(i).get(j).setBackgroundColor(Color.GREEN);
                } else if (matrix[i][j] == 3) { // orange
                    buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    buttonMatrix.get(i).get(j).setBackgroundResource(R.color.orange);
                } else if (matrix[i][j] == 4) { // light blue
                    buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    buttonMatrix.get(i).get(j).setBackgroundColor(Color.BLUE);
                } else if (matrix[i][j] == 5) { // pink
                    buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    buttonMatrix.get(i).get(j).setBackgroundResource(R.color.purple);
                }
            }
        }

        Random rnd = new Random();
        int buffer1;
        int buffer2;
        int buffer3;
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                buffer1 = matrix[i][j];
                if (j + 1 < Column) {
                    buffer2 = matrix[i][j + 1];
                    if (buffer1 == buffer2) {
                        if (j + 2 < Column) {
                            buffer3 = matrix[i][j + 2];
                            if (buffer1 == buffer3 && buffer1 != 0) {
                                while (matrix[i][j + 1] == buffer2) {
                                    matrix[i][j + 1] = 1 + rnd.nextInt(4);
                                }
                                if (matrix[i][j + 1] == 1)
                                    buttonMatrix.get(i).get(j + 1).setBackgroundColor(Color.YELLOW);
                                else if (matrix[i][j + 1] == 2)
                                    buttonMatrix.get(i).get(j + 1).setBackgroundColor(Color.GREEN);
                                else if (matrix[i][j + 1] == 3)
                                    buttonMatrix.get(i).get(j + 1).setBackgroundResource(R.color.orange);
                                else if (matrix[i][j + 1] == 4)
                                    buttonMatrix.get(i).get(j + 1).setBackgroundColor(Color.BLUE);
                                else if (matrix[i][j + 1] == 5)
                                    buttonMatrix.get(i).get(j + 1).setBackgroundResource(R.color.purple);
                            }
                        }
                    }
                }
            }
        }

        int buffer4;
        int buffer5;
        int buffer6;
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                buffer4 = matrix[i][j];
                if (i + 1 < Row) {
                    buffer5 = matrix[i + 1][j];
                    if (buffer4 == buffer5) {
                        if (i + 2 < Row) {
                            buffer6 = matrix[i + 2][j];
                            if (buffer4 == buffer6 && buffer4 != 0) {
                                while (matrix[i + 1][j] == buffer5) {
                                    matrix[i + 1][j] = 1 + rnd.nextInt(4);
                                }
                                if (matrix[i + 1][j] == 1)
                                    buttonMatrix.get(i + 1).get(j).setBackgroundColor(Color.YELLOW);
                                else if (matrix[i + 1][j] == 2)
                                    buttonMatrix.get(i + 1).get(j).setBackgroundColor(Color.GREEN);
                                else if (matrix[i + 1][j] == 3)
                                    buttonMatrix.get(i + 1).get(j).setBackgroundResource(R.color.orange);
                                else if (matrix[i + 1][j] == 4)
                                    buttonMatrix.get(i + 1).get(j).setBackgroundColor(Color.BLUE);
                                else if (matrix[i + 1][j] == 5)
                                    buttonMatrix.get(i + 1).get(j).setBackgroundResource(R.color.purple);
                            }
                        }
                    }
                }
            }
        }
        if(checkX(matrix) || checkY(matrix))setTable(matrix,buttonMatrix);
    }

    public void getAttributes(ImageButton button, int[][] matrix, ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        TextView Viewmoves = findViewById(R.id.moves);
        if (!getAttributes) {
            for (int i = 0; i < Row; i++) {
                for (int j = 0; j < Column; j++) {
                    if (buttonMatrix.get(i).get(j).equals(button)) {
                        ID1 = matrix[i][j];
                        if(ID1 == 8){
                            loveCrush(matrix,buttonMatrix);
                        }
                        i1 = i;
                        j1 = j;
                        System.out.println("x1: " + x1);
                        System.out.println("y1: " + y1);
                        System.out.println("id1: " + ID1);
                        x1 = buttonMatrix.get(i).get(j).getX();
                        y1 = buttonMatrix.get(i).get(j).getY();
                    }
                }
            }
            getAttributes = true;
        } else {
            for (int i = 0; i < Row; i++) {
                for (int j = 0; j < Column; j++) {
                    if (buttonMatrix.get(i).get(j).equals(button)) {
                        ID2 = matrix[i][j];
                        i2 = i;
                        j2 = j;
                        System.out.println("x2: " + x2);
                        System.out.println("y2: " + y2);
                        System.out.println("id2: " + ID2);
                        x2 = buttonMatrix.get(i).get(j).getX();
                        y2 = buttonMatrix.get(i).get(j).getY();
                    }
                }
            }
            swap = true;
            getAttributes = false;
            moves--;
            Viewmoves.setText(String.valueOf(moves));
        }
    }

    public void scrollImages(ArrayList<ArrayList<ImageButton>> buttonMatrix, int[][] matrix){

        if (x1 > x2 && x1 - x2 == 124f && i1 == i2) {
            blockGame(buttonMatrix);
            matrix[i1][j1] = ID2;
            matrix[i2][j2] = ID1;
            AnimatorSet set = new AnimatorSet();
            ObjectAnimator thisButton1 = ObjectAnimator.ofFloat(buttonMatrix.get(i1).get(j1), "translationX", -124f);
            ObjectAnimator thisButton2 = ObjectAnimator.ofFloat(buttonMatrix.get(i2).get(j2), "translationX", 124f);
            set.playTogether(thisButton1, thisButton2);
            set.setDuration(0);
            set.start();
            swap = false;
            AnimatorSet set1 = new AnimatorSet();
            ObjectAnimator thisButton1back = ObjectAnimator.ofFloat(buttonMatrix.get(i1).get(j1), "translationX", 0f);
            ObjectAnimator thisButton2back = ObjectAnimator.ofFloat(buttonMatrix.get(i2).get(j2), "translationX", 0f);
            set1.playTogether(thisButton1back, thisButton2back);
            if(checkX(matrix) || checkY(matrix)){
                set1.setDuration(0);
                set1.start();
                new CountDownTimer(8000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if(checkX(matrix)){
                            try{
                                destroyX(buttonMatrix,matrix);
                            } catch (Exception e) { }
                        }
                    }
                    public void onFinish() {
                    }
                }.start();
                new CountDownTimer(8000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if(checkY(matrix)) {
                            try{
                                destroyY(buttonMatrix,matrix);
                            } catch (Exception e){}
                        }
                    }
                    public void onFinish() {
                    }
                }.start();
            } else{
                set1.setDuration(1000);
                matrix[i1][j1] = ID1;
                matrix[i2][j2] = ID2;
                set1.start();
            }

            if(moves == 0) {
                blockGame(buttonMatrix);
                if (counter < lessScore) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Retry?");
                    builder1.setTitle("YOU LOSE");
                    builder1.setIcon(R.drawable.ops);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            (dialog, id) ->{
                                dialog.cancel();
                                reset(matrix);
                                setTable(matrix,buttonMatrix);
                                moves = 22;
                                Viewmoves.setText(String.valueOf(moves));
                                counterView.setText("");
                                progressBar.setProgress(0);
                            });

                    builder1.setNegativeButton(
                            "No",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter < mediumScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("1 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> {
                                dialog.cancel();
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter < highScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("2 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> {
                                dialog.cancel();

                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter > highScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("3 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                }
            }else if(moves % 5 == 0){
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        heart(matrix,buttonMatrix);
                    }
                    public void onFinish() {
                    }
                }.start();
            }

        } else if (x2 > x1 && x2 - x1 == 124f && i1 == i2) {
            blockGame(buttonMatrix);
            matrix[i1][j1] = ID2;
            matrix[i2][j2] = ID1;
            AnimatorSet set = new AnimatorSet();
            ObjectAnimator thisButton1 = ObjectAnimator.ofFloat(buttonMatrix.get(i1).get(j1), "translationX", 124f);
            ObjectAnimator thisButton2 = ObjectAnimator.ofFloat(buttonMatrix.get(i2).get(j2), "translationX", -124f);
            set.playTogether(thisButton1, thisButton2);
            set.setDuration(0);
            set.start();
            swap = false;
            AnimatorSet set1 = new AnimatorSet();
            ObjectAnimator thisButton1back = ObjectAnimator.ofFloat(buttonMatrix.get(i1).get(j1), "translationX", 0f);
            ObjectAnimator thisButton2back = ObjectAnimator.ofFloat(buttonMatrix.get(i2).get(j2), "translationX", 0f);
            set1.playTogether(thisButton1back, thisButton2back);
            if(checkX(matrix) || checkY(matrix)){
                set1.setDuration(0);
                set1.start();
                new CountDownTimer(8000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if(checkX(matrix)) {
                            try {
                                destroyX(buttonMatrix,matrix);
                            } catch (Exception e){}
                        }
                    }
                    public void onFinish() {
                    }
                }.start();
                new CountDownTimer(8000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if(checkY(matrix)){
                            try{
                                destroyY(buttonMatrix,matrix);
                            } catch (Exception e){}
                        }
                    }
                    public void onFinish() {

                    }
                }.start();

            } else {
                set1.setDuration(1000);
                matrix[i1][j1] = ID1;
                matrix[i2][j2] = ID2;
                set1.start();
            }

            if(moves == 0) {
                blockGame(buttonMatrix);
                if (counter < lessScore) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Retry?");
                    builder1.setTitle("YOU LOSE");
                    builder1.setIcon(R.drawable.ops);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            (dialog, id) ->{
                                dialog.cancel();
                                reset(matrix);
                                setTable(matrix,buttonMatrix);
                                moves = 22;
                                Viewmoves.setText(String.valueOf(moves));
                                counterView.setText("");
                                progressBar.setProgress(0);
                            });

                    builder1.setNegativeButton(
                            "No",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter < mediumScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("1 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter < highScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("2 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter > highScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("3 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                }
            }else if(moves % 5 == 0){
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        heart(matrix,buttonMatrix);
                    }
                    public void onFinish() {
                    }
                }.start();
            }

        } else if(y1 > y2 && y1-y2 == 124f && j1 == j2) {
            blockGame(buttonMatrix);
            matrix[i1][j1] = ID2;
            matrix[i2][j2] = ID1;
            AnimatorSet set = new AnimatorSet();
            ObjectAnimator thisButton1 = ObjectAnimator.ofFloat(buttonMatrix.get(i1).get(j1),"translationY",-124f);
            ObjectAnimator thisButton2 = ObjectAnimator.ofFloat(buttonMatrix.get(i2).get(j2),"translationY",124f);
            set.playTogether(thisButton1, thisButton2);
            set.setDuration(0);
            set.start();
            swap = false;
            AnimatorSet set1 = new AnimatorSet();
            ObjectAnimator thisButton1back = ObjectAnimator.ofFloat(buttonMatrix.get(i1).get(j1), "translationY", 0f);
            ObjectAnimator thisButton2back = ObjectAnimator.ofFloat(buttonMatrix.get(i2).get(j2), "translationY", 0f);
            set1.playTogether(thisButton1back, thisButton2back);
            if(checkX(matrix) || checkY(matrix)){
                set1.setDuration(0);
                set1.start();
                new CountDownTimer(8000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if(checkX(matrix)) {
                            try{
                                destroyX(buttonMatrix,matrix);
                            } catch (Exception e){}
                        }
                    }
                    public void onFinish() {
                    }
                }.start();

                new CountDownTimer(8000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if(checkY(matrix)) {
                            try{
                                destroyY(buttonMatrix,matrix);
                            } catch (Exception e){}
                        }
                    }
                    public void onFinish() {
                    }
                }.start();
            } else {
                set1.setDuration(1000);
                matrix[i1][j1] = ID1;
                matrix[i2][j2] = ID2;
                set1.start();
            }

            if(moves == 0) {
                blockGame(buttonMatrix);
                if (counter < lessScore) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Retry?");
                    builder1.setTitle("YOU LOSE");
                    builder1.setIcon(R.drawable.ops);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            (dialog, id) ->{
                                dialog.cancel();
                                reset(matrix);
                                setTable(matrix,buttonMatrix);
                                moves = 22;
                                Viewmoves.setText(String.valueOf(moves));
                                counterView.setText("");
                                progressBar.setProgress(0);
                            });

                    builder1.setNegativeButton(
                            "No",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter < mediumScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("1 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter < highScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("2 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter > highScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("3 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                }
            }else if(moves % 5 == 0){
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        heart(matrix,buttonMatrix);
                    }
                    public void onFinish() {
                    }
                }.start();
            }

        } else if(y2 > y1 && y2-y1 == 124f && j1 == j2) {
            blockGame(buttonMatrix);
            matrix[i1][j1] = ID2;
            matrix[i2][j2] = ID1;
            AnimatorSet set = new AnimatorSet();
            ObjectAnimator thisButton1 = ObjectAnimator.ofFloat(buttonMatrix.get(i1).get(j1),"translationY",124f);
            ObjectAnimator thisButton2 = ObjectAnimator.ofFloat(buttonMatrix.get(i2).get(j2),"translationY",-124f);
            set.playTogether(thisButton1, thisButton2);
            set.setDuration(0);
            set.start();
            swap = false;
            AnimatorSet set1 = new AnimatorSet();
            ObjectAnimator thisButton1back = ObjectAnimator.ofFloat(buttonMatrix.get(i1).get(j1), "translationY", 0f);
            ObjectAnimator thisButton2back = ObjectAnimator.ofFloat(buttonMatrix.get(i2).get(j2), "translationY", 0f);
            set1.playTogether(thisButton1back, thisButton2back);
            if(checkX(matrix) || checkY(matrix)){
                set1.setDuration(0);
                set1.start();
                new CountDownTimer(8000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if(checkX(matrix)) {
                            try{
                                destroyX(buttonMatrix,matrix);
                            } catch (Exception e){}
                        }
                    }
                    public void onFinish() {
                    }
                }.start();
                new CountDownTimer(8000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        if(checkY(matrix)) {
                            try{
                                destroyY(buttonMatrix,matrix);
                            } catch (Exception e){}
                        }
                    }
                    public void onFinish() {
                    }
                }.start();
            } else {
                set1.setDuration(1000);
                matrix[i1][j1] = ID1;
                matrix[i2][j2] = ID2;
                set1.start();
            }

            if(moves == 0) {
                blockGame(buttonMatrix);
                if (counter < lessScore) {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("Retry?");
                    builder1.setTitle("YOU LOSE");
                    builder1.setIcon(R.drawable.ops);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            (dialog, id) ->{
                                dialog.cancel();
                                reset(matrix);
                                setTable(matrix,buttonMatrix);
                                moves = 22;
                                Viewmoves.setText(String.valueOf(moves));
                                counterView.setText("");
                                progressBar.setProgress(0);
                            });

                    builder1.setNegativeButton(
                            "No",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter < mediumScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("1 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter < highScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("2 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                } else if(counter > highScore){
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setMessage("3 Heart");
                    builder1.setTitle("YOU WIN");
                    builder1.setIcon(R.drawable.path14);
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Next!",
                            (dialog, id) -> dialog.cancel());

                    AlertDialog alert11 = builder1.create();
                    alert11.getWindow().setBackgroundDrawableResource(R.drawable.rounded_dialog);
                    alert11.show();
                }
            } else if(moves % 5 == 0){
                new CountDownTimer(1000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        heart(matrix,buttonMatrix);
                    }
                    public void onFinish() {
                    }
                }.start();
            }
        }
        enableGame(buttonMatrix,matrix);
    }

    public boolean checkX(int[][] matrix) {
        int buffer1;
        int buffer2;
        int buffer3;
        int buffer4;
        int buffer5;
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                buffer1 = matrix[i][j];
                if (j + 1 < Column) {
                    buffer2 = matrix[i][j + 1];
                    if (buffer1 == buffer2 && buffer1 != 0 && j + 2 < Column) {
                        buffer3 = matrix[i][j + 2];
                        if (buffer1 == buffer3) {
                            if(j + 3 < Column) {
                                buffer4 = matrix[i][j + 3];
                                if (buffer1 == buffer4) {
                                    if (j + 4 < Column) {
                                        buffer5 = matrix[i][j + 4];
                                        if (buffer1 == buffer5) {
                                            return true;
                                        } else {
                                            return true;
                                        }
                                    } else {
                                        return true;
                                    }
                                }else {
                                    return true;
                                }
                            }else {
                                return true;
                            }

                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean checkY(int[][] matrix) {
        int buffer1;
        int buffer2;
        int buffer3;
        int buffer4;
        int buffer5;
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Column; j++){
                buffer1 = matrix[i][j];
                if(i+1 < Row){
                    buffer2 = matrix[i+1][j];
                    if(buffer1 == buffer2 && buffer1 != 0 && i+2 < Row){
                        buffer3 = matrix[i+2][j];
                        if(buffer1 == buffer3){
                            if(i+3 < Row){
                                buffer4 = matrix[i+3][j];
                                if(buffer1 == buffer4){
                                    if(i+4 < Row){
                                        buffer5 = matrix[i+4][j];
                                        if(buffer1 == buffer5){
                                            return true;
                                        } else {
                                            return true;
                                        }
                                    } else {
                                        return true;
                                    }
                                } else {
                                    return true;
                                }
                            } else {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public void destroyX(ArrayList<ArrayList<ImageButton>> buttonMatrix, int[][] matrix) {
        int buffer1;
        int buffer2;
        int buffer3;
        int buffer4;
        int buffer5;
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                buffer1 = matrix[i][j];
                if (j + 1 < Column) {
                    buffer2 = matrix[i][j + 1];
                    if (buffer1 == buffer2 && buffer1 != 0 && j + 2 < Column) {
                        buffer3 = matrix[i][j + 2];
                        if (buffer1 == buffer3) {
                            if(j + 3 < Column) {
                                buffer4 = matrix[i][j + 3];
                                if (buffer1 == buffer4) {
                                    if (j + 4 < Column) {
                                        buffer5 = matrix[i][j + 4];
                                        System.out.println(buffer1+","+buffer5);
                                        if (buffer1 == buffer5) {
                                            AnimatorSet set5 = new AnimatorSet();
                                            matrix[i][j] = 7;
                                            matrix[i][j + 1] = 7;
                                            matrix[i][j + 2] = 7;
                                            matrix[i][j + 3] = 7;
                                            matrix[i][j + 4] = 7;
                                            ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b4x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+3), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b4y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+3), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b5x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+4), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b5y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+4), "scaleY",1f,0f,1.5f,1f);
                                            set5.playTogether(b1x,b1y,b2x,b2y,b3x,b3y,b4x,b4y,b5x,b5y);
                                            set5.setDuration(900);
                                            set5.start();
                                            handler.postDelayed(() -> fall5x(matrix,buttonMatrix),300);
                                        } else {
                                            AnimatorSet set4 = new AnimatorSet();
                                            matrix[i][j] = 7;
                                            matrix[i][j + 1] = 7;
                                            matrix[i][j + 2] = 7;
                                            matrix[i][j + 3] = 7;
                                            ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b4x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+3), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b4y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+3), "scaleY",1f,0f,1.5f,1f);
                                            set4.playTogether(b1x,b1y,b2x,b2y,b3x,b3y,b4x,b4y);
                                            set4.setDuration(900);
                                            set4.start();
                                            handler.postDelayed(() -> fall4x(matrix,buttonMatrix),300);
                                        }
                                    } else {
                                        AnimatorSet set4 = new AnimatorSet();
                                        matrix[i][j] = 7;
                                        matrix[i][j + 1] = 7;
                                        matrix[i][j + 2] = 7;
                                        matrix[i][j + 3] = 7;
                                        ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                        ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                        ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleX",1f,0f,1.5f,1f);
                                        ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleY",1f,0f,1.5f,1f);
                                        ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleX",1f,0f,1.5f,1f);
                                        ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleY",1f,0f,1.5f,1f);
                                        ObjectAnimator b4x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+3), "scaleX",1f,0f,1.5f,1f);
                                        ObjectAnimator b4y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+3), "scaleY",1f,0f,1.5f,1f);
                                        set4.playTogether(b1x,b1y,b2x,b2y,b3x,b3y,b4x,b4y);
                                        set4.setDuration(900);
                                        set4.start();
                                        handler.postDelayed(() -> fall4x(matrix,buttonMatrix),300);
                                    }
                                }else {
                                    AnimatorSet set3 = new AnimatorSet();
                                    matrix[i][j] = 7;
                                    matrix[i][j + 1] = 7;
                                    matrix[i][j + 2] = 7;
                                    ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                    ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                    ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleX",1f,0f,1.5f,1f);
                                    ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleY",1f,0f,1.5f,1f);
                                    ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleX",1f,0f,1.5f,1f);
                                    ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleY",1f,0f,1.5f,1f);
                                    set3.playTogether(b1x,b1y,b2x,b2y,b3x,b3y);
                                    set3.setDuration(900);
                                    set3.start();
                                    handler.postDelayed(() -> fall3x(matrix, buttonMatrix),300);
                                }
                            }else {
                                AnimatorSet set3 = new AnimatorSet();
                                matrix[i][j] = 7;
                                matrix[i][j + 1] = 7;
                                matrix[i][j + 2] = 7;
                                ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleX",1f,0f,1.5f,1f);
                                ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+1), "scaleY",1f,0f,1.5f,1f);
                                ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleX",1f,0f,1.5f,1f);
                                ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j+2), "scaleY",1f,0f,1.5f,1f);
                                set3.playTogether(b1x,b1y,b2x,b2y,b3x,b3y);
                                set3.setDuration(900);
                                set3.start();
                                handler.postDelayed(() -> fall3x(matrix, buttonMatrix),300);
                            }

                        }
                    }
                }
            }
        }
    }

    public void destroyY(ArrayList<ArrayList<ImageButton>> buttonMatrix, int[][] matrix){
        int buffer1;
        int buffer2;
        int buffer3;
        int buffer4;
        int buffer5;
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Column; j++){
                buffer1 = matrix[i][j];
                if(i+1 < Row){
                    buffer2 = matrix[i+1][j];
                    if(buffer1 == buffer2 && buffer1 != 0 && i+2 < Row){
                        buffer3 = matrix[i+2][j];
                        if(buffer1 == buffer3){
                            if(i+3 < Row){
                                buffer4 = matrix[i+3][j];
                                if(buffer1 == buffer4){
                                    if(i+4 < Row){
                                        buffer5 = matrix[i+4][j];
                                        if(buffer1 == buffer5){
                                            AnimatorSet set5 = new AnimatorSet();
                                            matrix[i][j] = 7;
                                            matrix[i+1][j] = 7;
                                            matrix[i+2][j] = 7;
                                            matrix[i+3][j] = 7;
                                            matrix[i+4][j] = 7;
                                            ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b4x = ObjectAnimator.ofFloat( buttonMatrix.get(i+3).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b4y = ObjectAnimator.ofFloat( buttonMatrix.get(i+3).get(j), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b5x = ObjectAnimator.ofFloat( buttonMatrix.get(i+4).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b5y = ObjectAnimator.ofFloat( buttonMatrix.get(i+4).get(j), "scaleY",1f,0f,1.5f,1f);
                                            set5.playTogether(b1x,b1y,b2x,b2y,b3x,b3y,b4x,b4y,b5x,b5y);
                                            set5.setDuration(900);
                                            set5.start();
                                            handler.postDelayed(() -> fally(matrix,buttonMatrix),300);
                                        } else {
                                            AnimatorSet set4 = new AnimatorSet();
                                            matrix[i][j] = 7;
                                            matrix[i+1][j] = 7;
                                            matrix[i+2][j] = 7;
                                            matrix[i+3][j] = 7;
                                            ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleY",1f,0f,1.5f,1f);
                                            ObjectAnimator b4x = ObjectAnimator.ofFloat( buttonMatrix.get(i+3).get(j), "scaleX",1f,0f,1.5f,1f);
                                            ObjectAnimator b4y = ObjectAnimator.ofFloat( buttonMatrix.get(i+3).get(j), "scaleY",1f,0f,1.5f,1f);
                                            set4.playTogether(b1x,b1y,b2x,b2y,b3x,b3y,b4x,b4y);
                                            set4.setDuration(900);
                                            set4.start();
                                            handler.postDelayed(() -> fally(matrix,buttonMatrix),300);
                                        }
                                    } else {
                                        AnimatorSet set4 = new AnimatorSet();
                                        matrix[i][j] = 7;
                                        matrix[i+1][j] = 7;
                                        matrix[i+2][j] = 7;
                                        matrix[i+3][j] = 7;
                                        ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                        ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                        ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleX",1f,0f,1.5f,1f);
                                        ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleY",1f,0f,1.5f,1f);
                                        ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleX",1f,0f,1.5f,1f);
                                        ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleY",1f,0f,1.5f,1f);
                                        ObjectAnimator b4x = ObjectAnimator.ofFloat( buttonMatrix.get(i+3).get(j), "scaleX",1f,0f,1.5f,1f);
                                        ObjectAnimator b4y = ObjectAnimator.ofFloat( buttonMatrix.get(i+3).get(j), "scaleY",1f,0f,1.5f,1f);
                                        set4.playTogether(b1x,b1y,b2x,b2y,b3x,b3y,b4x,b4y);
                                        set4.setDuration(900);
                                        set4.start();
                                        handler.postDelayed(() -> fally(matrix,buttonMatrix),300);
                                    }
                                } else {
                                    AnimatorSet set3 = new AnimatorSet();
                                    matrix[i][j] = 7;
                                    matrix[i+1][j] = 7;
                                    matrix[i+2][j] = 7;
                                    ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                    ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                    ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleX",1f,0f,1.5f,1f);
                                    ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleY",1f,0f,1.5f,1f);
                                    ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleX",1f,0f,1.5f,1f);
                                    ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleY",1f,0f,1.5f,1f);
                                    set3.playTogether(b1x,b1y,b2x,b2y,b3x,b3y);
                                    set3.setDuration(900);
                                    set3.start();
                                    handler.postDelayed(() -> fally(matrix,buttonMatrix),300);
                                }
                            } else {
                                AnimatorSet set3 = new AnimatorSet();
                                matrix[i][j] = 7;
                                matrix[i+1][j] = 7;
                                matrix[i+2][j] = 7;
                                ObjectAnimator b1x = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleX",1f,0f,1.5f,1f);
                                ObjectAnimator b1y = ObjectAnimator.ofFloat( buttonMatrix.get(i).get(j), "scaleY",1f,0f,1.5f,1f);
                                ObjectAnimator b2x = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleX",1f,0f,1.5f,1f);
                                ObjectAnimator b2y = ObjectAnimator.ofFloat( buttonMatrix.get(i+1).get(j), "scaleY",1f,0f,1.5f,1f);
                                ObjectAnimator b3x = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleX",1f,0f,1.5f,1f);
                                ObjectAnimator b3y = ObjectAnimator.ofFloat( buttonMatrix.get(i+2).get(j), "scaleY",1f,0f,1.5f,1f);
                                set3.playTogether(b1x,b1y,b2x,b2y,b3x,b3y);
                                set3.setDuration(900);
                                set3.start();
                                handler.postDelayed(() -> fally(matrix,buttonMatrix),300);
                            }
                        }
                    }
                }
            }
        }
    }

    public void fall3x(int[][] matrix, ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        counter += (10);
        counterView.setText(String.valueOf(counter));
        progressBar.incrementProgressBy(40);
        Random rnd = new Random();
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
              if(i == 0 && matrix[i][j] == 7) {
                  if(matrix[i][j] == 0){
                      if(matrix[i][j+1] == 0){
                          if(matrix[i][j+2] == 0){
                              break;
                          } else {
                              if(matrix[i][j+2] == 7){
                                  matrix[i][j+2] = 1 + rnd.nextInt(5);
                                  setID(matrix,buttonMatrix,0);
                              } else break;
                          }
                      } else {
                          if(matrix[i][j+1] == 7){
                              matrix[i][j+1] = 1 + rnd.nextInt(5);
                              setID(matrix,buttonMatrix,0);
                          }
                          if(matrix[i][j+2] == 0){
                              break;
                          } else {
                              if(matrix[i][j+2] == 7){
                                  matrix[i][j+2] = 1 + rnd.nextInt(5);
                                  setID(matrix,buttonMatrix,0);
                              } else break;
                          }
                      }
                  } else {
                      if(matrix[i][j] == 7){
                          matrix[i][j] = 1 + rnd.nextInt(5);
                          setID(matrix,buttonMatrix,0);
                      }
                      if(matrix[i][j+1] == 0){
                          if(matrix[i][j+2] == 0){
                              break;
                          } else {
                              if(matrix[i][j+2] == 7){
                                      matrix[i][j+2] = 1 + rnd.nextInt(5);
                                      setID(matrix,buttonMatrix,0);
                              } else break;
                          }
                      } else {
                          if(matrix[i][j+1] == 7){
                              matrix[i][j+1] = 1 + rnd.nextInt(5);
                              setID(matrix,buttonMatrix,0);
                          }
                          if(matrix[i][j+2] == 0){
                              break;
                          } else {
                              if(matrix[i][j+2] == 7){
                                  matrix[i][j+2] = 1 + rnd.nextInt(5);
                                  setID(matrix,buttonMatrix,0);
                              } else break;
                          }
                      }
                  }
                  return;

              }else if (matrix[i][j] == 7) {
                  if(matrix[i-1][j] == 0){
                      matrix[i][j] = 1 + rnd.nextInt(5);
                  } else{
                      matrix[i][j] = matrix[i-1][j];
                      matrix[i-1][j] = 7;
                  }
                  if(matrix[i-1][j+1] == 0){
                      if(matrix[i][j+1] != 0) matrix[i][j+1] = 1 + rnd.nextInt(5);
                  } else {
                      matrix[i][j+1] = matrix[i-1][j+1];
                      matrix[i-1][j+1] = 7;
                  }
                  if(matrix[i-1][j+2] == 0){
                      if(matrix[i][j+2] != 0)matrix[i][j+2] = 1 + rnd.nextInt(5);
                  } else {
                      matrix[i][j+2] = matrix[i-1][j+2];
                      matrix[i-1][j+2] = 7;
                  }
                  setID(matrix,buttonMatrix,1);
              }
            }
        }
    }

    public void fall4x(int[][] matrix, ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        counter += (10);
        counterView.setText(String.valueOf(counter));
        progressBar.incrementProgressBy(40);
        Random rnd = new Random();
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                if(i == 0 &&  matrix[i][j] == 7) {
                    if (matrix[i][j] == 0) {
                        if (matrix[i][j + 1] == 0) {
                            if(matrix[i][j + 2] == 0){
                                if(matrix[i][j + 3] == 0){
                                    break;
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                    } else break;
                                }
                            } else {
                                if(matrix[i][j + 2] == 7){
                                    matrix[i][j + 2] = 1 + rnd.nextInt(5);
                                    setID(matrix,buttonMatrix,0);
                                }
                                if(matrix[i][j + 3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                    } else break;
                                }
                            }
                        } else {
                            if(matrix[i][j + 1] == 7){
                                matrix[i][j + 1] = 1 + rnd.nextInt(5);
                                setID(matrix,buttonMatrix,0);
                            }
                            if (matrix[i][j+2] == 0){
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                    } else break;
                                }
                            } else {
                                if(matrix[i][j+2] == 7){
                                    matrix[i][j+2] = 1 + rnd.nextInt(5);
                                    setID(matrix,buttonMatrix,0);
                                }
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                    } else break;
                                }
                            }
                        }
                    } else {
                        if(matrix[i][j] == 7){
                            matrix[i][j] = 1 + rnd.nextInt(5);
                            setID(matrix,buttonMatrix,0);
                        }
                        if(matrix[i][j + 1] == 0){
                            if(matrix[i][j+2] == 0){
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                    } else break;
                                }
                            } else {
                                if(matrix[i][j+2] == 7){
                                    matrix[i][j+2] = 1 + rnd.nextInt(5);
                                    setID(matrix,buttonMatrix,0);
                                }
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                    } else break;
                                }
                            }
                        } else {
                            if(matrix[i][j + 1] == 7){
                                matrix[i][j + 1] = 1 + rnd.nextInt(5);
                                setID(matrix,buttonMatrix,0);
                            }
                            if(matrix[i][j + 2] == 0){
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                    } else break;
                                }
                            } else {
                                if(matrix[i][j + 2] == 7){
                                    matrix[i][j + 2] = 1 + rnd.nextInt(5);
                                    setID(matrix,buttonMatrix,0);
                                }
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                    } else break;
                                }
                            }
                        }
                    }
                    return;
                }
                else if (matrix[i][j] == 7) {
                    if(matrix[i-1][j] == 0){
                        matrix[i][j] = 1 + rnd.nextInt(5);
                    } else{
                        matrix[i][j] = matrix[i-1][j];
                        matrix[i-1][j] = 7;
                    }
                    if(matrix[i-1][j+1] == 0){
                        if(matrix[i][j+1] != 0) matrix[i][j+1] = 1 + rnd.nextInt(5);
                    } else {
                        matrix[i][j+1] = matrix[i-1][j+1];
                        matrix[i-1][j+1] = 7;
                    }
                    if(matrix[i-1][j+2] == 0){
                        if(matrix[i][j+2] != 0)matrix[i][j+2] = 1 + rnd.nextInt(5);
                    } else {
                        matrix[i][j+2] = matrix[i-1][j+2];
                        matrix[i-1][j+2] = 7;
                    }
                    if(matrix[i-1][j+3] == 0){
                        if(matrix[i][j+3] != 0)matrix[i][j+3] = 1 + rnd.nextInt(5);
                    } else {
                        matrix[i][j+3] = matrix[i-1][j+3];
                        matrix[i-1][j+3] = 7;
                    }
                    setID(matrix,buttonMatrix,2);
                }
            }
        }
    }

    public void fall5x(int[][] matrix, ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        counter += (10);
        counterView.setText(String.valueOf(counter));
        progressBar.incrementProgressBy(40);
        Random rnd = new Random();
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                if(i == 0 && matrix[i][j] == 7) {

                    if (matrix[i][j] == 0) {
                        if (matrix[i][j + 1] == 0) {
                            if(matrix[i][j + 2] == 0){
                                if(matrix[i][j + 3] == 0){
                                    if(matrix[i][j+4] == 0){
                                        break;
                                    } else {
                                        if(matrix[i][j+4] == 7){
                                            matrix[i][j+4] = 1 + rnd.nextInt(5);
                                            setID(matrix,buttonMatrix,0);
                                        } else break;
                                    }
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                        if(matrix[i][j+4] == 0){
                                            break;
                                        } else {
                                            if(matrix[i][j+4] == 7){
                                                matrix[i][j+4] = 1 + rnd.nextInt(5);
                                                setID(matrix,buttonMatrix,0);
                                            } else break;
                                        }
                                    }
                                }
                            } else {
                                if(matrix[i][j + 2] == 7){
                                    matrix[i][j + 2] = 1 + rnd.nextInt(5);
                                    setID(matrix,buttonMatrix,0);
                                }
                                if(matrix[i][j + 3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                        if(matrix[i][j+4] == 0){
                                            break;
                                        } else {
                                            if(matrix[i][j+4] == 7){
                                                matrix[i][j+4] = 1 + rnd.nextInt(5);
                                                setID(matrix,buttonMatrix,0);
                                            } else break;
                                        }
                                    }
                                }
                            }
                        } else {
                            if(matrix[i][j + 1] == 7){
                                matrix[i][j + 1] = 1 + rnd.nextInt(5);
                                setID(matrix,buttonMatrix,0);
                            }
                            if (matrix[i][j+2] == 0){
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                        if(matrix[i][j+4] == 0){
                                            break;
                                        } else {
                                            if(matrix[i][j+4] == 7){
                                                matrix[i][j+4] = 1 + rnd.nextInt(5);
                                                setID(matrix,buttonMatrix,0);
                                            } else break;
                                        }
                                    }
                                }
                            } else {
                                if(matrix[i][j+2] == 7){
                                    matrix[i][j+2] = 1 + rnd.nextInt(5);
                                    setID(matrix,buttonMatrix,0);
                                }
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                        if(matrix[i][j+4] == 0){
                                            break;
                                        } else {
                                            if(matrix[i][j+4] == 7){
                                                matrix[i][j+4] = 1 + rnd.nextInt(5);
                                                setID(matrix,buttonMatrix,0);
                                            } else break;
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        if(matrix[i][j] == 7){
                            matrix[i][j] = 1 + rnd.nextInt(5);
                            setID(matrix,buttonMatrix,0);
                        }
                        if(matrix[i][j + 1] == 0){
                            if(matrix[i][j+2] == 0){
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                        if(matrix[i][j+4] == 0){
                                            break;
                                        } else {
                                            if(matrix[i][j+4] == 7){
                                                matrix[i][j+4] = 1 + rnd.nextInt(5);
                                                setID(matrix,buttonMatrix,0);
                                            } else break;
                                        }
                                    }
                                }
                            } else {
                                if(matrix[i][j+2] == 7){
                                    matrix[i][j+2] = 1 + rnd.nextInt(5);
                                    setID(matrix,buttonMatrix,0);
                                }
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                        if(matrix[i][j+4] == 0){
                                            break;
                                        } else {
                                            if(matrix[i][j+4] == 7){
                                                matrix[i][j+4] = 1 + rnd.nextInt(5);
                                                setID(matrix,buttonMatrix,0);
                                            } else break;
                                        }
                                    }
                                }
                            }
                        } else {
                            if(matrix[i][j + 1] == 7){
                                matrix[i][j + 1] = 1 + rnd.nextInt(5);
                                setID(matrix,buttonMatrix,0);
                            }
                            if(matrix[i][j + 2] == 0){
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                        if(matrix[i][j+4] == 0){
                                            break;
                                        } else {
                                            if(matrix[i][j+4] == 7){
                                                matrix[i][j+4] = 1 + rnd.nextInt(5);
                                                setID(matrix,buttonMatrix,0);
                                            } else break;
                                        }
                                    }
                                }
                            } else {
                                if(matrix[i][j + 2] == 7){
                                    matrix[i][j + 2] = 1 + rnd.nextInt(5);
                                    setID(matrix,buttonMatrix,0);
                                }
                                if(matrix[i][j+3] == 0){
                                } else {
                                    if(matrix[i][j+3] == 7){
                                        matrix[i][j+3] = 1 + rnd.nextInt(5);
                                        setID(matrix,buttonMatrix,0);
                                        if(matrix[i][j+4] == 0){
                                            break;
                                        } else {
                                            if(matrix[i][j+4] == 7){
                                                matrix[i][j+4] = 1 + rnd.nextInt(5);
                                                setID(matrix,buttonMatrix,0);
                                            } else break;
                                        }
                                    }
                                }
                            }
                        }
                        return;
                    }
                } else if (matrix[i][j] == 7) {
                    if(matrix[i-1][j] == 0){
                        matrix[i][j] = 1 + rnd.nextInt(5);
                    } else{
                        matrix[i][j] = matrix[i-1][j];
                        matrix[i-1][j] = 7;
                    }
                    if(matrix[i-1][j+1] == 0){
                        if(matrix[i][j+1] != 0) matrix[i][j+1] = 1 + rnd.nextInt(5);
                    } else {
                        matrix[i][j+1] = matrix[i-1][j+1];
                        matrix[i-1][j+1] = 7;
                    }
                    if(matrix[i-1][j+2] == 0){
                        if(matrix[i][j+2] != 0)matrix[i][j+2] = 1 + rnd.nextInt(5);
                    } else {
                        matrix[i][j+2] = matrix[i-1][j+2];
                        matrix[i-1][j+2] = 7;
                    }
                    if(matrix[i-1][j+3] == 0){
                        if(matrix[i][j+3] != 0)matrix[i][j+3] = 1 + rnd.nextInt(5);
                    } else {
                        matrix[i][j+3] = matrix[i-1][j+3];
                        matrix[i-1][j+3] = 7;
                    }
                    if(matrix[i-1][j+4] == 0){
                        if(matrix[i][j+4] != 0)matrix[i][j+4] = 1 + rnd.nextInt(5);
                    }else {
                        matrix[i][j+4] = matrix[i-1][j+4];
                        matrix[i-1][j+4] = 7;
                    }
                   setID(matrix,buttonMatrix,3);
                }
            }
        }
    }

    public void fally(int[][] matrix, ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        counter += (50);
        counterView.setText(String.valueOf(counter));
        progressBar.incrementProgressBy(40);
        Random rnd = new Random();
        int r = -1;
        int c = -1;
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
               if(matrix[i][j] == 7){
                   r = i;
                   c = j;
                   break;
               }
            }
            if(r != -1)break;
        }

        while(r > -1){
                if (r - 1 == -1) {
                    if (matrix[r][c] != 0) matrix[r][c] = 1 + rnd.nextInt(5);
                    setID(matrix, buttonMatrix, 4);
                } else {
                    if (matrix[r - 1][c] != 0) matrix[r][c] = matrix[r - 1][c];
                    else {
                        if(matrix[r][c] != 0) matrix[r][c] = 1 + rnd.nextInt(5);
                    }
                }
            r--;
            setID(matrix,buttonMatrix,4);
        }

    }

    public void setID(int[][] matrix, ArrayList<ArrayList<ImageButton>> buttonMatrix, int id) {
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Column; j++){
                if(matrix[i][j] == 1){
                    buttonMatrix.get(i).get(j).setBackgroundColor(Color.YELLOW);
                    if(buttonMatrix.get(i).get(j).getVisibility() == View.INVISIBLE){
                        buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    }
                }else if (matrix[i][j] == 2) {
                    buttonMatrix.get(i).get(j).setBackgroundColor(Color.GREEN);
                    if (buttonMatrix.get(i).get(j).getVisibility() == View.INVISIBLE) {
                        buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    }
                }else if (matrix[i][j] == 3) {
                    buttonMatrix.get(i).get(j).setBackgroundResource(R.color.orange);
                    if (buttonMatrix.get(i).get(j).getVisibility() == View.INVISIBLE) {
                        buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    }
                }else if (matrix[i][j] == 4) {
                    buttonMatrix.get(i).get(j).setBackgroundColor(Color.BLUE);
                    if (buttonMatrix.get(i).get(j).getVisibility() == View.INVISIBLE) {
                        buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    }
                }else if (matrix[i][j] == 5) {
                    buttonMatrix.get(i).get(j).setBackgroundResource(R.color.purple);
                    if (buttonMatrix.get(i).get(j).getVisibility() == View.INVISIBLE) {
                        buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    }
                }else if(matrix[i][j] == 7) {
                    buttonMatrix.get(i).get(j).setVisibility(View.INVISIBLE);
                }else if(matrix[i][j] == 8) {
                    buttonMatrix.get(i).get(j).setVisibility(View.VISIBLE);
                    AnimatorSet set = new AnimatorSet();
                    ObjectAnimator rotation = ObjectAnimator.ofFloat(buttonMatrix.get(i).get(j), "rotation", -30,30,-20,20,-10,10,0f);
                    set.playTogether(rotation);
                    set.setDuration(1700);
                    set.start();
                    buttonMatrix.get(i).get(j).setBackgroundResource(R.drawable.path14);
                    AnimatorSet set1 = new AnimatorSet();
                    ObjectAnimator scalexback = ObjectAnimator.ofFloat(buttonMatrix.get(i).get(j), "scaleX", 1f,0.6f,1f);
                    ObjectAnimator scaleyback = ObjectAnimator.ofFloat(buttonMatrix.get(i).get(j), "scaleY", 1f,0.6f,1f);
                    set1.playTogether(scalexback,scaleyback);
                    set1.setDuration(1000);
                    set1.start();
                }
            }
        }

        switch (id){
            case 1: {
                 fall3x(matrix,buttonMatrix);
                break;
            }
            case 2: {
                fall4x(matrix,buttonMatrix);
                break;
            }
            case 3: {
                fall5x(matrix,buttonMatrix);
                break;
            }
            case 4: {
                fally(matrix,buttonMatrix);
                break;
            }
        }
    }

    public void heart(int[][] matrix, ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        Random rnd = new Random();
        int r = rnd.nextInt(8);
        int c = rnd.nextInt(8);
        matrix[r][c] = 8;
        setID(matrix,buttonMatrix,0);
    }

    public void loveCrush(int[][] matrix, ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        blockGame(buttonMatrix);
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Column; j++) {
                if(matrix[i][j] == 8){
                    matrix[i][j] = 1 + new Random().nextInt(5);
                    AnimatorSet set1 = new AnimatorSet();
                    ObjectAnimator scalex = ObjectAnimator.ofFloat(buttonMatrix.get(i).get(j), "scaleX", 1f,1.9f,1f);
                    ObjectAnimator scaley = ObjectAnimator.ofFloat(buttonMatrix.get(i).get(j), "scaleY", 1f,1.9f,1f);
                    set1.playTogether(scalex,scaley);
                    set1.setDuration(600);
                    set1.start();
                    handler.postDelayed(() -> setID(matrix,buttonMatrix,0),500);
                }
            }
        }
        enableGame(buttonMatrix,matrix);
    }

    public void blockGame(ArrayList<ArrayList<ImageButton>> buttonMatrix) {
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Column; j++){
                buttonMatrix.get(i).get(j).setEnabled(false);
            }
        }
    }

    public void enableGame(ArrayList<ArrayList<ImageButton>> buttonMatrix, int[][] matrix) {
        for(int i = 0; i < Row; i++){
            for(int j = 0; j < Column; j++){
                if(matrix[i][j] != 0) buttonMatrix.get(i).get(j).setEnabled(true);
            }
        }
    }

    public void reset(int[][] matrix){
        Random rnd = new Random();
        for (int i = 0; i < Row; i++) {
            for (int j = 0; j < Column; j++) {
                matrix[i][j] = 1 + rnd.nextInt(5);
            }
        }
    }
}



