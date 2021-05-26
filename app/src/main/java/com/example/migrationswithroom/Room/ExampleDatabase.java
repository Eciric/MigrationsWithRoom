package com.example.migrationswithroom.Room;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.migrationswithroom.Room.dao.CategoryDao;
import com.example.migrationswithroom.Room.dao.ItemDao;
import com.example.migrationswithroom.Room.dao.OwnerDao;
import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.model.Owner;

@Database(entities = {Category.class, Item.class, Owner.class}, version = 2, exportSchema = false)
public abstract class ExampleDatabase extends RoomDatabase {

    public abstract CategoryDao categoryDao();

    public abstract ItemDao itemDao();

    public abstract OwnerDao ownerDao();

    private static ExampleDatabase INSTANCE;

    public static synchronized ExampleDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ExampleDatabase.class, "example_db")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCalback)
                    .build();
        }
        return INSTANCE;
    }
    private static RoomDatabase.Callback roomCalback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(INSTANCE).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private CategoryDao categoryDao;
        private ItemDao itemDao;
        private OwnerDao ownerDao;

        public PopulateDbAsyncTask(ExampleDatabase db) {
            this.categoryDao = db.categoryDao();
            this.itemDao = db.itemDao();
            this.ownerDao = db.ownerDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            categoryDao.insertCategory(new Category("Vegetable"));
            categoryDao.insertCategory(new Category("Meat"));
            categoryDao.insertCategory(new Category("Fruit"));

            itemDao.insertItem(new Item("Carrot", "small, peeled", categoryDao.getCategoryByName("Vegetable").getCategoryId()));
            itemDao.insertItem(new Item("Beef", "2kg", categoryDao.getCategoryByName("Meat").getCategoryId()));
            itemDao.insertItem(new Item("Apple", "green, Polish product", categoryDao.getCategoryByName("Fruit").getCategoryId()));

            ownerDao.insertOwner(new Owner("Biedronka","789456132", itemDao.getItemByName("Beef").getItemId()));
            ownerDao.insertOwner(new Owner("Lidl","968456963", itemDao.getItemByName("Carrot").getItemId()));
            ownerDao.insertOwner(new Owner("Dino","568145132", itemDao.getItemByName("Apple").getItemId()));
            return null;
        }
    }

}
