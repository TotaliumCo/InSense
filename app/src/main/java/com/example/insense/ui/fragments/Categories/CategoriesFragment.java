package com.example.insense.ui.fragments.Categories;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        Bundle bundle = new Bundle();
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




        fragmentCategoriesBinding.buttonSport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("arg1", "sport");
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
            }
        });
        fragmentCategoriesBinding.buttonMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("arg1", "music");
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
            }
        });
        fragmentCategoriesBinding.buttonStudy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("arg1", "study");
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
            }
        });
        fragmentCategoriesBinding.buttonWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("arg1", "work");
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
            }
        });
        fragmentCategoriesBinding.buttonHobby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bundle.putString("arg1", "hobby");
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
            }
        });
        fragmentCategoriesBinding.buttonFamily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("arg1", "family");
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment,bundle);
            }
        });

        fragmentCategoriesBinding.buttonOther.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bundle.putString("arg1", "other");
                NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
            }
        });

        return fragmentCategoriesBinding.getRoot();

    }
}