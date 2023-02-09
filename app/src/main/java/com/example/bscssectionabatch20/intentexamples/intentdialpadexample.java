package com.example.bscssectionabatch20.intentexamples;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.bscssectionabatch20.R;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class intentdialpadexample extends AppCompatActivity {

    ImageView imageView;
    Bitmap bitmap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intentdialpadexample2);
        imageView = findViewById(R.id.intentimggallery);

    }

    public void Opendialpad(View view) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:+123456789"));
        startActivity(intent);

    }

    public void opengoogle(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.google.com"));
        startActivity(intent);
    }

    public void opengallery(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, 101);




    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode==101 & resultCode==RESULT_OK)
        {

            try {
                InputStream inputStream = getContentResolver().openInputStream(intent.getData());
                if(bitmap !=null)
                {
                    bitmap.recycle();
                }
                bitmap = BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);

            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
}