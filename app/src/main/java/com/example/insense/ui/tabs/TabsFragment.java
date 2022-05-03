package com.example.insense.ui.tabs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.insense.R;
import com.example.insense.databinding.FragmentTabsBinding;

public class TabsFragment extends Fragment {
    FragmentTabsBinding fragmentTabsBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentTabsBinding = FragmentTabsBinding.inflate(inflater,container,false);
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.tabsContainer);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(fragmentTabsBinding.bottomNavigationView,navController);
        return fragmentTabsBinding.getRoot();

    }
}
