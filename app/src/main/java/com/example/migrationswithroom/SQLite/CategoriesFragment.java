package com.example.migrationswithroom.SQLite;

import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.migrationswithroom.R;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment {

    DBHelper dbHelper;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    public static CategoriesFragment newInstance() {
        return new CategoriesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_categories, container, false);
        dbHelper = new DBHelper(getContext());
        populateListView(view);
        return view;
    }

    public void populateListView(View view) {
        ListView listView = view.findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor data = dbHelper.getCategories();
        while (data.moveToNext()) {
            String id = data.getString(0);
            String name = data.getString(1);
            String string = "ID: " + id + "\t\tName: "+ name;
            arrayList.add(string);
        }
        ListAdapter listAdapter = new ArrayAdapter<>(getContext(), R.layout.sqlite_list_view, R.id.item_text, arrayList);
        listView.setAdapter(listAdapter);
    }
}