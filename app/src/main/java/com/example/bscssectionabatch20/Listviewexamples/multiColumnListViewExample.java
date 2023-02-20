package com.example.bscssectionabatch20.Listviewexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.bscssectionabatch20.R;

import java.util.ArrayList;
import java.util.HashMap;

public class multiColumnListViewExample extends AppCompatActivity {
    public ArrayList<HashMap<String,String>> list;
    public static final String First_coloumn = "First";
    public static final String Second_coloumn = "Second";
    public static final String Third_coloumn = "Third";
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_column_list_view_example);
        listview = findViewById(R.id.lstmulticolumnexample);
        list = new ArrayList<HashMap<String,String>>();
        LoadData();
        MultiColumnListViewAdapter adapter =
                new MultiColumnListViewAdapter(list,this);
        listview.setAdapter(adapter);



    }
    public void LoadData()
    {
        //control + alt + m
        HashMap<String,String> hashMap1 = new HashMap<String,String>();
        hashMap1.put(First_coloumn,"Zain");
        hashMap1.put(Second_coloumn,"John");
        hashMap1.put(Third_coloumn,"Saqi");
        list.add(hashMap1);
        HashMap<String,String> hashMap2 = new HashMap<String,String>();
        hashMap2.put(First_coloumn,"Yown");
        hashMap2.put(Second_coloumn,"Born");
        hashMap2.put(Third_coloumn,"Fore");
        list.add(hashMap2);
        HashMap<String,String> hashMap3 = new HashMap<String,String>();
        hashMap3.put(First_coloumn,"Haze");
        hashMap3.put(Second_coloumn,"Laze");
        hashMap3.put(Third_coloumn,"Zaze");
        list.add(hashMap3);

    }




}
