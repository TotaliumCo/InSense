package com.example.insense.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.repository.room.occupationDB.Occupation;
import com.example.insense.repository.room.occupationDB.OccupationDAO;
import com.example.insense.repository.room.occupationDB.OccupationDB;

import java.util.ArrayList;
import java.util.List;

public class OccupationRepository {
    OccupationDB db;
    OccupationDAO occupationDAO;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public OccupationRepository(Context context) {

        OccupationDB db = OccupationDB.getOccupationDB(context.getApplicationContext());
        occupationDAO = db.occupationDAO();
    }

    public List<Occupation> get_everything_from_occupations() {
        List<Occupation> all;

        all = occupationDAO.getAllOccupation();
        List<Occupation> all_occup = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_occup.add(all.get(i));
        }
        return all_occup;
    }

    public List<String> get_all_occupations(String categ) {
        List<Occupation> all;

        all = occupationDAO.loadOccupationByCategoriesName(categ);
        List<String> all_occup = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_occup.add(all.get(i).name);
        }
        return all_occup;
    }

    public List<String> occupation_by_category(String categ) {
        List<Occupation> all;

        all = occupationDAO.loadOccupationByCategoriesName(categ);
        List<String> all_categ = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_categ.add(all.get(i).name);
        }
        return all_categ;
    }

    public OccupationDAO getOccupationDAO() {
        return occupationDAO;
    }
}
