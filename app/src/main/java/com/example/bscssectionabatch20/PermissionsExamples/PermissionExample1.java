package com.example.bscssectionabatch20.PermissionsExamples;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;

import com.example.bscssectionabatch20.R;

public class PermissionExample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_example1);
    }

    public void RequestForPermission(View view) {

    }

    public boolean CheckPermission(View view) {
        int result_P1 = ContextCompat.checkSelfPermission(this,ACCESS_FINE_LOCATION);
        int result_P2 = ContextCompat.checkSelfPermission(this, CAMERA);
        return result_P1 == PackageManager.PERMISSION_GRANTED &&
                result_P2 == PackageManager.PERMISSION_GRANTED;


    }
}