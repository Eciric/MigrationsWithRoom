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
    @ColumnInfo(name = "category_Id")
    private Long category_Id;

    //id w long a nie obiekt category
    public Item(String name, String description, Long category_Id) {
        this.name = name;
        this.description = description;
        this.category_Id = category_Id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategory_Id() {
        return category_Id;
    }

    public void setCategory_Id(Long category_Id) {
        this.category_Id = category_Id;
    }
}
