package com.example.colorchangingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {

    private int[] colorsInt;
    private String[] colors;

    public PaletteFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static PaletteFragment newInstance(String[] colors, int[] colorsInt) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Colors", colors);
        bundle.putIntArray("ColorsInt", colorsInt);

        fragment.setArguments(bundle);

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View l = inflater.inflate(R.layout.fragment_palette, container, false);



        return l;
    }
}