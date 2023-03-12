package com.example.bscssectionabatch20.asynctaskclassExamples;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.bscssectionabatch20.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

public class AsyncTaskExample1 extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task_example1);
        imageView=findViewById(R.id.imgasynctask);
    }

    public void Download_Image_AsyncTask(View view) throws ExecutionException, InterruptedException {
        DownloadImage obj = new DownloadImage();
        Bitmap bitmap = obj.execute("https://cdn.thinglink.me/api/image/854796788643659778/1240/10/scaletowidt").get();//it will automatically redirect to doInbackground Function
        imageView.setImageBitmap(bitmap);
        Log.d("TAG","Back In Main");



    }
    public class DownloadImage extends AsyncTask<String,Void, Bitmap>
    {

        //... means array like strings
        //This class do the work in background

        @Override
        protected Bitmap doInBackground(String... strings) {

            try {
                URL url = new URL(strings[0]);
                HttpsURLConnection connection =(HttpsURLConnection) url.openConnection();
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                Log.d("Tag","doInBackground() in progress");
                return bitmap;

            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }



        }
    }
}