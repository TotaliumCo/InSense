package com.example.insense.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.repository.room.categoryDB.Category;
import com.example.insense.repository.room.categoryDB.CategoryDAO;
import com.example.insense.repository.room.categoryDB.CategoryDB;

import java.util.ArrayList;

public class CategoryRepository {

    CategoryDB db;
    CategoryDAO categoryDAO;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CategoryRepository(Context context){
        ArrayList<Category> categories = new ArrayList<Category>(){};

        Category sport = new Category();
        ArrayList<String> all_sports = new ArrayList<>();
        all_sports.add("ПРОБЕЖКА");
        all_sports.add("ПРЫЖКИ НА СКАКАЛКЕ");
        all_sports.add("ПРИСЕДАНИЯ");
        all_sports.add("РАЗМИНКА");
        all_sports.add("ЗАРЯДКА");
        all_sports.add("РАСТЯЖКА");
        sport.name = "спорт";
        sport.description = "физическая нагрузка";
//        sport.occupations = all_sports;

        Category music = new Category();
        ArrayList<String> all_music = new ArrayList<>();
        all_music.add("ИГРА НА ГИТАРЕ");
        all_music.add("ИГРА НА ФОРТЕПИАНО");
        all_music.add("СОЛЬФЕДЖИО");
        all_music.add("УЧИТЬ НОТЫ");
        all_music.add("ИГРА НА СКРИПКЕ");
        all_music.add("РАСТЯЖКА");
        music.name = "ПИСАТЬ МУЗЫКУ";
        music.description = "занятия музыкой";
  //      music.occupations = all_music;

        categories.add(sport);
        categories.add(music);

        CategoryDB db =  Room.databaseBuilder(context,
                CategoryDB.class, "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        categoryDAO = db.categoryDAO();
        categoryDAO.insertAll(categories);

    }
    public CategoryDB getDatabase(){
        return db;
    }
}
