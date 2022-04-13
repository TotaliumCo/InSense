package com.example.insense.application;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.CategoryRepository;
import com.example.insense.repository.room.activityDB.ActivityDB;
import com.example.insense.repository.room.categoryDB.CategoryDAO;
import com.example.insense.repository.room.categoryDB.CategoryDB;

public class App extends Application {
    public static App instance;

    private ActivityDB database;
    private CategoryDB database_category;

    private ActivityRepository activityRepository;
    private CategoryRepository categoryRepository;


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database_category = Room.databaseBuilder(this, CategoryDB.class, "database_category")
                .build();

        activityRepository = new ActivityRepository(getApplicationContext());
        database = activityRepository.getDatabase();

        categoryRepository = new CategoryRepository(getApplicationContext());
        database_category = categoryRepository.getDatabase();
    }


    public CategoryDB getDatabase_categ() {
        return database_category;
    }
    public CategoryRepository getCategoryRepository(){
        return categoryRepository;
    }
    public CategoryDB getDatabase_category(){
        return database_category;
    }

    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }

    public static App getInstance() {
        return instance;
    }

    /*public ActivityDB getDatabase() {
        return database;
    }*/
}
