package com.example.insense.repository.room.activityDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {Activity.class}, version = 20)
@TypeConverters({ActivityConverters.class})
public abstract class ActivityDB extends RoomDatabase {
    public abstract ActivityDAO activityDao();

    private static ActivityDB activityDB;

    public static ActivityDB getActivityDB(final Context context) {
        if (activityDB == null) {
            synchronized (ActivityDB.class) {
                activityDB = Room.databaseBuilder(context, ActivityDB.class, "DATABASE")
                        .fallbackToDestructiveMigration().allowMainThreadQueries().build();
            }
        }
        return activityDB;
    }
}
