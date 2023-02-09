package com.example.bscssectionabatch20.intentexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bscssectionabatch20.MainActivity;
import com.example.bscssectionabatch20.R;


public class intentexample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentexample1);
    }

    public void GoToMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }
}