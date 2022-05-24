package com.example.insense.repository.room.occupationDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.insense.repository.room.activityDB.ActivityDB;

@Database(entities = {Occupation.class}, version = 4)
public abstract class OccupationDB extends RoomDatabase {
    public abstract OccupationDAO occupationDAO();

    private static OccupationDB occupationDB;

    public static OccupationDB getOccupationDB(final Context context) {
        if (occupationDB == null) {
            synchronized (OccupationDB.class) {
                occupationDB = Room.databaseBuilder(context, OccupationDB.class, "DAT_ABASE")
                        .fallbackToDestructiveMigration().allowMainThreadQueries().build();
            }
        }
        return occupationDB;
    }
}

