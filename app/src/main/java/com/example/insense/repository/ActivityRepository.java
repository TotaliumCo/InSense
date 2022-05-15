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
import com.example.insense.repository.room.occupationDB.Occupation;

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

        Activity learn_new_song = new Activity();
        learn_new_song.name = "Учить новую мелодию";
        learn_new_song.description = "lol";
        learn_new_song.occupation = "Игра на пианино";
        learn_new_song.color =
                new ColorCanvas(255,200,140 ,89);
        learn_new_song.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        learn_new_song.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,1,0);
        activities.add(learn_new_song);


        Activity repeat_learned_songs = new Activity();
        repeat_learned_songs.name = "Повторять изученные песни";
        repeat_learned_songs.description = "lol";
        repeat_learned_songs.occupation = "Игра на пианино";
        repeat_learned_songs.color =
                new ColorCanvas(255,200,140 ,89);
        repeat_learned_songs.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        repeat_learned_songs.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,1,0);
        activities.add(repeat_learned_songs);

        Activity make_tune = new Activity();
        make_tune.name = "Придумывать мелодию";
        make_tune.description = "lol";
        make_tune.occupation = "Игра на пианино";
        make_tune.color =
                new ColorCanvas(255,200,140 ,89);
        make_tune.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        make_tune.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,1,0);
        activities.add(make_tune);

//РИСОВАНИЕ
        Activity draw_sketches = new Activity();
        draw_sketches.name = "Рисовать скетчи";
        draw_sketches.description = "lol";
        draw_sketches.occupation = "Рисование";
        draw_sketches.color =
                new ColorCanvas(255,200,140 ,89);
        draw_sketches.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        draw_sketches.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,1,0);
        activities.add(draw_sketches);


        Activity draw_portraits = new Activity();
        draw_portraits.name = "Рисовать портреты";
        draw_portraits.description = "lol";
        draw_portraits.occupation = "Рисование";
        draw_portraits.color =
                new ColorCanvas(255,200,140 ,89);
        draw_portraits.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        draw_portraits.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,1,0);
        activities.add(draw_portraits);


        Activity learn_drawing_techniques = new Activity();
        learn_drawing_techniques.name = "Учить новые техники";
        learn_drawing_techniques.description = "lol";
        learn_drawing_techniques.occupation = "Рисование";
        learn_drawing_techniques.color =
                new ColorCanvas(255,200,140 ,89);
        learn_drawing_techniques.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        learn_drawing_techniques.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,1,0);
        activities.add(learn_drawing_techniques);

//ЧТЕНИЕ
        Activity read_articles = new Activity();
        read_articles.name = "Читать статьи";
        read_articles.description = "lol";
        read_articles.occupation = "Чтение";
        read_articles.color =
                new ColorCanvas(255,200,140 ,89);
        read_articles.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        read_articles.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,1,0);
       activities.add(read_articles);


        Activity read_fiction = new Activity();
        read_fiction.name = "Читать художественную литературу";
        read_fiction.description = "lol";
        read_fiction.occupation = "Чтение";
        read_fiction.color =
                new ColorCanvas(255,200,140 ,89);
        read_fiction.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        read_fiction.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,1,0);
        activities.add(read_fiction);


        Activity read_nonfiction = new Activity();
        read_nonfiction.name = "Читать научную литературу";
        read_nonfiction.description = "lol";
        read_nonfiction.occupation = "Чтение";
        read_nonfiction.color =
                new ColorCanvas(255,200,140 ,89);
        read_nonfiction.endDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,0,0);
        read_nonfiction.startDate =
                new com.example.insense.models.Date(Calendar.YEAR,Calendar.DAY_OF_YEAR,0,1,0);
        activities.add(read_nonfiction);


        db = Room.databaseBuilder(context, ActivityDB.class, "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
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

    public List<String> activity_by_category(String occupation){
        List<Activity> all;

        all = activityDao.loadByOccupation(occupation);
        List<String> all_activities = new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            all_activities.add(all.get(i).name);
        }
        return all_activities;
    }
}
