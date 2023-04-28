package com.example.bscssectionabatch20.FileHandling;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bscssectionabatch20.R;
import com.google.android.material.snackbar.Snackbar;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileHandlingMainActivity extends AppCompatActivity {
EditText editText;
TextView textView;
String File_Name = "MyTextFile";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_handling_main);
         editText = findViewById(R.id.edtfilehandling);
         textView = findViewById(R.id.txtfilehandling);




    }

    public void save_Text(View view) {

        String TextData = editText.getText().toString();
        try {
            FileOutputStream outputStream = openFileOutput(File_Name, Context.MODE_PRIVATE);
            outputStream.write(TextData.getBytes());
            editText.setText("");
            Snackbar.make(view,"Text Saved",Snackbar.LENGTH_LONG).show();
            outputStream.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void Show_TextData(View view) {
        String readTextData = "";
        try {
            FileInputStream inputStream  = openFileInput(File_Name);
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String text =  bufferedReader.readLine();
            if(text ==null)
            {
                Toast.makeText(this,"File is empty",Toast.LENGTH_LONG).show();

            }
            else {
                while (text!=null)
                {
                    readTextData=readTextData + text;
                    text = bufferedReader.readLine();
                }
                bufferedReader.close();
                inputStream.close();
                reader.close();
                textView.setText(readTextData);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}