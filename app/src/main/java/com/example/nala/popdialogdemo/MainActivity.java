package com.example.nala.popdialogdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 new MyDialog(MainActivity.this).show();
             }
         });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MyBottomDialog(MainActivity.this).show();
            }
        });

    }
}
