package com.example.bscssectionabatch20.SensorExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bscssectionabatch20.R;

public class SensorExample2MainActivity extends AppCompatActivity implements SensorEventListener {
View view;
SensorManager sensorManager;
boolean color = false;
long lastTimeStamp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_example2_main);
        view=findViewById(R.id.txtsensorvalue);
        lastTimeStamp = System.currentTimeMillis();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER)
        {
            getAccelerometerValues(event);

        }
    }

    private void getAccelerometerValues(SensorEvent event) {
        float[] values = event.values;
        float x=values[0];
        float y=values[1];
        float z= values[2];
        float Acceleration = (x*x + y*y +z*z)/
                (SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
        long actualTime=event.timestamp;
        if(Acceleration>=3)
        {
            if (actualTime -lastTimeStamp < 150)
            {
                return;
            }
            else
            {
                lastTimeStamp = actualTime;
                Toast.makeText(this, "Device was Moved", Toast.LENGTH_SHORT).show();
                if(color)
                {
                    view.setBackgroundColor(Color.RED);
                    color=false;

                }
                else
                {
                    view.setBackgroundColor(Color.GREEN);
                    color=true;
                }



            }
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}