package com.example.insense.ui.tabs.main;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.insense.repository.room.activityDB.Activity;

public class MainViewModel extends ViewModel{
    private MutableLiveData<Activity> currentActivity;

    public MutableLiveData<Activity> getCurrentActivity() {
        if (currentActivity == null) {
            currentActivity = new MutableLiveData<Activity>();
        }
        return currentActivity;
    }
}
