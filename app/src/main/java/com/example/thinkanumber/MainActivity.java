package com.example.thinkanumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageHp1, imageHp2, imageHp3, imageHp4;
    private TextView textTippeltSzam;
    private Button btnNovel, btnCsokkent, btnTippel;
    private int gondoltSzam, tippeltSzam, elet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        btnTippel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gondoltSzam < tippeltSzam){
                    //TODO: értesítés, hogy a gondolt szám kisebb
                    eletLevon();
                } else if (gondoltSzam > tippeltSzam){
                    //TODO: értesítés, hogy a gondolt szám nagyobb
                    eletLevon();
                } else {
                    //TODO: VICTORY felugró ablak
                }
            }
        });
        //TODO: Növel és csökkent gombok eseménye
    }

    private void eletLevon() {
        switch (elet){
            case 4:
                imageHp4.setImageResource(R.drawable.heart1);
                break;
            case 3:
                imageHp3.setImageResource(R.drawable.heart1);
                break;
            case 2:
                imageHp2.setImageResource(R.drawable.heart1);
                break;
            case 1:
                imageHp1.setImageResource(R.drawable.heart1);
                break;
            default:
                break;
        }
        elet--;
        if (elet < 1){
            //TODO: GAME OVER felugró ablak
        }
    }

    private void init() {
        imageHp1 = findViewById(R.id.image_hp1);
        imageHp2 = findViewById(R.id.image_hp2);
        imageHp3 = findViewById(R.id.image_hp3);
        imageHp4 = findViewById(R.id.image_hp4);
        textTippeltSzam = findViewById(R.id.text_tippelt_szam);
        btnNovel = findViewById(R.id.btn_novel);
        btnCsokkent = findViewById(R.id.btn_csokkent);
        btnTippel = findViewById(R.id.btn_tipp);
        tippeltSzam = 1;
        elet = 4;
        gondoltSzam = (int)(Math.random()*10)+1;
    }


}
