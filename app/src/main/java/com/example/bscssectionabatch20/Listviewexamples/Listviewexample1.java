package com.example.bscssectionabatch20.Listviewexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bscssectionabatch20.R;

public class Listviewexample1 extends AppCompatActivity {

    String [] Studentlist = { "Ali","Umair","Ahmed","Jabbar","Toqeer","Mustafa" };
    Integer[] MobileList = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five,R.drawable.one};

    ListView listView;
    ImageView imageview;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewexample1);
        listView = findViewById(R.id.mylistviewexample1);
        imageview =findViewById(R.id.lstex1);



    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Studentlist);
        listView.setAdapter(adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               // Toast.makeText(Listviewexample1.this,position + " " + "Clicked",Toast.LENGTH_SHORT).show();
            if(position>=0 && position<=5)
            {
                imageview.setImageResource(MobileList[position]);

            }
            }
        });

    }
}