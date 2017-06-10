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
    int paused;

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
        if(!isStarted) {

            //   videoView.setMediaController(mediaController);
            //    mediaController.setAnchorView(videoView);
            videoView.seekTo(0);
            videoView.start();
            setIsStarted();
        } else {
            videoView.seekTo(paused);
            videoView.start();
        }
    }

    public void pauseVideo(View view) {
        if(isStarted) {
            paused = videoView.getCurrentPosition();
            videoView.pause();
        }
    }

    private void setIsStarted(){
        if(isStarted) isStarted = false;
        else isStarted = true;
    }
}
