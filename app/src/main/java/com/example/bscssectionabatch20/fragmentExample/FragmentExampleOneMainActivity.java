package com.example.bscssectionabatch20.fragmentExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;

import com.example.bscssectionabatch20.R;

public class FragmentExampleOneMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_fragment_example_one_main);
        //return obj of fragment manager
        FragmentManager FM = getSupportFragmentManager();
        FragmentTransaction FT = FM.beginTransaction();
        Configuration config = getResources().getConfiguration();
        if(config.orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            PM_Fragment pm_fragment = new PM_Fragment();
            FT.replace(android.R.id.content,pm_fragment);

        }
        else {
            LM_Fragment lm_fragment = new LM_Fragment();
            FT.replace(android.R.id.content,lm_fragment);
        }
        FT.commit();
    }
}