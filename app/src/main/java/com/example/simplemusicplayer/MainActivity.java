package com.example.simplemusicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MediaPlayer mp=new MediaPlayer();
        mp.setAudioStreamType(AudioManager.STREAM_MUSIC);
        String aPath="android.resourse://"+getPackageName()+"/raw/amaydekona";
        Uri audioURI= Uri.parse(aPath);
        try{
            mp.setDataSource(this,audioURI);
            mp.prepare();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}