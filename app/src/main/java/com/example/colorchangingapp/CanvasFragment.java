package com.example.colorchangingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CanvasFragment extends Fragment {



    public CanvasFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static CanvasFragment newInstance(String color, int colorInt ) {
        CanvasFragment fragment = new CanvasFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Color", color);
        bundle.putInt("ColorInt", colorInt);
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View l = inflater.inflate(R.layout.fragment_canvas, container, false);

        TextView tv = l.findViewById(R.id.textview13);
        String color = this.getArguments().getString("Color");
        int colorInt = this.getArguments().getInt("ColorInt");
        tv.setText(color);
        l.setBackgroundColor(colorInt);


        return l;
    }
}