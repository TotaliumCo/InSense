package com.example.insense.ui.tabs.categories.Category;

import android.app.FragmentManagerNonConfig;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.insense.R;
import com.example.insense.application.App;
import com.example.insense.databinding.FragmentCategoryBinding;
import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.OccupationRepository;
import com.example.insense.repository.room.activityDB.Activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class CategoryFragment extends Fragment {

    private FragmentCategoryBinding fragmentCategoryBinding;
    OccupationRepository repository_occupation = App.instance.getOccupationRepository();
    ActivityRepository repository_activity = App.instance.getActivityRepository();
    ExpandableListView expListView;
    ExpandableListAdapter expListAdapter;
    List<String> expListTitle;
    Activity context_activity;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentCategoryBinding = FragmentCategoryBinding.inflate(inflater, container, false);
        fragmentCategoryBinding.buttonBackCategory.setOnClickListener(v -> NavHostFragment.findNavController(CategoryFragment.this).popBackStack());
        fragmentCategoryBinding.buttonAdd.setOnClickListener(view -> {
            OccupationCreationListDialogFragment occupationCreationListDialogFragment = new OccupationCreationListDialogFragment(getArguments().getString("arg1"));
            occupationCreationListDialogFragment.show(getParentFragmentManager(), "OccupationCreationListDialogFragment");
        });
        return fragmentCategoryBinding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String text = getArguments().getString("arg1");
        TextView tv = view.findViewById(R.id.textView_category);
        tv.setText(text);
        HashMap<String, List<String>> map_of_occupations_activities = new HashMap<>();
        List<String> all_occupations = repository_occupation.get_all_occupations(text);
        for (int i = 0; i < all_occupations.size(); i++) {

            List<String> all_activities = repository_activity.activity_by_category(all_occupations.get(i));
            map_of_occupations_activities.put(all_occupations.get(i), all_activities);
        }
        expListTitle = new ArrayList<>(map_of_occupations_activities.keySet());
        expListView = (ExpandableListView) view.findViewById(R.id.expListView);
        all_occupations = repository_occupation.occupation_by_category(text);
        expListAdapter = new ListAdapter(getContext(), context_activity, all_occupations, NavHostFragment.findNavController(this),map_of_occupations_activities, CategoryFragment.this);
        expListView.setAdapter(expListAdapter);
    }
}


