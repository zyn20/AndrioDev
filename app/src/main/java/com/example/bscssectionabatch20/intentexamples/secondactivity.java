package com.example.bscssectionabatch20.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bscssectionabatch20.R;

public class secondactivity extends AppCompatActivity {

    TextView textview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);
        textview = findViewById(R.id.txtintentsecondactivity);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent  intent = getIntent();
        String v1 = intent.getStringExtra("A1");
        String v2 = intent.getStringExtra("A2");
        textview.setText(v1 + " " + v2);


    }
}