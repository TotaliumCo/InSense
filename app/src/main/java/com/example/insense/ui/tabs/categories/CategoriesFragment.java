package com.example.insense.ui.tabs.categories;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentCategoriesBinding;


public class CategoriesFragment extends Fragment {

    private FragmentCategoriesBinding fragmentCategoriesBinding;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new Bundle();
        fragmentCategoriesBinding = FragmentCategoriesBinding.inflate(inflater, container, false);
        buttonsBinding(new Bundle());
        return fragmentCategoriesBinding.getRoot();

    }

    private void buttonsBinding(Bundle bundle) {
        fragmentCategoriesBinding.buttonSport.setOnClickListener(v -> {
            bundle.putString("arg1", "спорт");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment2_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonMusic.setOnClickListener(v -> {
            bundle.putString("arg1", "музыка");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment2_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonStudy.setOnClickListener(v -> {
            bundle.putString("arg1", "учеба");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment2_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonWork.setOnClickListener(v -> {
            bundle.putString("arg1", "работа");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment2_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonHobby.setOnClickListener(v -> {
            bundle.putString("arg1", "хобби");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment2_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonFamily.setOnClickListener(v -> {

            bundle.putString("arg1", "семья");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment2_to_categoryFragment, bundle);
        });
        fragmentCategoriesBinding.buttonOther.setOnClickListener(v -> {

            bundle.putString("arg1", "другое");
            NavHostFragment.findNavController(CategoriesFragment.this).navigate(R.id.action_categoriesFragment2_to_categoryFragment, bundle);
        });
    }
}