package com.example.slawcio.lab1;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import static com.example.slawcio.lab1.Cart.uploadData;


public class Shop extends Fragment {

    private static final int ROCK_IMAGES[]={
            R.drawable.the_doors,
            R.drawable.rchp,
            R.drawable.eric,
            R.drawable.the_doors,
            R.drawable.rchp,
            R.drawable.eric,
            R.drawable.the_doors,
            R.drawable.rchp,
            R.drawable.eric
    };

    private static final int SLAWCIO_IMAGES[]={
            R.drawable.jo2,
            R.drawable.jo3,
            R.drawable.jo_i_martyna,
            R.drawable.jo2,
            R.drawable.jo3,
            R.drawable.jo_i_martyna,
            R.drawable.jo2,
            R.drawable.jo3,
            R.drawable.jo_i_martyna
    };

    private static final int ELECTRONIC_IMAGES[]={
            R.drawable.big_wild,
            R.drawable.crazy,
            R.drawable.escobar,
            R.drawable.dj_snake,
            R.drawable.luis,
            R.drawable.big_wild,
            R.drawable.crazy,
            R.drawable.escobar,
            R.drawable.dj_snake,
            R.drawable.luis
    };

    private static final int CLASSIC_IMAGES[]={
            R.drawable.star_wars,
            R.drawable.prokofiew,
            R.drawable.the_maker,
            R.drawable.star_wars,
            R.drawable.prokofiew,
            R.drawable.the_maker,
            R.drawable.star_wars,
            R.drawable.prokofiew,
            R.drawable.the_maker
    };

    private static final int ROCK[]={
            R.raw.riders_on_the_storm,
            R.raw.funny_face,
            R.raw.layla,
            R.raw.riders_on_the_storm,
            R.raw.funny_face,
            R.raw.layla,
            R.raw.riders_on_the_storm,
            R.raw.funny_face,
            R.raw.layla
    };

    private static final int SLAWCIO[]={
            R.raw.banana,
            R.raw.solo_zycia,
            R.raw.sweet_dreams,
            R.raw.banana,
            R.raw.solo_zycia,
            R.raw.sweet_dreams,
            R.raw.banana,
            R.raw.solo_zycia,
            R.raw.sweet_dreams
    };

    private static final int CLASSIC[]={
            R.raw.throne_room_theme,
            R.raw.dance_of_the_knights,
            R.raw.the_maker,
            R.raw.throne_room_theme,
            R.raw.dance_of_the_knights,
            R.raw.the_maker,
            R.raw.throne_room_theme,
            R.raw.dance_of_the_knights,
            R.raw.the_maker,
    };

    private static final int ELECTRONIC[]={
            R.raw.aftergold,
            R.raw.crazy,
            R.raw.san_escobar,
            R.raw.turn_down_for_what,
            R.raw.body_gold,
            R.raw.aftergold,
            R.raw.crazy,
            R.raw.san_escobar,
            R.raw.turn_down_for_what,
            R.raw.body_gold
    };

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        uploadData();
        view = (View) inflater.inflate(R.layout.fragment_shop, container, false);
        Button b1 = (Button) view.findViewById(R.id.slawcio_songs);
        Button b2 = (Button) view.findViewById(R.id.electronic);
        Button b3 = (Button) view.findViewById(R.id.classic);
        Button b4 = (Button) view.findViewById(R.id.rock);
        TextView textView = (TextView) view.findViewById(R.id.tv_full_price);
        textView.setText(Cart.getFullPrice() + "$");

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), CartActivity.class);
                startActivity(intent);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MusicShop.class);
                Bundle bundle = new Bundle();
                bundle.putIntArray("images", SLAWCIO_IMAGES);
                bundle.putIntArray("music", SLAWCIO);
                intent.putExtras(bundle);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                        0, v.getWidth(), v.getHeight());
                startActivity(intent, options.toBundle());
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MusicShop.class);
                Bundle bundle = new Bundle();
                bundle.putIntArray("images", ELECTRONIC_IMAGES);
                bundle.putIntArray("music", ELECTRONIC);
                intent.putExtras(bundle);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                        0, v.getWidth(), v.getHeight());
                startActivity(intent, options.toBundle());
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MusicShop.class);
                Bundle bundle = new Bundle();
                bundle.putIntArray("images", CLASSIC_IMAGES);
                bundle.putIntArray("music", CLASSIC);
                intent.putExtras(bundle);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                        0, v.getWidth(), v.getHeight());
                startActivity(intent, options.toBundle());
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), MusicShop.class);
                Bundle bundle = new Bundle();
                bundle.putIntArray("images", ROCK_IMAGES);
                bundle.putIntArray("music", ROCK);
                intent.putExtras(bundle);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(v, 0,
                        0, v.getWidth(), v.getHeight());
                startActivity(intent, options.toBundle());
            }
        });
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        TextView textView = (TextView) view.findViewById(R.id.tv_full_price);
        textView.setText(Cart.getFullPrice() + "$");
    }
}

