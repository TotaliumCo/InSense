package com.example.insense.models;

public class Date {

    long year,day,hour,minute,sec;

    long secs;

    public Date(long year,long day,long hour,long minute,long sec){
        this.year=year;
        this.day = day;
        this.hour=hour;
        this.minute = minute;
        this.sec=sec;
        secs = year*365*24*60*60+day*24*60*60+hour*60*60+minute*60+sec;
    }

    public long getSecs() {
        return secs;
    }

    public long getYear() {
        return year;
    }

    public long getDay() {
        return day;
    }

    public long getHour() {
        return hour;
    }

    public long getMinute() {
        return minute;
    }

    public long getSec() {
        return sec;
    }
}
