package com.example.bscssectionabatch20.PermissionsExamples;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.Manifest.permission.CAMERA;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.graphics.Camera;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bscssectionabatch20.R;

public class PermissionExample1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permission_example1);
    }

    public void RequestForPermission(View view) {

        ActivityCompat.requestPermissions(this,new String[]{ACCESS_FINE_LOCATION,CAMERA},101);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode ==101 &&grantResults[0] == PackageManager.PERMISSION_GRANTED)
        {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean CheckPermission() {
        int result_P1 = ContextCompat.checkSelfPermission(this,ACCESS_FINE_LOCATION);
        int result_P2 = ContextCompat.checkSelfPermission(this, CAMERA);
        return result_P1 == PackageManager.PERMISSION_GRANTED &&
                result_P2 == PackageManager.PERMISSION_GRANTED;


    }
    public void Check_For_Permission(View view)
    {
        if(CheckPermission())
        {
            Toast.makeText(this, "Permission Already Granted", Toast.LENGTH_SHORT).show();

        }
        else Toast.makeText(this, "Request For Permission", Toast.LENGTH_SHORT).show();

    }

}