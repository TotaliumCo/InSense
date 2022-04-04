package com.example.insense.repository;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.models.ColorCanvas;
import com.example.insense.models.Date;
import com.example.insense.repository.room.activityDB.Activity;
import com.example.insense.repository.room.activityDB.ActivityDAO;
import com.example.insense.repository.room.activityDB.ActivityDB;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ActivityRepository {
    ActivityDB db;
    ActivityDAO activityDao;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public ActivityRepository(Context context){

        Log.i("ACTIVEREPOSITORYCRATION", String.valueOf(context));
        List<Activity> activities = new ArrayList<Activity>(){};
        Activity earlyMorning = new Activity();
        earlyMorning.name = "Early walking with the dog";
        earlyMorning.description = "lol";
        earlyMorning.color =
                new ColorCanvas(255,200,140 ,89);
        earlyMorning.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        earlyMorning.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,2,0,0);
//
//
//        Activity breakfast = new Activity();
//        breakfast.name = "Breakfast";
//        breakfast.description = "lol";
//        breakfast.color =
//                new ColorCanvas(254,50,140,180);
//        breakfast.endDate =
//                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,2,0,0);
//        breakfast.startDate =
//                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,10,0,0);
//
//        if(earlyMorning.)
       activities.add(earlyMorning);
//        activities.add(breakfast);

        db = Room.databaseBuilder(context, ActivityDB.class, "database-name").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        activityDao = db.userDao();
        activityDao.insertAll(activities);

    }
    public ActivityDB getDatabase(){
        return db;
    }
    public List<Activity> ActivitiesFromTo(Date startDate,Date endDate){


          ArrayList<Activity> allActivities;
          List<Activity> allGotActivities;
          ArrayList<Long> Activities = new ArrayList<>();
          allActivities = (ArrayList<Activity>) db.userDao().getAll();
          for (Activity activity:allActivities) {
              if((activity.startDate.getSecs() >= startDate.getSecs()) && (activity.endDate.getSecs() <= endDate.getSecs())){
                  Activities.add(activity.uid);
              }
          }
          allGotActivities = (List<Activity>) db.userDao().loadAllByIds(Activities);
          Collections.sort(allGotActivities, new MyComparator ());
          return  allGotActivities;
    }
    class MyComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity activity, Activity t1) {
            return Long.compare(activity.startDate.getSecs(),t1.startDate.getSecs());
        }
    }
}
