package com.example.bscssectionabatch20.Listviewexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bscssectionabatch20.R;

public class Listviewexample1 extends AppCompatActivity {

    String [] Studentlist = { "Ali","Umair","Ahmed","Jabbar","Toqeer","Mustafa","Kamal","Johnny","Ali","Umair","Ahmed","Jabbar","Toqeer","Mustafa","Kamal","Johnny","Ali","Umair","Ahmed","Jabbar","Toqeer","Mustafa","Kamal","Johnny" };
    ListView listView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listviewexample1);
        listView = findViewById(R.id.mylistviewexample1);


    }

    @Override
    protected void onStart() {
        super.onStart();
        ArrayAdapter adaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Studentlist);
        listView.setAdapter(adaptor);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Listviewexample1.this,position + " " + "Clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }
}