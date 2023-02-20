package com.example.bscssectionabatch20.Listviewexamples;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.bscssectionabatch20.R;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiColumnListViewAdapter extends BaseAdapter {
    public ArrayList<HashMap<String,String>> list;
    Activity activity;//context aae ga
    public static final String First_coloumn = "First";
    public static final String Second_coloumn = "Second";
    public static final String Third_coloumn = "Third";
    //add contructor key
    //alt + insert


    public MultiColumnListViewAdapter(ArrayList<HashMap<String, String>> list, Activity activity) {
        this.list = list;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        //setconetentView only in onCreate()
        //suppose we have to add layout by ourself
        LayoutInflater inflater = activity.getLayoutInflater();
        ViewHolder viewHolder = new ViewHolder();
        if(view==null)
        {
            view = inflater.inflate(R.layout.multicolumnlistview,null);
            viewHolder.textview1 = view.findViewById(R.id.txt1multicolumnexample);
            viewHolder.textview2 = view.findViewById(R.id.txt2multicolumn);
            viewHolder.textview3 = view.findViewById(R.id.txt3multicoloumn);
            view.setTag(viewHolder);
        }
        else viewHolder = (ViewHolder)view.getTag();
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap = list.get(position);
        viewHolder.textview1.setText(hashMap.get(First_coloumn));
        viewHolder.textview2.setText(hashMap.get(Second_coloumn));
        viewHolder.textview3.setText(hashMap.get(Third_coloumn));
        return view;
    }
    public class ViewHolder
    {
        TextView textview1,textview2,textview3;

    }
}
