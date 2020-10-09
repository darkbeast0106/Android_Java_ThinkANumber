package com.example.thinkanumber;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView imageHp1, imageHp2, imageHp3, imageHp4;
    private TextView textTippeltSzam;
    private Button btnNovel, btnCsokkent, btnTippel;
    private int gondoltSzam, tippeltSzam, elet;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        ujJatek();

        btnTippel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gondoltSzam < tippeltSzam){
                    Toast.makeText(MainActivity.this, "A gondolt szám kisebb", Toast.LENGTH_SHORT).show();
                    eletLevon();
                } else if (gondoltSzam > tippeltSzam){
                    Toast.makeText(MainActivity.this, "A gondolt szám nagyobb", Toast.LENGTH_SHORT).show();
                    eletLevon();
                } else {
                    builder.setTitle("Győzelem");
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
        btnNovel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippeltSzam < 10){
                    tippeltSzam++;
                    textTippeltSzam.setText(tippeltSzam+"");
                }else{
                    Toast.makeText(MainActivity.this, "A szám nem lehet nagyobb mint 10", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnCsokkent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tippeltSzam > 1){
                    tippeltSzam--;
                    textTippeltSzam.setText(String.valueOf(tippeltSzam));
                }else{
                    Toast.makeText(MainActivity.this, "A szám nem lehet kisebb mint 1", Toast.LENGTH_SHORT).show();
                }

            }
        });
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
            builder.setTitle("Vesztettél").create().show();
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
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false).setMessage("Szeretne új játékot játszani?")
            .setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    ujJatek();
                }
            })
            .setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
    }

    private void ujJatek() {
        tippeltSzam = 1;
        elet = 4;
        gondoltSzam = (int)(Math.random()*10)+1;
        textTippeltSzam.setText(String.valueOf(tippeltSzam));
        imageHp1.setImageResource(R.drawable.heart2);
        imageHp2.setImageResource(R.drawable.heart2);
        imageHp3.setImageResource(R.drawable.heart2);
        imageHp4.setImageResource(R.drawable.heart2);

    }


}
