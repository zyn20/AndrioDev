package com.example.bscssectionabatch20.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.bscssectionabatch20.R;

public class ContactList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        DbQueries dbQueries = new DbQueries(getApplicationContext());
    }
    public void OpenNewContactActivity(View view) {
        Intent intent = new Intent(this,NewContactActivity.class);
        startActivity(intent);
    }
}