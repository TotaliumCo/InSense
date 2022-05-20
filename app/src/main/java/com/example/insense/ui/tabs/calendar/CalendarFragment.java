package com.example.insense.ui.tabs.calendar;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.insense.R;
import com.example.insense.application.App;
import com.example.insense.databinding.FragmentCalendarBinding;
import com.example.insense.models.ColorCanvas;
import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.room.activityDB.Activity;
import com.example.insense.repository.room.activityDB.ActivityDAO;
import com.skyhope.eventcalenderlibrary.CalenderEvent;
import com.skyhope.eventcalenderlibrary.listener.CalenderDayClickListener;
import com.skyhope.eventcalenderlibrary.model.DayContainerModel;
import com.skyhope.eventcalenderlibrary.model.Event;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.List;


public class CalendarFragment extends Fragment {

    private FragmentCalendarBinding fragmentCalendarBinding;
    private CalendarView calendarView;
    private Calendar calendar = Calendar.getInstance();


    ActivityDAO activityDao;
    ActivityRepository repository_activity = App.instance.getActivityRepository();
    List<Activity> all;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/*
        Activity draw_sketches = new Activity();
        draw_sketches.name = "Рисовать скетчи";
        draw_sketches.description = "lol";
        draw_sketches.occupation = "Рисование";
        draw_sketches.color =
                new ColorCanvas(255,200,140 ,89);
        LocalDateTime date_end = LocalDateTime.of(2022, 5, 1, 15, 30, 24);
        draw_sketches.endDate =date_end;
        LocalDateTime date_start = LocalDateTime.of(2022, 7, 10, 16, 30, 24);
        draw_sketches.startDate = date_start;
        activities.add(draw_sketches);
*/



    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        fragmentCalendarBinding = FragmentCalendarBinding.inflate(inflater, container, false);

        all = repository_activity.all_activities();

        /*for(int i = 0; i < all.size(); i++) {
            ZoneId zoneId = ZoneId.of("Europe/Moscow");
            ZonedDateTime zdt = ZonedDateTime.of(all.get(i).endDate, zoneId);
            long millis = zdt.toInstant().toEpochMilli();
            Event event = new Event(millis, all.get(i).name);
            fragmentCalendarBinding.calenderEvent.addEvent(event);
        }*/
/*                Event event = new Event(tim*1000, all.get(3).name);

        fragmentCalendarBinding.calenderEvent.addEvent(event);*/



    /*    TextView textView_name_of_occupation = (TextView) view1.findViewById(R.id.name_of_occupation);
        TextView textView_time_start_end = (TextView) view1.findViewById(R.id.time_start_end);
        TextView textView_description_of_activity = (TextView) view1.findViewById(R.id.description_of_activity);*/




        fragmentCalendarBinding. calenderEvent.initCalderItemClickCallback(dayContainerModel -> {
            Log.i("LOL", "onCreateView: ");
            CalenderEvent calenderEvent = container.findViewById(R.id.calender_event);




            ScrollView scrollView = container.findViewById(R.id.scroll_calendar_event);
            LinearLayout layout =  container.findViewById(R.id.layout_all_activities_in_one_day);
            layout.removeAllViews();
            for(int i = 0; i < all.size(); i++) {
                ZoneId zoneId = ZoneId.of("Europe/Moscow");
                ZonedDateTime zdt = ZonedDateTime.of(all.get(i).endDate, zoneId);
                long millis = zdt.toInstant().toEpochMilli();
                Event event = new Event(millis, all.get(i).name, Color.rgb(255, 255, 255 ));
                Log.d("RRR",all.get(i).name);

                fragmentCalendarBinding.calenderEvent.addEvent(event);
                dayContainerModel.setEvent(event);




                if (dayContainerModel.isHaveEvent() && dayContainerModel.getDay() == all.get(i).endDate.getDayOfMonth() && dayContainerModel.getYear() == all.get(i).endDate.getYear() && dayContainerModel.getMonthNumber()+1 == all.get(i).endDate.getMonthValue()) {
                    /*layout.removeAllViews();*/

                    View view1 = getLayoutInflater().inflate(R.layout.actions_calendar, null, false);
                    TextView textView_name_of_activity =  view1.findViewById(R.id.name_of_activity);
                    TextView textView_description_of_activity =  view1.findViewById(R.id.description_of_activity);
                    TextView textView_name_of_occupation =  view1.findViewById(R.id.name_of_occupation);
                    TextView textView_time_start_end = view1.findViewById(R.id.time_start_end);
                    String str = all.get(i).startDate.getHour() + ":" + all.get(i).startDate.getMinute() + " - " + all.get(i).endDate.getHour() + ":" + all.get(i).endDate.getMinute();


                    textView_name_of_activity.setText(dayContainerModel.getEvent().getEventText());
                    textView_description_of_activity.setText(getString(R.string.calendar_description, all.get(i).description));
                    textView_name_of_occupation.setText( getString(R.string.calendar_occupation, all.get(i).occupation));
                    textView_time_start_end.setText(getString(R.string.calendar_time,  str));


                    layout.addView(view1);

                    Log.d("jjjjj", dayContainerModel.getEvent().getEventText());


                } else {

                }
            }
        });
        return fragmentCalendarBinding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}