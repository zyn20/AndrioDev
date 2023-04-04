package com.example.bscssectionabatch20.SensorExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.example.bscssectionabatch20.R;

public class SensorExampleOneMainActivity extends AppCompatActivity {
TextView textview;
SensorManager sensorManager;
Sensor sensor;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_example_one_main);
        textview = findViewById(R.id.txtsense);
        sensorManager =(SensorManager) getSystemService(this.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        if(sensor == null)
        {
            textview.setText("No sensor found");
        }
        else {
sensorManager.registerListener(proximitySensorEventListener,sensor,SensorManager.SENSOR_DELAY_UI);

        }


    }
    SensorEventListener proximitySensorEventListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if(event.sensor.getType() == Sensor.TYPE_PROXIMITY)
            {
                if(event.values[0]==0)
                textview.setText("Object is Near");
                else
                    textview.setText("Object is away");

            }



        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };
}