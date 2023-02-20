package com.example.bscssectionabatch20.Tasktwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.bscssectionabatch20.R;

public class studentactivityone extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    EditText name,cnic,phone,sgpa,cgpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentactivityone);
        name=findViewById(R.id.tasktwonameid);
        cnic=findViewById(R.id.tasktwocnicid);
        phone=findViewById(R.id.tasktwophoneid);
        sgpa=findViewById(R.id.tasktwospgaid);
        cgpa=findViewById(R.id.tasktwocpgaid);
        sharedPreferences=getSharedPreferences("studentinfo",0);
    }

    public void SaveBtn(View view) {
        String naam= name.getText().toString();
        String cn= cnic.getText().toString();
        String ph= phone.getText().toString();
        String sgpg= sgpa.getText().toString();
        String cgp=cgpa.getText().toString();
        SharedPreferences.Editor edit=sharedPreferences.edit();
        edit.putString("Name",naam);
        edit.putString("Cnic",cn);
        edit.putString("Phone",ph);
        edit.putString("Sgpa",sgpg);
        edit.putString("Cgpa",cgp);
        edit.apply();
        Intent intent=new Intent(this,studentactivitytwo.class);
        startActivity(intent);
    }
}