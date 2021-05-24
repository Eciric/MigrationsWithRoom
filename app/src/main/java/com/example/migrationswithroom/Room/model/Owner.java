package com.example.migrationswithroom.Room.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Owner {
    @PrimaryKey(autoGenerate = true)
    private Long ownerId;
    @ColumnInfo(name = "owner_name")
    private String name;

    private String phoneNumber;

    @ColumnInfo(name = "item_id")
    public Long item_id;
}
