package com.example.bscssectionabatch20.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bscssectionabatch20.R;

import java.util.HashMap;

public class EditContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contact);
        Intent intent = getIntent();
        String id = intent.getExtras().getString("id");
        DbQueries dbQueries = new DbQueries(getApplicationContext());
        dbQueries.getSingleContact(id);
        HashMap<String,String> singleContact =  dbQueries.getSingleContact(id);

    }
}