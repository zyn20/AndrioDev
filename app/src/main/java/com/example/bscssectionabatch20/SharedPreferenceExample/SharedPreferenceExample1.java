package com.example.bscssectionabatch20.SharedPreferenceExample;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bscssectionabatch20.R;

import java.util.ArrayList;

public class SharedPreferenceExample1 extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    //TextView textView;
    ListView listview;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preference_example1);
        sharedPreferences = getSharedPreferences("MyFile",0);
        listview = findViewById(R.id.mylistviewsharedpref);
        //textView = findViewById(R.id.txtsharedprefexample1);


    }

    public void Show_My_Preference(View view) {
        int a = sharedPreferences.getInt("A",0);
        String b= sharedPreferences.getString("B",null);
        //textView.setText(String.valueOf(a) + " " + b);








    }
    public void Save_My_Preference(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("A",100);
        editor.putString("B","Zain");
        editor.putString("C","Jordan");
        editor.putString("D","Umair");
        editor.putString("E","Muhammad");
        editor.commit();
        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();





    }

    @Override
    protected void onStart() {
        super.onStart();
       /* if(sharedPreferences.contains("A") && sharedPreferences.contains("B"))
        {

        }
        else
        {
            Toast.makeText(this, "No Value Found !", Toast.LENGTH_SHORT).show();
        }
        */
        int a = sharedPreferences.getInt("A",0);
        String b = sharedPreferences.getString("B",null);
        String c = sharedPreferences.getString("C",null);
        String d = sharedPreferences.getString("D",null);
        ArrayList <String> mylist = new ArrayList<>();
        mylist.add(String.valueOf(a));
        mylist.add(b);
        mylist.add(c);
        mylist.add(d);
        ArrayAdapter <String> myadaptor =  new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,mylist);
        listview.setAdapter(myadaptor);


    }
}