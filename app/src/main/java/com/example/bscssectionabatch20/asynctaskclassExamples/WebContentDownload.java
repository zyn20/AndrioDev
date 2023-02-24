package com.example.bscssectionabatch20.asynctaskclassExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.bscssectionabatch20.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class WebContentDownload extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_content_download);

        textView = findViewById(R.id.edtasynctask);

    }

    public void Download_Web_content(View view) {
        




    }
    public class DownloadWeb extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection connection =(HttpsURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inputStream);
                int data = reader.read();
                String webContent  ="";
                while(data != -1)
                {
                    char ch = (char) data;
                    webContent = webContent + ch;
                    data = reader.read();

                }
                return webContent;


            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}