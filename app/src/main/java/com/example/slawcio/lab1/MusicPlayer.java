package com.example.slawcio.lab1;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MusicPlayer extends AppCompatActivity {

    View view;

    private MediaPlayer sound;
    private int paused;
    private AudioManager audioManager = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        view = (View) findViewById(R.id.player_layout) ;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setPrice();
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
        ImageButton imageButton = (ImageButton) findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CartActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(getIntent().getBooleanExtra("favorite", false))
        getMenuInflater().inflate(R.menu.menu_add_to_cart, menu);
        return true;
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
            case R.id.favorite_item: //dodawanie do ulubionych!!!
            {
//                ArrayList<Integer> list = Cart.getInstance();
//                if(!list.contains(getIntent().getIntExtra("images", 0)))
//                list.add(getIntent().getIntExtra("images", 0));
                addToCart();
                setPrice();
                if(Cart.ifChecked(getIntent().getIntExtra("images", 0)))
                Snackbar.make(view, "Added to cart!", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
                else
                    Snackbar.make(view, "Removed from cart!", Snackbar.LENGTH_SHORT)
                            .setAction("Action", null).show();
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setPrice();
    }

    private void setPrice(){
        Cart.setFullPrice();
        TextView price = (TextView) view.findViewById(R.id.tv_full_price);
        price.setText(Cart.getFullPrice()+"$");
    }

    private boolean addToCart(){
        ArrayList<CartActivity.Product> list = Cart.getInstance();
        for(CartActivity.Product product : list){
            if(product.getImage() == getIntent().getIntExtra("images", 0)){
                product.changeIsChosen();
                return true;
            }
        }
        return false;
    }


}
