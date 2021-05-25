package com.example.migrationswithroom.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.migrationswithroom.Room.dao.CategoryDao;
import com.example.migrationswithroom.Room.dao.ItemDao;
import com.example.migrationswithroom.Room.dao.OwnerDao;
import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.model.Owner;

@Database(entities = {Category.class, Item.class, Owner.class}, version = 1, exportSchema = false)
public abstract class ExampleDatabase extends RoomDatabase {

    public abstract CategoryDao categoryDao();

    public abstract ItemDao itemDao();

    public abstract OwnerDao ownerDao();

    private static ExampleDatabase INSTANCE;

    public static synchronized ExampleDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ExampleDatabase.class, "example_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }
    //add at start

}
