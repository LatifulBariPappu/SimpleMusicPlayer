package com.example.simplemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPause,btnPlay,btnStop;

        btnPlay=findViewById(R.id.btnPlay);
        btnPause=findViewById(R.id.btnPause);
        btnStop=findViewById(R.id.btnStop);


        MediaPlayer mp=new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String aPath="android.resourse://"+getPackageName()+"/raw/amaydekona";
        String onlineAudioPath="https://soundcloud.com/djactor/2013-1";
//      Uri audioURI= Uri.parse(aPath);
        Uri onlineURI=Uri.parse(onlineAudioPath);
        try{
            mp.setDataSource(this,onlineURI);
            mp.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });
        btnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.seekTo(0);
            }
        });

//        mp.seekTo();
//        mp.getDuration();
//        mp.getCurrentPosition();
//        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//
//            }
//        });
    }
}
