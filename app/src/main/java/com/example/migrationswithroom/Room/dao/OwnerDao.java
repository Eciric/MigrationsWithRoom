package com.example.migrationswithroom.Room.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.model.Owner;
import com.example.migrationswithroom.Room.relations.OwnerItem;

import java.util.List;

@Dao
public interface OwnerDao {
    @Query("Select * from owner")
    LiveData<List<Owner>> getAll();

    @Query("Select * from owner where owner_name Like :name")
    Owner getOwnerByName(String name);

    @Query("Select * from owner where ownerId like :id")
    Owner getOwnerById(Long id);

    @Transaction
    @Query("Select * from item inner join Owner where itemId = item_id")
    List<OwnerItem> getOwnerAndItem();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertOwner(Owner... owners);

    @Delete
    void deleteOwner(Owner... owners);

    @Update
    void updateOwner(Owner owner);
}
