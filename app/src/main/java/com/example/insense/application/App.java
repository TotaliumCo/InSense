package com.example.insense.application;

import android.app.Application;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.OccupationRepository;
import com.example.insense.services.time.GlobalTimer;

public class App extends Application {
    public static App instance;

    private ActivityRepository activityRepository;
    private OccupationRepository occupationRepository;

    private GlobalTimer globalTimer;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        globalTimer = new GlobalTimer();
        activityRepository = new ActivityRepository(getApplicationContext());
        occupationRepository = new OccupationRepository(getApplicationContext());
    }

    public ActivityRepository getActivityRepository() {
        return activityRepository;
    }
    public OccupationRepository getOccupationRepository() { return occupationRepository; }
    public GlobalTimer getGlobalTimer() { return globalTimer; }
    public static App getInstance() {
        return instance;
    }
}
