package com.example.bscssectionabatch20.fragmentExample.CommunicationBetweenFragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bscssectionabatch20.R;

public class MyFragmentOne extends Fragment {
    ButtonPressListener.OnButtonPressListener buttonPressListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragmentonelayout,container,false);
        myFunction(viewGroup);
        return viewGroup;

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        buttonPressListener = (ButtonPressListener.OnButtonPressListener) getActivity();

    }

    private void myFunction(ViewGroup viewGroup) {
        TextView textView;
        textView = viewGroup.findViewById(R.id.cmfragmenttxt);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonPressListener.onButtonPressed("Message From Fragment One......");
            }
        });

    }
}
