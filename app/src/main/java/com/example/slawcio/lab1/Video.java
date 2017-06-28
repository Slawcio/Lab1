package com.example.slawcio.lab1;

import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.VideoView;


public class Video extends android.support.v4.app.Fragment {

    private int VIDEOS[]={
            R.raw.moje_pole,
            R.raw.nowy_rok,
            R.raw.pytania,
            R.raw.moje_pole,
            R.raw.nowy_rok,
            R.raw.pytania,
            R.raw.moje_pole,
            R.raw.nowy_rok,
            R.raw.pytania,
            R.raw.moje_pole,
            R.raw.nowy_rok,
            R.raw.pytania
    };

    private int IMAGES[]={
      R.drawable.moje_pole_img,
            R.drawable.nowy_rok_img,
            R.drawable.pytania_img,
            R.drawable.moje_pole_img,
            R.drawable.nowy_rok_img,
            R.drawable.pytania_img,
            R.drawable.moje_pole_img,
            R.drawable.nowy_rok_img,
            R.drawable.pytania_img,
            R.drawable.moje_pole_img,
            R.drawable.nowy_rok_img,
            R.drawable.pytania_img
    };

    String[] uriTitles = new String[VIDEOS.length];


    @Override
    public void onDestroy() {
        super.onDestroy();
        FragmentManager manager = ((Fragment) this).getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) this);
        trans.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_video, container, false);
        for(int i = 0; i < VIDEOS.length; i++){
            uriTitles[i] = "android.resource://com.example.slawcio.lab1/" + VIDEOS[i];
        }

        GridView gridView = (GridView) view.findViewById(R.id.gridview_3);
     //   gridView.setAdapter(new VideoAdapter(getContext(), uriTitles));
        VideoAdapter adapter = new VideoAdapter(getContext(), uriTitles, IMAGES);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent intent = new Intent(getContext(), VideoPlayer.class);
                intent.putExtra("video", VIDEOS[position]);
                startActivity(intent);


            }
        });
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                VideoView videoView = (VideoView) view.findViewById(R.id.video_item);
                ImageView imageView = (ImageView) view.findViewById(R.id.image_item);
                if(!videoView.isPlaying()) {
                    imageView.setVisibility(View.GONE);
                    videoView.setVisibility(View.VISIBLE);
                    videoView.seekTo(0);
                    videoView.start();
                } else {
                    videoView.pause();
                    videoView.setVisibility(View.GONE);
                    imageView.setVisibility(View.VISIBLE);
                }
                return true;
            }
        });


        return view;
    }



}
