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


//МУЗЫКА!
        Occupation piano = new Occupation();
        piano.category = "музыка";
        piano.name = "Игра на пианино";
        piano.description = "Изучение нот, запоминание мелодий";
        occupationList.add(piano);

        Occupation guitar = new Occupation();
        guitar.category = "музыка";
        guitar.name = "Игра на гитаре";
        guitar.description = "Перебирание струн";
        occupationList.add(guitar);

//ХОББИ!
        Occupation draw = new Occupation();
        draw.category = "хобби";
        draw.name = "Рисование";
        draw.description = "рисование";
        occupationList.add(draw);

        Occupation reading = new Occupation();
        reading.category = "хобби";
        reading.name = "Чтение";
        reading.description = "чтение";
        occupationList.add(reading);

        Occupation computer_games = new Occupation();
        computer_games.category = "хобби";
        computer_games.name = "Компьютерные игры";
        computer_games.description = "играть в комп";
        occupationList.add(computer_games);

        Occupation needlework = new Occupation();
        needlework.category = "хобби";
        needlework.name = "Рукоделие";
        needlework.description = "делать что-то совими руками";
        occupationList.add(needlework);


//СПОРТ
        Occupation workout = new Occupation();
        workout.category = "спорт";
        workout.name = "Разминка";
        workout.description = "Легкая активность";
        occupationList.add(workout);

        Occupation run = new Occupation();
        run.category = "спорт";
        run.name = "Пробежка";
        run.description = "лоооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооооо";
        occupationList.add(run);

        Occupation tennis = new Occupation();
        tennis.category = "спорт";
        tennis.name = "Теннис";
        tennis.description = "LOL! WHAT?!";
        occupationList.add(tennis);







        OccupationDB db = Room.databaseBuilder(context,
                OccupationDB.class, "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        occupationDAO = db.occupationDAO();
        occupationDAO.insertAll(occupationList);
    }

    public List<String> get_all_occupations(String categ){
        List<Occupation> all;

        all = occupationDAO.loadOccupationByCategoriesName(categ);
        List<String> all_occup = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_occup.add(all.get(i).name);
        }
        return all_occup;
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

    public OccupationDAO getOccupationDAO() {
        return occupationDAO;
    }
}
