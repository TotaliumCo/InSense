package com.example.insense.repository;

import android.content.Context;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.repository.room.categoryDB.Category;
import com.example.insense.repository.room.categoryDB.CategoryDAO;
import com.example.insense.repository.room.categoryDB.CategoryDB;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    CategoryDB db;
    CategoryDAO categoryDAO;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public CategoryRepository(Context context) {
        ArrayList<Category> categories = new ArrayList<Category>() {
        };

        Category temp = new Category();
        temp.name = "Работа";
        temp.description = "всё что связано с работой";
        categories.add(temp);
        temp.name = "Хобби";
        temp.description = "всё что связано с работой";
        categories.add(temp);
        temp.name = "Отношения";
        temp.description = "всё что связано с работой";
        categories.add(temp);
        temp.name = "Семья";
        temp.description = "всё что связано с работой";
        categories.add(temp);
        temp.name = "Животные";
        temp.description = "всё что связано с работой";
        categories.add(temp);
        temp.name = "Путешествия";
        temp.description = "всё что связано с работой";
        categories.add(temp);
        temp.name = "Мероприятия";
        temp.description = "всё что связано с работой";
        categories.add(temp);




        db = Room.databaseBuilder(context,
                CategoryDB.class, "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        categoryDAO = db.categoryDAO();
        categoryDAO.insertAll(categories);

    }

    public CategoryDB getDatabase() {
        return db;
    }
}
