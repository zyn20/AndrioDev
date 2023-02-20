package com.example.bscssectionabatch20.Listviewexamples;

import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

public class ImageandTextAdapter extends ArrayAdapter<String> {
    Activity activity;
    String [] Name;
    String [] Text;
     int [] Image;

    public ImageandTextAdapter(@NonNull Context context, int resource, Activity activity, String[] name, String[] text, int[] image) {
        super(context, resource);
        this.activity = activity;
        Name = name;
        Text = text;
        Image = image;
    }


}
