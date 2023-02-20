package com.example.bscssectionabatch20.Tasktwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.bscssectionabatch20.R;

import java.util.ArrayList;
import java.util.List;

public class studentactivitytwo extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentactivitytwo);
        sharedPreferences=getSharedPreferences("studentinfo",0);
        listView=findViewById(R.id.tasktwolistview);
    }


    protected void onStart() {
        super.onStart();
        List list=new ArrayList<>();
        String naam=sharedPreferences.getString("Name",null);
        String cn=sharedPreferences.getString("Cnic",null);
        String ph=sharedPreferences.getString("Phone",null);
        String sgp=sharedPreferences.getString("Sgpa",null);
        String cgp=sharedPreferences.getString("Cgpa",null);
        list.add(naam);
        list.add(cn);
        list.add(ph);
        list.add(sgp);
        list.add(cgp);
        ArrayAdapter<String> array=new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,list);
        listView.setAdapter(array);
    }

}