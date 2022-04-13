package com.example.insense.application;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.room.activityDB.ActivityDB;
import com.example.insense.services.time.GlobalTimer;

public class App extends Application {
    public static App instance;

    private ActivityDB database;

    private ActivityRepository activityRepository;

    private GlobalTimer globalTimer;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        globalTimer = new GlobalTimer();

        activityRepository = new ActivityRepository(getApplicationContext());
        database = activityRepository.getDatabase();
        globalTimer.setTimerByActivity(database.userDao().loadById(1));
    }

    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }

    public static App getInstance() {
        return instance;
    }

    public ActivityDB getDatabase() {
        return database;
    }

    public GlobalTimer getGlobalTimer() {
        return globalTimer; }
}
