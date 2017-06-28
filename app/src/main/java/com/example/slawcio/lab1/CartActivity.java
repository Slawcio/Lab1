package com.example.slawcio.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Integer> listImages;
    private static ArrayList<Product> listProduct = new ArrayList<Product>();
    ShopAdapter adapter;
    TextView price;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        listImages = Cart.getInstance();
        assignImages();
        listView = (ListView) findViewById(R.id.list_cart);
        price = (TextView) findViewById(R.id.tv_full_price);
        setPrice();
        adapter = new ShopAdapter(listProduct, getBaseContext(), price);
        listView.setAdapter(adapter);
        setPrice();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                setPrice();
           }
       });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                return true;
            }
        });
        Button buyButton = (Button) findViewById(R.id.button_buy);
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Product> list = Cart.getInstance();
                Toast.makeText(getApplicationContext(), "You just bought cool music for: " + String.valueOf(Cart.getFullPrice()) + "$", Toast.LENGTH_LONG).show();
                for(Product product : list){
                    product.setAmount(1);
                    product.setFalse();
                }
                Cart.reloadData();
                Cart.setFullPriceZero();
                listProduct.clear();
                setPrice();
                adapter.notifyDataSetChanged();


            }
        });
    }

    private void assignImages(){
        ArrayList<Product> list = Cart.getInstance();
        listProduct.clear();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isChosen()){
                listProduct.add(list.get(i));
            }
        }
    }

    public void setPrice(){
        price.setText("Full price: " + Cart.getFullPrice()+"$");
    }
    static class Product{
        private int image;
        private String title;
        private final int PRICE;
        private int amount = 1;
        private boolean isChosen = false;
        Product(int image, String title, int price){
            this.image = image;
            this.title = title;
            this.PRICE = price;
        }

        int getImage(){
            return image;
        }

        void setAmount(int amount){
            this.amount = amount;
        }
        void changeIsChosen(){
            if(isChosen)
                isChosen = false;
            else
                isChosen = true;
        }

        boolean isChosen(){
            return isChosen;
        }

        int getAmout(){
            return amount;
        }

        void setFalse(){
            isChosen = false;
        }


        int getPrice(){
            return PRICE * amount;
        }

        void setPlus(){
            amount++;
        }

        void setMinus(){
            if(amount>1){
                amount--;
            }
        }

        String getTitle(){
            return title;
        }

    }

}
