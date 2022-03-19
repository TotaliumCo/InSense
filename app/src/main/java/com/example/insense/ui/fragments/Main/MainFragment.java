package com.example.insense.ui.fragments.Main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentMainBinding;


public class MainFragment extends Fragment {

    private FragmentMainBinding fragmentMainBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
        fragmentMainBinding.buttonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("RRRR","Profile click");
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_profileFragment);
            }
        });
        fragmentMainBinding.buttonMainProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_profileFragment);
            }
        });
        fragmentMainBinding.buttonMainCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_calendarFragment);
            }
        });
        fragmentMainBinding.buttonMainCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MainFragment.this).navigate(R.id.action_mainFragment_to_categoriesFragment);
            }
        });
        return fragmentMainBinding.getRoot();

    }

   /* @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentMainBinding.button5.setOnClickListener(view1 -> { Navigation.findNavController(view).navigate(R.id.profileFragment);});
    }*/

}