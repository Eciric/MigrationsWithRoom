package com.example.migrationswithroom.Room.relations;


import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.migrationswithroom.Room.model.Category;
import com.example.migrationswithroom.Room.model.Item;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class CategoryItem {
    @Embedded public Category category;
    @Relation(
            parentColumn = "categoryId",
            entityColumn = "category_Id"
    )
    public List<Item> productList;
}
