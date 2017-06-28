package com.example.slawcio.lab1;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Slawcio on 2017-06-19.
 */

public class Cart {
    private static final ArrayList<MusicData> list = new ArrayList<MusicData>();
    private static final ArrayList<Integer> list2 = new ArrayList<Integer>();
    private static final ArrayList<CartActivity.Product> list3 = new ArrayList<CartActivity.Product>();
    private static int fullPrice = 0;
    public static ArrayList getInstance() {
        return list3;
    }

    public static int getFullPrice(){
        return fullPrice;
    }

    public static void setFullPriceZero(){
        fullPrice = 0;
    }

    public static void setFullPrice(){
        fullPrice = 0;
        for(CartActivity.Product product : list3){
            if(product.isChosen())
            fullPrice = fullPrice + product.getPrice();
        }
    }

    public static boolean ifChecked(int id){
        for(CartActivity.Product product : list3)
        {
            if(product.getImage()==id && product.isChosen())
                return true;
        }
        return false;
    }

    public static void reloadData(){
        list3.clear();
        list3.add(new CartActivity.Product(R.drawable.jo2, "Woda Ski Bla - Banana", 15));
        list3.add(new CartActivity.Product(R.drawable.big_wild, "Big Wild - Aftergold", 17));
        list3.add(new CartActivity.Product(R.drawable.the_doors, "The Doors - Riders on the storm", 20));
        list3.add(new CartActivity.Product(R.drawable.star_wars, "John Williams - Throne Room Theme", 15));
        list3.add(new CartActivity.Product(R.drawable.crazy, "Gnarls Barkley - Crazy", 12));
        list3.add(new CartActivity.Product(R.drawable.prokofiew, "Sergiej Prokofiew - Dance of the knights", 12));
        list3.add(new CartActivity.Product(R.drawable.rchp, "Red Hot Chili Peppers - Funny Face", 10));
        list3.add(new CartActivity.Product(R.drawable.eric, "Eric Clapton - Layla", 9));
        list3.add(new CartActivity.Product(R.drawable.escobar, "PAFF - San Escobar", 22));
        list3.add(new CartActivity.Product(R.drawable.jo3, "Sławcio - Solo Życia 2014", 43));
        list3.add(new CartActivity.Product(R.drawable.jo_i_martyna, "Sławcio i Martyna - Sweet Dreams", 11));
        list3.add(new CartActivity.Product(R.drawable.the_maker, "The Maker Soundtrack", 23));
        list3.add(new CartActivity.Product(R.drawable.dj_snake, "DJ Snake - Turn Down For What", 43));
        list3.add(new CartActivity.Product(R.drawable.luis, "Luis The Child - Body Gold", 12));
    }

    public static void uploadData(){
        if(list3.isEmpty()){
        list3.add(new CartActivity.Product(R.drawable.jo2, "Woda Ski Bla - Banana", 15));
        list3.add(new CartActivity.Product(R.drawable.big_wild, "Big Wild - Aftergold", 17));
        list3.add(new CartActivity.Product(R.drawable.the_doors, "The Doors - Riders on the storm", 20));
        list3.add(new CartActivity.Product(R.drawable.star_wars, "John Williams - Throne Room Theme", 15));
        list3.add(new CartActivity.Product(R.drawable.crazy, "Gnarls Barkley - Crazy", 12));
        list3.add(new CartActivity.Product(R.drawable.prokofiew, "Sergiej Prokofiew - Dance of the knights", 12));
        list3.add(new CartActivity.Product(R.drawable.rchp, "Red Hot Chili Peppers - Funny Face", 10));
        list3.add(new CartActivity.Product(R.drawable.eric, "Eric Clapton - Layla", 9));
        list3.add(new CartActivity.Product(R.drawable.escobar, "PAFF - San Escobar", 22));
        list3.add(new CartActivity.Product(R.drawable.jo3, "Sławcio - Solo Życia 2014", 43));
        list3.add(new CartActivity.Product(R.drawable.jo_i_martyna, "Sławcio i Martyna - Sweet Dreams", 11));
        list3.add(new CartActivity.Product(R.drawable.the_maker, "The Maker Soundtrack", 23));
        list3.add(new CartActivity.Product(R.drawable.dj_snake, "DJ Snake - Turn Down For What", 43));
        list3.add(new CartActivity.Product(R.drawable.luis, "Luis The Child - Body Gold", 12));
        }
    }


    public void addData(int image, int music){
        list.add(new MusicData(image, music));
    }


    public class MusicData{
        private int image;
        private int music;
        public MusicData(int image, int music){
            this.music = music;
            this.image = image;
        }

        public int getImage() {
            return image;
        }

        public int getMusic() {
            return music;
        }
    }
}
