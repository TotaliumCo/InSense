package com.example.insense.repository.room.categoryDB;


import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
@Entity
@TypeConverters({CategoriesConventer.class})
@Database(entities = {Category.class}, version = 2, exportSchema = false)
public abstract class CategoryDB extends RoomDatabase {
    public abstract CategoryDAO user_categ();
}