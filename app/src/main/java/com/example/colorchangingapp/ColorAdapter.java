package com.example.colorchangingapp;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {


    Context context;
    String[] colorArray;
    int[] colorInts;

    public ColorAdapter(Context context, String[] colorArray, int[] colorInts){
        this.context = context;
        this.colorArray = colorArray;
        this.colorInts = colorInts;
    }

    @Override
    public int getCount() {
        return colorArray.length;
    }

    @Override
    public String getItem(int i) {
        return colorArray[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(context);
        textView.setText(getItem(i));
        textView.setBackgroundColor(colorInts[i]);
        textView.setTextSize(24);
        textView.setTextColor(Color.BLACK);
        return textView;
    }
}
