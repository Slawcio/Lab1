package com.example.slawcio.lab1;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class Music extends android.support.v4.app.Fragment{

    private static final int IMAGES[]={
            R.drawable.jo2,
            R.drawable.big_wild,
            R.drawable.the_doors,
            R.drawable.star_wars,
            R.drawable.crazy,
            R.drawable.prokofiew,
            R.drawable.rchp,
            R.drawable.eric,
            R.drawable.escobar,
            R.drawable.jo3,
            R.drawable.jo_i_martyna,
            R.drawable.the_maker,
            R.drawable.dj_snake,
            R.drawable.luis

    };

    private static final int MUSIC[]={
      R.raw.banana,
            R.raw.aftergold,
            R.raw.riders_on_the_storm,
            R.raw.throne_room_theme,
            R.raw.crazy,
            R.raw.dance_of_the_knights,
            R.raw.funny_face,
            R.raw.layla,
            R.raw.san_escobar,
            R.raw.solo_zycia,
            R.raw.sweet_dreams,
            R.raw.the_maker,
            R.raw.turn_down_for_what,
            R.raw.body_gold
    };



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_music, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.gridview_2);
        gridView.setAdapter(new ImageAdapter(getContext(), IMAGES));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), MusicPlayer.class);
                intent.putExtra("position", position);
                Bundle b = new Bundle();
                b.putInt("images", IMAGES[position]);
                b.putInt("music", MUSIC[position]);
                intent.putExtras(b);
                ActivityOptions options = ActivityOptions.makeScaleUpAnimation(view, 0,
                        0, view.getWidth(), view.getHeight());
                startActivity(intent, options.toBundle());
            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        FragmentManager manager = ((Fragment) this).getFragmentManager();
        FragmentTransaction trans = manager.beginTransaction();
        trans.remove((Fragment) this);
        trans.commit();
    }


}
