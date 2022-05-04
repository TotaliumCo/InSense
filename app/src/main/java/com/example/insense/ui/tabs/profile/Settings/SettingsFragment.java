package com.example.insense.ui.tabs.profile.Settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.insense.R;
import com.example.insense.databinding.FragmentSettingsBinding;


public class SettingsFragment extends Fragment {
    private FragmentSettingsBinding fragmentSettingsBinding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentSettingsBinding = FragmentSettingsBinding.inflate(inflater, container, false);
        fragmentSettingsBinding.buttonBackSettings.setOnClickListener(v -> NavHostFragment
                .findNavController(SettingsFragment.this).popBackStack());
        return fragmentSettingsBinding.getRoot();
    }
}