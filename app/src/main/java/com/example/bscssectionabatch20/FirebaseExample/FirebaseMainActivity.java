package com.example.bscssectionabatch20.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.bscssectionabatch20.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FirebaseMainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    TextView textView;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase_main);
        //connecting to db of my Firebase
        database = FirebaseDatabase.getInstance("https://bscssectionabatch20-default-rtdb.firebaseio.com/");
        reference = database.getReference("MyDatabase");
        textView = findViewById(R.id.txtfirebasereadbtn);
    }

    public void SendDatatoFirebase(View view) {
    /*  reference.child("Student").child("Name").setValue("Zain Ul Abideen");
        reference.child("Student").child("Age").setValue("23");
        Log.d("Tag","Sent");
     */
      /*  String id = reference.push().getKey();
        String Name = "Zain";
        String City  = "Bahawalpur";
        FAST_Student obj =  new FAST_Student(id,Name,City);
        reference.child(id).setValue(obj);
         reference.removeValue();

       */
        reference.setValue("my First Message");
        //On data change will run when this message go into db



    }

    public void ReadFromFirebase(View view) {
        //Reading data from Firebase
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
            String value = snapshot.getValue().toString();
            textView.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}