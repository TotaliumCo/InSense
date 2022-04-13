package com.example.insense.services.time;

import android.os.CountDownTimer;

import com.example.insense.repository.room.activityDB.Activity;

public class GlobalTimer {
    Activity mActivity;



    int mLeftTimeInMillis;
    int startTime;
    boolean mIsTimerRunning;
    boolean isTimer = false;
    private CountDownTimer mCountDownTimer;


    public GlobalTimer(){

    }

    public void startTimer(){
        mCountDownTimer = new CountDownTimer(mLeftTimeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mLeftTimeInMillis =(int) millisUntilFinished;

            }

            @Override
            public void onFinish() {
                mIsTimerRunning = false;
            }
        }.start();

        mIsTimerRunning = true;
    }
    public void stopTimer(){
        mIsTimerRunning = false;
        mCountDownTimer.cancel();
    }

    public void setTimerByActivity(Activity activity) {
        this.mActivity = activity;
        mLeftTimeInMillis = (int) ( activity.endDate.getSecs()-activity.startDate.getSecs());
        startTime=mLeftTimeInMillis;
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
}
