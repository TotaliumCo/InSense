package com.example.insense.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.models.Date;
import com.example.insense.repository.room.activityDB.Activity;
import com.example.insense.repository.room.categoryDB.Category;
import com.example.insense.repository.room.categoryDB.CategoryDAO;
import com.example.insense.repository.room.categoryDB.CategoryDB;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        sport.name_categ = "спорт";
        sport.description_categ = "физическая нагрузка";
        sport.occupations = all_sports;

        Category music = new Category();
        ArrayList<String> all_music = new ArrayList<>();
        all_music.add("ИГРА НА ГИТАРЕ");
        all_music.add("ИГРА НА ФОРТЕПИАНО");
        all_music.add("СОЛЬФЕДЖИО");
        all_music.add("УЧИТЬ НОТЫ");
        all_music.add("ИГРА НА СКРИПКЕ");
        all_music.add("РАСТЯЖКА");
        music.name_categ = "ПИСАТЬ МУЗЫКУ";
        music.description_categ = "занятия музыкой";
        music.occupations = all_music;

        categories.add(sport);
        categories.add(music);

        CategoryDB db =  Room.databaseBuilder(context.getApplicationContext(),
                CategoryDB.class, "database").build();
        categoryDAO = db.user_categ();
        /*categoryDAO.insertAll(categories);*/

    }
    public List<String> all_categories_return(String name_categ){
        ArrayList<Category> categories = new ArrayList<Category>(){};

        Category sport = new Category();
        ArrayList<String> all_sports = new ArrayList<>();
        all_sports.add("ПРОБЕЖКА");
        all_sports.add("ПРЫЖКИ НА СКАКАЛКЕ");
        all_sports.add("ПРИСЕДАНИЯ");
        all_sports.add("РАЗМИНКА");
        all_sports.add("ЗАРЯДКА");
        all_sports.add("РАСТЯЖКА");
        sport.name_categ = "спорт";
        sport.description_categ = "физическая нагрузка";
        sport.occupations = all_sports;
        categories.add(sport);


        /*categories = (ArrayList<Category>) db.user_categ().getAll();*/

        for(int i = 0; i < categories.size(); i++){
            if(categories.get(i).name_categ.equals("sports")){
                return  categories.get(i).occupations;
            }


        }
        return  categories.get(0).occupations;

        /*allGotActivities = (List<Activity>) db.userDao().loadAllByIds(Activities);
        Collections.sort(allGotActivities, new ActivityRepository.MyComparator());
        return  allGotActivities;*/
    }
    public CategoryDB getDatabase(){
        return db;
    }

}
