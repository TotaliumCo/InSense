package com.example.insense.application;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.room.AppDB;

public class App extends Application {
    public static App instance;

    private AppDB database;

    private ActivityRepository activityRepository;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        activityRepository = new ActivityRepository(getApplicationContext());
        database = activityRepository.getDatabase();
    }

    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }

    public static App getInstance() {
        return instance;
    }

    public AppDB getDatabase() {
        return database;
    }
}
