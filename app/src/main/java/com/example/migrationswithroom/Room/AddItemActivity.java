package com.example.migrationswithroom.Room;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.migrationswithroom.R;
import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.view_model.CategoryViewModel;
import com.example.migrationswithroom.Room.view_model.ItemViewModel;
import com.example.migrationswithroom.Room.view_model.OwnerViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddItemActivity extends AppCompatActivity {

    private EditText itemName;
    private EditText itemDescription;
    private Spinner itemSpiner;
    private CategoryViewModel categoryViewModel;
    private ItemViewModel itemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        itemName = findViewById(R.id.edit_text_item_name);
        itemDescription = findViewById(R.id.edit_text_item_description);
        itemSpiner = findViewById(R.id.item_category_spinner);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);

        ArrayList<String> tempList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_own_spinner, tempList);
        adapter.setDropDownViewResource(R.layout.simple_own_dropdown);
        itemSpiner.setAdapter(adapter);

        categoryViewModel.getCategories().observe(this, new Observer<List<Category>>() {
            @Override
            public void onChanged(List<Category> categories) {
                for(Category category : categories){
                    tempList.add(category.getName());
                }
                adapter.notifyDataSetChanged();
            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close);
        actionBar.setTitle("Add Category");
    }

    private void saveItem(){
        String itemNameStr = itemName.getText().toString();
        String desc = itemDescription.getText().toString();
        String catName = (String) itemSpiner.getSelectedItem();
        Long position = 0L;
        for(Category category : categoryViewModel.getCategories().getValue()){
            if(category.getName().compareTo(catName) == 0){
                position = category.getCategoryId();
                break;
            }
        }

        if(itemNameStr.trim().isEmpty() || desc.trim().isEmpty()) {
            Toast.makeText(this, "Please insert item info!",Toast.LENGTH_SHORT).show();
            return;
        }
        itemViewModel.insert(new Item(itemNameStr, desc, position));

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_entity:
                saveItem();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}