package com.example.migrationswithroom.Room.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.repository.CategoryRepository;
import com.example.migrationswithroom.Room.repository.ItemRepository;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    private ItemRepository repository;
    private LiveData<List<Item>> items;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(application);
        items =  repository.getItems();
    }

    public void insert(Item item){
        repository.insert(item);
    }

    public void update(Item item){
        repository.update(item);
    }

    public void delete(Item item){
        repository.delete(item);
    }



    public LiveData<List<Item>> getItems(){
        return items;
    }
}
