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

    public Owner(String name, String phoneNumber, Long item_id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.item_id = item_id;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }
}
