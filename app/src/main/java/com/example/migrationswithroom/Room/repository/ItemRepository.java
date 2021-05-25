package com.example.migrationswithroom.Room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.migrationswithroom.Room.ExampleDatabase;
import com.example.migrationswithroom.Room.dao.ItemDao;
import com.example.migrationswithroom.Room.model.Item;

import java.util.List;

public class ItemRepository {
    private ItemDao itemDao;
    private LiveData<List<Item>> items;

    public ItemRepository(Application application){
        ExampleDatabase database = ExampleDatabase.getDatabase(application);
        itemDao = database.itemDao();
        items = itemDao.getAll();
    }

    public void insert(Item item){
        new ItemRepository.InsertItemAsyncTask(itemDao).execute(item);
    }

    public void update(Item item){
        new ItemRepository.UpdateItemAsyncTask(itemDao).execute(item);
    }

    public void delete(Item item){
        new ItemRepository.DeleteItemAsyncTask(itemDao).execute(item);
    }

    public LiveData<List<Item>> getItems() {
        return items;
    }

    private static class InsertItemAsyncTask extends AsyncTask<Item, Void, Void> {
        private ItemDao itemDao;

        public InsertItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.insertItem(items[0]);
            return null;
        }
    }

    private static class UpdateItemAsyncTask extends AsyncTask<Item, Void, Void>{
        private ItemDao itemDao;

        public UpdateItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.updateItem(items[0]);
            return null;
        }
    }

    private static class DeleteItemAsyncTask extends AsyncTask<Item, Void, Void>{
        private ItemDao itemDao;

        public DeleteItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }

        @Override
        protected Void doInBackground(Item... items) {
            itemDao.deleteItem(items[0]);
            return null;
        }
    }
}
