package com.example.migrationswithroom.Room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.migrationswithroom.R;
import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.model.Owner;
import com.example.migrationswithroom.Room.view_model.CategoryViewModel;
import com.example.migrationswithroom.Room.view_model.ItemViewModel;
import com.example.migrationswithroom.Room.view_model.OwnerViewModel;

import java.util.List;

public class ExampleActivity extends AppCompatActivity {

    private CategoryViewModel categoryViewModel;
    private ItemViewModel itemViewModel;
    private OwnerViewModel ownerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        categoryViewModel.getCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                //tu zmieniac UI
            }
        });

        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        itemViewModel.getItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                //tu zmieniac UI
            }
        });

        ownerViewModel = new ViewModelProvider(this).get(OwnerViewModel.class);
        ownerViewModel.getOwners().observe(this, new Observer<List<Owner>>() {
            @Override
            public void onChanged(List<Owner> owners) {
                //tu zmieniac UI
            }
        });
    }
}