package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class ReproductorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
    }

    public void playAudio1(View v) {
        System.out.println("playAudio1");
        MediaPlayer mp = MediaPlayer.create(this, R.raw.auddio1);
        mp.start();
    }

    public void playAudio2(View v) {
        System.out.println("playAudio2");
        MediaPlayer mp = MediaPlayer.create(this, R.raw.audio2);
        mp.start();
    }
}