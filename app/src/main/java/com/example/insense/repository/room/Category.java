package com.example.insense.repository.room;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.TypeConverters;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {
    @PrimaryKey(autoGenerate = true)
    public long uid_categ;
    @ColumnInfo(name = "name_categ")
    public String name_categ;
    @ColumnInfo(name = "description_categ")
    public String description_categ;
    @TypeConverters({CategoriesConventer.class})
    public List<String> category;



}
