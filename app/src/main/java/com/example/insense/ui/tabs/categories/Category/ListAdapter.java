package com.example.insense.ui.tabs.categories.Category;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.insense.R;
import com.example.insense.repository.room.activityDB.Activity;

import java.util.HashMap;
import java.util.List;

public class ListAdapter extends BaseExpandableListAdapter {

    private Context context;
    CategoryFragment categoryFragment;
    Activity activity;
    private List<String> list_of_occupations;
    private HashMap<String, List<String>> map_of_occupations_activities;

    public ListAdapter(Context context, Activity activity, List<String> expListTitle,
                       HashMap<String, List<String>> expListDetail, CategoryFragment isFromMyCategoriesFragment) {
        this.context = context;
        this.list_of_occupations = expListTitle;
        this.map_of_occupations_activities = expListDetail;
        this.activity = activity;
        this.categoryFragment = isFromMyCategoriesFragment;
        LayoutInflater inflater = LayoutInflater.from(context);
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
            convertView = mInflater.inflate(R.layout.one_element, null); //dhbfnjklak;ocfbadjnlks;
        }
        TextView ListActivityTextView = (TextView) convertView.findViewById(R.id.expandedListItem);
        ListActivityTextView.setText(one_activity);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }
}
