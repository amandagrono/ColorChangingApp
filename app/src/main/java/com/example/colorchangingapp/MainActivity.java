package com.example.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity implements PaletteFragment.clickedAButton {

    PaletteFragment pf;
    CanvasFragment cf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Resources res = this.getResources();
        final String[] colorArray = res.getStringArray(R.array.colorStrings);
        final int[] colorInts = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.LTGRAY, Color.MAGENTA, Color.parseColor("#289C8E"/*teal*/), Color.parseColor("#FFAE32"/*orange*/), Color.parseColor("#CCCCFF"/*periwinkle*/), Color.YELLOW, Color.parseColor("#93FF00")/*lime*/, Color.parseColor("#751A9C")/*purple*/ };

        pf = PaletteFragment.newInstance(colorArray, colorInts);
        FrameLayout fl = findViewById(R.id.container_1);

        getSupportFragmentManager().beginTransaction().add(R.id.container_1, pf).addToBackStack(null).commit();


    }



    @Override
    public void colorPicked(String colorPicked, int colorInt) {
        cf = CanvasFragment.newInstance(colorPicked, colorInt);
        getSupportFragmentManager().beginTransaction().add(R.id.container_2, cf).addToBackStack(null).commit();
    }
}