package com.androidstudio.audio;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button button;
    MediaPlayer mediaPlayer;
    ArrayList<MediaPlayer> songsArrayList = new ArrayList<>();
    TextView songLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        songsArrayList.add(MediaPlayer.create(this,R.raw.song1));
        songsArrayList.add(MediaPlayer.create(this,R.raw.song2));
        songsArrayList.add(MediaPlayer.create(this,R.raw.song3));
        songsArrayList.add(MediaPlayer.create(this,R.raw.song4));
        songsArrayList.add(MediaPlayer.create(this,R.raw.song5));
        songsArrayList.add(MediaPlayer.create(this,R.raw.song6));

        button = findViewById(R.id.SelectBtn);
        button.setOnClickListener(this);

        button = findViewById(R.id.PlayBtn);
        button.setOnClickListener(this);

        button = findViewById(R.id.StopBtn);
        button.setOnClickListener(this);
        songLabel = findViewById(R.id.txvCurrentSong);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SelectBtn:
                Intent intent = new Intent(HomeActivity.this, SongSelectActivity.class);
                startActivity(intent);
                break;
            case R.id.PlayBtn:
                if (mediaPlayer != null){
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                }
                try {
                    mediaPlayer = songsArrayList.get(SongSelected.CurrentSongNum - 1);
                    songLabel.setText("Đang phát bài thứ " + SongSelected.CurrentSongNum + "");
                    mediaPlayer.start();
                }catch (Exception e){}
                break;
            case R.id.StopBtn:
                if(mediaPlayer != null)
                    if(mediaPlayer.isPlaying()){
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        mediaPlayer = null;
                    }
                break;
        }
    }
}