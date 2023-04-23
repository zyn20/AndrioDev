package com.example.bscssectionabatch20.FirebaseExample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bscssectionabatch20.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class NewStudentExampleMainActivity extends AppCompatActivity {

    FirebaseDatabase database;
    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<NewStudent> messageList;
    FirebaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_new_student_example_main);
 recyclerView=findViewById(R.id.firebaserecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);
        database = FirebaseDatabase.getInstance("https://bscssectionabatch20-default-rtdb.firebaseio.com/");
        reference = database.getReference("MyDatabase");
        messageList = new ArrayList<>();
        ReadDataFromFirebase();
    }
    public void ReadDataFromFirebase()
    {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot datasnapshot) {
                for(DataSnapshot snapshot : datasnapshot.getChildren())
                {
                    NewStudent student = new NewStudent();
                    student.setName(snapshot.child("Name").getValue().toString());
                    student.setUrl(snapshot.child("Picture").getValue().toString());
                    messageList.add(student);
                }
                adapter=new FirebaseAdapter(messageList,getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}