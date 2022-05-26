package com.example.insense.repository.room.activityDB;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Dao;

@Dao
public interface ActivityDAO {

    @Query("SELECT * FROM Activity")
    List<Activity> getAll();
    @Query("SELECT * FROM Activity WHERE uid IN (:activity_lolIds)")
    List<Activity> loadAllByIds(List<Long> activity_lolIds);
    @Query("SELECT * FROM Activity WHERE uid IN (:id)")
    Activity loadById(int id);
    @Query("SELECT * FROM Activity WHERE occupation IN (:occupation)")
    List<Activity> loadByOccupation(String occupation);
    @Query("SELECT * FROM Activity WHERE name IN (:name)")
    Activity loadByName(String name);
    @Query("SELECT * FROM Activity WHERE name IN (:name)")
    Activity loadByDay(String name);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAll(List<Activity> activities);
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Activity activities);
    @Update
    void updateActivity(Activity activities);
    @Delete
    void delete(Activity activity);

}
