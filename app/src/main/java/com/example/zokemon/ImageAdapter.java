package com.example.zokemon;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {

    Context context;

    public int[] pokemon_sprite_array = {

        R.drawable.p1, R.drawable.p2, R.drawable.p3, R.drawable.p4, R.drawable.p5,
            R.drawable.p6, R.drawable.p7, R.drawable.p8, R.drawable.p9,  R.drawable.p10 ,
            R.drawable.p11, R.drawable.p12, R.drawable.p13, R.drawable.p14, R.drawable.p15,
            R.drawable.p16, R.drawable.p17, R.drawable.p18, R.drawable.p19,  R.drawable.p20 ,
            R.drawable.p21, R.drawable.p22, R.drawable.p23, R.drawable.p24, R.drawable.p25,
            R.drawable.p26, R.drawable.p27, R.drawable.p28, R.drawable.p29,  R.drawable.p30
    };

    public ImageAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return pokemon_sprite_array.length;
    }

    @Override
    public Object getItem(int position) {
        return pokemon_sprite_array[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ImageView imageView = new ImageView(context);
        imageView.setImageResource(pokemon_sprite_array[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(340,350));

        return imageView;
    }
}
