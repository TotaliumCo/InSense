package com.example.insense.repository.room.occupationDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Occupation.class}, version = 4, exportSchema = false)
public abstract class OccupationDB extends RoomDatabase {
    public abstract OccupationDAO occupationDAO();
}

