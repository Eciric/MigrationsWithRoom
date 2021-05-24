package com.example.migrationswithroom.Room.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.migrationswithroom.Room.model.Item;
import com.example.migrationswithroom.Room.model.Owner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class OwnerItem {
    @Embedded
    public Item item;
    @Relation(
            parentColumn = "itemId",
            entityColumn = "item_id"
    )
    public Owner owner;
}
