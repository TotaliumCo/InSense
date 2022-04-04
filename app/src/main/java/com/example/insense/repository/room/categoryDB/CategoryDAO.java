package com.example.insense.repository.room.categoryDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;


import java.util.List;
@Dao
public interface CategoryDAO {

    @Query("SELECT * FROM Category")
    List<Category> getAll();
    @Query("SELECT * FROM Category WHERE uid_categ IN (:id)")
    Category loadById(int id);


    @Query("SELECT * FROM category WHERE name_categ = :name_categ")
    Category get_all_categories(@TypeConverters({CategoriesConventer.class}) List<String> name_categ);


    @Insert
    void insertAll(List<Category> categories);
    @Update
    void updateActivity(Category category);

    @Delete
    void delete(Category category);



}
