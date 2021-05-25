package com.example.migrationswithroom.Room.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.migrationswithroom.Room.ExampleDatabase;
import com.example.migrationswithroom.Room.dao.ItemDao;
import com.example.migrationswithroom.Room.dao.OwnerDao;
import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.model.Owner;

import java.util.List;

public class OwnerRepository {
    private OwnerDao ownerDao;
    private LiveData<List<Owner>> owners;

    public OwnerRepository(Application application){
        ExampleDatabase database = ExampleDatabase.getDatabase(application);
        ownerDao = database.ownerDao();
        owners = ownerDao.getAll();
    }

    public void insert(Owner owner){
        new OwnerRepository.InsertOwnerAsyncTask(ownerDao).execute(owner);
    }

    public void update(Owner owner){
        new OwnerRepository.UpdateOwnerAsyncTask(ownerDao).execute(owner);
    }

    public void delete(Owner owner){
        new OwnerRepository.DeleteOwnerAsyncTask(ownerDao).execute(owner);
    }

    public LiveData<List<Owner>> getOwners() {
        return owners;
    }

    private static class InsertOwnerAsyncTask extends AsyncTask<Owner, Void, Void> {
        private OwnerDao ownerDao;

        public InsertOwnerAsyncTask(OwnerDao ownerDao) {
            this.ownerDao = ownerDao;
        }

        @Override
        protected Void doInBackground(Owner... owners) {
            ownerDao.insertOwner(owners[0]);
            return null;
        }
    }

    private static class UpdateOwnerAsyncTask extends AsyncTask<Owner, Void, Void> {
        private OwnerDao ownerDao;

        public UpdateOwnerAsyncTask(OwnerDao ownerDao) {
            this.ownerDao = ownerDao;
        }

        @Override
        protected Void doInBackground(Owner... owners) {
            ownerDao.updateOwner(owners[0]);
            return null;
        }
    }

    private static class DeleteOwnerAsyncTask extends AsyncTask<Owner, Void, Void> {
        private OwnerDao ownerDao;

        public DeleteOwnerAsyncTask(OwnerDao ownerDao) {
            this.ownerDao = ownerDao;
        }

        @Override
        protected Void doInBackground(Owner... owners) {
            ownerDao.deleteOwner(owners[0]);
            return null;
        }
    }
}
