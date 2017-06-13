package com.example.slawcio.lab1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.media.Image;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

/**
 * Created by Slawcio on 2017-06-09.
 */

public class VideoAdapter extends BaseAdapter{
    private Context mContext;
    private String videos[];
    private int images[];
    LayoutInflater inflater;


    public VideoAdapter(Context c, String videos[], int images[]){
        mContext = c;
        this.images = images;
        this.videos = videos;
        inflater = (LayoutInflater)mContext.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    public VideoAdapter(Context c, String videos[]){
        mContext = c;
        this.videos = videos;
        inflater = (LayoutInflater)mContext.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }



    public int getCount() {
        return videos.length;
    }

    public Object getItem(int position) {
        return videos[position];
    }

    public long getItemId(int position) {
        return position;
    }


    // create a new ImageViewSwipe for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView == null ? LayoutInflater.from(mContext).inflate(R.layout.grid_view_video_item, parent, false) : convertView;

        ImageView img = (ImageView) view.findViewById(R.id.image_item);
        VideoView videoView = (VideoView) view.findViewById(R.id.video_item);
        videoView.setVideoURI(Uri.parse(videos[position]));
     //   videoView.setLayoutParams(new GridView.LayoutParams(new Double(getWidthOfScreen()).intValue(), new Double(getWidthOfScreen() * 0.75).intValue()));
        Picasso.with(mContext).load(images[position])
                .resize(new Double(getWidthOfScreen()).intValue(), new Double(getWidthOfScreen() * 0.75).intValue())
                .centerCrop()
                .into(img);

        videoView.setFocusable(false);

        return view;
    }

    double getWidthOfScreen(){
        WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        return size.x/2;
    }
}
