package com.example.insense.repository;

import android.content.Context;
import android.os.Build;

import java.time.*;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.repository.room.activityDB.Activity;
import com.example.insense.repository.room.activityDB.ActivityDAO;
import com.example.insense.repository.room.activityDB.ActivityDB;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivityRepository {
    ActivityDB db;
    ActivityDAO activityDao;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ActivityRepository(Context context){
        db = ActivityDB.getActivityDB(context.getApplicationContext());
        activityDao = db.activityDao();
    }

    public ActivityDB getDatabase(){
        return db;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<Activity> ActivitiesFromTo(LocalDateTime startDate,LocalDateTime endDate){


        ArrayList<Activity> allActivities;
        List<Activity> allGotActivities;
        ArrayList<Long> Activities = new ArrayList<>();
        allActivities = (ArrayList<Activity>) db.activityDao().getAll();
        for (Activity activity:allActivities) {
            if ((activity.startDate.getYear() == startDate.getYear()) && (activity.endDate.getYear() == endDate.getYear())) {
                Activities.add(activity.uid);
            }
        }
        allGotActivities = (List<Activity>) db.activityDao().loadAllByIds(Activities);
        Collections.sort(allGotActivities, new MyComparator ());
        return  allGotActivities;
    }
    class MyComparator implements Comparator<Activity> {
        @RequiresApi(api = Build.VERSION_CODES.O)
        @Override

        public int compare(Activity activity, Activity t1) {
            ZoneId zoneId = ZoneId.of("Europe/Moscow");

            ZonedDateTime zdt_start = ZonedDateTime.of(activity.startDate, zoneId);
            long millis_start = zdt_start.toInstant().toEpochMilli();

            ZonedDateTime zdt_start_1 = ZonedDateTime.of(t1.startDate, zoneId);
            long millis_start_1 = zdt_start_1.toInstant().toEpochMilli();

            return Long.compare(millis_start, millis_start_1);
        }
    }

    public List<Activity> all_activities(){
        List<Activity> all;

        all = activityDao.getAll();
        List<Activity> all_activities = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_activities.add(all.get(i));
        }
        return all_activities;
    }

    public List<String> activity_by_occupation(String occupation){
        List<Activity> all;

        all = activityDao.loadByOccupation(occupation);
        List<String> all_activities = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_activities.add(all.get(i).name);
        }
        return all_activities;
    }
}
