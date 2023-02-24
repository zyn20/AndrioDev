package com.example.bscssectionabatch20.PermissionsExamples;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

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

    public void CheckPermission(View view) {
        int result_P1 = ContextCompat.checkSelfPermission(this,ACCESS_FINE_LOCATION);
        

    }
}