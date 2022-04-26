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
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = new Bundle();
        fragmentCategoriesBinding = FragmentCategoriesBinding.inflate(inflater, container, false);

        fragmentCategoriesBinding.buttonCategoriesMain.setOnClickListener(v -> NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_mainFragment));
        fragmentCategoriesBinding.buttonCategoriesProfile.setOnClickListener(v -> NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_profileFragment));
        fragmentCategoriesBinding.buttonCategoriesCalendar.setOnClickListener(v -> NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_calendarFragment));


        fragmentCategoriesBinding.buttonSport.setOnClickListener(v -> {
            bundle.putString("arg1", "семья");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
        });

        fragmentCategoriesBinding.buttonSport.setOnClickListener(v -> {
            bundle.putString("arg1", "спорт");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonMusic.setOnClickListener(v -> {
            bundle.putString("arg1", "музыка");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonStudy.setOnClickListener(v -> {
            bundle.putString("arg1", "учеба");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonWork.setOnClickListener(v -> {
            bundle.putString("arg1", "работа");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonHobby.setOnClickListener(v -> {
            bundle.putString("arg1", "хобби");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonFamily.setOnClickListener(v -> {

            bundle.putString("arg1", "семья");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonFamily.setOnClickListener(v -> fragmentCategoriesBinding.buttonOther.setOnClickListener(v1 -> {

            bundle.putString("arg1", "другое");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment_to_categoryFragment, bundle);
        }));
        return fragmentCategoriesBinding.getRoot();

    }
}
