package com.example.bscssectionabatch20.RecyclerViewExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bscssectionabatch20.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<MyMobile> MyMobileList = new ArrayList<>();
    MyMobileAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler_view_main);

        recyclerView = findViewById(R.id.my_recylcer_view);
        adapter = new MyMobileAdapter(MyMobileList);
        RecyclerView.LayoutManager layoutManager =  new
                LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        insert();

    }
    public void insert()
    {
        MyMobile obj1=new MyMobile("A52s","Samsung","67900");
        MyMobileList.add(obj1);
        MyMobile obj2=new MyMobile("A96","Oppo","58000");
        MyMobileList.add(obj2);
        MyMobile obj3=new MyMobile("X3","Xiomi","44000");
        MyMobileList.add(obj3);

        MyMobile obj4=new MyMobile("R 6","Realme","6790");
        MyMobileList.add(obj4);
        MyMobile obj5=new MyMobile("I 11","Apple","580000");
        MyMobileList.add(obj5);
        MyMobile obj6=new MyMobile("3310","Nokia","4400");
        MyMobileList.add(obj6);
        adapter.notifyDataSetChanged();

    }
}