package com.example.colorchangingapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {

    clickedAButton mainActivity;

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
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof clickedAButton){
            mainActivity = (clickedAButton) context;

        }
        else{
            throw new ClassCastException(context.toString() + "must implement clickedAButton");
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View l = inflater.inflate(R.layout.fragment_palette, container, false);

        GridView gv = l.findViewById(R.id.gridview);
        gv.setNumColumns(3);
        gv.setAdapter(new ColorAdapter(this.getContext(), this.getArguments().getStringArray("Colors"), this.getArguments().getIntArray("ColorsInt")));

        final String[] colors = this.getArguments().getStringArray("Colors");
        final int[] colorsInt = this.getArguments().getIntArray("ColorsInt");

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mainActivity.colorPicked(colors[position], colorsInt[position]);
            }
        });


        return l;
    }

    public interface clickedAButton{

        void colorPicked(String colorPicked, int colorInt);

    }
}