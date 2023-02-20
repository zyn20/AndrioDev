package com.example.bscssectionabatch20.Listviewexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bscssectionabatch20.R;

public class ImgandTextExample extends AppCompatActivity {

    String Name [] = {"Ali","Zain","Laiba","Maryam","Nawaz"};
    String Text [] = {"Hello Ali","Ok Ahmed","Noted","Vote ko izzat do","Mujhy kyun nikala"};
    int Image[] = {R.drawable.fb,R.drawable.fb,R.drawable.fb,R.drawable.fb,R.drawable.fb};
     ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imgand_text_example);
        listView = findViewById(R.id.firstimageandtxt);
        ImageandTextAdapter adapter = new ImageandTextAdapter(this,Name,Text,Image);



    }
}