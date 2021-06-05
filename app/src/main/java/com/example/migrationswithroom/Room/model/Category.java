package com.example.migrationswithroom.Room.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(tableName = "category_table", indices = @Index(value = "category_name", unique = true))
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Category {
    @PrimaryKey(autoGenerate = true)
    private long categoryId;

    @ColumnInfo(name = "category_name")
    private String name;

    private String description;

    public Category(String name) {
        this.name = name;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}
