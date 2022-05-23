package com.example.insense.ui.tabs.main;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.insense.R;
import com.example.insense.application.App;
import com.example.insense.databinding.FragmentMainBinding;
import com.example.insense.ui.tabs.main.Clocks.ClockFaceFragment;
import com.example.insense.ui.tabs.main.activities.ActivitiesAdapter;


public class MainFragment extends Fragment {

    private FragmentMainBinding fragmentMainBinding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        ft.replace(R.id.clock_fragment, new ClockFaceFragment());
        ft.commit();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentMainBinding = FragmentMainBinding.inflate(inflater, container, false);
        fragmentMainBinding.buttonAboutAction.setOnClickListener(v -> {
            App.getInstance().getGlobalTimer().setTimer(!App.getInstance().getGlobalTimer().getIsTimer());
        });

        ActivitiesAdapter activitiesAdapter = new ActivitiesAdapter(NavHostFragment.findNavController(this));
        fragmentMainBinding.activitiesOfTheCurrDay.setLayoutManager(new LinearLayoutManager(getContext()));
        fragmentMainBinding.activitiesOfTheCurrDay.setAdapter(activitiesAdapter);


        return fragmentMainBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}