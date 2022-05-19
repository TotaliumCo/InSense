package com.example.insense.repository.room.occupationDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.insense.repository.room.categoryDB.Category;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface OccupationDAO {
    @Query("SELECT * FROM Occupation")
    List<Occupation> getAllOccupation();
    @Query("SELECT * FROM Occupation WHERE uid IN (:id)")
    Occupation loadById(int id);
    @Query("SELECT * FROM Occupation WHERE category IN (:category)")
    List<Occupation> loadOccupationByCategoriesName(String category);

    @Insert
    void insertAll(List<Occupation> occupations);
    @Insert
    void insert(Occupation occupation);
    @Update
    void updateOccupation(Occupation occupation);
    @Delete
    void delete(Occupation occupation);


}
