package com.example.insense.repository.room;

import android.graphics.Color;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
import java.sql.Date;

import androidx.room.ColumnInfo;
import androidx.vectordrawable.graphics.drawable.ArgbEvaluator;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

@Entity
public class Activity {
    @PrimaryKey(autoGenerate = true)
    public long uid;
    @ColumnInfo(name = "name")
    public String name;
    @ColumnInfo(name = "occupation")
    public String occupation;
    @ColumnInfo(name = "description")
    public String description;
    @ColumnInfo(name = "start year")
    public int startYear;
    @ColumnInfo(name = "start day")
    public int startDay;
    @ColumnInfo(name = "start hour")
    public int startHour;
    @ColumnInfo(name = "start minute")
    public int startMinute;
    @ColumnInfo(name = "start sec")
    public int startSec;
    @ColumnInfo(name = "end year")
    public int endYear;
    @ColumnInfo(name = "end day")
    public int endDay;
    @ColumnInfo(name = "end hour")
    public int endHour;
    @ColumnInfo(name = "end minute")
    public int endMinute;
    @ColumnInfo(name = "end sec")
    public int endSec;
    @ColumnInfo(name = "red")
    public int red;
    @ColumnInfo(name = "green")
    public int green;
    @ColumnInfo(name = "blue")
    public int blue;
    @ColumnInfo(name = "al")
    public int al;

}
