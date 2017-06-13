package com.example.slawcio.lab1;

import android.media.MediaPlayer;
import android.widget.MediaController;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;
    Boolean isStarted = false;
    int paused = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        videoView = (VideoView) findViewById(R.id.videoView);
        mediaController = new MediaController(this);
        String path = "android.resource://com.example.slawcio.lab1/" + getIntent().getIntExtra("video", 0);
        Uri uri = Uri.parse(path);
        videoView.setVideoURI(uri);
        videoView.seekTo(100);


    }


    public void playVideo(View view) {
        MediaPlayer.OnPreparedListener onPreparedListener = new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mp) {
                mp.seekTo(paused);
            }
        };
        videoView.setOnPreparedListener(onPreparedListener);
            videoView.start();
            paused = 0;
    }

    public void pauseVideo(View view) {

            videoView.pause();
            paused = videoView.getCurrentPosition();

    }

    private void setIsStarted(){
        if(isStarted) isStarted = false;
        else isStarted = true;
    }
}
