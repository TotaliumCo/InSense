package com.example.insense.services.time;

import android.os.Build;
import android.os.CountDownTimer;

import androidx.annotation.RequiresApi;

import com.example.insense.application.App;
import com.example.insense.repository.room.activityDB.Activity;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class GlobalTimer {
    Activity mActivity;
    private int mLeftTimeInMillis;
    private int startTime;
    private boolean mIsTimerRunning;
    private boolean isTimer = false;
    private CountDownTimer mCountDownTimer;

    public GlobalTimer() {}

    public void startTimer() {
        mCountDownTimer = new CountDownTimer(mLeftTimeInMillis, 1) {

            @Override
            public void onTick(long millisUntilFinished){
                mLeftTimeInMillis = (int) millisUntilFinished;
            }

            @Override
            public void onFinish() {
                mIsTimerRunning = false;
                mActivity.status = "completed";
                App.getInstance().getActivityRepository().getDatabase().activityDao().updateActivity(mActivity);
                isTimer = false;
            }

        }.start();

        mActivity.status = "running";
        App.getInstance().getActivityRepository().getDatabase().activityDao().updateActivity(mActivity);
        mIsTimerRunning = true;
    }

    public void stopTimer() {
        mIsTimerRunning = false;
        mActivity.status = "stopped";
        App.getInstance().getActivityRepository().getDatabase().activityDao().updateActivity(mActivity);
        mCountDownTimer.cancel();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void setTimerByActivity(Activity activity) {
        this.mActivity = activity;
        ZoneId zoneId = ZoneId.of("Europe/Paris");
        ZonedDateTime zdt_end = ZonedDateTime.of(activity.endDate, zoneId);
        long millis_end = zdt_end.toInstant().toEpochMilli();

        ZonedDateTime zdt_start = ZonedDateTime.of(activity.startDate, zoneId);
        long millis_start = zdt_start.toInstant().toEpochMilli();
        mLeftTimeInMillis = (int) (millis_end - millis_start);
        startTime = mLeftTimeInMillis;
    }

    public long getLeftTimeInMillis() {
        return mLeftTimeInMillis;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setTimer(boolean timer) {
        isTimer = timer;
    }

    public boolean getIsTimer() {
        return isTimer;
    }

    public boolean getIsTimerRunning() {
        return mIsTimerRunning;
    }

    public Activity getmActivity() { return mActivity; }
}
