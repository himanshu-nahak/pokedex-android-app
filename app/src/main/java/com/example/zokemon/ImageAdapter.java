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
            R.drawable.p26, R.drawable.p27, R.drawable.p28, R.drawable.p29,  R.drawable.p30,
            R.drawable.p31, R.drawable.p32, R.drawable.p33, R.drawable.p34, R.drawable.p35,
            R.drawable.p36, R.drawable.p37, R.drawable.p38, R.drawable.p39, R.drawable.p40,
            R.drawable.p41, R.drawable.p42, R.drawable.p43, R.drawable.p44, R.drawable.p45,
            R.drawable.p46, R.drawable.p47, R.drawable.p48, R.drawable.p49, R.drawable.p50,
            R.drawable.p51, R.drawable.p52, R.drawable.p53, R.drawable.p54, R.drawable.p55,
            R.drawable.p56, R.drawable.p57, R.drawable.p58, R.drawable.p59, R.drawable.p60,
            R.drawable.p61, R.drawable.p62, R.drawable.p63, R.drawable.p64, R.drawable.p65,
            R.drawable.p66, R.drawable.p67, R.drawable.p68, R.drawable.p69, R.drawable.p70,
            R.drawable.p71, R.drawable.p72, R.drawable.p73, R.drawable.p74, R.drawable.p75,
            R.drawable.p76, R.drawable.p77, R.drawable.p78, R.drawable.p79, R.drawable.p80,
            R.drawable.p81, R.drawable.p82, R.drawable.p83, R.drawable.p84, R.drawable.p85,
            R.drawable.p86, R.drawable.p87, R.drawable.p88, R.drawable.p89, R.drawable.p90,
            R.drawable.p91, R.drawable.p92, R.drawable.p93, R.drawable.p94, R.drawable.p95,
            R.drawable.p96, R.drawable.p97, R.drawable.p98, R.drawable.p99, R.drawable.p100,
            R.drawable.p101, R.drawable.p102, R.drawable.p103, R.drawable.p104, R.drawable.p105,
            R.drawable.p106, R.drawable.p107, R.drawable.p108, R.drawable.p109, R.drawable.p110,
            R.drawable.p111, R.drawable.p112, R.drawable.p113, R.drawable.p114, R.drawable.p115,
            R.drawable.p116, R.drawable.p117, R.drawable.p118, R.drawable.p119, R.drawable.p120,
            R.drawable.p121, R.drawable.p122, R.drawable.p123, R.drawable.p124, R.drawable.p125,
            R.drawable.p126, R.drawable.p127, R.drawable.p128, R.drawable.p129, R.drawable.p130,
            R.drawable.p131, R.drawable.p132, R.drawable.p133, R.drawable.p134, R.drawable.p135,
            R.drawable.p136, R.drawable.p137, R.drawable.p138, R.drawable.p139, R.drawable.p140,
            R.drawable.p141, R.drawable.p142, R.drawable.p143, R.drawable.p144, R.drawable.p145,
            R.drawable.p146, R.drawable.p147, R.drawable.p148, R.drawable.p149, R.drawable.p150
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
