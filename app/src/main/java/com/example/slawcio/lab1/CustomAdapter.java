package com.example.slawcio.lab1;

import android.content.Context;
import android.graphics.Point;
import android.provider.ContactsContract;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Slawcio on 2017-05-30.
 */

public class CustomAdapter extends PagerAdapter{

    private Context context;
    private LayoutInflater inflater;
    private int images[];

    public CustomAdapter(Context context, int images[]){
        this.context = context;
        this.images = images;
    }

    @Override
    public int getCount() {
        return 10;
    }

    public boolean isViewFromObject(View view, Object object){
        return view == object;
    }

    private int getSizeOfDisplay(){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return  size.x;
    }

    public Object instantiateItem(ViewGroup container, int position){
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.swipe, container, false);
        ImageView img = (ImageView) v.findViewById(R.id.img);
  //      if(isFirst)   {    Picasso.with(context).load(images[positionStart]).into(img);
   //     isFirst = false;}
   //         else

        Picasso.with(context).load(images[position]).into(img);
        container.addView(v);
        return v;
//        ImageViewSwipe imageView = new ImageViewSwipe(context);
//        Picasso.with(context).load(images[position]).into(imageView);
//        ((ViewPager) container).addView(imageView,0);
//        return  imageView;
    }

    public void destroyItem(ViewGroup container, int position, Object object){
        ((ViewPager) container).removeView((View) object);
    }
}
