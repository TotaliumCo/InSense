package com.example.insense.ui.tabs.categories.Category;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.navigation.NavController;

import com.example.insense.R;
import com.example.insense.application.App;
import com.example.insense.repository.room.activityDB.Activity;

import java.util.HashMap;
import java.util.List;

public class ListAdapter extends BaseExpandableListAdapter {
    private NavController navController;
    private Context context;
    CategoryFragment categoryFragment;
    Activity activity;
    private List<String> list_of_occupations;
    private HashMap<String, List<String>> map_of_occupations_activities;

    public ListAdapter(Context context, Activity activity, List<String> expListTitle, NavController navController,
                       HashMap<String, List<String>> expListDetail, CategoryFragment isFromMyCategoriesFragment) {
        this.context = context;
        this.list_of_occupations = expListTitle;
        this.map_of_occupations_activities = expListDetail;
        this.activity = activity;
        this.categoryFragment = isFromMyCategoriesFragment;
        LayoutInflater inflater = LayoutInflater.from(context);
        this.navController = navController;
        for (String occupation : list_of_occupations.toArray(new String[0])) {
            List<String> list_of_real_act = map_of_occupations_activities.get(occupation);
            list_of_real_act.add(list_of_real_act.size(), "add");
            map_of_occupations_activities.put(occupation, list_of_real_act);
        }
    }

    @Override
    public int getGroupCount() {
        return list_of_occupations.size();
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return map_of_occupations_activities.get(
                list_of_occupations.get(listPosition)
        ).size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return list_of_occupations.get(listPosition);
    }


    @Override
    public Object getChild(int listPosition, int expListPosition) {
        return map_of_occupations_activities.get(
                list_of_occupations.get(listPosition)
        ).get(expListPosition);
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        // получаем родительский элемент
        String one_occupation = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.list_group, null);
        }
        TextView listOccupationTextView = (TextView) convertView
                .findViewById(R.id.listTitle);
        listOccupationTextView.setTypeface(null, Typeface.BOLD);
        listOccupationTextView.setText(one_occupation);
     /*   listOccupationTextView.setOnLongClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putString("occupation",list_of_occupations.get(listPosition));
            navController.navigate(R.id.action_categoryFragment_to_activityFragment2,bundle);
            return true;
        });*/
        return convertView;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        // получаем дочерний элемент
        String one_activity = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.one_element, null);
        }
        Button button = (Button) convertView.findViewById(R.id.change_activity_categories);
        button.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            if (one_activity.equals("add")) {
                bundle.putString("occupation",list_of_occupations.get(listPosition));
            } else {
                bundle.putString("uid", String.valueOf(App.getInstance().getActivityRepository().getDatabase().activityDao().loadByName(one_activity).uid));
            }

            navController.navigate(R.id.action_categoryFragment_to_activityFragment2, bundle);
        });
        TextView ListActivityTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        if (one_activity.equals("empty")) {
            ListActivityTextView.setText("");
        } else {

        }
        ListActivityTextView.setText(one_activity);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
