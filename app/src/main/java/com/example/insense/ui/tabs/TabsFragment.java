package com.example.insense.ui.tabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.insense.R;
import com.example.insense.databinding.FragmentTabsBinding;
import com.google.android.material.navigation.NavigationBarView;

public class TabsFragment extends Fragment {
    FragmentTabsBinding fragmentTabsBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this,callback);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentTabsBinding = FragmentTabsBinding.inflate(inflater, container, false);
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.tabsContainer);
        assert navHostFragment != null;
        NavController navController = navHostFragment.getNavController();
        navController.addOnDestinationChangedListener((navController1, navDestination, bundle) -> {
            if(navDestination.getId() == R.id.activityFragment){
                fragmentTabsBinding.bottomNavigationView.setVisibility(View.GONE);
            }else{
                fragmentTabsBinding.bottomNavigationView.setVisibility(View.VISIBLE);
            }
        });

        NavigationUI.setupWithNavController(fragmentTabsBinding.bottomNavigationView, navController);
        return fragmentTabsBinding.getRoot();

    }
}

