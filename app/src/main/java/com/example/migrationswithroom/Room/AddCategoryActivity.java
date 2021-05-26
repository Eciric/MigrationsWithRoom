package com.example.migrationswithroom.Room;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.migrationswithroom.R;
import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.view_model.CategoryViewModel;

public class AddCategoryActivity extends AppCompatActivity {
    private EditText categoryName;
    private CategoryViewModel categoryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        categoryName = findViewById(R.id.edit_text_category_name);
        categoryViewModel = new ViewModelProvider(this).get(CategoryViewModel.class);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close);
        actionBar.setTitle("Add Category");
    }

    private void saveCategory(){
        String name = categoryName.getText().toString();

        if(name.trim().isEmpty()) {
            Toast.makeText(this, "Please insert name!",Toast.LENGTH_SHORT).show();
            return;
        }
        categoryViewModel.insert(new Category(name));

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
                saveCategory();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}