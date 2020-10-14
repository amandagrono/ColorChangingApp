package com.example.colorchangingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class PalleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallete);


        Resources res = this.getResources();
        final String[] colorArray = res.getStringArray(R.array.colorStrings);
        final int[] colorInts = {Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.LTGRAY, Color.MAGENTA, Color.parseColor("#289C8E"/*teal*/), Color.parseColor("#FFAE32"/*orange*/), Color.parseColor("#CCCCFF"/*periwinkle*/), Color.YELLOW, Color.parseColor("#93FF00")/*lime*/, Color.parseColor("#751A9C")/*purple*/ };

        ColorAdapter colorAdapter = new ColorAdapter(this, colorArray, colorInts);


        GridView gridView = findViewById(R.id.gridview);

        gridView.setAdapter(colorAdapter);
        gridView.setNumColumns(3);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), CanvasActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Color", colorInts[i]);
                bundle.putString("ColorName", colorArray[i]);
                intent.putExtras(bundle);
                startActivity(intent);
                System.out.println("Hello");
               // finish();


            }
        });

    }

}