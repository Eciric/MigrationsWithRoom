package com.example.migrationswithroom.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "DatabaseSQLite", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table Categories(id INTEGER primary key, name TEXT)");
        DB.execSQL("create table Items(id INTEGER primary key, name TEXT, description TEXT, category_id INTEGER, FOREIGN KEY(category_id) REFERENCES Categories(id))");
        DB.execSQL("create table Owners(id INTEGER primary key, name TEXT, phone_number TEXT, item_id INTEGER, FOREIGN KEY(item_id) REFERENCES Items(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists Categories");
        DB.execSQL("drop table if exists Items");
        DB.execSQL("drop table if exists Owners");
    }

    public Boolean insertCategory(String name) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        long result = DB.insert("Categories", null, contentValues);
        return !(result == -1);
    }

    public Boolean insertItem(String name, String description, int category_id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("description", description);
        contentValues.put("category_id", category_id);
        long result = DB.insert("Items", null, contentValues);
        return !(result == -1);
    }

    public Boolean insertOwner(String name, String phone_number, int item_id) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("phone_number", phone_number);
        contentValues.put("item_id", item_id);
        long result = DB.insert("Owners", null, contentValues);
        return !(result == -1);
    }

    public void deleteCategories() {
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("DELETE FROM Categories");
    }

    public void deleteItems() {
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("DELETE FROM Items");
    }

    public void deleteOwners() {
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("DELETE FROM Owners");
    }

    public Cursor getCategories() {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("select * from Categories", null);
    }

    public Cursor getItems() {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("select * from Items", null);
    }

    public Cursor getOwners() {
        SQLiteDatabase DB = this.getWritableDatabase();
        return DB.rawQuery("select * from Owners", null);
    }
}
