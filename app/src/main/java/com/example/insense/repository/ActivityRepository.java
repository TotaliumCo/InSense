package com.example.insense.repository;

import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.time.Instant;
import java.time.*;

import androidx.annotation.RequiresApi;
import androidx.room.Room;

import com.example.insense.models.ColorCanvas;
import com.example.insense.models.Date;
import com.example.insense.repository.room.activityDB.Activity;
import com.example.insense.repository.room.activityDB.ActivityDAO;
import com.example.insense.repository.room.activityDB.ActivityDB;
import com.example.insense.repository.room.occupationDB.Occupation;

import java.time.LocalDateTime;
import java.time.Month;
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

//ИГРА НА ПИАНИНО
        Activity learn_new_song = new Activity();
        learn_new_song.name = "Учить новую мелодию";
        learn_new_song.description = "lol";
        learn_new_song.occupation = "Игра на пианино";
        learn_new_song.color =
                new ColorCanvas(255,200,140 ,89);
        LocalDateTime date_end = LocalDateTime.of(2022, 6, 10, 13, 30, 24);

        ZoneId zoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime zdt = ZonedDateTime.of(date_end, zoneId);
        long millis = zdt.toInstant().toEpochMilli();

        learn_new_song.endDate = date_end;

        LocalDateTime date_start = LocalDateTime.of(2022, 6, 10, 12, 30, 24);
        learn_new_song.startDate = date_start;
        activities.add(learn_new_song);


        Activity repeat_learned_songs = new Activity();
        repeat_learned_songs.name = "Повторять изученные песни";
        repeat_learned_songs.description = "lol";
        repeat_learned_songs.occupation = "Игра на пианино";
        repeat_learned_songs.color =
                new ColorCanvas(255,200,140 ,89);
        date_end = LocalDateTime.of(2022, 6, 10, 14, 30, 24);
        repeat_learned_songs.endDate =date_end;
        date_start = LocalDateTime.of(2022, 6, 10, 13, 30, 24);
        repeat_learned_songs.startDate = date_start;
        activities.add(repeat_learned_songs);

        Activity make_tune = new Activity();
        make_tune.name = "Придумывать мелодию";
        make_tune.description = "по видеоурокам";
        make_tune.occupation = "Игра на пианино";
        make_tune.color =
                new ColorCanvas(255,200,140 ,89);
        date_end = LocalDateTime.of(2022, 5, 1, 12, 50, 24);
        make_tune.endDate =date_end;
        date_start = LocalDateTime.of(2022, 7, 10, 12, 30, 24);
        make_tune.startDate = date_start;
        activities.add(make_tune);

//РИСОВАНИЕ
        Activity draw_sketches = new Activity();
        draw_sketches.name = "Рисовать скетчи";
        draw_sketches.description = "занятие с учителем";
        draw_sketches.occupation = "Рисование";
        draw_sketches.color =
                new ColorCanvas(255,200,140 ,89);
        date_end = LocalDateTime.of(2022, 5, 1, 16, 30, 24);
        draw_sketches.endDate =date_end;
        date_start = LocalDateTime.of(2022, 7, 10, 15, 30, 24);
        draw_sketches.startDate = date_start;
        activities.add(draw_sketches);


        Activity draw_portraits = new Activity();
        draw_portraits.name = "Рисовать портреты";
        draw_portraits.description = "lol";
        draw_portraits.occupation = "Рисование";
        draw_portraits.color =
                new ColorCanvas(255,200,140 ,89);
        date_end = LocalDateTime.of(2022, 6, 10, 15, 30, 24);
        draw_portraits.endDate =date_end;
        date_start = LocalDateTime.of(2022, 7, 10, 12, 30, 24);
        draw_portraits.startDate = date_start;
        activities.add(draw_portraits);


        Activity learn_drawing_techniques = new Activity();
        learn_drawing_techniques.name = "Учить новые техники";
        learn_drawing_techniques.description = "lol";
        learn_drawing_techniques.occupation = "Рисование";
        learn_drawing_techniques.color =
                new ColorCanvas(255,200,140 ,89);
        date_end = LocalDateTime.of(2022, 6, 10, 14, 30, 24);
        learn_drawing_techniques.endDate =date_end;
        date_start = LocalDateTime.of(2022, 7, 10, 12, 30, 24);
        learn_drawing_techniques.startDate = date_start;
        activities.add(learn_drawing_techniques);

//ЧТЕНИЕ
        Activity read_articles = new Activity();
        read_articles.name = "Читать статьи";
        read_articles.description = "lol";
        read_articles.occupation = "Чтение";
        read_articles.color =
                new ColorCanvas(255,200,140 ,89);
        date_end = LocalDateTime.of(2022, 6, 10, 17, 30, 24);
        read_articles.endDate =date_end;
        date_start = LocalDateTime.of(2022, 7, 10, 12, 30, 24);
        read_articles.startDate = date_start;
        activities.add(read_articles);


        Activity read_fiction = new Activity();
        read_fiction.name = "Читать художественную литературу";
        read_fiction.description = "lol";
        read_fiction.occupation = "Чтение";
        read_fiction.color =
                new ColorCanvas(255,200,140 ,89);
        date_end = LocalDateTime.of(2022, 6, 10, 18, 30, 24);
        read_fiction.endDate =date_end;
        date_start = LocalDateTime.of(2022, 7, 10, 17, 30, 24);
        read_fiction.startDate = date_start;
        activities.add(read_fiction);

        Activity exercises = new Activity();
        exercises.name = "Упражнения для спины";
        exercises.description = "lol";
        exercises.occupation = "Разминка";
        exercises.color =
                new ColorCanvas(255,200,140 ,89);
        date_end = LocalDateTime.of(2022, 5, 23, 18, 30, 24);
        exercises.endDate =date_end;
        date_start = LocalDateTime.of(2022, 5, 23, 17, 30, 24);
        exercises.startDate = date_start;
        activities.add(exercises);



        Activity read_nonfiction = new Activity();
        read_nonfiction.name = "Читать научную литературу";
        read_nonfiction.description = "lol";
        read_nonfiction.occupation = "Чтение";
        read_nonfiction.color =
                new ColorCanvas(255,200,140 ,89);
        date_end = LocalDateTime.of(2022, 5, 10, 20, 30, 24);
        read_nonfiction.endDate =date_end;
        date_start = LocalDateTime.of(2022, 7, 10, 23, 35, 24);
        read_nonfiction.startDate = date_start;
        activities.add(read_nonfiction);


        db = Room.databaseBuilder(context, ActivityDB.class, "database").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        activityDao = db.userDao();
        activityDao.insertAll(activities);

    }

    public ActivityDB getDatabase(){
        return db;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<Activity> ActivitiesFromTo(Date startDate, Date endDate){


        ArrayList<Activity> allActivities;
        List<Activity> allGotActivities;
        ArrayList<Long> Activities = new ArrayList<>();
        allActivities = (ArrayList<Activity>) db.userDao().getAll();
        for (Activity activity:allActivities) {
            ZoneId zoneId = ZoneId.of("Europe/Moscow");
            ZonedDateTime zdt_end = ZonedDateTime.of(activity.endDate, zoneId);
            long millis_end = zdt_end.toInstant().toEpochMilli();


            ZonedDateTime zdt_start = ZonedDateTime.of(activity.startDate, zoneId);
            long millis_start = zdt_start.toInstant().toEpochMilli();

            if ((millis_start >= startDate.getSecs()) && (millis_end <= endDate.getSecs())) {

                Activities.add(activity.uid);
            }
        }
        allGotActivities = (List<Activity>) db.userDao().loadAllByIds(Activities);
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
