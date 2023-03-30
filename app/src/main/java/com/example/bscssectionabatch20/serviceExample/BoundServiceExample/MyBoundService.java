package com.example.bscssectionabatch20.serviceExample.BoundServiceExample;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.bscssectionabatch20.R;

public class MyBoundService extends Service {
    private final Binder myBinder = new MyBinder();

    public static final String TAG = "TAG";
    public MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.small);
        Log.d(TAG,"Oncreate Method is Called__________");
    }

    @Nullable
    @Override

    public IBinder onBind(Intent intent) {

        Log.d(TAG,"onBind called _______");
        return myBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }


    //When bound service then binder msut be extend
    public class MyBinder extends Binder
    {
        MyBoundService getServiceMethod()
        {
            //return the context of its parent class
            return MyBoundService.this;
        }


    }
    public void Play()
    {
        mediaPlayer.start();
    }
    public void Pause()
    {
        mediaPlayer.stop();
    }


    public boolean isPlaying()
    {
       return mediaPlayer.isPlaying();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.release();
    }
}
