package com.example.insense.ui.fragments.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentProfileBinding;
import com.example.insense.ui.fragments.Login.LoginViewModel;
import com.firebase.ui.auth.AuthUI;


public class ProfileFragment extends Fragment {
    private FragmentProfileBinding fragmentProfileBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentProfileBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile,container,false);

        fragmentProfileBinding = FragmentProfileBinding.inflate(inflater, container, false);
        fragmentProfileBinding.buttonToSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this).navigate(R.id.action_profileFragment_to_settingsFragment);
            }
        });
        fragmentProfileBinding.buttonProfileMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this).navigate(R.id.action_profileFragment_to_mainFragment);
            }
        });
        fragmentProfileBinding.buttonProfileCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this).navigate(R.id.action_profileFragment_to_calendarFragment);
            }
        });
        fragmentProfileBinding.buttonProfileCategories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(ProfileFragment.this).navigate(R.id.action_profileFragment_to_categoriesFragment);
            }
        });
        return fragmentProfileBinding.getRoot();
    }

}