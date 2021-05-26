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
import com.example.migrationswithroom.Room.adapter.ItemAdapter;
import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.model.Owner;
import com.example.migrationswithroom.Room.view_model.CategoryViewModel;
import com.example.migrationswithroom.Room.view_model.ItemViewModel;
import com.example.migrationswithroom.Room.view_model.OwnerViewModel;

import java.util.ArrayList;
import java.util.List;

public class AddOwnerActivity extends AppCompatActivity {

    private EditText ownerName;
    private EditText ownerPhoneNumber;
    private Spinner ownerSpiner;
    private OwnerViewModel ownerViewModel;
    private ItemViewModel itemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_owner);

        ownerName = findViewById(R.id.edit_text_owner_name);
        ownerPhoneNumber = findViewById(R.id.edit_text_owner_number);
        ownerSpiner = findViewById(R.id.owner_item_spinner);

        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        ownerViewModel = new ViewModelProvider(this).get(OwnerViewModel.class);

        ArrayList<String> tempList = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,R.layout.simple_own_spinner, tempList);
        adapter.setDropDownViewResource(R.layout.simple_own_dropdown);
        ownerSpiner.setAdapter(adapter);
        itemViewModel.getItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> items) {
                for(Item item : items){
                    tempList.add(item.getName());
                }
                adapter.notifyDataSetChanged();
            }
        });



        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close);
        actionBar.setTitle("Add Owner");
    }

    private void saveOwner(){
        String name = ownerName.getText().toString();
        String number = ownerPhoneNumber.getText().toString();
        String itemName = (String) ownerSpiner.getSelectedItem();
        Long position = 0L;
        for(Item i : itemViewModel.getItems().getValue()){
            if(i.getName().compareTo(itemName)==0){
                position = i.getItemId();
                break;
            }
        }


        if(name.trim().isEmpty() || number.trim().isEmpty()) {
            Toast.makeText(this, "Please insert owner info!",Toast.LENGTH_SHORT).show();
            return;
        }
        ownerViewModel.insert(new Owner(name, number, position));

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
                saveOwner();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}