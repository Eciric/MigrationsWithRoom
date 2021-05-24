package com.example.migrationswithroom.Room.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Item {
    @PrimaryKey(autoGenerate = true)
    private Long itemId;
    @ColumnInfo(name = "item_name")
    private String name;
    private String description;
    @ColumnInfo(name = "category_id")
    private Long category_Id;


    public Item(String name, String description, Long category_Id) {
        this.name = name;
        this.description = description;
        this.category_Id = category_Id;
    }
}
