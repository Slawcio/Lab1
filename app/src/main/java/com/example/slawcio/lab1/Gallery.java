package com.example.slawcio.lab1;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import static com.example.slawcio.lab1.R.id.toolbar;


public class Gallery extends android.support.v4.app.Fragment {

    private static final int[] IMAGES = {
            R.drawable.t1,
            R.drawable.t2,
            R.drawable.t3,
            R.drawable.t4,
            R.drawable.t5,
            R.drawable.t6,
            R.drawable.t7,
            R.drawable.t8,
            R.drawable.t9,
            R.drawable.t10,
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(getContext(), IMAGES));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(), ImageViewSwipe.class);
                intent.putExtra("position", position);
                Bundle b = new Bundle();
                b.putIntArray("images", IMAGES);
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
