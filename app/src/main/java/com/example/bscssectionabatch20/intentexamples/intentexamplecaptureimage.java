package com.example.bscssectionabatch20.intentexamples;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.example.bscssectionabatch20.R;

public class intentexamplecaptureimage extends AppCompatActivity {
ImageView imageview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentexamplecaptureimage);
        imageview = findViewById(R.id.imgintentcaptureimg);
    }

    public void send(View view)
    {
        Intent intent = new Intent(this,secondactivity.class);
        intent.putExtra("A1","FAST");
        intent.putExtra("A2","NATIONAL");
        startActivity(intent);
    }

    public void openCamera(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,103);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==103 && resultCode==RESULT_OK)
        {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageview.setImageBitmap(bitmap);
        }
    }
}