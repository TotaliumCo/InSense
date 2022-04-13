package com.example.insense.services.time;

import android.os.CountDownTimer;
import android.util.Log;

import com.example.insense.repository.room.activityDB.Activity;

public class GlobalTimer {
    Activity mActivity;
    private int mLeftTimeInMillis;
    private int startTime;
    private boolean mIsTimerRunning;
    private boolean isTimer = false;
    private CountDownTimer mCountDownTimer;

    public GlobalTimer() {}

    public void startTimer() {
        mCountDownTimer = new CountDownTimer(mLeftTimeInMillis, 10) {

            @Override
            public void onTick(long millisUntilFinished) {
                mLeftTimeInMillis = (int) millisUntilFinished;
            }

            @Override
            public void onFinish() {
                mIsTimerRunning = false;
            }
        }.start();

        mIsTimerRunning = true;
    }

    public void stopTimer() {
        mIsTimerRunning = false;
        mCountDownTimer.cancel();
    }

    public void setTimerByActivity(Activity activity) {
        this.mActivity = activity;
        mLeftTimeInMillis = (int) (-activity.endDate.getSecs() + activity.startDate.getSecs())*1000;
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

}
