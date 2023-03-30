package com.example.bscssectionabatch20.fragmentExample.staticFragmentExample;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.ListFragment;

import com.example.bscssectionabatch20.R;

public class ContactsFragment extends ListFragment{
    public ListSelectionListener mListener = null;
    public interface ListSelectionListener
    {
        public void onSelection(int index);

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mListener = (ListSelectionListener) getActivity();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                R.layout.contactstextview,StaticFragmentMainActivity.contactsArray));
    }

    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int index, long id) {
        getListView().setItemChecked(index,true);
        mListener.onSelection(index);

    }
}
