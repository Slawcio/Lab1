package com.example.slawcio.lab1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Slawcio on 2017-06-27.
 */

public class ShopAdapter extends BaseAdapter {

    ArrayList<CartActivity.Product> list;
    Context mContext;
    TextView priceFull;

    ShopAdapter(ArrayList<CartActivity.Product> list, Context mContext, TextView price){
        this.list = list;
        this.mContext = mContext;
        this.priceFull = price;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView == null ? LayoutInflater.from(mContext).inflate(R.layout.shop_cart_item, parent, false) : convertView;
        TextView title = (TextView) view.findViewById(R.id.tV_title);
        final TextView amount = (TextView) view.findViewById(R.id.tV_amount);
        final TextView price = (TextView) view.findViewById(R.id.tV_price);
        ImageView image = (ImageView) view.findViewById(R.id.imageView);

        title.setText(list.get(position).getTitle());
        amount.setText("amount: " + String.valueOf(list.get(position).getAmout()));
        price.setText("price: " + String.valueOf(list.get(position).getPrice()) + "$");
        image.setImageResource(list.get(position).getImage());
        image.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                list.get(position).setAmount(1);
                list.get(position).setFalse();
                list.remove(position);
                notifyDataSetChanged();
                Cart.setFullPrice();
                priceFull.setText("Full price: " + Cart.getFullPrice() + "$");
                return true;
            }
        });
        Button plus = (Button) view.findViewById(R.id.buttonPlus);
                plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setPlus();
                amount.setText("amount: " + String.valueOf(list.get(position).getAmout()));
                price.setText("price: " + String.valueOf(list.get(position).getPrice()) + "$");
                Cart.setFullPrice();
                priceFull.setText("Full price: " + Cart.getFullPrice() + "$");
            }
        });
        Button minus = (Button) view.findViewById(R.id.buttonMinus);
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.get(position).setMinus();
                amount.setText("amount: " + String.valueOf(list.get(position).getAmout()));
                price.setText("price: " + String.valueOf(list.get(position).getPrice()) + "$");
                Cart.setFullPrice();
                priceFull.setText("Full price: " + Cart.getFullPrice() + "$");
            }
        });
        return view;
    }
}
