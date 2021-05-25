package com.example.migrationswithroom.Room.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.model.Owner;
import com.example.migrationswithroom.Room.repository.ItemRepository;
import com.example.migrationswithroom.Room.repository.OwnerRepository;

import java.util.List;

public class OwnerViewModel extends AndroidViewModel {
    private OwnerRepository repository;
    private LiveData<List<Owner>> owners;

    public OwnerViewModel(@NonNull Application application) {
        super(application);
        repository = new OwnerRepository(application);
        owners =  repository.getOwners();
    }

    public void insert(Owner owner){
        repository.insert(owner);
    }

    public void update(Owner owner){
        repository.update(owner);
    }

    public void delete(Owner owner){
        repository.delete(owner);
    }

    public LiveData<List<Owner>> getOwners(){
        return owners;
    }
}
