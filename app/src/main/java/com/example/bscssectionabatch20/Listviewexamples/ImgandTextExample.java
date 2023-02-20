package com.example.bscssectionabatch20.Listviewexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bscssectionabatch20.R;

public class ImgandTextExample extends AppCompatActivity {

    String Name [] = {"Ali","Zain","Laiba","Maryam","Nawaz"};
    String Text [] = {"Hello Ali","Ok Ahmed","Noted","Vote ko izzat do","Mujhy kyun nikala"};
    Integer Image[] = {R.drawable.fb,R.drawable.fb,R.drawable.fb,R.drawable.fb,R.drawable.fb};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgand_text_example);

    }
}