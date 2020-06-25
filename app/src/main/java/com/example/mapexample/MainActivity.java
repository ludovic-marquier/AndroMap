package com.example.mapexample;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.CustomView.Map;
import com.example.data.MapState;
import com.example.eventHandler.OnMapLoadListener;

public class MainActivity extends AppCompatActivity {

    private Map map;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        map  =findViewById(R.id.map);

        map.setOnMapLoadListener(new OnMapLoadListener() {
            @Override
            public void onMapLoaded() {

            }
        });


        map.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){

                        case MotionEvent.ACTION_DOWN:
                            map.goTo(48.0, 2.0, 16);
                            break;
                }
                return false;
            }

        });

    }
}
