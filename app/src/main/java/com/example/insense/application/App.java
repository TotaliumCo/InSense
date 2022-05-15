package com.example.insense.application;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.CategoryRepository;
import com.example.insense.repository.OccupationRepository;
import com.example.insense.repository.room.activityDB.ActivityDB;
import com.example.insense.repository.room.occupationDB.Occupation;
import com.example.insense.services.time.GlobalTimer;

public class App extends Application {
    public static App instance;

    private ActivityRepository activityRepository;
    private OccupationRepository occupationRepository;
    private CategoryRepository categoryRepository;

    private GlobalTimer globalTimer;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        globalTimer = new GlobalTimer();
        activityRepository = new ActivityRepository(getApplicationContext());
        occupationRepository = new OccupationRepository(getApplicationContext());
        categoryRepository = new CategoryRepository(getApplicationContext());
        globalTimer.setTimerByActivity(activityRepository.getDatabase().userDao().loadById(1));
    }

    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }
    public OccupationRepository getOccupationRepository() { return occupationRepository; }
    public CategoryRepository getCategoryRepository() { return categoryRepository; }
    public GlobalTimer getGlobalTimer() { return globalTimer; }
    public static App getInstance() {
        return instance;
    }
}
