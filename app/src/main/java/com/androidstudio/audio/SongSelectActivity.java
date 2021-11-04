package com.androidstudio.audio;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class SongSelectActivity extends Activity implements View.OnClickListener{
    Button button;
    TextView songNumbertxv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_select);
        button = findViewById(R.id.Song1);
        button.setOnClickListener(this);

        button = findViewById(R.id.Song2);
        button.setOnClickListener(this);

        button = findViewById(R.id.Song3);
        button.setOnClickListener(this);

        button = findViewById(R.id.Song4);
        button.setOnClickListener(this);

        button = findViewById(R.id.Song5);
        button.setOnClickListener(this);

        button = findViewById(R.id.Song6);
        button.setOnClickListener(this);

        button = findViewById(R.id.ChoseBtn);
        button.setOnClickListener(this);

        songNumbertxv = findViewById(R.id.songNumber);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Song1:
                songNumbertxv.setText("1");
                break;
            case R.id.Song2:
                songNumbertxv.setText("2");
                break;
            case R.id.Song3:
                songNumbertxv.setText("3");
                break;
            case R.id.Song4:
                songNumbertxv.setText("4");
                break;
            case R.id.Song5:
                songNumbertxv.setText("5");
                break;
            case R.id.Song6:
                songNumbertxv.setText("6");
                break;
            case R.id.ChoseBtn:
                int selected = 0;
                try{
                    selected = Integer.parseInt(songNumbertxv.getText().toString());
                }catch(Exception e){
                }
                SongSelected.CurrentSongNum = selected;
                this.finish();
                break;
        }
    }
}