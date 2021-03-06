package com.example.migrationswithroom.Room.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.repository.CategoryRepository;

import java.util.List;

public class CategoryViewModel extends AndroidViewModel {
    private CategoryRepository repository;
    private LiveData<List<Category>> categories;

    public CategoryViewModel(@NonNull Application application) {
        super(application);
        repository = new CategoryRepository(application);
        categories =  repository.getCategories();
    }

    public void insert(Category category){
        repository.insert(category);
    }

    public void update(Category category){
        repository.update(category);
    }

    public void delete(Category category){
        repository.delete(category);
    }

    public LiveData<List<Category>> getCategories(){
        return categories;
    }


}
