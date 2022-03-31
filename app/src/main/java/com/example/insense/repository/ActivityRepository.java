package com.example.insense.repository;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.repository.room.Activity;
import com.example.insense.repository.room.ActivityDAO;
import com.example.insense.repository.room.AppDB;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ActivityRepository {
    AppDB db;
    ActivityDAO activityDao;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ActivityRepository(Context context){

        List<Activity> activities = new ArrayList<Activity>(){};

        Activity earlyMorning = new Activity();

        earlyMorning.name = "Early walking with the dog";
        earlyMorning.description = "lol";
        earlyMorning.red = 140;
        earlyMorning.blue = 80;
        earlyMorning.green = 50;
        earlyMorning.al = 255;
        earlyMorning.startYear = 2022;
        earlyMorning.startDay = 200;
        earlyMorning.startHour = 0;
        earlyMorning.startMinute = 43;
        earlyMorning.startSec = 23;
        earlyMorning.endYear = 2022;
        earlyMorning.endDay = 200;
        earlyMorning.endHour = 6;
        earlyMorning.endMinute = 43;
        earlyMorning.endSec = 23;




        Activity breakfast = new Activity();

        breakfast.name = "Breakfast";
        breakfast.description = "lol";
        breakfast.red = 50;
        breakfast.blue = 180;
        breakfast.green = 140;
        breakfast.al = 254;
        breakfast.startYear = 2022;
        breakfast.startDay = 200;
        breakfast.startHour = 7;
        breakfast.startMinute = 43;
        breakfast.startSec = 23;
        breakfast.endYear = 2022;
        breakfast.endDay = 200;
        breakfast.endHour = 23;
        breakfast.endMinute = 43;
        breakfast.endSec = 23;

        activities.add(earlyMorning);
        activities.add(breakfast);


        db = Room.databaseBuilder(context, AppDB.class, "database-name").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        activityDao = db.userDao();
        activityDao.insertAll(activities);
           }
    public AppDB getDatabase(){
        return db;
    }
}
