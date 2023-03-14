package com.example.bscssectionabatch20.serviceExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bscssectionabatch20.R;

public class serviceExample1MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_example1_main);
    }

    public void StartService(View view) {
        Intent intent = new
                Intent(this , myserviceExampleOne.class);
        startService(intent);

    }

    public void StopService(View view) {
        Intent intent = new Intent(this,myserviceExampleOne.class);
        stopService(intent);
    }
}