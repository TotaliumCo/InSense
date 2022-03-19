package com.example.insense.ui.fragments.Calendar;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentCalendarBinding;


public class CalendarFragment extends Fragment {

    private FragmentCalendarBinding fragmentCalendarBinding;

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
}