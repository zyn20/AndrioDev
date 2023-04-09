package com.example.bscssectionabatch20.fragmentExample.staticFragmentExample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bscssectionabatch20.R;

public class StaticFragmentMainActivity extends AppCompatActivity implements ContactsFragment.ListSelectionListener {

    public static String[] contactsArray;
    public static  String[] contactdetailArray;
    ContactsDetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_fragment_main);
        contactsArray = getResources().getStringArray(R.array.contacts);
        contactdetailArray = getResources().getStringArray(R.array.details_array);
        detailFragment = (ContactsDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detailsfragment);
    }

    @Override
    public void onSelection(int index) {
        if (detailFragment.getShownIndex()!= index)
        {
            detailFragment.ContactIndex(index);

        }



    }
}