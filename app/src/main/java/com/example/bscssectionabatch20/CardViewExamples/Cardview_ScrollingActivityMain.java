package com.example.bscssectionabatch20.CardViewExamples;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bscssectionabatch20.R;
import com.example.bscssectionabatch20.databinding.ActivityCardviewScrollingMainBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class Cardview_ScrollingActivityMain extends AppCompatActivity {

    public ArrayList<My_Model> my_modelList;
    public MyCardViewAdapter adapter;
    public RecyclerView recyclerView;


    private ActivityCardviewScrollingMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityCardviewScrollingMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        recyclerView = findViewById(R.id.my_recyclerview2);
        my_modelList= new ArrayList<>();
        adapter = new MyCardViewAdapter(this,my_modelList);
        RecyclerView.LayoutManager layoutManager =  new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        InsertData();



    }
    public void InsertData()
    {
        int [] mydrawables = new int[]
                {
                  R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five
                };
        My_Model my_model = new My_Model("My First cardView",40,mydrawables[0]);
        my_modelList.add(my_model);
        my_model = new My_Model("My Second CardView",45,mydrawables[1]);
        my_modelList.add(my_model);
        my_model = new My_Model("My third CardView",45,mydrawables[2]);
        my_modelList.add(my_model);
        my_model = new My_Model("My fourth CardView",45,mydrawables[3]);
        my_modelList.add(my_model);
        my_model = new My_Model("My fifth CardView",45,mydrawables[4]);
        my_modelList.add(my_model);
     adapter.notifyDataSetChanged();


    }

}