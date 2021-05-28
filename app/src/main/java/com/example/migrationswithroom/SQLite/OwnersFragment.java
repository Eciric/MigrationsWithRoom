package com.example.migrationswithroom.SQLite;

import android.app.AlertDialog;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.migrationswithroom.R;

import java.util.ArrayList;

public class OwnersFragment extends Fragment {
    DBHelper dbHelper;
    public OwnersFragment() {
        // Required empty public constructor
    }

    public static OwnersFragment newInstance() {
        return new OwnersFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_owners, container, false);
        dbHelper = new DBHelper(getContext());
        populateListView(view);

        Button addButton = view.findViewById(R.id.addButton);
        addButton.setOnClickListener(v -> {
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
            LayoutInflater inflater1 = getActivity().getLayoutInflater();
            View dialogView = inflater1.inflate(R.layout.add_owners_dialog, null);
            EditText ownerName = dialogView.findViewById(R.id.ownerName);
            EditText ownerPhone = dialogView.findViewById(R.id.ownerPhone);
            EditText itemID = dialogView.findViewById(R.id.itemID);
            dialogBuilder.setView(dialogView);
            dialogBuilder.setTitle("Add New Owner!");
            dialogBuilder.setPositiveButton("Add!", (dialogInterface, i) -> {
                dbHelper.insertOwner(ownerName.getText().toString(), ownerPhone.getText().toString(), Integer.parseInt(itemID.getText().toString()));
                populateListView(view);
            });

            dialogBuilder.setNeutralButton("Cancel", (dialogInterface, i) -> dialogInterface.dismiss());
            AlertDialog alertDialog = dialogBuilder.create();
            alertDialog.show();
        });

        ListView listView = view.findViewById(R.id.listView);
        listView.setOnItemClickListener((parent, v, position, id) -> {
            deleteElement(position);
            populateListView(view);
        });
        return view;
    }

    public void deleteElement(int position) {
        Cursor data = dbHelper.getOwners();
        data.move(position + 1);
        dbHelper.deleteOwner(data.getInt(0));
    }

    public void populateListView(View view) {
        ListView listView = view.findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<>();
        Cursor data = dbHelper.getOwners();
        while (data.moveToNext()) {
            String id = data.getString(0);
            String name = data.getString(1);
            String phone = data.getString(2);
            String itemID = data.getString(3);
            String string = "ID: " + id + " Name: "+ name + " Phone: "+ phone + " Category ID: " + itemID;
            arrayList.add(string);
        }
        ListAdapter listAdapter = new ArrayAdapter<>(getContext(), R.layout.sqlite_list_view, R.id.item_text, arrayList);
        listView.setAdapter(listAdapter);
    }
}