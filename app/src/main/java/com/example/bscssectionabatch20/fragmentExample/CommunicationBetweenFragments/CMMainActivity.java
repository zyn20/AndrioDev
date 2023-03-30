package com.example.bscssectionabatch20.fragmentExample.CommunicationBetweenFragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bscssectionabatch20.R;

public class CMMainActivity extends AppCompatActivity implements ButtonPressListener.OnButtonPressListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cmmain);
    }

    @Override
    public void onButtonPressed(String Msg) {
        MyFragmenttwo fragmenttwo = (MyFragmenttwo) getSupportFragmentManager().findFragmentById(R.id.frag2);
        fragmenttwo.OnFragmentInteraction(Msg);

    }
}