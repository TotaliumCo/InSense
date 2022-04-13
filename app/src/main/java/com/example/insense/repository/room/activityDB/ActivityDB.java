package com.example.insense.repository.room.activityDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.insense.repository.room.activityDB.Activity;
import com.example.insense.repository.room.activityDB.ActivityConverters;
import com.example.insense.repository.room.activityDB.ActivityDAO;


@Database(entities = {Activity.class},version = 18, exportSchema = false)
@TypeConverters({ActivityConverters.class})
public abstract class ActivityDB extends RoomDatabase {
    public abstract ActivityDAO userDao();
}
