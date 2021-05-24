package com.example.migrationswithroom.Room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.migrationswithroom.Room.model.Item;

import java.util.List;

@Dao
public interface ItemDao {

    @Query("Select * from item")
    List<Item> getAll();

    @Query("Select * from item where item_name Like :name")
    Item getItemByName(String name);

    @Query("Select * from item where itemId like :id")
    Item getItemById(Long id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertItem(Item... items);

    @Delete
    void deleteItem(Item... items);

    @Update
    void updateItem(Item item);
}
