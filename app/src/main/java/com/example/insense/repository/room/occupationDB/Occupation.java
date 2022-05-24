package com.example.insense.repository.room.occupationDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Occupation {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "category")
    public String category;
}
