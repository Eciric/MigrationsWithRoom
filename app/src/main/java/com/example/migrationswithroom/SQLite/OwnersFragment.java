package com.example.migrationswithroom.SQLite;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.migrationswithroom.R;

public class OwnersFragment extends Fragment {
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_owners, container, false);
    }
}