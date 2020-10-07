package com.example.colorchangingapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        Bundle bundle = getIntent().getExtras();
        int colorValue;
        colorValue = bundle.getInt("Color");
        String colorName;
        colorName = bundle.getString("ColorName");


        View rl =  findViewById(R.id.canvasLayout);
        rl.setBackgroundColor(colorValue);

        TextView tv = findViewById(R.id.textView2);
        tv.setText(colorName);


    }

}
