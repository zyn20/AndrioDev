package com.example.bscssectionabatch20.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.bscssectionabatch20.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ContactList extends AppCompatActivity {
    DbQueries dbQueries;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        DbQueries dbQueries = new DbQueries(getApplicationContext());
        listView = findViewById(R.id.listdb);
        ArrayList<HashMap<String,String>> contactList = dbQueries.getAllContacts();
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                contactList,
                R.layout.newlayoutmain,
                new String[]{"_id", "firstName", "lastName", "phoneNumber","emailAddress","homeAddress"},
                new int[]{R.id.txtid, R.id.txtfirstname, R.id.txtlastname, R.id.txtphone,R.id.txtemail,R.id.txthome}
        );

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ContactList.this,EditContactActivity.class);
                intent.putExtra("id",String.valueOf(position+1));
                startActivity(intent);
            }
        });
    }
    public void OpenNewContactActivity(View view) {
        Intent intent = new Intent(this,NewContactActivity.class);
        startActivity(intent);
    }
}