package com.example.migrationswithroom.Room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.relations.CategoryItem;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("Select * from category_table")
    LiveData<List<Category>> getAll();

    @Query("Select * from category_table where category_name Like :name")
    Category getCategoryByName(String name);

    @Query("Select * from category_table where categoryId like :id")
    Category getCategoryById(Long id);

    @Transaction
    @Query("Select * from category_table")
    List<CategoryItem> getCategoryAndItems();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertCategory(Category... categories);

    @Delete
    void deleteCategory(Category... categories);

    @Update
    void updateCategory(Category category);
}
