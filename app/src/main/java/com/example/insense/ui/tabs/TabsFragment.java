package com.example.insense.ui.tabs;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavOptions;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.insense.R;
import com.example.insense.databinding.FragmentTabsBinding;
import com.google.android.material.navigation.NavigationBarView;

public class TabsFragment extends Fragment {
    FragmentTabsBinding fragmentTabsBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentTabsBinding = FragmentTabsBinding.inflate(inflater, container, false);
        NavHostFragment navHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.tabsContainer);
        NavController navController = navHostFragment.getNavController();
        NavOptions options = new NavOptions.Builder()
                .setLaunchSingleTop(true)
                .setEnterAnim(R.anim.enter_from_bottom)
                .setExitAnim(R.anim.exit_to_top)
                .setPopEnterAnim(R.anim.enter_from_top)
                .setPopExitAnim(R.anim.exit_to_bottom)
                .setPopUpTo(navController.getGraph().getStartDestinationId(), false)
                .build();

        fragmentTabsBinding.bottomNavigationView.setOnItemSelectedListener((NavigationBarView.OnItemSelectedListener)
                item -> {
                    if(item.getItemId()==0){
                        Log.i("NAVtabs", "onCreateView: toclocknavigated1");
                        navController.navigate(R.id.clocks,savedInstanceState,options);
                    }else if (item.getItemId()==1){
                        Log.i("NAVtabs", "onCreateView: toclocknavigated2");
                        navController.navigate(R.id.calendar,savedInstanceState,options);
                    }else if (item.getItemId()==2){
                        Log.i("NAVtabs", "onCreateView: toclocknavigated3");
                        navController.navigate(R.id.categories,savedInstanceState,options);
                    }else{
                        Log.i("NAVtabs", "onCreateView: toclocknavigated4");
                        navController.navigate(R.id.profile,savedInstanceState,options);
                    }
                    return false;
                });

        fragmentTabsBinding.bottomNavigationView.setOnItemReselectedListener((NavigationBarView.OnItemReselectedListener)
                item -> {
                    if(item.getItemId()==0){
                        Log.i("NAVtabs", "onCreateView: toclocknavigated1");
                        navController.navigate(R.id.clocks,savedInstanceState,options);
                    }else if (item.getItemId()==1){
                        Log.i("NAVtabs", "onCreateView: toclocknavigated2");
                        navController.navigate(R.id.calendar,savedInstanceState,options);
                    }else if (item.getItemId()==2){
                        Log.i("NAVtabs", "onCreateView: toclocknavigated3");
                        navController.navigate(R.id.categories,savedInstanceState,options);
                    }else{
                        Log.i("NAVtabs", "onCreateView: toclocknavigated4");
                        navController.navigate(R.id.profile,savedInstanceState,options);
                    }
                });

        NavigationUI.setupWithNavController(fragmentTabsBinding.bottomNavigationView, navController);
        return fragmentTabsBinding.getRoot();

    }
}

