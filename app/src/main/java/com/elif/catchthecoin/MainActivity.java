package com.elif.catchthecoin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView scoretw;
    TextView timetw;
    int score;
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;
    ImageView imageView6;
    ImageView imageView7;
    ImageView imageView8;
    ImageView imageView9;
    ImageView imageView10;
    ImageView imageView11;
    ImageView imageView12;
    ImageView imageView13;
    ImageView imageView14;
    ImageView imageView15;
    ImageView imageView16;
    ImageView imageView17;
    ImageView imageView18;
    ImageView imageView19;
    ImageView imageView20;
    ImageView imageView21;
    ImageView imageView22;
ImageView[] imagearray;
Handler handler;
Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize
        timetw=findViewById(R.id.timetw);
        scoretw=findViewById(R.id.scoretw);

        imageView3=findViewById(R.id.imageView3);
        imageView4=findViewById(R.id.imageView4);
        imageView5=findViewById(R.id.imageView5);
        imageView6=findViewById(R.id.imageView6);
        imageView7=findViewById(R.id.imageView7);
        imageView8=findViewById(R.id.imageView8);
        imageView9=findViewById(R.id.imageView9);
        imageView10=findViewById(R.id.imageView10);
        imageView11=findViewById(R.id.imageView11);
        imageView12=findViewById(R.id.imageView12);
        imageView13=findViewById(R.id.imageView13);
        imageView14=findViewById(R.id.imageView14);
        imageView15=findViewById(R.id.imageView15);
        imageView16=findViewById(R.id.imageView16);
        imageView17=findViewById(R.id.imageView17);
        imageView18=findViewById(R.id.imageView18);
        imageView19=findViewById(R.id.imageView19);
        imageView20=findViewById(R.id.imageView20);
        imageView21=findViewById(R.id.imageView21);
        imageView22=findViewById(R.id.imageView22);

        imagearray=new ImageView[]{imageView18,imageView20,
                imageView10,imageView17,imageView16,imageView9,
                imageView8,imageView7,imageView6,imageView4,
                imageView22,imageView21,imageView19,imageView15,
                imageView14,imageView13,imageView12,imageView11,
                imageView5,imageView3
        };

        hideImages();

        score= 0 ;

        new CountDownTimer(10000,1000)
        {

            @Override
            public void onTick(long millisUntilFinished) {
                timetw.setText("TİME : "+millisUntilFinished/1000);

            }

            @Override
            public void onFinish() {
                timetw.setText("TİME IS OVER");
                handler.removeCallbacks(runnable);
                for(ImageView image : imagearray)
                {
                    image.setVisibility(View.INVISIBLE);
                }

                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

                alert.setTitle("RESTART ? ");
                alert.setMessage("Are you sure");
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //restart, güncel aktiviteyi bitirecek sonra yeniden başlatacak, çok kullanılmıyor bu yöntem

                        Intent intent =getIntent();
                        finish();
                        startActivity(intent);

                    }
                });
                alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this,"GAME OVER",Toast.LENGTH_LONG).show();

                    }
                });
                alert.show();
            }
        }.start();
    }

    public void increaseScore(View view)
    {
        score++;

        scoretw.setText("SCORE :"+ score);

    }

    public void hideImages()
    {
        handler= new Handler();
        runnable=new Runnable() {
            @Override
            public void run() {
                for(ImageView image : imagearray)
                {
                    image.setVisibility(View.INVISIBLE);
                }
                Random random = new Random();
                int i = random.nextInt(20);
                imagearray[i].setVisibility(View.VISIBLE);

                //bir şeyi çalıştır, benim dediğim periodda
                handler.postDelayed(this,500);
            }
        };

        handler.post(runnable);

    }

}