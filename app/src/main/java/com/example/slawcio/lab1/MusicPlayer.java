package com.example.slawcio.lab1;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import static com.example.slawcio.lab1.R.id.toolbar;

public class MusicPlayer extends AppCompatActivity {

    private MediaPlayer sound;
    private int paused;
    private AudioManager audioManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageView artist = (ImageView) findViewById(R.id.artist);
        artist.setImageResource(getIntent().getIntExtra("images", 0));
    //    ImageButton pauseButton = (ImageButton) findViewById(R.id.pause);
        SeekBar volume = (SeekBar) findViewById(R.id.volume);
        audioManager = (AudioManager) getSystemService(getApplicationContext().AUDIO_SERVICE);
        volume.setMax(audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        volume.setProgress(audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC));
        volume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                        progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void play(View view){
        if(sound == null) {
            sound = MediaPlayer.create(getApplicationContext(), getIntent().getIntExtra("music", 0));
            sound.start();
        } else if(!sound.isPlaying()){
            sound.seekTo(paused);
            sound.start();
        }
    }

    public void pause(View view){
        if(sound != null) {
            sound.pause();
            paused=sound.getCurrentPosition();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case android.R.id.home: {
                sound.stop();
                finish();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}