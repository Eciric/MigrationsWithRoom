package com.example.migrationswithroom.Room.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.migrationswithroom.R;
import com.example.migrationswithroom.Room.AddCategoryActivity;
import com.example.migrationswithroom.Room.AddOwnerActivity;
import com.example.migrationswithroom.Room.adapter.OwnerAdapter;
import com.example.migrationswithroom.Room.model.Owner;
import com.example.migrationswithroom.Room.view_model.OwnerViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OwnerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OwnerFragment extends Fragment {

    private OwnerViewModel ownerViewModel;
    private TextView name;
    private FloatingActionButton buttonAddOwner;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OwnerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OwnerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OwnerFragment newInstance(String param1, String param2) {
        OwnerFragment fragment = new OwnerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getView().findViewById(R.id.recycle_view_owner);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        final OwnerAdapter adapter = new OwnerAdapter();
        recyclerView.setAdapter(adapter);
        name = getView().findViewById(R.id.name_text);
        name.setText("Owner Fragment");

        buttonAddOwner = getView().findViewById(R.id.button_add_owner);
        buttonAddOwner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddOwnerActivity.class);
                startActivity(intent);

            }
        });

        ownerViewModel = new ViewModelProvider(this).get(OwnerViewModel.class);
        ownerViewModel.getOwners().observe(this, new Observer<List<Owner>>() {
            @Override
            public void onChanged(List<Owner> owners) {
                adapter.setOwners(owners);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                ownerViewModel.delete(adapter.getOwnerAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getContext(), "Owner deleted!", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_owner, container, false);
    }
}