package com.example.insense.repository.room;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {Activity.class},version = 8)
@TypeConverters({Converters.class})
public abstract class AppDB extends RoomDatabase {
    public abstract ActivityDAO userDao();
}
