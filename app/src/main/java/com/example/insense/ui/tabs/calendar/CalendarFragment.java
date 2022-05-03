package com.example.insense.ui.tabs.calendar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;

import com.example.insense.R;
import com.example.insense.databinding.FragmentCalendarBinding;

import java.util.Calendar;


public class CalendarFragment extends Fragment {

    private FragmentCalendarBinding fragmentCalendarBinding;
    private CalendarView calendarView;
    private Calendar calendar = Calendar.getInstance();
    int mHour=calendar.get(Calendar.HOUR_OF_DAY);
    int mMinute=calendar.get(Calendar.MINUTE);



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        fragmentCalendarBinding = FragmentCalendarBinding.inflate(inflater, container, false);
        fragmentCalendarBinding.buttonCalendarMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(CalendarFragment.this).navigate(R.id.action_calendarFragment_to_mainFragment);
            }
        });
        fragmentCalendarBinding.buttonCalendarProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(CalendarFragment.this).navigate(R.id.action_calendarFragment_to_profileFragment);
            }
        });
        fragmentCalendarBinding.buttonCalendarCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(CalendarFragment.this).navigate(R.id.action_calendarFragment_to_categoriesFragment);
            }
        });

        return fragmentCalendarBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       /* calendar.setFirstDayOfWeek(5);
        CalenderEvent calenderEvent = view.findViewById(R.id.calender_event);
        Event event = new Event(calendar.getTimeInMillis(), "Test");
        event.setEventText("lol");


        calenderEvent.addEvent(event);
        calenderEvent.initCalderItemClickCallback(dayContainerModel -> Log.d(")))))", dayContainerModel.getDate()));*/
    }
}