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

        ArrayList<Occupation> occupationList = new ArrayList<Occupation>() {
        };
        Occupation piano = new Occupation();
        piano.category = "хобби";
        piano.name = "Игра на пианино";
        piano.description = "Изучение нот, запоминание мелодий";
        occupationList.add(piano);

        Occupation guitar = new Occupation();
        guitar.category = "хобби";
        guitar.name = "Игра на гитаре";
        guitar.description = "Перебирание струн";
        occupationList.add(guitar);

        Occupation workout = new Occupation();
        workout.category = "спорт";
        workout.name = "разминка";
        workout.description = "Легкая активность";
        occupationList.add(workout);

        Occupation run = new Occupation();
        run.category = "спорт";
        run.name = "пробежка";
        run.description = "лоооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооо";
        occupationList.add(run);

        Occupation tennis = new Occupation();
        tennis.category = "спорт";
        tennis.name = "игра в теннис";
        tennis.description = "LOL! WHAT?!";
        occupationList.add(tennis);

        Occupation temp = new Occupation();
        temp.category = "спорт";
        temp.name = "игра в теннис";
        temp.description = "LOL! WHAT?!";
        occupationList.add(temp);





        OccupationDB db = Room.databaseBuilder(context,
                OccupationDB.class, "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        occupationDAO = db.occupationDAO();
        occupationDAO.insertAll(occupationList);
    }
    public List<String> occupation_by_category(String categ){
        List<Occupation> all;

        all = occupationDAO.loadOccupationByCategoriesName(categ);
        List<String> all_categ = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_categ.add(all.get(i).name);
        }
        return all_categ;
    }

    public List<String> discription_of_occupation(String categ){
        List<Occupation> all;

        all = occupationDAO.loadOccupationByCategoriesName(categ);
        List<String> all_descrigt = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_descrigt.add(all.get(i).description);
        }
        return all_descrigt;
    }

}
