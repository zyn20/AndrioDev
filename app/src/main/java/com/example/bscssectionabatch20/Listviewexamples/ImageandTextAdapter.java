package com.example.bscssectionabatch20.Listviewexamples;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.bscssectionabatch20.R;

public class ImageandTextAdapter extends ArrayAdapter<String> {
    Activity activity;
    String [] Name;
    String [] Text;
     int [] Image;

    public ImageandTextAdapter(@NonNull  int resource, Activity activity, String[] name, String[] text, int[] image) {
        super(activity, R.layout.imageandtext,text);
        this.activity = activity;
        Name = name;
        Text = text;
        Image = image;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View View, @NonNull ViewGroup parent) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View ViewHolder = inflater.inflate(R.layout.imageandtext,null);
        TextView txtName = ViewHolder.findViewById(R.id.txtoneimgandtxt);
        TextView txtText = ViewHolder.findViewById(R.id.txttwoimgandtxt);
        ImageView imageView = ViewHolder.findViewById(R.id.imgimgandtxt);
        txtName.setText(Name[position]);
        txtText.setText(Text[position]);
        imageView.setImageResource(Image[position]);
        return ViewHolder;





    }
}
