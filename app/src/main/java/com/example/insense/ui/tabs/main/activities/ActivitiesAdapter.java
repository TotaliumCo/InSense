package com.example.insense.ui.tabs.main.activities;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.insense.R;
import com.example.insense.application.App;
import com.example.insense.repository.ActivityRepository;
import com.example.insense.repository.room.activityDB.Activity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivitiesAdapter extends RecyclerView.Adapter<ActivitiesAdapter.ViewHolder> {
    List<Activity> activities = new ArrayList<>();
    ActivityRepository repository_activity = App.instance.getActivityRepository();
    NavController navController;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView;
        private final Button editButton;
        private final Button startButton;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View
            startButton = view.findViewById(R.id.button3);
            editButton = view.findViewById(R.id.button2);
            textView = (TextView) view.findViewById(R.id.textView6);
        }

        public Button getEditButton() {
            return editButton;
        }

        public Button getStartButton() {
            return startButton;
        }

        public TextView getTextView() {
            return textView;
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public ActivitiesAdapter(NavController navController) {
        this.navController = navController;
        List<Activity> all_activities = repository_activity.all_activities();
        List<Long> idActivities = new ArrayList<>();
        for (Activity activity : all_activities) {
            if (activity.startDate.getYear() == LocalDateTime.now().getYear() && activity.startDate.getDayOfYear() == LocalDateTime.now().getDayOfYear() && !activity.status.equals("completed")) {
                activities.add(activity);
            }
        }
        for (Activity activity : activities) {
            idActivities.add(activity.uid);
        }
        boolean isSorted = false;
        Activity buf;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < activities.size() - 1; i++) {
                if (activities.get(i).startDate.isBefore(activities.get(i + 1).startDate)) {
                    isSorted = false;

                    buf = activities.get(i);
                    activities.set(i, activities.get(i + 1));
                    activities.set(i + 1, buf);
                }
            }
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.main_activities_item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextView().setText(activities.get(position).name);
        viewHolder.getEditButton().setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("uid",String.valueOf(activities.get(position).uid));
            navController.navigate(R.id.action_mainFragment_to_activityFragment,bundle);
        });
        viewHolder.startButton.setOnClickListener(view -> {
            App.getInstance().getGlobalTimer().setTimerByActivity(activities.get(position));
            if(!App.getInstance().getGlobalTimer().getIsTimer())
            App.getInstance().getGlobalTimer().startTimer();
            App.getInstance().getGlobalTimer().setTimer(true);
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return activities.size();
    }
}
