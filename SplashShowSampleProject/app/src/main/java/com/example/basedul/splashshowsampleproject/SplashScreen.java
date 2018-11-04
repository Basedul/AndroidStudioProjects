package com.example.basedul.splashshowsampleproject;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {

    private ProgressBar progressBar;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_splash_screen);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        mediaPlayer = MediaPlayer.create(this, R.raw.keno);

        if(mediaPlayer != null){
            mediaPlayer.start();
        }
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = 1; i <= 100; i+=5) {
                    try {
                        Thread.sleep(1000);
                        progressBar.setProgress(i);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i>95){
                        mediaPlayer.stop();
                    }
                }

                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });
        thread.start();


    }
}
