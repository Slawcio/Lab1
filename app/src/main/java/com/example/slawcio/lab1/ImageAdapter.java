package com.example.slawcio.lab1;

import android.content.Context;
import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Slawcio on 2017-05-29.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private int images[];

    public ImageAdapter(Context c, int images[]){
        mContext = c;
        this.images = images;
    }

    public int getCount() {
        return images.length;
    }

    public Object getItem(int position) {
        return images[position];
    }

    public long getItemId(int position) {
        return images[position];
    }


    // create a new ImageViewSwipe for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        double x = size.x/2;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
        } else {
            imageView = (ImageView) convertView;
        }
        Picasso.with(mContext)
                .load(images[position])
                .resize(new Double(x).intValue(), new Double(x*0.75).intValue())
                .into(imageView);
        return imageView;
    }

}