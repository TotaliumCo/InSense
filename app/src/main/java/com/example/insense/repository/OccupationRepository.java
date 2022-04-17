package com.example.insense.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.repository.room.occupationDB.Occupation;
import com.example.insense.repository.room.occupationDB.OccupationDAO;
import com.example.insense.repository.room.occupationDB.OccupationDB;

import java.util.ArrayList;

public class OccupationRepository {
    OccupationDB db;
    OccupationDAO occupationDAO;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public OccupationRepository(Context context) {

        ArrayList<Occupation> occupationList = new ArrayList<Occupation>() {
        };
        Occupation piano = new Occupation();
        piano.category = "Hobbies";
        piano.name = "Playing on Piano";
        piano.description = "LOL! WHAT?!";
        occupationList.add(piano);

        Occupation guitar = new Occupation();
        guitar.category = "Hobbies";
        guitar.name = "Playing on guitar";
        guitar.description = "LOL! WHAT?!";
        occupationList.add(guitar);

        Occupation workout = new Occupation();
        guitar.category = "Health";
        guitar.name = "workout";
        guitar.description = "LOL! WHAT?!";
        occupationList.add(workout);

        Occupation medecine = new Occupation();
        guitar.category = "Health";
        guitar.name = "medecine";
        guitar.description = "LOL! WHAT?!";
        occupationList.add(medecine);

        OccupationDB db = Room.databaseBuilder(context,
                OccupationDB.class, "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        occupationDAO = db.occupationDAO();
        occupationDAO.insertAll(occupationList);
    }
}
