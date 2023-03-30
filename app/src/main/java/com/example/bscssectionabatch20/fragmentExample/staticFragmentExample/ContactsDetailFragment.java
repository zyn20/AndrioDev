package com.example.bscssectionabatch20.fragmentExample.staticFragmentExample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bscssectionabatch20.MainActivity;
import com.example.bscssectionabatch20.R;

public class ContactsDetailFragment extends Fragment {

    TextView textView;
    int currentIndex = -1;
    int arrayLength;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contactdetails,container,false);

    }
    public int getShownIndex()
    {
        return currentIndex;

    }
    public void ContactIndex(int index)
    {
        if(index<0 || index >=arrayLength )
        {
            return;
        }
        currentIndex=index;
        textView.setText(StaticFragmentMainActivity.contactdetailArray[index]);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = getActivity().findViewById(R.id.txtdetails);
        arrayLength = StaticFragmentMainActivity.contactsArray.length;

    }
}
