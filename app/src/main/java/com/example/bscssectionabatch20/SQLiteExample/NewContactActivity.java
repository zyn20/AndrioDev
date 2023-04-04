package com.example.bscssectionabatch20.SQLiteExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bscssectionabatch20.R;

import java.util.HashMap;

public class NewContactActivity extends AppCompatActivity {
     EditText firstName, lastName, phoneNumber, emailAddress, homeAddress;
     DbQueries dbQueries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        dbQueries = new DbQueries(getApplicationContext());


        firstName = (EditText) findViewById(R.id.edtfirstname);
        lastName = (EditText) findViewById(R.id.edtsecondname);
        phoneNumber = (EditText) findViewById(R.id.edtphonenumber);
        emailAddress = (EditText) findViewById(R.id.edtemail);
        homeAddress = (EditText) findViewById(R.id.edthomeaddress);


    }

    public void SaveIntoDB(View view) {
        HashMap<String,String> contact = new HashMap<String,String>();
        contact.put("firstName",firstName.getText().toString());
        contact.put("lastName",lastName.getText().toString());
        contact.put("phoneNumber",phoneNumber.getText().toString());
        contact.put("emailAddress",emailAddress.getText().toString());
        contact.put("homeAddress",homeAddress.getText().toString());
        dbQueries.InsertSingleContact(contact);
        Intent intent = new Intent(this,ContactList.class);
        startActivity(intent);
    }
}