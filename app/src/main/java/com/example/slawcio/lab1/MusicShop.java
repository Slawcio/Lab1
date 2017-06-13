package com.example.slawcio.lab1;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class MusicShop extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_shop);

        final int[] images = getIntent().getIntArrayExtra("images");
        final int[] music = getIntent().getIntArrayExtra("music");

        GridView gridView = (GridView) findViewById(R.id.gridview_music_shop);
        gridView.setAdapter(new ImageAdapter(getApplicationContext(), images));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MusicPlayer.class);
                intent.putExtra("position", position);
                Bundle b = new Bundle();
                b.putInt("images", images[position]);
                b.putInt("music", music[position]);
                b.putBoolean("favorite", true);
                intent.putExtras(b);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
                        0, view.getWidth(), view.getHeight());
                startActivity(intent, options.toBundle());
            }
        });
    }
}
