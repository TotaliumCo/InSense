package com.example.insense.ui.fragments.Categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentCategoriesBinding;
import com.example.insense.ui.fragments.Calendar.CalendarFragment;


public class CategoriesFragment extends Fragment {

    private FragmentCategoriesBinding fragmentCategoriesBinding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCategoriesBinding = FragmentCategoriesBinding.inflate(inflater, container, false);
        fragmentCategoriesBinding.buttonCategoriesMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_mainFragment);
            }
        });
        fragmentCategoriesBinding.buttonCategoriesProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_profileFragment);
            }
        });
        fragmentCategoriesBinding.buttonCategoriesCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_calendarFragment);
            }
        });
        return fragmentCategoriesBinding.getRoot();
    }
}